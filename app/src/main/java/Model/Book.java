package Model;

import android.os.Parcelable;
import android.os.Parcel;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Book implements Parcelable {
    private String title;
    private String description;
    private Integer image;
    private Integer dots;
    private String color;
    private ArrayList<String> questions;
    private ArrayList<String> answers;

    public Book(String title, String description, Integer image, Integer dots, String color) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.dots = dots;
        this.color = color;
    }

    public Book(String title, String description, Integer image, Integer dots, String color, ArrayList<String> questions, ArrayList<String> answers) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.dots = dots;
        this.color = color;
        this.questions = questions;
        this.answers = answers;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getImage() {
        return this.image;
    }

    public Integer getDots() {
        return this.dots;
    }

    public String getColor() {
        return this.color;
    }

    public ArrayList<String> getQuestions() {
        return this.questions;
    }

    public ArrayList<String> getAnswers() {
        return this.answers;
    }

    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public void writeQuestionsAndAnswers() {
        int questionLineCount = 0;
        Scanner inFile = new Scanner(new File("path/to/txtfile"));
        while (inFile.hasNextLine()) {
            if (questionLineCount == 0)
                questions.add(inFile.nextLine());
            else if (questionLineCount%5 != 0)
                answers.add(inFile.nextLine()); //idk if we want to add each answer choice to its own index in arraylist
            else
                inFile.nextLine();

            questionLineCount++;
            questionLineCount = questionLineCount%6;
        }
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    private Book(Parcel in) {
        title = in.readString();
        description = in.readString();
        image = in.readInt();
        dots = in.readInt();
        color = in.readString();
        questions = in.readArrayList(ClassLoader.getSystemClassLoader()); //not 100% sure this is right
        answers = in.readArrayList(ClassLoader.getSystemClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeInt(image);
        dest.writeInt(dots);
        dest.writeString(color);
        dest.writeList(questions);
        dest.writeList(answers);
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[0];
        }
    };
}

package Model;

import android.os.Parcelable;
import android.os.Parcel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

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

    public Book(String title, String description, Integer image, Integer dots, String color,
                ArrayList<String> questions, ArrayList<String> answers) {
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

    public void buildQuiz(String bookTitle) {
        ArrayList<String> questions = new ArrayList<>();
        ArrayList<String> answers = new ArrayList<>();

        String title = formatBookTitle(bookTitle);


        StringBuilder text = new StringBuilder();
        BufferedReader reader;
        try{
            File questionsFile = new File("./../../../res/raw/" + title + ".txt");
            final InputStream file = new FileInputStream(questionsFile);
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();

            while(line != null) {
                if (!(line.equals(""))) {
                    text.append(line);

                    ArrayList<String> randomized = new ArrayList<>();
                    String answer1 = reader.readLine();
                    String answer2 = reader.readLine();
                    String answer3 = reader.readLine();
                    String answer4 = reader.readLine();

                    randomized.add(answer1);
                    randomized.add(answer2);
                    randomized.add(answer3);
                    randomized.add(answer4);
                    Collections.shuffle(randomized);

                    answers.add(answer1);

                    for (String s: randomized) {
                        text.append('\n');
                        text.append(s);
                    }
                    questions.add(text.toString());
                    text.setLength(0);
                    line = reader.readLine();
                }
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        this.questions = questions;
        this.answers = answers;
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

    private String formatBookTitle(String title) {
        title = title.toLowerCase();
        title = title.replaceAll(" ", "_");
        title = title.replaceAll("\\?", "");
        title = title.replaceAll("'s", "s");
        return title;
    }

}

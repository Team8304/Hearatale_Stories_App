package Model;

import android.content.Context;
import android.os.Parcelable;
import android.os.Parcel;
import android.util.Log;


import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import android.R;


public class Book implements Parcelable {
    private String title;
    private String description;
    private Integer image;
    private Integer dots;
    private String color;
    private ArrayList<String> questions;
    private ArrayList<String> answers;
    private ArrayList<Integer> images;
    private int numPages;

    public Book(String title, String description, Integer image, Integer dots, String color) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.dots = dots;
        this.color = color;
        this.questions = null;
        this.answers = null;
    }

    public Book(String title, String description, Integer image, Integer dots, String color, int numPages) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.dots = dots;
        this.color = color;
        this.numPages = numPages;
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

    public ArrayList<Integer> getImages() {
         return this.images;
    }

    public void setImages(ArrayList<Integer> images) {
        this.images = images;
    }

    public int getNumPages() {
        return this.numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
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
        images = in.readArrayList(ClassLoader.getSystemClassLoader());

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
        dest.writeList(images);
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

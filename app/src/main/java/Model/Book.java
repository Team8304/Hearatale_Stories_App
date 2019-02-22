package Model;

import android.os.Parcelable;
import android.os.Parcel;

public class Book implements Parcelable {
    private String title;
    private String description;
    private Integer image;
    private Integer dots;
    private String color;

    public Book(String title, String description, Integer image, Integer dots, String color) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.dots = dots;
        this.color = color;
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
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeInt(image);
        dest.writeInt(dots);
        dest.writeString(color);
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

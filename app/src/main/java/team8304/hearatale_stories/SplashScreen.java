package team8304.hearatale_stories;

import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import Model.Book;
import java.util.ArrayList;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIMEOUT = 2500;
    private ArrayList<Book> mBooks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent navigateHomePage = new Intent(SplashScreen.this, Home_Page.class);
                navigateHomePage.putParcelableArrayListExtra("books", createBooks());
                startActivity(navigateHomePage);
                finish();
            }
        }, SPLASH_TIMEOUT);
    }

    private ArrayList<Book> createBooks() {
        String lionDesc = "A lion releases a mouse, believing it’s too small and weak ever to return the favor, but when the lion is trapped in a net the mouse gnaws the threads and releases the lion.";
        mBooks.add(new Book("The Lion and the Mouse", lionDesc, R.drawable.thelionandthemouse,
                R.drawable.greydot, "grey", "thelionandthemouse"));

        return mBooks;
    }
}

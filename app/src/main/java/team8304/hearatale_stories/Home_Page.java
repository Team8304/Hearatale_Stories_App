package team8304.hearatale_stories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import Model.Book;
import java.util.ArrayList;
import android.util.Log;

public class Home_Page extends AppCompatActivity {
    private static final String TAG = "RecyclerViewAdapter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__page);
    }

    public void navigateToLibrary(View view) {
        Intent startLibraryActivity = new Intent(this, LibraryActivity.class);
//        startActivity(startLibraryActivity);
        ArrayList<Book> mBooks = getIntent().getParcelableArrayListExtra("books");
        startLibraryActivity.putExtra("books", mBooks);
        startLibraryActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        Log.d(TAG, "###");
        Log.d(TAG, Boolean.toString(mBooks.isEmpty()));
        startActivityIfNeeded(startLibraryActivity, 0);
    }
}

package team8304.hearatale_stories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import Model.Book;
import java.util.ArrayList;

public class Home_Page extends AppCompatActivity {
    private static final String TAG = "RecyclerViewAdapter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__page);
    }

    public void navigateToLibrary(View view) {
        Intent startLibraryActivity = new Intent(this, LibraryActivity.class);
        ArrayList<Book> mBooks = getIntent().getParcelableArrayListExtra("books");
        ArrayList<Book> mImagines = getIntent().getParcelableArrayListExtra("imagines");
        startLibraryActivity.putParcelableArrayListExtra("books", mBooks);
        startLibraryActivity.putParcelableArrayListExtra("imagines", mImagines);
        startLibraryActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(startLibraryActivity, 0);
    }
}

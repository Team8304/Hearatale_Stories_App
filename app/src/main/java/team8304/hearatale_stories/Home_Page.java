package team8304.hearatale_stories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__page);
    }

    public void navigateToLibrary(View view) {
        Intent startLibraryActivity = new Intent(this, LibraryActivity.class);
        startActivity(startLibraryActivity);
    }
}

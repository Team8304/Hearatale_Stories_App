package team8304.hearatale_stories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class LibraryImagineActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<Class> mClasses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_imagine);

        Button btn1 = (Button) findViewById(R.id.classicButton);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LibraryImagineActivity.this, LibraryActivity.class));
            }
        });
        Button btn2 = (Button) findViewById(R.id.favoriteButton);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LibraryImagineActivity.this, LibraryFavoriteActivity.class));
            }
        });

        getImages();
    }

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/shoe.png");
        mNames.add("If a Shoe Wanted to be a Car");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/pump.png");
        mNames.add("Do you pump your legs when you swing?");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/window.png");
        mNames.add("Upside Down Windows");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/blink.png");
        mNames.add("The Special One-Eye Blink\n");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/angel.png");
        mNames.add("If a Naughty Angel");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/IfYouDecideToBeAKitten.png");
        mNames.add("If You Decide to be a Kitten");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/NobodysBetterThanYou.png");
        mNames.add("Nobody's Better than You");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/dirt.png");
        mNames.add("If a Piece of Dirt...");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/palace.png");
        mNames.add("The Imaginary Fairy Palace");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/bubbles.jpg");
        mNames.add("Do You Like Bubbles");
        mClasses.add(Activity_title_page.class); //replace with correct class

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls, mClasses);
        recyclerView.setAdapter(adapter);
    }
}
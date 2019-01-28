package team8304.hearatale_stories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<Class> mClasses = new ArrayList<>();
    private ArrayList<String> mDotUrls = new ArrayList<>();
    private ArrayList<String> mFileTitles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Button btn1 = (Button) findViewById(R.id.imagineButton);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LibraryActivity.this, LibraryImagineActivity.class));
            }
        });
        Button btn2 = (Button) findViewById(R.id.favoriteButton);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LibraryActivity.this, LibraryFavoriteActivity.class));
            }
        });

        getImages();
    }

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/OakTreeAndReeds.jpg");
        mNames.add("The Oak Tree and the Reed");

        mDotUrls.add("http://hearatale.com/images/target_audience/A.png");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/DogAndShadow.jpg");
        mNames.add("The Dog and His Shadow");
        mDotUrls.add("http://hearatale.com/images/target_audience/A.png");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/PrincessAndPea.jpg");
        mNames.add("The Princess and the Pea");
        mDotUrls.add("http://hearatale.com/images/target_audience/F.png");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/BlindMenAndElephant.jpg");
        mNames.add("The Blind Men and the Elephant");
        mDotUrls.add("http://hearatale.com/images/target_audience/B.png");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/LionAndTheMouse.jpg");
        mNames.add("The Lion and the Mouse");
        mDotUrls.add("http://hearatale.com/images/target_audience/A.png");
        mClasses.add(Activity_title_page.class); //replace with correct class
        mFileTitles.add("thelionandthemouse");

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/RoosterAndFox.jpg");
        mNames.add("The Rooster and the Fox");
        mDotUrls.add("http://hearatale.com/images/target_audience/A.png");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/LittleRedHen.jpg");
        mNames.add("The Little Red Hen");
        mDotUrls.add("http://hearatale.com/images/target_audience/A.png");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/CountryMouseCityMouse.jpg");
        mNames.add("The Country Mouse and the City Mouse");
        mDotUrls.add("http://hearatale.com/images/target_audience/A.png");
        mClasses.add(Activity_title_page.class); //replace with correct class

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls, mDotUrls, mClasses);
        recyclerView.setAdapter(adapter);
    }
}
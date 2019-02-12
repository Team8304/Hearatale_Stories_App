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
    private ArrayList<Integer> mImages = new ArrayList<>();
    private ArrayList<Class> mClasses = new ArrayList<>();
    private ArrayList<String> mColors = new ArrayList<>();
    private ArrayList<Integer> mDots = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_imagine);

        Button btn1 = (Button) findViewById(R.id.classicButton);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibraryImagineActivity.this, LibraryActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivityIfNeeded(intent, 0);
            }
        });
        Button btn2 = (Button) findViewById(R.id.favoriteButton);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibraryImagineActivity.this, LibraryFavoriteActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivityIfNeeded(intent, 0);
            }
        });

        getImages();
    }

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImages.add(R.drawable.shoe);
        mNames.add("If a Shoe Wanted to be a Car");
        mDots.add(R.drawable.whitespace);
        mColors.add("white");
        mClasses.add(Activity_title_page.class); //replace with correct class


        mImages.add(R.drawable.pump);
        mNames.add("Do you pump your legs when you swing?");
        mDots.add(R.drawable.whitespace);
        mColors.add("white");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImages.add(R.drawable.window);
        mNames.add("Upside Down Windows");
        mDots.add(R.drawable.whitespace);
        mColors.add("white");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImages.add(R.drawable.blink);
        mNames.add("The Special One-Eye Blink\n");
        mDots.add(R.drawable.whitespace);
        mColors.add("white");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImages.add(R.drawable.angel);
        mNames.add("If a Naughty Angel");
        mDots.add(R.drawable.whitespace);
        mColors.add("white");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImages.add(R.drawable.if_you_decide_to_be_a_kitten);
        mNames.add("If You Decide to be a Kitten");
        mDots.add(R.drawable.whitespace);
        mColors.add("white");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImages.add(R.drawable.nobodys_better_than_you);
        mNames.add("Nobody's Better than You");
        mDots.add(R.drawable.whitespace);
        mColors.add("white");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImages.add(R.drawable.dirt);
        mNames.add("If a Piece of Dirt...");
        mDots.add(R.drawable.whitespace);
        mColors.add("white");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImages.add(R.drawable.palace);
        mNames.add("The Imaginary Fairy Palace");
        mDots.add(R.drawable.whitespace);
        mColors.add("white");
        mClasses.add(Activity_title_page.class); //replace with correct class

        mImages.add(R.drawable.bubbles);
        mNames.add("Do You Like Bubbles");
        mDots.add(R.drawable.whitespace);
        mColors.add("white");
        mClasses.add(Activity_title_page.class); //replace with correct class

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImages, mDots, mColors, mClasses);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Home_Page.class);
//        startActivity(intent);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);
    }
}
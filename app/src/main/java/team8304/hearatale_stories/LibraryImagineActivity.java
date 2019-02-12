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
    private ArrayList<String> mDotUrls = new ArrayList<>();
    private ArrayList<String> mFileTitles = new ArrayList<>();
    private ArrayList<String> mStoryDescriptions = new ArrayList<>();

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
        mDotUrls.add("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARMAAAC3CAMAAAAGjUrGAAAAA1BMVEX///+nxBvIAAAAR0lEQVR4nO3BAQ0AAADCoPdPbQ8HFAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAPBgxUwAAU+n3sIAAAAASUVORK5CYII=");
        mClasses.add(Activity_title_page.class); //replace with correct class
        mStoryDescriptions.add("Imagine a shoe wanting to be like a car, and what a child might find in the home to help.");
        mFileTitles.add("shoecar");

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/pump.png");
        mNames.add("Do you pump your legs when you swing?");
        mDotUrls.add("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARMAAAC3CAMAAAAGjUrGAAAAA1BMVEX///+nxBvIAAAAR0lEQVR4nO3BAQ0AAADCoPdPbQ8HFAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAPBgxUwAAU+n3sIAAAAASUVORK5CYII=");
        mClasses.add(Activity_title_page.class); //replace with correct class
        mStoryDescriptions.add("Imagine swinging as high as trees, birds, clouds, or even higher, what it might feel like, what you might see. ");
        mFileTitles.add("pumpswing");

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/window.png");
        mNames.add("Upside Down Windows");
        mDotUrls.add("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARMAAAC3CAMAAAAGjUrGAAAAA1BMVEX///+nxBvIAAAAR0lEQVR4nO3BAQ0AAADCoPdPbQ8HFAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAPBgxUwAAU+n3sIAAAAASUVORK5CYII=");
        mClasses.add(Activity_title_page.class); //replace with correct class
        mStoryDescriptions.add("Imagine wandering into a world where everything is upside down and backwards.");
        mFileTitles.add("upsidedownwindows");

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/blink.png");
        mNames.add("The Special One-Eye Blink\n");
        mDotUrls.add("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARMAAAC3CAMAAAAGjUrGAAAAA1BMVEX///+nxBvIAAAAR0lEQVR4nO3BAQ0AAADCoPdPbQ8HFAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAPBgxUwAAU+n3sIAAAAASUVORK5CYII=");
        mClasses.add(Activity_title_page.class); //replace with correct class
        mStoryDescriptions.add("Imagine blinking to become very tiny and what you might be able to do if you were very, very small.");
        mFileTitles.add("specialblink");

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/angel.png");
        mNames.add("If a Naughty Angel");
        mDotUrls.add("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARMAAAC3CAMAAAAGjUrGAAAAA1BMVEX///+nxBvIAAAAR0lEQVR4nO3BAQ0AAADCoPdPbQ8HFAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAPBgxUwAAU+n3sIAAAAASUVORK5CYII=");
        mClasses.add(Activity_title_page.class); //replace with correct class
        mStoryDescriptions.add("Imagine what you’d say if a little angel asked your advice on how to be a tiny bit mischievous.");
        mFileTitles.add("naughtyangel");

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/IfYouDecideToBeAKitten.png");
        mNames.add("If You Decide to be a Kitten");
        mDotUrls.add("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARMAAAC3CAMAAAAGjUrGAAAAA1BMVEX///+nxBvIAAAAR0lEQVR4nO3BAQ0AAADCoPdPbQ8HFAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAPBgxUwAAU+n3sIAAAAASUVORK5CYII=");
        mClasses.add(Activity_title_page.class); //replace with correct class
        mStoryDescriptions.add("Imagine what it might be like to be a kitten.");
        mFileTitles.add("decidekitten");

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/NobodysBetterThanYou.png");
        mNames.add("Nobody's Better than You");
        mDotUrls.add("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARMAAAC3CAMAAAAGjUrGAAAAA1BMVEX///+nxBvIAAAAR0lEQVR4nO3BAQ0AAADCoPdPbQ8HFAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAPBgxUwAAU+n3sIAAAAASUVORK5CYII=");
        mClasses.add(Activity_title_page.class); //replace with correct class
        mStoryDescriptions.add("Always remember, nobody’s better than you.");
        mFileTitles.add("nobodybetter");

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/dirt.png");
        mNames.add("If a Piece of Dirt...");
        mDotUrls.add("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARMAAAC3CAMAAAAGjUrGAAAAA1BMVEX///+nxBvIAAAAR0lEQVR4nO3BAQ0AAADCoPdPbQ8HFAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAPBgxUwAAU+n3sIAAAAASUVORK5CYII=");
        mClasses.add(Activity_title_page.class); //replace with correct class
        mStoryDescriptions.add("Imagine some of the things you might help a sad, lonely, bored piece of dirt become.");
        mFileTitles.add("pieceofdirt");

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/palace.png");
        mNames.add("The Imaginary Fairy Palace");
        mDotUrls.add("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARMAAAC3CAMAAAAGjUrGAAAAA1BMVEX///+nxBvIAAAAR0lEQVR4nO3BAQ0AAADCoPdPbQ8HFAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAPBgxUwAAU+n3sIAAAAASUVORK5CYII=");
        mClasses.add(Activity_title_page.class); //replace with correct class
        mStoryDescriptions.add("Imagine the kind of home fairies might create for themselves if they wanted.");
        mFileTitles.add("fairypalace");

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/bubbles.jpg");
        mNames.add("Do You Like Bubbles");
        mDotUrls.add("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAARMAAAC3CAMAAAAGjUrGAAAAA1BMVEX///+nxBvIAAAAR0lEQVR4nO3BAQ0AAADCoPdPbQ8HFAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAPBgxUwAAU+n3sIAAAAASUVORK5CYII=");
        mClasses.add(Activity_title_page.class); //replace with correct class
        mStoryDescriptions.add("Imagine blowing bubbles in a sink or bathtub.");
        mFileTitles.add("likebubbles");

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls, mDotUrls, mClasses, mFileTitles, mStoryDescriptions);
        recyclerView.setAdapter(adapter);
    }
}
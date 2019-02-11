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
    private ArrayList<String> mStoryDescriptions = new ArrayList<>();

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
        mNames.add("The Oak Tree and the Reeds");
        mDotUrls.add("http://hearatale.com/images/target_audience/A.png");
        mClasses.add(Activity_title_page.class); //replace with correct class
        mFileTitles.add("theoaktreeandthereed");
        mStoryDescriptions.add("A big, strong oak tree doesn’t allow sun to reach the little reeds until a storm; the reeds bend and survive, but the oak tree breaks and falls, leaving the reeds in the sunshine.");

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/DogAndShadow.jpg");
        mNames.add("The Dog and His Shadow");
        mDotUrls.add("http://hearatale.com/images/target_audience/A.png");
        mClasses.add(Activity_title_page.class); //replace with correct class
        mFileTitles.add("thedogandhisshadow");
        mStoryDescriptions.add("A greedy dog, not satisfied with his own bone, barks to get another dog’s, but as his own bone splashes in the water he realizes he had only barked at his own reflection.");

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/PrincessAndPea.jpg");
        mNames.add("The Princess and the Pea");
        mDotUrls.add("http://hearatale.com/images/target_audience/F.png");
        mClasses.add(Activity_title_page.class); //replace with correct class
        mFileTitles.add("theprincessandthepea");
        mStoryDescriptions.add("A prince can’t find a real princess to marry until a pea buried under several mattresses makes a young woman too uncomfortable to sleep. ");

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/BlindMenAndElephant.jpg");
        mNames.add("The Blind Men and the Elephant");
        mDotUrls.add("http://hearatale.com/images/target_audience/B.png");
        mClasses.add(Activity_title_page.class); //replace with correct class
        mFileTitles.add("theblindmenandtheelephant");
        mStoryDescriptions.add("Blind men argue whether an elephant is a snake, spear, wall, tree or something else; a boy sees the truth all along, but doesn’t bother to argue with them.");

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/LionAndTheMouse.jpg");
        mNames.add("The Lion and the Mouse");
        mDotUrls.add("http://hearatale.com/images/target_audience/A.png");
        mClasses.add(Activity_title_page.class); //replace with correct class
        mFileTitles.add("thelionandthemouse");
        mStoryDescriptions.add("A lion releases a mouse, believing it’s too small and weak ever to return the favor, but when the lion is trapped in a net the mouse gnaws the threads and releases the lion.");

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/RoosterAndFox.jpg");
        mNames.add("The Rooster and the Fox");
        mDotUrls.add("http://hearatale.com/images/target_audience/A.png");
        mClasses.add(Activity_title_page.class); //replace with correct class
        mFileTitles.add("theroosterandthefox");
        mStoryDescriptions.add("A fox traps a rooster by flattering the rooster’s singing voice, but the rooster escapes when he convinces the fox to taunt and trash talk his pursuers.");

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/LittleRedHen.jpg");
        mNames.add("The Little Red Hen");
        mDotUrls.add("http://hearatale.com/images/target_audience/A.png");
        mClasses.add(Activity_title_page.class); //replace with correct class
        mFileTitles.add("thelittleredhen");
        mStoryDescriptions.add("Lazy animals refuse to help the hen plant the seed, harvest the grain, or bake the bread, so the hen refuses to share the baked bread with the lazy animals.");

        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/CountryMouseCityMouse.jpg");
        mNames.add("The Country Mouse and the City Mouse");
        mDotUrls.add("http://hearatale.com/images/target_audience/A.png");
        mClasses.add(Activity_title_page.class); //replace with correct class
        mFileTitles.add("thecountrymouseandthecitymouse");
        mStoryDescriptions.add("A country mouse enjoys the luxuries of city life until a frightening city cat convinces him a simple life with safety is better than a rich life full of danger.");

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
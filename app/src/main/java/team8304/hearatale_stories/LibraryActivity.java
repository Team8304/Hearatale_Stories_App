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
import Model.Book;

public class LibraryActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
//    private ArrayList<String> mNames = new ArrayList<>();
//    private ArrayList<Integer> mImages = new ArrayList<>();
//    private ArrayList<Class> mClasses = new ArrayList<>();
//    private ArrayList<String> mFileTitles = new ArrayList<>();
//    private ArrayList<Integer> mDots = new ArrayList<>();
//    private ArrayList<String> mColors = new ArrayList<>();
//    private ArrayList<String> mStoryDescriptions = new ArrayList<>();
    private ArrayList<Book> mBooks = new ArrayList<>();
    private ArrayList<Book> mImagines = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Button btn1 = (Button) findViewById(R.id.imagineButton);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibraryActivity.this, LibraryImagineActivity.class);
                mImagines = getIntent().getParcelableArrayListExtra("imagines");
                intent.putParcelableArrayListExtra("imagines", mImagines);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivityIfNeeded(intent, 0);
            }
        });
        Button btn2 = (Button) findViewById(R.id.favoriteButton);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibraryActivity.this, LibraryFavoriteActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivityIfNeeded(intent, 0);
            }
        });

        //getImages();
        initRecyclerView();
    }

//    private void getImages(){
//        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
//
//        /*mImages.add(R.drawable.oak_tree_and_reeds);
//        mNames.add("The Oak Tree and the Reed");
//        mDots.add(R.drawable.greydot);
//        mColors.add("grey");
//        mClasses.add(Activity_title_page.class); //replace with correct class*/
//
//        mImages.add(R.drawable.thelionandthemouse);
//        mNames.add("The Lion and the Mouse");
//        mDots.add(R.drawable.greydot);
//        mColors.add("grey");
//        mClasses.add(Activity_title_page.class); //replace with correct class
//        mFileTitles.add("thelionandthemouse");
//        mStoryDescriptions.add("A lion releases a mouse, believing it’s too small and weak ever to return the favor, but when the lion is trapped in a net the mouse gnaws the threads and releases the lion.");
//
//        mImages.add(R.drawable.little_red_hen);
//        mNames.add("The Little Red Hen");
//        mDots.add(R.drawable.greydot);
//        mColors.add("grey");
//        mClasses.add(Activity_title_page.class); //replace with correct class
//        mFileTitles.add("little_red_hen");
//        mStoryDescriptions.add("Lazy animals refuse to help the hen plant the seed, harvest the grain, or bake the bread, so the hen refuses to share the baked bread with the lazy animals.");
//
//        mImages.add(R.drawable.boy_who_cried_wolf);
//        mNames.add("The Boy Who Cried Wolf");
//        mDots.add(R.drawable.bluedot);
//        mColors.add("blue");
//        mClasses.add(Activity_title_page.class); //replace with correct class
//        mFileTitles.add("boy_who_cried_wolf");
//        mStoryDescriptions.add("Bored watching over the sheep, a boy causes excitement by lying that a wolf threatens; when a real wolf attacks, the people think the boy’s lying and won’t come to help him.");
//
//        mImages.add(R.drawable.elves_and_shoemaker);
//        mNames.add("The Elves and Shoemaker");
//        mDots.add(R.drawable.greendot);
//        mColors.add("green");
//        mClasses.add(Activity_title_page.class); //replace with correct class
//        mFileTitles.add("elves_and_shoemaker");
//        mStoryDescriptions.add("By secretly making shoes, two elves save a poor shoemaker and his wife; the man and wife make clothes to reward the elves, who leave when their help is no longer needed.");
//
//        mImages.add(R.drawable.three_little_pigs);
//        mNames.add("The Three Little Pigs");
//        mDots.add(R.drawable.greydot);
//        mColors.add("grey");
//        mClasses.add(Activity_title_page.class); //replace with correct class
//        mFileTitles.add("three_little_pigs");
//        mStoryDescriptions.add("Two pigs squander their money and build shabby houses; their smarter brother saves and works hard to build a brick house which protects them all from the big bad wolf.");
//
//        mImages.add(R.drawable.three_billy_goats_gruff);
//        mNames.add("The Three Billy Goats Gruff");
//        mDots.add(R.drawable.greydot);
//        mColors.add("grey");
//        mClasses.add(Activity_title_page.class); //replace with correct class
//        mFileTitles.add("three_billy_goats_gruff");
//        mStoryDescriptions.add("Two billy goats trick a mean troll into waiting for their brother; with his horns the big brother knocks the troll off the bridge.");
//
//        mImages.add(R.drawable.peter_rabbit);
//        mNames.add("The Tale of Peter Rabbit");
//        mDots.add(R.drawable.greydot);
//        mColors.add("grey");
//        mClasses.add(Activity_title_page.class); //replace with correct class
//        mFileTitles.add("peter_rabbit");
//        mStoryDescriptions.add("Peter disobeys his mother and enters Mr. MacGregor’s garden, where he is almost captured and put into a pie; Peter escapes and returns to his mother who scolds him.");
//
////        mImages.add(R.drawable.elves_and_shoemaker);
////        mNames.add("The Elves and Shoemaker");
////        mDots.add(R.drawable.greendot);
////        mColors.add("green");
////        mClasses.add(Activity_title_page.class); //replace with correct class
//
//        mImages.add(R.drawable.gingerbread_man);
//        mNames.add("The Gingerbread Man");
//        mDots.add(R.drawable.greendot);
//        mColors.add("green");
//        mClasses.add(Activity_title_page.class); //replace with correct class
//        mFileTitles.add("gingerbread_man");
//        mStoryDescriptions.add("The Gingerbread Man speaks rudely, brags, and outruns all the people and animals until the fox’s help, is tricked and swallowed.");
//
//        mImages.add(R.drawable.rumplestiltskin);
//        mNames.add("Rumplestiltskin");
//        mDots.add(R.drawable.reddot);
//        mColors.add("red");
//        mClasses.add(Activity_title_page.class); //replace with correct class
//        mFileTitles.add("rumplestiltskin");
//        mStoryDescriptions.add("A cruel man spins straw into gold to save a girl’s life, demanding her first child in payment; when she’s queen she saves her child by learning the man’s secret name.");
//
//        mImages.add(R.drawable.little_red_riding_hood);
//        mNames.add("Little Red Riding Hood");
//        mDots.add(R.drawable.reddot);
//        mColors.add("red");
//        mClasses.add(Activity_title_page.class); //replace with correct class
//        mFileTitles.add("little_red_riding_hood");
//        mStoryDescriptions.add("A girl speaks to a wolf and leaves the proper path; the wolf swallows the grandmother and girl, but a huntsman kills the wolf, opens the wolf’s belly, and rescues both of them.");
//
//        /*mImages.add("http://hearatale.com/Thumbnails/StoriesThumbs/DogAndShadow.jpg");
//        mNames.add("The Dog and His Shadow");
//        mDots.add(R.drawable.greydot);
//        mColors.add("grey");
//        mClasses.add(Activity_title_page.class); //replace with correct class
//
//        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/PrincessAndPea.jpg");
//        mNames.add("The Princess and the Pea");
//        mDots.add(R.drawable.reddot);
//        mColors.add("red");
//        mClasses.add(Activity_title_page.class); //replace with correct class
//
//        mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/BlindMenAndElephant.jpg");
//        mNames.add("The Blind Men and the Elephant");
//        mDots.add(R.drawable.greendot);
//        mColors.add("green");
//        mClasses.add(Activity_title_page.class); //replace with correct class
//        */
//
//        /*mImageUrls.add("http://hearatale.com/Thumbnails/StoriesThumbs/CountryMouseCityMouse.jpg");
//        mNames.add("The Country Mouse and the City Mouse");
//        mDots.add(R.drawable.greydot);
//        mColors.add("grey");
//        mClasses.add(Activity_title_page.class); //replace with correct class
//        */
//
//        initRecyclerView();
//
//    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        mBooks = getIntent().getParcelableArrayListExtra("books");
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mBooks);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Home_Page.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);
    }
}
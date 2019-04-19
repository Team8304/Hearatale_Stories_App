package team8304.hearatale_stories;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import Model.Book;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIMEOUT = 2500;
    private ArrayList<Book> mBooks = new ArrayList<>();
    private ArrayList<Book> mImagines = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mImagines = createImagines();
                mBooks = createBooks();
                for(Book b: mBooks) {
                    buildQuiz(b);
                }

                Intent navigateHomePage = new Intent(SplashScreen.this, Home_Page.class);
                navigateHomePage.putParcelableArrayListExtra("books", mBooks);
                navigateHomePage.putParcelableArrayListExtra("imagines", mImagines);
                startActivity(navigateHomePage);
                finish();
            }
        }, SPLASH_TIMEOUT);
    }


    private String formatBookTitle(String title) {
        title = title.toLowerCase();
        title = title.replaceAll(" ", "_");
        title = title.replaceAll("\\?", "");
        title = title.replaceAll("'s", "s");
        return title;
    }

    public void buildQuiz(Book book) {
        ArrayList<String> questions = new ArrayList<>();
        ArrayList<String> answers = new ArrayList<>();

        String title = formatBookTitle(book.getTitle());

        String fileName = "questions_" + title;

        Uri storyContentPath = Uri.parse("android.resource://" + getPackageName() + "/raw/" + fileName);

        StringBuilder text = new StringBuilder();
        BufferedReader reader;
        try{
            final InputStream file = getContentResolver().openInputStream(storyContentPath);

            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();

            while(line != null) {
                if (!(line.equals(""))) {
                    text.append(line);

                    ArrayList<String> randomized = new ArrayList<>();
                    String answer1 = reader.readLine();
                    String answer2 = reader.readLine();
                    String answer3 = reader.readLine();
                    String answer4 = reader.readLine();

                    randomized.add(answer1);
                    randomized.add(answer2);
                    randomized.add(answer3);
                    randomized.add(answer4);
                    Collections.shuffle(randomized);

                    answers.add(answer1);

                    for (String s: randomized) {
                        text.append('\n');
                        text.append(s);
                    }
                    questions.add(text.toString());
                    text.setLength(0);
                }
                line = reader.readLine();
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        book.setQuestions(questions);
        book.setAnswers(answers);
    }

    private ArrayList<Book> createBooks() {
        ArrayList<Book> mBooks = new ArrayList<>();

        ArrayList<Integer> times = new ArrayList<>();
        times.add(4);
        times.add(32);
        times.add(50);
        times.add(63);
        times.add(95);
        times.add(117);
        times.add(150);

        String lionDesc = "A lion releases a mouse, believing it’s too small and weak ever to return the favor, but when the lion is trapped in a net the mouse gnaws the threads and releases the lion.";
        mBooks.add(new Book("The Lion and the Mouse", lionDesc, R.drawable.thelionandthemouse,
                R.drawable.greydot, "grey", 4, times));
        String littleredhen = "Lazy animals refuse to help the hen plant the seed, harvest the grain, or bake the bread, so the hen refuses to share the baked bread with the lazy animals.";
        mBooks.add(new Book("The Little Red Hen", littleredhen, R.drawable.little_red_hen,
                R.drawable.greydot, "grey", 4));
        String boywolf = "Bored watching over the sheep, a boy causes excitement by lying that a wolf threatens; when a real wolf attacks, the people think the boy’s lying and won’t come to help him.";
        mBooks.add(new Book("The Boy Who Cried Wolf", boywolf, R.drawable.boy_who_cried_wolf,
                R.drawable.bluedot, "blue", 4));
        String elves = "By secretly making shoes, two elves save a poor shoemaker and his wife; the man and wife make clothes to reward the elves, who leave when their help is no longer needed.";
        mBooks.add(new Book("The Elves and Shoemaker", elves, R.drawable.elves_and_shoemaker,
                R.drawable.greendot, "green", 4));
        String littlepigs = "Two pigs squander their money and build shabby houses; their smarter brother saves and works hard to build a brick house which protects them all from the big bad wolf.";
        mBooks.add(new Book("The Three Little Pigs", littlepigs, R.drawable.three_little_pigs,
                R.drawable.greydot, "grey", 4));
        String billygoat = "Two billy goats trick a mean troll into waiting for their brother; with his horns the big brother knocks the troll off the bridge.";
        mBooks.add(new Book("The Three Billy Goats Gruff", billygoat, R.drawable.three_billy_goats_gruff,
                R.drawable.greydot, "grey", 4));
        String peterRabbit = "Peter disobeys his mother and enters Mr. MacGregor’s garden, where he is almost captured and put into a pie; Peter escapes and returns to his mother who scolds him.";
        ArrayList<Integer> times1 = new ArrayList<>();
        times1.add(22);
        times1.add(47);
        times1.add(61);
        times1.add(68);
        times1.add(80);
        times1.add(92);
        times1.add(97);
        times1.add(105);
        times1.add(119);
        times1.add(131);
        times1.add(152);
        times1.add(167);
        times1.add(176);
        times1.add(188);
        times1.add(204);
        times1.add(217);
        times1.add(231);
        times1.add(276);
        times1.add(315);
        times1.add(353);
        times1.add(372);
        times1.add(382);
        times1.add(414);
        times1.add(435);
        mBooks.add(new Book("The Tale of Peter Rabbit", peterRabbit, R.drawable.peter_rabbit,
                R.drawable.greydot, "grey", 4, times1));
        String ginger = "The Gingerbread Man speaks rudely, brags, and outruns all the people and animals until the fox’s help, is tricked and swallowed.";
        ArrayList<Integer> times2 = new ArrayList<>();
        times2.clear();
        times2.add(1);
        times2.add(44);
        times2.add(93);
        times2.add(123);
        times2.add(164);
        times2.add(200);
        times2.add(220);
        times2.add(242);
        times2.add(253);
        times2.add(279);
        times2.add(305);
        times2.add(340);
        times2.add(380);
        times2.add(435);
        mBooks.add(new Book("The Gingerbread Man", ginger, R.drawable.gingerbread_man,
                R.drawable.greendot, "green", 4, times2));
        String rumple = "A cruel man spins straw into gold to save a girl’s life, demanding her first child in payment; when she’s queen she saves her child by learning the man’s secret name.";
        times.clear();
        times.add(3);
        times.add(31);
        times.add(69);
        times.add(99);
        times.add(148);
        times.add(171);
        times.add(198);
        times.add(231);
        times.add(261);
        times.add(296);
        times.add(324);
        times.add(340);
        times.add(358);
        times.add(380);
        times.add(400);
        times.add(428);
        times.add(455);
        times.add(485);
        mBooks.add(new Book("Rumplestiltskin", rumple, R.drawable.rumplestiltskin,
                R.drawable.reddot, "red", 4, times));
        String redriding = "A girl speaks to a wolf and leaves the proper path; the wolf swallows the grandmother and girl, but a huntsman kills the wolf, opens the wolf’s belly, and rescues both of them.";
        ArrayList<Integer> times3 = new ArrayList<>();
        times3.clear();
        times3.add(6);
        times3.add(32);
        times3.add(56);
        times3.add(61);
        times3.add(99);
        times3.add(151);
        times3.add(181);
        times3.add(207);
        times3.add(226);
        times3.add(268);
        times3.add(302);
        times3.add(331);
        times3.add(364);
        times3.add(387);
        mBooks.add(new Book("Little Red Riding Hood", redriding, R.drawable.little_red_riding_hood,
                R.drawable.reddot, "red", 4, times3));
        return mBooks;
    }

    private ArrayList<Book> createImagines() {
        ArrayList<Book> mImagines = new ArrayList<>();

        ArrayList<Integer> times = new ArrayList<>();
        times.add(42);
        times.add(66);
        times.add(85);

        String shoe = "Imagine a shoe wanting to be like a car, and what a child might find in the home to help.";
        mImagines.add(new Book("If a Shoe Wanted to be a Car", shoe,
                R.drawable.shoe, R.drawable.whitespace, "white", 4, times));
        String pump = "Imagine swinging as high as trees, birds, clouds, or even higher, what it might feel like, what you might see.";
        mImagines.add(new Book("Do you pump your legs when you swing?", pump,
                R.drawable.pump, R.drawable.whitespace, "white", 4));
        String window = "Imagine wandering into a world where everything is upside down and backwards.";
        mImagines.add(new Book("Upside Down Windows", window,
                R.drawable.window, R.drawable.whitespace, "white", 4));
        String blink = "Imagine blinking to become very tiny and what you might be able to do if you were very, very small.";
        mImagines.add(new Book("The Special One Eye Blink", blink,
                R.drawable.blink, R.drawable.whitespace, "white"));
        String angel = "Imagine what you’d say if a little angel asked your advice on how to be a tiny bit mischievous.";
        mImagines.add(new Book("If a Naughty Angel", angel,
                R.drawable.angel, R.drawable.whitespace, "white", 4));
        String kitten = "Imagine what it might be like to be a kitten.";
        mImagines.add(new Book("If you Decide to be a Kitten", kitten,
                R.drawable.if_you_decide_to_be_a_kitten, R.drawable.whitespace, "white", 4));
        String nobody = "Always remember, nobody’s better than you.";
        mImagines.add(new Book("Nobody's Better Than You", nobody,
                R.drawable.nobodys_better_than_you, R.drawable.whitespace, "white", 4));
        String dirt = "Imagine some of the things you might help a sad, lonely, bored piece of dirt become.";
        mImagines.add(new Book("If a Piece of Dirt", dirt,
                R.drawable.dirt, R.drawable.whitespace, "white"));
        String fairy = "Imagine the kind of home fairies might create for themselves if they wanted.";
        mImagines.add(new Book("The Imaginary Fairy Palace", fairy,
                R.drawable.palace, R.drawable.whitespace, "white", 4));
        String bubbles = "Imagine blowing bubbles in a sink or bathtub.";
        mImagines.add(new Book("Do You Like Bubbles", bubbles,
                R.drawable.bubbles, R.drawable.whitespace, "white", 4));

        return mImagines;
    }


}

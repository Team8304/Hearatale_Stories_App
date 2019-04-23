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
import java.util.Arrays;
import java.util.Collections;
import java.util.Arrays;

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

        ArrayList<Integer> timesLion = new ArrayList<>();
        /*timesLion.add(42);
        timesLion.add(66);
        timesLion.add(85);*/
        timesLion.add(4);
        timesLion.add(32);
        timesLion.add(50);
        timesLion.add(63);
        timesLion.add(95);
        timesLion.add(117);
        timesLion.add(150);

        String lionDesc = "A lion releases a mouse, believing it’s too small and weak ever to return the favor, but when the lion is trapped in a net the mouse gnaws the threads and releases the lion.";
        mBooks.add(new Book("The Lion and the Mouse", lionDesc, R.drawable.thelionandthemouse,
                R.drawable.greydot, "grey", 4, timesLion, new ArrayList<Integer>(Arrays.asList(50, 95, 166)), 5));

        ArrayList<Integer> timesHen = new ArrayList<>();
        timesHen.add(25);
        timesHen.add(56);
        timesHen.add(67);
        timesHen.add(97);
        timesHen.add(126);
        timesHen.add(159);

        String littleredhen = "Lazy animals refuse to help the hen plant the seed, harvest the grain, or bake the bread, so the hen refuses to share the baked bread with the lazy animals.";
        ArrayList<Integer> henQuiz = new ArrayList<>(Arrays.asList(54, 130, 190));
        mBooks.add(new Book("The Little Red Hen", littleredhen, R.drawable.little_red_hen,
                R.drawable.greydot, "grey", 4, timesHen, henQuiz, 5));

        ArrayList<Integer> timeswolf = new ArrayList<>();
        timeswolf.add(3);
        timeswolf.add(36);
        timeswolf.add(82);
        timeswolf.add(110);
        timeswolf.add(146);
        timeswolf.add(186);
        timeswolf.add(217);
        timeswolf.add(231);

        String boywolf = "Bored watching over the sheep, a boy causes excitement by lying that a wolf threatens; when a real wolf attacks, the people think the boy’s lying and won’t come to help him.";
        mBooks.add(new Book("The Boy Who Cried Wolf", boywolf, R.drawable.boy_who_cried_wolf,
                R.drawable.bluedot, "blue", 4, timeswolf, new ArrayList<Integer>(Arrays.asList(82, 118, 274)), 5));

        ArrayList<Integer> times4 = new ArrayList<>();
        times4.add(5);
        times4.add(67);
        times4.add(101);
        times4.add(132);
        times4.add(154);
        times4.add(214);
        times4.add(298);

        String elves = "By secretly making shoes, two elves save a poor shoemaker and his wife; the man and wife make clothes to reward the elves, who leave when their help is no longer needed.";
        ArrayList<Integer> elvesQuiz = new ArrayList<>(Arrays.asList(100, 240, 315, 370));
        mBooks.add(new Book("The Elves and Shoemaker", elves, R.drawable.elves_and_shoemaker,
                R.drawable.greendot, "green", 4, times4, elvesQuiz, 4));

        ArrayList<Integer> times5 = new ArrayList<>();
        times5.add(27);
        times5.add(67);
        times5.add(102);
        times5.add(140);
        times5.add(162);
        times5.add(193);
        times5.add(209);
        times5.add(238);
        times5.add(261);
        times5.add(290);
        times5.add(359);
        times5.add(373);

        String littlepigs = "Two pigs squander their money and build shabby houses; their smarter brother saves and works hard to build a brick house which protects them all from the big bad wolf.";
        mBooks.add(new Book("The Three Little Pigs", littlepigs, R.drawable.three_little_pigs,
                R.drawable.greydot, "grey", 4, times5, new ArrayList<Integer>(Arrays.asList(66, 140, 225, 320, 392)), 6));

        ArrayList<Integer> times6 = new ArrayList<>();
        times6.add(2);
        times6.add(38);
        times6.add(57);
        times6.add(69);
        times6.add(87);
        times6.add(107);
        times6.add(168);
        times6.add(216);
        times6.add(263);
        times6.add(283);
        times6.add(317);
        times6.add(367);
        times6.add(390);

        String billygoat = "Two billy goats trick a mean troll into waiting for their brother; with his horns the big brother knocks the troll off the bridge.";
        ArrayList<Integer> billyQuiz = new ArrayList<>(Arrays.asList(80, 170, 240, 310, 390));
        mBooks.add(new Book("The Three Billy Goats Gruff", billygoat, R.drawable.three_billy_goats_gruff,
                R.drawable.greydot, "grey", 4, times6, billyQuiz, 6));
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
                R.drawable.greydot, "grey", 4, times1, new ArrayList<Integer>(Arrays.asList(71, 133, 246, 355, 440)), 6));

        String ginger = "The Gingerbread Man speaks rudely, brags, and outruns all the people and animals until the fox’s help, is tricked and swallowed.";
        ArrayList<Integer> times2 = new ArrayList<>();
        //times2.clear();
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
                R.drawable.greendot, "green", 4, times2, new ArrayList<Integer>(Arrays.asList(78, 140, 250, 320, 395, 465)), 5));
        String rumple = "A cruel man spins straw into gold to save a girl’s life, demanding her first child in payment; when she’s queen she saves her child by learning the man’s secret name.";
        ArrayList<Integer> times = new ArrayList<>();
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
                R.drawable.reddot, "red", 4, times, new ArrayList<Integer>(Arrays.asList(69, 148, 238, 313, 400, 495)), 5));

        String redriding = "A girl speaks to a wolf and leaves the proper path; the wolf swallows the grandmother and girl, but a huntsman kills the wolf, opens the wolf’s belly, and rescues both of them.";
        ArrayList<Integer> times3 = new ArrayList<>();
        //times3.clear();
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

                R.drawable.reddot, "red", 4, times3, new ArrayList<Integer>(Arrays.asList(70, 150, 240, 360, 405, 515)), 5));
        return mBooks;
    }

    private ArrayList<Book> createImagines() {
        ArrayList<Book> mImagines = new ArrayList<>();

        ArrayList<Integer> times = new ArrayList<>();
        times.add(5);
        times.add(42);
        times.add(66);
        times.add(85);

        String shoe = "Imagine a shoe wanting to be like a car, and what a child might find in the home to help.";
        mImagines.add(new Book("If a Shoe Wanted to be a Car", shoe,
                R.drawable.shoe, R.drawable.whitespace, "white", 4, times));


        ArrayList<Integer> times2 = new ArrayList<>();
        times2.add(5);
        times2.add(33);
        times2.add(57);
        times2.add(69);
        times2.add(73);

        String pump = "Imagine swinging as high as trees, birds, clouds, or even higher, what it might feel like, what you might see.";
        mImagines.add(new Book("Do you pump your legs when you swing?", pump,
                R.drawable.pump, R.drawable.whitespace, "white", 4, times2));

        ArrayList<Integer> times3 = new ArrayList<>();
        times3.add(4);
        times3.add(33);
        times3.add(58);
        times3.add(85);

        String window = "Imagine wandering into a world where everything is upside down and backwards.";
        mImagines.add(new Book("Upside Down Windows", window,
                R.drawable.window, R.drawable.whitespace, "white", 4, times3));

        ArrayList<Integer> times4 = new ArrayList<>();
        times4.add(4);
        times4.add(35);
        times4.add(55);
        times4.add(79);
        times4.add(104);

        String blink = "Imagine blinking to become very tiny and what you might be able to do if you were very, very small.";
        mImagines.add(new Book("The Special One Eye Blink", blink,
                R.drawable.blink, R.drawable.whitespace, "white", 4, times4));

        ArrayList<Integer> times5 = new ArrayList<>();
        times5.add(3);
        times5.add(45);
        times5.add(64);
        times5.add(96);
        times5.add(130);


        String angel = "Imagine what you’d say if a little angel asked your advice on how to be a tiny bit mischievous.";
        mImagines.add(new Book("If a Naughty Angel", angel,
                R.drawable.angel, R.drawable.whitespace, "white", 4, times5));

        ArrayList<Integer> times6 = new ArrayList<>();
        times6.add(3);
        times6.add(21);
        times6.add(38);
        times6.add(49);
        times6.add(60);
        times6.add(78);
        times6.add(96);
        times6.add(110);
        times6.add(121);
        times6.add(141);
        
        String kitten = "Imagine what it might be like to be a kitten.";
        mImagines.add(new Book("If you Decide to be a Kitten", kitten,
                R.drawable.if_you_decide_to_be_a_kitten, R.drawable.whitespace, "white", 4, times6));

        ArrayList<Integer> times7 = new ArrayList<>();
        times7.add(3);
        times7.add(12);
        times7.add(19);
        times7.add(31);
        times7.add(38);
        times7.add(47);
        times7.add(50);
        times7.add(57);
        times7.add(78);
        times7.add(88);
        times7.add(107);
        times7.add(117);
        times7.add(141);

        
        String nobody = "Always remember, nobody’s better than you.";
        mImagines.add(new Book("Nobody's Better Than You", nobody,
                R.drawable.nobodys_better_than_you, R.drawable.whitespace, "white", 4, times7));

        ArrayList<Integer> times8 = new ArrayList<>();
        times8.add(6);
        times8.add(26);
        times8.add(53);
        times8.add(71);
        times8.add(103);
        times8.add(145);
        
        String dirt = "Imagine some of the things you might help a sad, lonely, bored piece of dirt become.";
        mImagines.add(new Book("If a Piece of Dirt", dirt,
                R.drawable.dirt, R.drawable.whitespace, "white", 4, times8));

        ArrayList<Integer> times9 = new ArrayList<>();
        times9.add(6);
        times9.add(43);
        times9.add(94);
        times9.add(123);
        times9.add(152);
        
        String fairy = "Imagine the kind of home fairies might create for themselves if they wanted.";
        mImagines.add(new Book("The Imaginary Fairy Palace", fairy,
                R.drawable.palace, R.drawable.whitespace, "white", 4, times9));

        ArrayList<Integer> times1 = new ArrayList<>();
        times1.add(2);
        times1.add(13);
        times1.add(40);
        times1.add(65);
        times1.add(102);
        times1.add(122);
        times1.add(127);
        
        String bubbles = "Imagine blowing bubbles in a sink or bathtub.";
        mImagines.add(new Book("Do You Like Bubbles", bubbles,
                R.drawable.bubbles, R.drawable.whitespace, "white", 4, times1));

        return mImagines;
    }


}

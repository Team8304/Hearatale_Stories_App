package team8304.hearatale_stories;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

import Model.Book;

public class BookActivity extends AppCompatActivity {

    private Button playButton;
    private Button experienceButton;
    private SeekBar seekBar;
    private TextView elapsedTimeLabel;
    private TextView remainingTimeLabel;
    //private TextView storyContent;
    private ImageView storyImage;
    private MediaPlayer mp;
    private int totalTime;
    private String bookTitle;
    private Book currentBook;
    private AlertDialog alert11;
    private Button quizButton;
    private boolean popped;
    private String bookllist[] = new String [] {"rumplestiltskin", "the_boy_who_cried_wolf",
            "the_elves_and_shoemaker", "the_gingerbread_man", "the_lion_and_the_mouse",
            "the_little_red_hen", "the_tale_of_peter_rabbit", "the_three_billy_goats_gruff",
            "the_three_little_pigs", "little_red_riding_hood"};

    private int currentPage;
    private boolean foundCurrentPage;

    private ArrayList<String> currentQuestions;
    private ArrayList<String> currentAnswers;

    private static final String TAG = "QuizActivity";

    public static int questionCounter = 0;
    public static int questionEnd = 0;

    public int quizPosition = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);


        popped = false;
        currentBook = getIntent().getParcelableExtra("book");
        bookTitle = currentBook.getTitle();
        storyImage = (ImageView) findViewById(R.id.storyImage);
        //storyContent = (TextView) findViewById(R.id.storyContentTextView);
        //storyContent.setMovementMethod(new ScrollingMovementMethod());
        playButton = (Button) findViewById(R.id.playButton);
        experienceButton = (Button) findViewById(R.id.button10);
        elapsedTimeLabel = (TextView) findViewById(R.id.elapsedTimeLabel);
        remainingTimeLabel = (TextView) findViewById(R.id.remainingTimeLabel);
        // Question Part
        quizButton = (Button) findViewById(R.id.questionButton);
        quizButton.setText("Quiz");
        quizButton.setVisibility(View.INVISIBLE);
        // Check is book object is imagine
//        if (currentBook.getAnswers() == null) {
//            quizButton.setVisibility(View.INVISIBLE);
//        }
//        quizButton.setVisibility(View.INVISIBLE);
//            quizButton.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    quizButton.setVisibility(View.VISIBLE);
//                }
//            }, 1000 * 5);

//        ArrayList<Integer> qTimes = currentBook.getQuizTimes();

        currentQuestions = currentBook.getQuestions();
        currentAnswers = currentBook.getAnswers();


        Uri bookPath = Uri.parse("android.resource://" + getPackageName() + "/raw/" + ""
                + formatBookTitle(bookTitle));
        Uri storyContentPath = Uri.parse("android.resource://" + getPackageName() + "/raw/" + "story_"
                + formatBookTitle(bookTitle));
        currentPage = 1;
        foundCurrentPage = true;

        storyImage.setImageResource(getResources().getIdentifier(formatBookTitle(bookTitle) + "_0" + String.valueOf(currentPage), "drawable", getPackageName()));

        //ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //home experience button
        experienceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp.isPlaying()) {
                    mp.pause();
                    playButton.setBackgroundResource(R.drawable.play_button);
                }
                Intent experience_intent = new Intent(getApplicationContext(), HomeExperienceActivity.class);
                experience_intent.putExtra("book", currentBook);
                startActivity(experience_intent);
            }
        });


        //hide the home experience button if the book is imagine
        if (!Arrays.asList(bookllist).contains(formatBookTitle(bookTitle))) {
            experienceButton.setVisibility(View.GONE); //SHOW the button
        }

//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        /*ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i;
        try {
            InputStream inputStream = getContentResolver().openInputStream(storyContentPath);
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //storyContent.setText(byteArrayOutputStream.toString());

        mp = MediaPlayer.create(this, bookPath);
        mp.setLooping(false);
        mp.seekTo(0);
        mp.setVolume(1.0f, 1.0f);
        totalTime = mp.getDuration();


        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(totalTime);
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser) {
                        if (fromUser) {
                            mp.seekTo(progress);
                            seekBar.setProgress(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        //Thread (Update seekbar and Time labels)
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mp != null) {
                    try {
                        Message msg = new Message();
                        msg.what = mp.getCurrentPosition();
                        handler.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }).start();
//        if (questionCounter == questionEnd) {
//            quizPosition++;
//        }

    }

    public void navigateToQuiz(View view) {
        Intent startLibraryActivity = new Intent(this, QuizActivity.class);
//        startLibraryActivity.putStringArrayListExtra("questions", currentQuestions);
//        for (int time : currentBook.getQuizTimes()) {
//            if (time < getTime(mp.getCurrentPosition()) ) {
//                questionEnd += currentBook.getIncrement();
//            }
//        }

        if (currentBook.getQuizTimes().get(quizPosition) < getTime(mp.getCurrentPosition())) {
//            questionEnd += currentBook.getIncrement();
            quizPosition++;
        }
//        if (questionCounter >= questionEnd) { quizPosition++; }
        if (questionEnd > currentBook.getQuestions().size()) {
            questionEnd = currentBook.getQuestions().size();
        }
        ArrayList<String> q = new ArrayList<>(currentQuestions.subList(questionCounter, questionEnd));
        startLibraryActivity.putStringArrayListExtra("questions", q);
        startLibraryActivity.putStringArrayListExtra("answers", currentAnswers);
        startLibraryActivity.putExtra("bookTitle", formatBookTitle(bookTitle));
        startActivityIfNeeded(startLibraryActivity, 0);
        mp.pause();
        playButton.setBackgroundResource(R.drawable.play_button);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int currentPosition = msg.what;
            seekBar.setProgress(currentPosition);

            String elapsedTime = createTimeLabel(currentPosition);
            elapsedTimeLabel.setText(elapsedTime);

            String remainTime = createTimeLabel(totalTime - currentPosition);
            remainingTimeLabel.setText("- " + remainTime);

            int numPages = currentBook.getNumPages();

            //list of time changes
            ArrayList<Integer> times = currentBook.getTimes();

            //makes sure we have always have the correct currentPage (handles scrolling and normal playback)
            foundCurrentPage = false;
            int currTime = getTime(currentPosition);
            for (int i = 0; (i < times.size()) && (foundCurrentPage == false); i++) {
                //first page
                if (i == 0) {
                    if (currTime < times.get(i)) {
                        currentPage = 1;
                        foundCurrentPage = true;
                    }
                }
                //last page and second to last page
                else if (i == times.size()-1) {
                    if (currTime >= times.get(i)) {
                        currentPage = times.size()+1;
                        foundCurrentPage = true;
                    } else if (currTime >= times.get(i-1) && currTime < times.get(i)) {
                        currentPage = times.size();
                        foundCurrentPage = true;
                    }
                }
                //middle page
                else {
                    if (currTime >= times.get(i-1) && currTime < times.get(i)) {
                        currentPage = i + 1;
                        foundCurrentPage = true;
                    }
                }

            }

            if (currentBook.getQuizTimes().get(quizPosition) < getTime(mp.getCurrentPosition()) || questionCounter < questionEnd) {
                quizButton.setVisibility(View.VISIBLE);
            } else {
                quizButton.setVisibility(View.INVISIBLE);
            }
            if (currentBook.getQuizTimes().get(quizPosition) < getTime(mp.getCurrentPosition())) {
                questionEnd += currentBook.getIncrement();
//                quizPosition++;
            }

            int id2;
            if (currentPage < 10) {
                id2 = getResources().getIdentifier(formatBookTitle(bookTitle) + "_0" + String.valueOf(currentPage), "drawable", getPackageName());
            } else {
                id2 = getResources().getIdentifier(formatBookTitle(bookTitle) + "_" + String.valueOf(currentPage), "drawable", getPackageName());
            }
            storyImage.setImageResource(id2);


            if(!((Activity) BookActivity.this).isFinishing())
            {
                if (remainTime.equals("0:00") && !popped){
                    popped = true;
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(BookActivity.this);
                    builder1.setMessage("You have completed the story!");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent end_story_Intent = new Intent(BookActivity.this, End_Story_Page.class);
                                    Bundle get_bundle = getIntent().getExtras();
                                    int pic = get_bundle.getInt("image");
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("image", pic);
                                    end_story_Intent.putExtras(bundle);
                                    end_story_Intent.putExtra("book", currentBook);
                                    startActivity(end_story_Intent);
                                    finish();
                                    dialog.dismiss();
                                }
                            });
                    alert11 = builder1.create();
                    alert11.show();
                }
            }
        }
    };

    public String createTimeLabel(int time) {
        String timeLabel;
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }

    public int getTime(int position) {
        return 60*(position / 1000 / 60) + (position / 1000 % 60);
    }


    public void playButtonClick(View view) {
        if (!mp.isPlaying()) {
            //Stopping
            mp.start();
            playButton.setBackgroundResource(R.drawable.pause_icon);
        } else {
            //Playing
            mp.pause();
            playButton.setBackgroundResource(R.drawable.play_button);
        }
    }

    public void back_to_home_page (View view) {
        Intent intent = new Intent(this, Activity_title_page.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);
        mp.stop();
        questionCounter = 0;
        questionEnd = 0;
        finish();
    }


    @Override
    public void onBackPressed() {
        back_to_home_page(new View(this));
    }


//    public void onQuestionPressed() { to_question_page(new View(this)); }
//
//    public void to_question_page(View view) {
//        Intent intent = new Intent(this, QuizActivity.class);
//        startActivity(intent);
//    }

    private String formatBookTitle(String title) {
        title = title.toLowerCase();
        title = title.replaceAll(" ", "_");
        title = title.replaceAll("\\?", "");
        title = title.replaceAll("'s", "s");
        Log.d("DEBUG", title);
        return title;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (alert11 != null && alert11.isShowing()) {
            alert11.dismiss();
        }
    }

}

package team8304.hearatale_stories;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    private TextView question;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private int counter = 0;
    private Button back_button;
    private int tries;
    private String answer;
    private boolean firstTry;
    private boolean secondTry;
    private ArrayList<String> questions;
    private ArrayList<String> answers;
    private static final String TAG = "QuizActivity";
    private String bookTitle = "";
    private MediaPlayer mp;
    private String questionPath = "";
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        // Assign buttons
        question = (TextView) findViewById(R.id.questionTextView);
        answer1 = (Button) findViewById(R.id.answer1Button);
        answer2 = (Button) findViewById(R.id.answer2Button);
        answer3 = (Button) findViewById(R.id.answer3Button);
        answer4 = (Button) findViewById(R.id.answer4Button);
        // Get passed question/answers
        questions = getIntent().getStringArrayListExtra("questions");
        answers = getIntent().getStringArrayListExtra("answers");
        bookTitle = getIntent().getStringExtra("bookTitle");
        //mp = MediaPlayer.create(this, Uri.parse("android.resource://" + getPackageName()
                //+ "/raw/" + bookTitle));

        updateQuestion();

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer1.getText().equals(answer)) {
                    Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    counter++;
                    updateQuestion();
                } else if (tries < 2) {
                    Toast.makeText(QuizActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
                    tries++;
                    score--;
                } else {
                    Toast.makeText(QuizActivity.this, "Aww You'll get the Next One! Next Question", Toast.LENGTH_SHORT).show();
                    counter++;
                    score--;
                    updateQuestion();
                }
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer2.getText().equals(answer)) {
                    Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    counter++;
                    updateQuestion();
                } else if (tries < 2) {
                    Toast.makeText(QuizActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
                    tries++;
                    score--;
                } else {
                    Toast.makeText(QuizActivity.this, "Aww You'll get the Next One! Next Question", Toast.LENGTH_SHORT).show();
                    counter++;
                    score--;
                    updateQuestion();
                }
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer3.getText().equals(answer)) {
                    Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    counter++;
                    updateQuestion();
                } else if (tries < 2) {
                    Toast.makeText(QuizActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
                    tries++;
                    score--;
                } else {
                    Toast.makeText(QuizActivity.this, "Aww You'll get the Next One! Next Question", Toast.LENGTH_SHORT).show();
                    counter++;
                    score--;
                    updateQuestion();
                }
            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer4.getText().equals(answer)) {
                    Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    counter++;
                    updateQuestion();
                } else if (tries < 2) {
                    Toast.makeText(QuizActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
                    tries++;
                    score--;
                } else {
                    Toast.makeText(QuizActivity.this, "Aww You'll get the Next One! Next Question", Toast.LENGTH_SHORT).show();
                    counter++;
                    score--;
                    updateQuestion();
                }
            }
        });

        back_button = findViewById(R.id.button10);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, BookActivity.class);
        BookActivity.questionCounter--;

        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        mp.stop();
        startActivity(intent);
        finish();
    }

    private void updateQuestion() {
        BookActivity.questionCounter++;
        score += 2;

        if (counter == questions.size()) {
            Intent intent = new Intent(this, BookActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            BookActivity.questionCounter--;
            System.out.println("QuestCounter:" + BookActivity.questionCounter);
            System.out.println("QuestEnd:" + BookActivity.questionEnd);
            mp.pause();
            startActivity(intent);
        }
        if (counter < questions.size()) {
            String[] lines = questions.get(counter).split("\\r?\\n");
            question.setText(lines[0]);
            answer1.setText(lines[1]);
            answer2.setText(lines[2]);
            answer3.setText(lines[3]);
            answer4.setText(lines[4]);
            answer = answers.get(counter);
            tries = 1;

            String questionNum =  lines[0].substring(0, 2);
            questionNum = questionNum.replaceAll("\\.", "");

            questionPath = "android.resource://" + getPackageName() + "/raw/" + "q" +
                    questionNum + "_" + bookTitle;
            Log.d("Test", questionPath);

            // strips off all non-ASCII characters
            questionNum = questionNum.replaceAll("[^\\x00-\\x7F]", "");

            // erases all the ASCII control characters
            questionNum = questionNum.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", "");

            // removes non-printable characters from Unicode
            questionNum = questionNum.replaceAll("\\p{C}", "");
            int val = Integer.parseInt(questionNum.trim());
            if (counter == 0) {
                questionPath = "android.resource://" + getPackageName() + "/raw/" + "q" +
                        questionNum + "_" + bookTitle;
                mp = MediaPlayer.create(this, Uri.parse(questionPath));
                mp.setLooping(false);
                mp.seekTo(0);
                mp.setVolume(2.0f, 2.0f);
                mp.start();
            } else {

                mp.reset();
                try {
                    mp.setDataSource(getApplicationContext(), Uri.parse(questionPath));
                    mp.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mp.start();
            }
        }
    }
}

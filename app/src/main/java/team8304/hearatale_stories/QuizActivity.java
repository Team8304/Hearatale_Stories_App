package team8304.hearatale_stories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.util.Log;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class QuizActivity extends AppCompatActivity {
    private TextView questionNumber;
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
    private String questions[];
    private String answerChoices[][];
    private String answers[];

    private static final String TAG = "QuizActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionNumber = (TextView) findViewById(R.id.qNumTextView);
        question = (TextView) findViewById(R.id.questionTextView);
        answer1 = (Button) findViewById(R.id.answer1Button);
        answer2 = (Button) findViewById(R.id.answer2Button);
        answer3 = (Button) findViewById(R.id.answer3Button);
        answer4 = (Button) findViewById(R.id.answer4Button);

        // Create Array of questions
//        Queue<String> questions = new LinkedList<>();
//        ((LinkedList<String>) questions).add("What is 1?");
//        ((LinkedList<String>) questions).add("What is 2?");
//        ((LinkedList<String>) questions).add("What is 3?");
        questions = new String[]{"First Question", "Second Question", "Third Question"};

        // Create Double Array of AnswerChoices
//        ArrayList<ArrayList> answers = new ArrayList<>();
//        ArrayList<String> one = new ArrayList<>();
//        ArrayList<String> two = new ArrayList<>();
//        ArrayList<String> three = new ArrayList<>();
        answerChoices = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        // Create Array of Answers
        answers = new String[]{"1", "2", "3"};
        updateQuestion();
        if (questions.length != 0) {
            answer1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (answer1.getText() == answer) {
                        Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                        counter++;
                        updateQuestion();
                    } else if (tries < 2) {
                        Toast.makeText(QuizActivity.this, "Wrong! Try Again", Toast.LENGTH_SHORT).show();
                        tries++;
                    } else {
                        Toast.makeText(QuizActivity.this, "Wrong Again. You suck kiddo", Toast.LENGTH_SHORT).show();
                        counter++;
                        updateQuestion();
                    }
                }
            });
            answer2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (answer2.getText() == answer) {
                        Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                        counter++;
                        updateQuestion();
                    } else if (tries < 2) {
                        Toast.makeText(QuizActivity.this, "Wrong! Try Again", Toast.LENGTH_SHORT).show();
                        tries++;
                    } else {
                        Toast.makeText(QuizActivity.this, "Wrong Again. You suck kiddo", Toast.LENGTH_SHORT).show();
                        counter++;
                        updateQuestion();
                    }
                }
            });
            answer3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (answer3.getText() == answer) {
                        Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                        counter++;
//                        if (counter >= questions.length) {
//                            QuizActivity.super.onBackPressed();
//                        }
                        updateQuestion();
                    } else if (tries < 2) {
                        Toast.makeText(QuizActivity.this, "Wrong! Try Again", Toast.LENGTH_SHORT).show();
                        tries++;
                    } else {
                        Toast.makeText(QuizActivity.this, "Wrong Again. You suck kiddo", Toast.LENGTH_SHORT).show();
                        counter++;
                        updateQuestion();
                    }
                }
            });
            answer4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (answer4.getText() == answer) {
                        Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                        counter++;
                        updateQuestion();
                    } else if (tries < 2) {
                        Toast.makeText(QuizActivity.this, "Wrong! Try Again", Toast.LENGTH_SHORT).show();
                        tries++;
                    } else {
                        Toast.makeText(QuizActivity.this, "Wrong Again. You suck kiddo", Toast.LENGTH_SHORT).show();
                        counter++;
                        updateQuestion();
                    }
                }
            });
        }

        back_button = findViewById(R.id.button10);
        back_button.setText("Back");
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizActivity.super.onBackPressed();
//                back_to_home_page();
            }
        });
    }

    private void updateQuestion() {
        questionNumber.setText(Integer.toString(counter + 1));
        question.setText(questions[counter]);
        answer1.setText(answerChoices[counter][0]);
        answer2.setText(answerChoices[counter][1]);
        answer3.setText(answerChoices[counter][2]);
        answer4.setText(answerChoices[counter][3]);
        answer = answers[counter];
        tries = 1;
    }
}

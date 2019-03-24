package team8304.hearatale_stories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import org.w3c.dom.Text;

import java.util.Queue;

public class QuizActivity extends AppCompatActivity {
    private TextView questionNumber;
    private TextView question;
    private TextView answer1;
    private TextView answer2;
    private TextView answer3;
    private TextView answer4;
    private int counter;
    private Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

//        questionNumber = (TextView) findViewById(R.id.qNumTextView);
//        question = (TextView) findViewById(R.id.questionTextView);
//        answer1 = (TextView) findViewById(R.id.answer1TextView);
//        answer2 = (TextView) findViewById(R.id.answer2TextView);
//        answer3 = (TextView) findViewById(R.id.answer3TextView);
//        answer4 = (TextView) findViewById(R.id.answer4TextView);
//
//        questionNumber.setText("1");
//        question.setText("What color is the ball?");
//        answer1.setText("red");
//        answer2.setText("blue");
//        answer3.setText("green");
//        answer4.setText("brown");


        back_button = findViewById(R.id.button10);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizActivity.super.onBackPressed();
//                back_to_home_page();
            }
        });
    }
}

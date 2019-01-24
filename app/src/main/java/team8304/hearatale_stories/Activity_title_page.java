package team8304.hearatale_stories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Activity_title_page extends AppCompatActivity {
    private Button back_button;
    private Button play_button;  //TODO
    private Button favourite_button; //TODO
    private TextView story_title;
    private TextView story_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_page);


        story_title = (TextView) findViewById(R.id.textView2);
        story_title.setMovementMethod(new ScrollingMovementMethod());
        story_description = (TextView) findViewById(R.id.textView3);
        story_description.setMovementMethod(new ScrollingMovementMethod());


        String data = "";
        StringBuffer sbuffer_2 = new StringBuffer();

        // Read txt File
//        InputStream is = this.getResources().openRawResource(R.raw.sample);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

//        if(is != null) {
//            try {
//                while((data=reader.readLine()) != null) {
//                    sbuffer.append(data + "n");
//                }
//                story_description.setText(sbuffer);
//                is.close();
//            }catch(Exception e) {
//                e.printStackTrace();
//            }
//        }

        back_button = findViewById(R.id.button3);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_to_home_page();
            }
        });

//        favourite_button = (Button) findViewById(R.id.button5);
//        favourite_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                favourite_button.setBackgroundResource(R.drawable.favourite);
//            }
//        });
    }

    public void back_to_home_page () {
        Intent intent = new Intent(this, Home_Page.class);
        startActivity(intent);
    }
}
package team8304.hearatale_stories;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class End_Story_Page extends AppCompatActivity {

    private String bookTitle;
    private TextView story_title;
    private Button replay_button;
    private Button home_buttom;
    private Button back_to_story_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end__story__page);

        //set the story title
        story_title = (TextView) findViewById(R.id.textView101);
        story_title.setMovementMethod(new ScrollingMovementMethod());
        bookTitle = getIntent().getStringExtra("title");
        story_title.setText(bookTitle);

        //replay button
        replay_button = findViewById(R.id.button7);
        replay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replay_intent = new Intent(End_Story_Page.this, BookActivity.class);
                replay_intent.putExtra("bookTitle", bookTitle);
                startActivity(replay_intent);
            }
        });
    }

    //home button
    public void go_home(View view) {
        Intent homeIntent = new Intent(this, Home_Page.class);
        startActivity(homeIntent);
    }


    //back_to_story button
    public void back_to_story(View view) {

        Intent back_to_story_Intent = new Intent(this, Activity_title_page.class);
        String story_description = getIntent().getExtras().getString("description");
        Bundle get_bundle = getIntent().getExtras();
        int pic = get_bundle.getInt("image");
        Bundle bundle = new Bundle();
        bundle.putInt("image", pic);
        back_to_story_Intent.putExtras(bundle);
        back_to_story_Intent.putExtra("description", story_description);
        back_to_story_Intent.putExtra("title", bookTitle);
        startActivity(back_to_story_Intent);
    }
}

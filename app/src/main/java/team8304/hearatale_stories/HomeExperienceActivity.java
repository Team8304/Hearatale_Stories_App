package team8304.hearatale_stories;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import Model.Book;

public class HomeExperienceActivity extends Activity {

    private TextView content;
    private ArrayList<String> text_buffer;
    private ArrayList<String> path_arr;
    private int counter;
    private Book currentBook;
    private String bookTitle;
    private Button backButton;
    private Button nextButton;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_experience);

        currentBook = getIntent().getParcelableExtra("book");
        backButton = (Button) findViewById(R.id.button11);
        nextButton = (Button) findViewById(R.id.button12);
        bookTitle = currentBook.getTitle();
        text_buffer = new ArrayList<String>();
        path_arr = new ArrayList<String>();
        content = (TextView) findViewById(R.id.textView10);
        content.setMovementMethod(new ScrollingMovementMethod());
        Uri storyContentPath = Uri.parse("android.resource://" + getPackageName() + "/raw/" + "experience_"
                + formatBookTitle(bookTitle));

        String str;
        try {
            InputStream inputStream = getContentResolver().openInputStream(storyContentPath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (inputStream != null) {
                while ((str = reader.readLine()) != null) {
                    if (str != "\n") {
                        text_buffer.add(str);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        text_buffer.removeAll(Collections.singleton(null));
        text_buffer.removeAll(Collections.singleton(""));
        backButton.setVisibility(View.GONE);
        content.setText(text_buffer.get(0));
        counter = 0;

        String path;
        for (int i = 0; i < text_buffer.size(); i++) {
            path = "android.resource://" + getPackageName() + "/raw/" + "audio_"
                    + formatBookTitle(bookTitle) + "_" + Integer.toString(i+1);
            path_arr.add(path);
        }

        Log.d("sadasd", path_arr.get(0));
        mp = MediaPlayer.create(this, Uri.parse(path_arr.get(0)));
        mp.setLooping(false);
        mp.setVolume(2.0f, 2.0f);
        mp.start();



        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * 0.9), (int) (height * 0.8));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;
        getWindow().setAttributes(params);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                content.setText(text_buffer.get(counter));
                if (counter!= 0)
                {
                    backButton.setVisibility(View.VISIBLE); //SHOW the button
                    nextButton.setVisibility(View.VISIBLE);
                } else {
                    backButton.setVisibility(View.GONE); //SHOW the button
                    nextButton.setVisibility(View.VISIBLE);
                }
                mp.stop();
                try {
                    mp.setDataSource(getApplicationContext(), Uri.parse(path_arr.get(1)));
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (SecurityException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }try {
                    mp.prepare();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mp.start();
            }
        });


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                content.setText(text_buffer.get(counter));
                if (counter == (text_buffer.size()- 1) ) {
                    backButton.setVisibility(View.VISIBLE);
                    nextButton.setVisibility(View.GONE);
                } else {
                    backButton.setVisibility(View.VISIBLE);
                    nextButton.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    private String formatBookTitle(String title) {
        title = title.toLowerCase();
        title = title.replaceAll(" ", "_");
        title = title.replaceAll("\\?", "");
        title = title.replaceAll("'s", "s");
        Log.d("DEBUG", title);
        return title;
    }
}

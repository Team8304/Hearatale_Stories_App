package team8304.hearatale_stories;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Model.Book;

public class HomeExperienceActivity extends Activity {

    private TextView content;
    private ArrayList<String> text_buffer;
    private Book currentBook;
    private String bookTitle;
    private Button backButton;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_experience);

        currentBook = getIntent().getParcelableExtra("book");
        bookTitle = currentBook.getTitle();
        text_buffer = new ArrayList<String>();
        content = (TextView) findViewById(R.id.textView10);
        content.setMovementMethod(new ScrollingMovementMethod());
        Uri storyContentPath = Uri.parse("android.resource://" + getPackageName() + "/raw/" + "experience_"
                + formatBookTitle(bookTitle));


//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        int i;
//        try {
//            InputStream inputStream = getContentResolver().openInputStream(storyContentPath);
//            i = inputStream.read();
//            while (i != -1) {
//                byteArrayOutputStream.write(i);
//                i = inputStream.read();
//            }
//            inputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        content.setText(byteArrayOutputStream.toString());

        String str = "";
        StringBuffer buffer = new StringBuffer();
        try {
            InputStream inputStream = getContentResolver().openInputStream(storyContentPath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (inputStream != null) {
                while ((str = reader.readLine()) != null) {
                    if (str != "") {
                        buffer.append(str + "\n" );
                        text_buffer.add(str);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        content.setText(text_buffer.get(2));
        Log.d("2", Integer.toString(text_buffer.size()));
//        Log.d("3", text_buffer.toString());


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

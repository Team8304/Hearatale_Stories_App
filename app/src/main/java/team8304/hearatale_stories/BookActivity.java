package team8304.hearatale_stories;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BookActivity extends AppCompatActivity {

    private Button playButton;
    private SeekBar seekBar;
    private TextView elapsedTimeLabel;
    private TextView remainingTimeLabel;
    private TextView storyContent;
    private MediaPlayer mp;
    private int totalTime;
    private String bookTitle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        bookTitle = getIntent().getExtras().getString("bookTitle");
        storyContent = (TextView) findViewById(R.id.storyContentTextView);
        storyContent.setMovementMethod(new ScrollingMovementMethod());
        playButton = (Button) findViewById(R.id.playButton);
        elapsedTimeLabel = (TextView) findViewById(R.id.elapsedTimeLabel);
        remainingTimeLabel = (TextView) findViewById(R.id.remainingTimeLabel);
        Uri bookPath = Uri.parse("android.resource://" + getPackageName() + "/raw/" + ""
            + formatBookTitle(bookTitle));
        Uri storyContentPath = Uri.parse("android.resource://" + getPackageName() + "/raw/" + "story_"
                + formatBookTitle(bookTitle));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i;
        try {
            InputStream inputStream = getContentResolver().openInputStream(storyContentPath);
            i = inputStream.read();
            while (i != -1)
            {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        storyContent.setText(byteArrayOutputStream.toString());

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
        finish();
    }

    @Override
    public void onBackPressed() {
        back_to_home_page(new View(this));
    }

    private String formatBookTitle(String title) {
        title = title.toLowerCase();
        title = title.replaceAll(" ", "_");
        title = title.replaceAll("\\?", "");
        title = title.replaceAll("'s", "s");
        Log.d("DEBUG", title);
        return title;
    }

}//

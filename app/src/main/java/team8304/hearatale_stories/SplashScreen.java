package team8304.hearatale_stories;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIMEOUT = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent navigateHomePage = new Intent(SplashScreen.this, Home_Page.class);
                startActivity(navigateHomePage);
                finish();
            }
        }, SPLASH_TIMEOUT);
    }
}

package code.gift.qr.kenny.qrgiftcode;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;


public class SplashScreenActivity extends Activity {

    //Tiempo de duracionn del splash
    private static final long SPLASH_SCREEN_DELAY = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Definimos orientacion del splash
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_splash_screen);

        //Definimos la actividad que seguira del splash
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // Start the next activity
                Intent mainIntent = new Intent().setClass(
                        SplashScreenActivity.this, LoginActivity.class);
                startActivity(mainIntent);

                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };

        //Enviamos el metodo y el tiempo
        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);



    }

}

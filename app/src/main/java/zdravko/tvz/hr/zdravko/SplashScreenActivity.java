package zdravko.tvz.hr.zdravko;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class SplashScreenActivity extends ActionBarActivity {
    private boolean _active = true;
    private int _splashTime = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (_active && (waited < _splashTime)) {
                        sleep(100);
                        if (_active) {
                            waited += 100;
                        }
                    }
                } catch (Exception e) {

                } finally {

                    startActivity(new Intent(SplashScreenActivity.this,
                            MainActivity.class));
                    finish();
                }
            };
        };
        splashTread.start();
    }
    }




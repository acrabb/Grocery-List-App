package acrabb.glist;
import acrabb.glist.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author Andre Crabb
 *
 */
public class SplashActivity extends Activity {
    
    protected boolean active = true;
    protected int splashTime = 5000; // time to display the splash screen in ms

    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
     // thread for displaying the SplashScreen
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while(active && (waited < splashTime)) {
                        sleep(100);
                        if(active) {
                            waited += 100;
                        }
                    }
                } catch(InterruptedException e) {
                    // do nothing
                } finally {
                    finish();
                    SplashActivity.this.finish();
                    stop();
                }
            }
        };
        splashTread.start();
    }
}

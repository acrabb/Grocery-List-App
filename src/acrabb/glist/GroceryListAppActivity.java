package acrabb.glist;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class GroceryListAppActivity extends Activity {
    private ArrayList<ListItem> items = new ArrayList<ListItem>();
    
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.startActivity(new Intent(this, SplashActivity.class));
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
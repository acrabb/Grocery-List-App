package acrabb.glist;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class GroceryListAppActivity extends Activity {
    private ArrayList<ListItem> items = new ArrayList<ListItem>();
    
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.main_lists_menu, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	switch(item.getItemId()){
    		case R.id.add_list:
//    			Toast.makeText(this, "RAWWWWWWRRR", Toast.LENGTH_LONG).show();
    			AlertDialog.Builder listNameAlert =
    				new AlertDialog.Builder(this);
    			listNameAlert.setTitle("New List");
    			listNameAlert.setMessage("Enter a name for your new list:");
    			
    			//set an editText view to get user input
    			final EditText input = new EditText(this);
    			listNameAlert.setView(input);
    			
    			listNameAlert.setPositiveButton("OK",
    					new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						String value = input.getText().toString(); 
						Toast.makeText(GroceryListAppActivity.this, 
								value, Toast.LENGTH_SHORT).show();
						
						
					}
				});
    			
    			listNameAlert.setNegativeButton("Cancel",
    					new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.cancel();
					}
				});
    			
    			listNameAlert.show();
    			return true;
    		default:
    			return super.onOptionsItemSelected(item);
    	}
    }
    
}
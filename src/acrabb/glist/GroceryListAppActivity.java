package acrabb.glist;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;

public class GroceryListAppActivity extends ListActivity {
    private ArrayList<List> lists = new ArrayList<List>();
    ListDataHelper data;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.setListAdapter(new MainListAdapter(this, lists));
        
        data = new ListDataHelper(this);
        SQLiteDatabase readable = data.getReadableDatabase();
        //NON BLOCKING POPUP!!
        //DONT DO THIS!!!: data.addUser("Zach");
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
    			AlertDialog.Builder listNameAlert =
    				new AlertDialog.Builder(this);
    			listNameAlert.setTitle("New List");
    			listNameAlert.setMessage("Enter a name for your new list:");
    			
    			//set an editText view to get user input
    			final EditText input = new EditText(this);
    			listNameAlert.setView(input);
    			
    			listNameAlert.setPositiveButton("OK",
    					new DialogInterface.OnClickListener() {
					
    				//OK BUTTON
					@Override
					public void onClick(DialogInterface dialog, int which) {
						String value = input.getText().toString();
						//ADD VALUE TO LIST
						if (value != null && !value.equals("")){
							Toast.makeText(GroceryListAppActivity.this, 
								value, Toast.LENGTH_SHORT).show();
						lists.add(new List(value));
						}
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
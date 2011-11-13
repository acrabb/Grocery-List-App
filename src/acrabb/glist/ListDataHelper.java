package acrabb.glist;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.widget.EditText;
import android.widget.Toast;

public class ListDataHelper extends SQLiteOpenHelper {

	private static int version = 1;
	private Context context;
	
	private static final String USERS = "Users";
	private static final String CREATE_TABLE_USERS = "CREATE TABLE " + USERS +
	 " ( user_id INTEGER PRIMARY KEY, name TEXT, tab REAL);";

	private static final String LISTS = "Lists";
	private static final String CREATE_TABLE_LISTS = "CREATE TABLE " + LISTS +
	 " ( list_id INTEGER PRIMARY KEY, name TEXT, active BOOLEAN, " +
	 "personal BOOLEAN);";

	private static final String LIST_ITEMS = "List_Items";
	private static final String CREATE_TABLE_LIST_ITEMS = 
		"CREATE TABLE " + LIST_ITEMS + " ( item_id INTEGER PRIMARY KEY, " +
		"list_id INTEGER, name TEXT, price REAL, count INTEGER);";

	private static final String ITEM_PEOPLE = "Item_People";
	private static final String CREATE_TABLE_ITEM_PEOPLE = 
		"CREATE TABLE " + ITEM_PEOPLE + " ( item_id INTEGER, user_id INTEGER );";
	
	public ListDataHelper(Context context) {
		super(context, "GROCERY_LIST_DATA", null, version);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_USERS);
		db.execSQL(CREATE_TABLE_LISTS);
		db.execSQL(CREATE_TABLE_LIST_ITEMS);
		db.execSQL(CREATE_TABLE_ITEM_PEOPLE);
		
		AlertDialog.Builder listNameAlert =
			new AlertDialog.Builder(context);
		listNameAlert.setTitle("Welcome");
		listNameAlert.setMessage("What is your name?:");
		
		//set an editText view to get user input
		final EditText input = new EditText(context);
		listNameAlert.setView(input);
		
		listNameAlert.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
			
			//ADD ITEM BUTTON
			@Override
			public void onClick(DialogInterface dialog, int which) {
				String value = input.getText().toString();
				addUser(value);
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
	}
	
	public void addUser(String name){
		SQLiteDatabase dbw = this.getWritableDatabase();
		SQLiteDatabase dbr = this.getReadableDatabase();
		Cursor result = dbr.query(USERS, null, "name = '" + name + "'", 
				null, null, null, null);
		if(result.getCount() == 0){
			String query = "INSERT INTO " + USERS + " (name, tab) VALUES ('" + name 
							+ "', 0)";
			dbw.execSQL(query);
			Toast.makeText(context, name + " has been added.", Toast.LENGTH_SHORT).show();
		}else{
			result.moveToFirst();
			int uid = result.getInt(result.getColumnIndex("user_id"));
			Toast.makeText(context, name + 
					" already exists in the database, idiot (" + uid + ")", 
					Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

}

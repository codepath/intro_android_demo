package codepath.apps.demointroandroid;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.CursorLoader;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ContactListActivity extends Activity {
	
	ArrayList<String> names = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_list);
		loadContacts();
		populateListView();
	}

	private void populateListView() {
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
		  android.R.layout.simple_list_item_1, names);

		ListView listView = (ListView) findViewById(R.id.lvContacts);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(ContactListActivity.this, names.get(position), Toast.LENGTH_SHORT).show();
			}
		});
	}

	@SuppressLint("NewApi")
	private void loadContacts() {
		Uri allContacts = Uri.parse("content://contacts/people");
		CursorLoader cursorLoader = new CursorLoader(this, allContacts, 
		   null, // the columns to retrive 
		   null, // the selection criteria
		   null, // the selection args
		   null // the sort order
		);
		
		Cursor c = cursorLoader.loadInBackground();
		if (c.moveToFirst()) { 
			do {
			     // Get Contact ID
				int idIndex = c.getColumnIndex(ContactsContract.Contacts._ID);
				String contactID = c.getString(idIndex);

				// Get Contact Name
				int nameIndex = c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
				String contactDisplayName = c.getString(nameIndex);
				names.add(contactDisplayName);

				Log.d("debug", contactID + ", " + contactDisplayName); 
			} while (c.moveToNext());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_contact_list, menu);
		return true;
	}

}

package codepath.apps.demointroandroid;

import java.util.ArrayList;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.CursorLoader;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ContactListActivity extends Activity {


    boolean isPermissionGranted = false ;
    ArrayList<String> names = new ArrayList<String>();
    private RelativeLayout noPermission;
    private static final int MY_PERMISSION_READ = 1000 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        noPermission = (RelativeLayout) findViewById(R.id.acl_no_permission);
        checkPermissions();
    }


    private void checkPermissions(){
        boolean grantedPermissions = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                == PackageManager.PERMISSION_GRANTED;

        if(grantedPermissions){
            loadContacts();
            populateListView();
            noPermission.setVisibility(View.GONE);
        }
        else{
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CONTACTS},
                    MY_PERMISSION_READ);
        }
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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_READ: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    loadContacts();
                    populateListView();
                    noPermission.setVisibility(View.GONE);
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(ContactListActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                    noPermission.setVisibility(View.VISIBLE);

                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_contact_list, menu);
        return true;
    }

}

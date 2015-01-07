package codepath.apps.demointroandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SimpleListViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_list_view);
		String[] myStringArray = { "Bruce", "Wayne", "Bill" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
		  R.layout.simple_list_view_item, myStringArray);

		ListView listView = (ListView) findViewById(R.id.lvDemo);
		listView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_simple_list_view, menu);
		return true;
	}

}

package codepath.apps.demointroandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewClicksActivity extends Activity {
	ArrayAdapter<String> adapter; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view_clicks);
		String[] myCountries = { "United States", "Canada", "Mexico", "Japan" };
		adapter = new ArrayAdapter<String>(this, 
		  android.R.layout.simple_list_item_1, myCountries);

		ListView listView = (ListView) findViewById(R.id.lvDemo);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String country = adapter.getItem(position);
				SimpleAlertDialog.displayWithOK(ListViewClicksActivity.this, country);
				Toast.makeText(ListViewClicksActivity.this, country, Toast.LENGTH_SHORT).show();
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_list_view_clicks, menu);
		return true;
	}

}

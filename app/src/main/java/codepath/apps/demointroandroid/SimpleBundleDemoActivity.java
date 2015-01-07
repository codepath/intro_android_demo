package codepath.apps.demointroandroid;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SimpleBundleDemoActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_bundle_demo);
		String initialText = getIntent().getStringExtra("text");
		TextView tvDisplayText = (TextView) findViewById(R.id.tvDisplayText);
		if (initialText != null)
		  tvDisplayText.setText(initialText);
		getActionBar().setHomeButtonEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_simple_bundle_demo, menu);
		return true;
	}
	
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	  switch (item.getItemId()) {
	  case android.R.id.home:
		Intent i = new Intent(this, ActionBarMenuActivity.class);
		startActivity(i);
		 break;
	  default:
		break;
	  }
	  return true;
	}

}

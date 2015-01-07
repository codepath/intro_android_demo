package codepath.apps.demointroandroid;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class ViewAttributesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_attributes);
		TextView tvMain = (TextView) findViewById(R.id.tvMain);
		Log.d("DEBUG", tvMain.getText().toString());
		Toast.makeText(this, tvMain.getText().toString(), Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_view_attributes, menu);
		return true;
	}

}

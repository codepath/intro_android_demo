package codepath.apps.demointroandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class PersistSettingsActivity extends Activity {
	
	SharedPreferences prefs;
	Editor edits;
	TextView txtPersist;
	CheckBox chkPersist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_persist_settings);
		txtPersist = (TextView) findViewById(R.id.txtPersistText);
		chkPersist = (CheckBox) findViewById(R.id.chkPersistState);
		prefs = getSharedPreferences("view", 0);
		edits = prefs.edit();
		populateValues();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_persist_settings, menu);
		return true;
	}
	
	public void populateValues() {
		String persistedText = prefs.getString("txtVal", "None Stored Yet");
		boolean isChecked = prefs.getBoolean("chkState", false);
		txtPersist.setText(persistedText);
		chkPersist.setChecked(isChecked);
	}
	
	public void persistValues(View v) {
		edits.putString("txtVal", txtPersist.getText().toString());
		edits.putBoolean("chkState", chkPersist.isChecked());
		edits.commit();
		Toast.makeText(this, "Persisted!", Toast.LENGTH_SHORT).show();
	}

}

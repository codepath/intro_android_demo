package codepath.apps.demointroandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerWithToastActivity extends Activity {
	Spinner spinner;
	Button btnSpinnerVal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner_with_toast);
		spinner = (Spinner) findViewById(R.id.spnOptions); 
		btnSpinnerVal = (Button) findViewById(R.id.btnSpinnerValue);
		loadSpinner();
	}

	private void loadSpinner() {
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		  R.array.spinner_options, android.R.layout.simple_spinner_item);
		// Set layout style during dropdown
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Load data from adapter
		spinner.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_spinner_with_toast, menu);
		return true;
	}
	
	public void displayVal(View v) {
		Toast.makeText(this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
	}

}

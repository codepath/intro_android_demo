package codepath.apps.demointroandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ToastFormInputsActivity extends Activity {
	
	EditText etVal;
	CheckBox chkVal;
	RadioGroup rdgVal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toast_form_inputs);
		etVal = (EditText) findViewById(R.id.etVal);
		chkVal = (CheckBox) findViewById(R.id.chkVal);
		rdgVal = (RadioGroup) findViewById(R.id.rdgVal);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_toast_form_inputs, menu);
		return true;
	}
	
	public void toastInputs(View v) {
		int selected = rdgVal.getCheckedRadioButtonId();
		RadioButton b = (RadioButton) findViewById(selected);
		
		String text = etVal.getText() + " | " + chkVal.isChecked() + " | " + b.getText();
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}

}

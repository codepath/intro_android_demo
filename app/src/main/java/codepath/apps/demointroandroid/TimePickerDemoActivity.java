package codepath.apps.demointroandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class TimePickerDemoActivity extends Activity {
	
	TimePicker tpTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_time_picker_demo);
		tpTime = (TimePicker) findViewById(R.id.tpTime);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_time_picker_demo, menu);
		return true;
	}
	
	public void displayTime(View v) {
		String time = tpTime.getCurrentHour() + ":" + tpTime.getCurrentMinute();
		Toast.makeText(this, time, Toast.LENGTH_SHORT).show();
	}

}

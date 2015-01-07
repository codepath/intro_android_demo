package codepath.apps.demointroandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class SimpleReturnResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_return_result);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_simple_return_result, menu);
		return true;
	}
	
	public void sendResult(View v) {
		String result = ((EditText) findViewById(R.id.txtRandomResultText)).getText().toString();
		Intent i = new Intent();
		i.putExtra("result", result);
		setResult(RESULT_OK, i);
		finish();
	}

}

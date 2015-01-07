package codepath.apps.demointroandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class BasicClickHandlersActivity extends Activity {
  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_basic_click_handlers);
		Button secondButton = (Button) findViewById(R.id.btnClick2);
		secondButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				secondButtonClicked(v);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_basic_click_handlers, menu);
		return true;
	}
	
	public void firstButtonClicked(View v) {
		SimpleAlertDialog.displayWithOK(this, "firstButton clicked via XML handler");
	}
	
	private void secondButtonClicked(View v) {
		SimpleAlertDialog.displayWithOK(this, "secondButton clicked via Java handler in onCreate");
	}

}

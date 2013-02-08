package codepath.apps.demointroandroid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PublishingInstructionsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_publishing_instructions);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.activity_publishing_instructions, menu);
		return true;
	}

}

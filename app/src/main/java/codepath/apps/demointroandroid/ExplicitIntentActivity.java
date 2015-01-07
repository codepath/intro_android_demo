package codepath.apps.demointroandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ExplicitIntentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_explicit_intent);
		Button btnLaunchSecond = (Button) findViewById(R.id.btnLaunchSecond);
		btnLaunchSecond.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(ExplicitIntentActivity.this, SimpleBundleDemoActivity.class);
				i.putExtra("text", "Passed String Extra!");
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_explicit_intent, menu);
		return true;
	}

}

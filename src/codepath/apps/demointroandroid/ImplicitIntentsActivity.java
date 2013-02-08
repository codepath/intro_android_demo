package codepath.apps.demointroandroid;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ImplicitIntentsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_implicit_intents);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_implicit_intents, menu);
		return true;
	}
	
	public void visitUrlAddress(View v) {
		Uri url = getUriToVisit();
		if (url != null) {
			Intent i = new Intent(Intent.ACTION_VIEW);
			i.setData(url);
			startActivity(i); 
		}
			
	}
	
	public Uri getUriToVisit() {
		String urlAddress =  ((TextView) findViewById(R.id.txtUrlAddress)).getText().toString();
		if (urlAddress != null) {
		  if (!urlAddress.startsWith("http://"))
		     urlAddress = "http://" + urlAddress;
		  return Uri.parse(urlAddress);
		} else {
		  return null;
		}
	}

}

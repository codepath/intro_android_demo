package codepath.apps.demointroandroid;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class AsyncTaskPerformActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_async_task_perform);
		new MyAsyncTask().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_async_task_perform, menu);
		return true;
	}
	
	public void doneCounting() {
		Toast.makeText(this, "Done Counting to 100000", Toast.LENGTH_SHORT).show();
	}
	
	private class MyAsyncTask extends AsyncTask<Void, Void, Void> {
	     public Void doInBackground(Void... params) {
	    	for (long i=0; i < 100000; i++) {
	    		System.out.println(i);
	    	}
			return null;
	     }

	     protected void onPostExecute(Void result) {
	    	 doneCounting();
	     }
	}

}

package codepath.apps.demointroandroid;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpStatus;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

public class ProgressBarActivity extends Activity {
	
	ProgressBar pb;
	TextView tvResult;
	ArrayList<String> lines = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progress_bar);
		pb = (ProgressBar) findViewById(R.id.pgDownloading);
		tvResult = (TextView) findViewById(R.id.txtUrlOutput);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_progress_bar, menu);
		return true;
	}
	
	public void startFourUrlAsync(View v) {
       new DelayTask().execute();
	}
	
	public class DelayTask extends AsyncTask<Void, Integer, String> {
		int count = 0;
		@Override
		protected void onPreExecute() {
		  pb.setVisibility(ProgressBar.VISIBLE);
		}

		@Override
		protected String doInBackground(Void... params) {
			String res = loadUrlBody("http://google.com");
			lines.add(res.split("\n")[0]);
			publishProgress(25);
			res = loadUrlBody("http://yahoo.com");
			lines.add(res.split("\n")[0]);
			publishProgress(50);
			res = loadUrlBody("http://twitter.com");
			lines.add(res.split("\n")[0]);
			publishProgress(75);
			res = loadUrlBody("http://facebook.com");
			lines.add(res.split("\n")[0]);
			publishProgress(100);
			return "complete";
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			 pb.setProgress(values[0]);
		}
		
		@Override
		protected void onPostExecute(String result) {
			Toast.makeText(ProgressBarActivity.this, "Completed!", Toast.LENGTH_SHORT).show();
			tvResult.setText(lines.toString());
		}
		
		protected String loadUrlBody(String address) {
			HttpClient httpclient = new DefaultHttpClient();
		    HttpResponse response = null;
			String responseString = null;
			try {
				response = httpclient.execute(new HttpGet(address));
				StatusLine statusLine = response.getStatusLine();
			    if(statusLine.getStatusCode() == HttpStatus.SC_OK){
			        ByteArrayOutputStream out = new ByteArrayOutputStream();
			        response.getEntity().writeTo(out);
			        out.close();
			        responseString = out.toString();
			    } else{
			        response.getEntity().getContent().close();
			        throw new IOException(statusLine.getReasonPhrase());
			    }
			} catch (ClientProtocolException e) {
			} catch (IOException e) {
			}
			
		    return responseString;
		}
		
	}

}

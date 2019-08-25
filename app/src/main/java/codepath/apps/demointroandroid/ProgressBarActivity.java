package codepath.apps.demointroandroid;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.stetho.server.http.HttpStatus;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
            String res = loadUrlBody("https://google.com");
            lines.add(res.split("\n")[0]);
            publishProgress(25);
            res = loadUrlBody("https://yahoo.com");
            lines.add(res.split("\n")[0]);
            publishProgress(50);
            res = loadUrlBody("https://twitter.com");
            lines.add(res.split("\n")[0]);
            publishProgress(75);
            res = loadUrlBody("https://facebook.com");
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
            OkHttpClient httpclient = new OkHttpClient();
            Response response;
            String responseString = null;
            try {
                response = httpclient.newCall(new Request.Builder().url(address).build()).execute();
                int statusCode = response.code();
                if (statusCode == HttpStatus.HTTP_OK) {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    out.write(response.body().bytes());
                    responseString = out.toString();
                    out.close();
                } else {
                    response.body().byteStream().close();
                    throw new IOException(response.message());
                }
            } catch (IOException e) {
                Log.e(ProgressBarActivity.class.getSimpleName(),
                        "Error retrieving data from: " + address, e);
            }

            return responseString;
        }

    }

}

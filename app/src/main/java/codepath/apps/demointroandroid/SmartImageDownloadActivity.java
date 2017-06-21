package codepath.apps.demointroandroid;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BinaryHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class SmartImageDownloadActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_smart_image_download);
		downloadSmartImageFromUrl("http://2.gravatar.com/avatar/858dfac47ab8176458c005414d3f0c36?s=128&d=&r=G");
	}

	private void downloadSmartImageFromUrl(String address) {
		AsyncHttpClient client = new AsyncHttpClient();
		client.get(address, new
				BinaryHttpResponseHandler() {
					@Override
					public void onSuccess(int statusCode, Header[] headers, byte[] image) {
						Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
						ImageView img = (ImageView) findViewById(R.id.ivSmartImage);
						img.setImageBitmap(bitmap);

					}

					@Override
					public void onFailure(int statusCode, Header[] headers, byte[] binaryData, Throwable error) {
						error.printStackTrace();
					}
				}
		);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_smart_image_download, menu);
		return true;
	}

}

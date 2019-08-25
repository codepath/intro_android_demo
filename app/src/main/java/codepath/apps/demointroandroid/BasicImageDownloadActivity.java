package codepath.apps.demointroandroid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class BasicImageDownloadActivity extends Activity {

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_image_download);
        StrictMode.setThreadPolicy(
                new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
        downloadImageFromUri("https://2.gravatar.com/avatar/858dfac47ab8176458c005414d3f0c36?s=128&d=&r=G");
    }

    private void downloadImageFromUri(String address) {
        URL url;
        try {
            url = new URL(address);
        } catch (MalformedURLException e1) {
            url = null;
        }

        URLConnection conn;
        InputStream in;
        Bitmap bitmap;
        try {
            conn = url.openConnection();
            conn.connect();
            in = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(in);
            in.close();
        } catch (IOException e) {
            bitmap = null;
        }

        if (bitmap != null) {
            ImageView img = (ImageView) findViewById(R.id.ivBasicImage);
            img.setImageBitmap(bitmap);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_basic_image_download, menu);
        return true;
    }

}

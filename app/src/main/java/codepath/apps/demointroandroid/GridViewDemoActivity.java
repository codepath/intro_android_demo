package codepath.apps.demointroandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewDemoActivity extends Activity {
	
	GridView gvImages;
	GridImageAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_view_demo);
		populateGridViewImages();
	}

	private void populateGridViewImages() {
		gvImages = (GridView) findViewById(R.id.gvImages);
		String[] numbers = new String[] { "ad", "ae", "af", "ag", "ai", "al"};
		adapter = new GridImageAdapter(this,
				android.R.layout.simple_list_item_1, numbers);
		gvImages.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_grid_view_demo, menu);
		return true;
	}
	
	class GridImageAdapter extends ArrayAdapter<String> {

		public GridImageAdapter(Context context, int textViewResourceId, String[] numbers) {
			super(context, textViewResourceId, numbers);
		}
		
		public View getView(int position, View convertView, ViewGroup parent) {
		    ImageView v = new ImageView(GridViewDemoActivity.this);
		    int resId = getResources().getIdentifier(getItem(position), "drawable", getPackageName());
		    v.setImageDrawable(getResources().getDrawable(resId));
		    return v;
		}
	
	}

}

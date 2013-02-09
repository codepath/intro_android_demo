package codepath.apps.demointroandroid;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

public class DemoSelector extends Activity {
	
	ExpandableListView elvChapters;
	ChaptersListAdapter elaAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo_selector);
	    setupChaptersListView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_demo_selector, menu);
		return true;
	}
	
	private void setupChaptersListView() {
		elvChapters = (ExpandableListView)findViewById(R.id.elvChapters);
		elaAdapter = new ChaptersListAdapter();
		elvChapters.setAdapter(elaAdapter);
		elvChapters.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				
				String exerciseTitle =  (String)elaAdapter.getChild(groupPosition, childPosition);
                Class<? extends Activity> exerciseClass = elaAdapter.getExerciseClass(groupPosition, childPosition, id);
                if (exerciseClass != null) {
                	Toast.makeText(DemoSelector.this, exerciseTitle, Toast.LENGTH_LONG).show();
                	startActivity(new Intent(DemoSelector.this, exerciseClass));	
                } else {
                	Toast.makeText(DemoSelector.this, "Exercise Not Available", Toast.LENGTH_SHORT).show();
                }
				return false;
			}
		});

	}
	
	private class ChaptersListAdapter extends BaseExpandableListAdapter {
        private String[] chapters = getResources().getStringArray(R.array.chapters);
        private String[][] exercises;
        
        public ChaptersListAdapter() {
        	super();
        	exercises = new String[chapters.length][];
        	for (int i=0; i < exercises.length; i++) {
        		int resId = getResources().getIdentifier("chap" + (i+1), "array", getPackageName());
        		exercises[i] = getResources().getStringArray(resId);
        	}
        }


        public Object getChild(int groupPosition, int childPosition) {
            return exercises[groupPosition][childPosition];
        }

        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        public int getChildrenCount(int groupPosition) {
            return exercises[groupPosition].length;
        }

        public TextView getGenericView() {
            // Layout parameters for the ExpandableListView
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            TextView textView = new TextView(DemoSelector.this);
            textView.setLayoutParams(lp);
            // Center the text vertically
            textView.setTextSize(20);
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            // Set the text starting position
            textView.setPadding(60, 20, 20, 20);
            return textView;
        }

        public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                View convertView, ViewGroup parent) {
            TextView textView = getGenericView();
            textView.setPadding(80, 20, 20, 20);
            textView.setText(getChild(groupPosition, childPosition).toString());
            return textView;
        }

        public Object getGroup(int groupPosition) {
            return "Chapter " + (groupPosition + 1) + ": " + chapters[groupPosition];
        }

        public int getGroupCount() {
            return chapters.length;
        }

        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                ViewGroup parent) {
            TextView textView = getGenericView();
            textView.setText(getGroup(groupPosition).toString());
            return textView;
        }

        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        public boolean hasStableIds() {
            return true;
        }	
        
        public Class<? extends Activity> getExerciseClass(int groupPosition, int childPosition, long id) {
        	String exerciseId = "chap" + (groupPosition + 1) + "ex" + (childPosition + 1);
        	return ExerciseActivityMapper.getExerciseClass(exerciseId);
        }
	}

}

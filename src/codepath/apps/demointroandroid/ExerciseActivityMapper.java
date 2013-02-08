package codepath.apps.demointroandroid;

import java.util.HashMap;

import android.app.Activity;

public class ExerciseActivityMapper {
  private static ExerciseActivityMapper singleton;
  private HashMap<String, Class<? extends Activity>> exerciseClassMap;
	
  public ExerciseActivityMapper() {
	  defineExerciseMappings();
  }

  // ExerciseActivityMapper.getExerciseClass("chap1ex1");
  public static Class<? extends Activity> getExerciseClass(String exerciseId) {
	  return getSingleton().exerciseClassMap.get(exerciseId);
  }
  
  private static ExerciseActivityMapper getSingleton() {
	  if (singleton == null) {
		  singleton = new ExerciseActivityMapper();
	  }
	  return singleton;
  }
  
  private void defineExerciseMappings() {
	  exerciseClassMap = new HashMap<String, Class<? extends Activity>>();
	  // Chapter 1: App Fundamentals
	  exerciseClassMap.put("chap1ex1", BasicTextViewActivity.class);
	  // Chapter 2: User Interface
	  exerciseClassMap.put("chap2ex1", LinearLayoutDemoActivity.class);
	  // Chapter 3: View Controls
	  exerciseClassMap.put("chap3ex1", LayoutGravityActivity.class);
	  exerciseClassMap.put("chap3ex2", BasicViewsActivity.class);
	  exerciseClassMap.put("chap3ex3", ViewAttributesActivity.class);
	  exerciseClassMap.put("chap3ex4", SimpleListViewActivity.class);
	  // Chapter 4: User Interactions
	  exerciseClassMap.put("chap4ex1", BasicClickHandlersActivity.class);
	  exerciseClassMap.put("chap4ex2", ListViewClicksActivity.class);
	  // Chapter 5: User Flows
	  exerciseClassMap.put("chap5ex1", ExplicitIntentActivity.class); // Explicit Intents
	  exerciseClassMap.put("chap5ex2", ImplicitIntentsActivity.class); // Implicit Intents
	  exerciseClassMap.put("chap5ex3", IntentWithResultActivity.class); // Intent with Results
	  exerciseClassMap.put("chap5ex4", ActionBarMenuActivity.class); // Action Bar
	  // Chapter 6: Networking
	  exerciseClassMap.put("chap6ex1", BasicImageDownloadActivity.class); // Basic Image Download
	  exerciseClassMap.put("chap6ex2", AsyncTaskPerformActivity.class); // AsyncTask
	  exerciseClassMap.put("chap6ex3", SmartImageDownloadActivity.class); // Smart Image Download
	  // Chapter 7: Advanced Views
	  exerciseClassMap.put("chap7ex1", ToastFormInputsActivity.class); // Toast Inputs
	  exerciseClassMap.put("chap7ex2", SpinnerWithToastActivity.class); // Spinner Toast
	  exerciseClassMap.put("chap7ex3", TimePickerDemoActivity.class); // TimePicker
	  exerciseClassMap.put("chap7ex4", ProgressBarActivity.class); // ProgressBar
	  exerciseClassMap.put("chap7ex5", GridViewDemoActivity.class); // GridView
	  // Chapter 8: Preferences
	  exerciseClassMap.put("chap8ex1", PersistSettingsActivity.class); // Persist Settings
	  // Chapter 9: ContentProviders
	  exerciseClassMap.put("chap9ex1", ContactListActivity.class); // Contact List
	  // Chapter 10: Publishing
	  exerciseClassMap.put("chap10ex1", PublishingInstructionsActivity.class); // APK Generation
  }
}

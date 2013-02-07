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
	  exerciseClassMap.put("chap1ex1", BasicTextViewActivity.class);
	  exerciseClassMap.put("chap2ex1", LinearLayoutDemoActivity.class);
	  exerciseClassMap.put("chap3ex1", LayoutGravityActivity.class);
	  exerciseClassMap.put("chap3ex2", BasicViewsActivity.class);
	  exerciseClassMap.put("chap3ex3", ViewAttributesActivity.class);
	  exerciseClassMap.put("chap3ex4", SimpleListViewActivity.class);
	  exerciseClassMap.put("chap4ex1", null);
	  exerciseClassMap.put("chap4ex2", null);
	  exerciseClassMap.put("chap4ex3", null);
	  exerciseClassMap.put("chap5ex1", null);
	  exerciseClassMap.put("chap5ex2", null);
	  exerciseClassMap.put("chap5ex3", null);
	  exerciseClassMap.put("chap5ex4", null);
	  exerciseClassMap.put("chap6ex1", null);
	  exerciseClassMap.put("chap6ex2", null);
	  exerciseClassMap.put("chap6ex3", null);
	  exerciseClassMap.put("chap6ex4", null);
	  exerciseClassMap.put("chap7ex1", null);
	  exerciseClassMap.put("chap7ex2", null);
	  exerciseClassMap.put("chap7ex3", null);
	  exerciseClassMap.put("chap7ex4", null);
	  exerciseClassMap.put("chap7ex5", null);
	  exerciseClassMap.put("chap8ex1", null);
	  exerciseClassMap.put("chap9ex1", null);
	  exerciseClassMap.put("chap10ex1", null);
  }
}

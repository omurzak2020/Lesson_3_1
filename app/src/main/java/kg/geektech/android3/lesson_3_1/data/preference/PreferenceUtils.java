package kg.geektech.android3.lesson_3_1.data.preference;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtils {

    private static SharedPreferences preferences;

    private static final String PREF_NAME = "preferenceName";
    private static final String KEY_USER_NAME = "userName";

    private PreferenceUtils() {}

    public static PreferenceUtils getPreferences(Context context) {
        if (preferences != null) {
            preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        }
        return new PreferenceUtils();
    }

//    public static void init(Context context) {
//        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
//    }

    public void saveUserName(String userName) {
        preferences.edit().putString(KEY_USER_NAME, userName).apply();
    }

    public String getUserName(String id) {
        return preferences.getString(KEY_USER_NAME, "");
    }
}

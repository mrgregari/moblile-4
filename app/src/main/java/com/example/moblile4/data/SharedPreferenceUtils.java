package com.example.moblile4.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceUtils {

    private static final String PREFS_NAME = "MyPreferences";
    private static final String KEY_DATA = "data";

    public static void saveData(Context context, String data) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_DATA, data);
        editor.apply();
    }

    public static String loadData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_DATA, null);
    }
}
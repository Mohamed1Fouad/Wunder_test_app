package test.wunder.com.wundertestapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import test.wunder.com.wundertestapp.data.remote.RetrofitClient;
import test.wunder.com.wundertestapp.data.remote.RetrofitService;

public class Utils {
    private static SharedPreferences app_preferences;

    public static RetrofitService getService() {
        return RetrofitClient.getClient(Constants.BASE_URL).create(RetrofitService.class);
    }


    public static boolean downloadFirstTime(Context context) {
        Boolean isFirstTime;
        app_preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = app_preferences.edit();
        isFirstTime = app_preferences.getBoolean("isFirstTime", true);

        if (isFirstTime) {
            editor.putBoolean("isFirstTime", false);
            editor.commit();
        }
        return isFirstTime;
    }
}

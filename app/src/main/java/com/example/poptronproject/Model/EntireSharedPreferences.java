package com.example.poptronproject.Model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class EntireSharedPreferences {
    public static final String MyPRE = "myPreference";
    public static String Email = "emailKey";
    public static final String Password = "passKey";
    public static String Name = "namekey";
    public static final String Login = "statusKey";
    public static final String MyViewPager = "viewpager";

    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    public static void cInitialize(Context context) {
        sharedPreferences = context.getSharedPreferences(MyPRE, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    //    putUserCredentials
    public static void putUserName(String name) {
        editor.putString(Name, name).commit();

    }

    public static void putMailId(String email) {
        editor.putString(Email, email).commit();

    }

    public static void putPassword(String pass) {
        editor.putString(Password, pass).commit();

    }

    //   getUserCredentials
    public static String getUserName() {
        return sharedPreferences.getString(Name, "editName");

    }

    public static String getEmail() {
        return sharedPreferences.getString(Email, "editEmail");

    }

    public static String getPassword() {
        return sharedPreferences.getString(Password, "editPassword");
    }

    // once loggedIn it should not login again

    public static Boolean onceLoggedIn() {
        return sharedPreferences.getBoolean(Login, true);
    }

    public static void doesNotLogin(boolean bool) {
        editor.putBoolean(Login, bool).commit();

    }

    //once Viewpager loggedIn
    public static Boolean onceViewpagerLoggedIn() {
        return sharedPreferences.getBoolean(MyViewPager, true);
    }

    public static void viewPagerDoesNotLogin(boolean bool) {
        editor.putBoolean(MyViewPager, bool).commit();

    }

}

package com.idiots.smart_code_generater;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;


public class LocationFragment extends PreferenceFragment{

    private final static String beep = "beep";
    private final static String frontCamera = "frontCamera";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.settings);
    }

}

package com.octavi.lab;

import com.android.internal.logging.nano.MetricsProto.MetricsEvent;

import android.os.Bundle;
import android.content.res.Resources;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.Preference.OnPreferenceChangeListener;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class OctaviLab extends SettingsPreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from XML
        addPreferencesFromResource(R.xml.octavi_lab);
        final PreferenceScreen screen = getPreferenceScreen();

        if (screen == null) {
            android.util.Log.e("OctaviLab", "PreferenceScreen is null");
            return;
        }

        // Log the number of preferences found
        final int count = screen.getPreferenceCount();
        android.util.Log.d("OctaviLab", "Found " + count + " preferences");

        // Each preference already has layout="@layout/cardview" in the XML
        // No need to set it again here, as it may interfere with the existing layout
        for (int i = 0; i < count; i++) {
            final Preference preference = screen.getPreference(i);
            if (preference == null) {
                android.util.Log.e("OctaviLab", "Preference at index " + i + " is null");
                continue;
            }
            // Log each preference that was found
            android.util.Log.d("OctaviLab", "Preference " + i + ": " + preference.getTitle());
        }
    }

    @Override
    public int getMetricsCategory() {
        return MetricsEvent.OCTAVI;
    }
}

package org.foree.duker.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.foree.duker.R;
import org.foree.duker.base.BaseActivity;
import org.foree.duker.ui.fragment.SettingsFragment;

/**
 * Created by foree on 16-7-28.
 * 设置界面
 */
public class SettingsActivity extends BaseActivity{
    private static final String TAG = SettingsActivity.class.getSimpleName();

    /**
     * keys for Application preference
     */
    // key: first launch
    public static final String KEY_FIRST_LAUNCH = "first_launch";
    // key: change theme
    public static final String KEY_THEME_SETTING = "theme_setting";
    // key: dark theme
    public static final String KEY_DARK_THEME = "dark_theme";
    // key: refresh on launch
    public static final String KEY_REFRESH_ON_LAUNCH = "refresh_on_launch";
    // key: offline wifi only
    public static final String KEY_OFFLINE_WIFI_ONLY = "offline_wifi_only";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        getFragmentManager().beginTransaction()
                .replace(R.id.fr_settings, new SettingsFragment())
                .commit();

    }
}

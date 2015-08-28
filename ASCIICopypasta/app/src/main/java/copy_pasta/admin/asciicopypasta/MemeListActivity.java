package copy_pasta.admin.asciicopypasta;

import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceFragment;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Scott on 20/08/15.
 */
public class MemeListActivity extends ActionBarActivity {
    private  FragmentManager fragManager = getFragmentManager();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        if(fragManager.findFragmentById(android.R.id.content) == null) {
            MemeListFragment memeFragment = new MemeListFragment();
            fragManager.beginTransaction().replace(android.R.id.content, memeFragment).commit();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return false;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            //Goes to the categories fragment
            case R.id.categories:
                categoryMenu();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    /*Setting the fragment for the categories menu */
    public void categoryMenu() {
        SettingsFragment settingsFragment = new SettingsFragment();
        fragManager.beginTransaction().addToBackStack(null).setCustomAnimations(R.animator.slide_in_top,
                R.animator.slide_out_bottom,
                R.animator.slide_in_bottom,
                R.animator.slide_out_top).replace(android.R.id.content,
                settingsFragment).commit();
    }
    /*Allows going back to the previous screen */
    @Override
    public void onBackPressed() {
        if(fragManager.getBackStackEntryCount() != 0) {
            fragManager.popBackStack();
        } else {
            super.onBackPressed();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

    }
    public static class SettingsFragment extends PreferenceFragment implements
            SharedPreferences.OnSharedPreferenceChangeListener {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
        @Override
        public void onResume() {
            super.onResume();
            getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        }
        @Override
        public void onPause() {
            super.onPause();
            getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        }
        @Override
        public void onSharedPreferenceChanged (SharedPreferences sharedPreferences, String key) {
            SharedPreferences sharedPref = getActivity().getSharedPreferences
                (getString(R.string.categories_settings), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean(key, sharedPreferences.getBoolean(key, false));
            editor.putString("button", key);
            editor.commit();
        }
    }
}

package copy_pasta.admin.asciicopypasta;

import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {
    private FragmentManager fragManager = getFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(fragManager.findFragmentById(android.R.id.content) == null) {
            MemeListFragment memeFragment = new MemeListFragment();
            fragManager.beginTransaction().
                    add(android.R.id.content, memeFragment).commit();

        }
    }
    @Override
    public void onBackPressed() {
        if(fragManager.getBackStackEntryCount() != 0) {
            fragManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.categories:
                categoryMenu();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void categoryMenu() {
            SettingsFragment settingsFragment = new SettingsFragment();
            fragManager.beginTransaction().addToBackStack(null).replace(android.R.id.content, settingsFragment).commit();
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

    }
    public static class SettingsFragment extends PreferenceFragment implements OnSharedPreferenceChangeListener{
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
            SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("twitch_memes", sharedPreferences.getBoolean("twitch_memes", false));
                editor.putString("button", "twitch_memes");
            editor.commit();
        }
    }
}

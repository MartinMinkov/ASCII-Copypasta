package copy_pasta.admin.asciicopypasta;

import android.app.FragmentManager;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


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
    public static class SettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }
}

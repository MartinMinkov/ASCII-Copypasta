package copy_pasta.admin.asciicopypasta;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Scott on 25/08/15.
 */
public class FavoritesActivity extends ActionBarActivity {
    private FragmentManager fragManager = getFragmentManager();
    @Override
    public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.main);
        if(fragManager.findFragmentById(android.R.id.content) == null) {
            FavoriteMemeListFragment memeFragment = new FavoriteMemeListFragment();
            fragManager.beginTransaction().
                    replace(android.R.id.content, memeFragment).commit();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}

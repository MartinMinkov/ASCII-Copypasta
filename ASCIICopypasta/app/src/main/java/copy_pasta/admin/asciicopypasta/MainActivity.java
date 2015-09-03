package copy_pasta.admin.asciicopypasta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Application starting activity which holds the two buttons to go to either the favorites or all
 * memes fragments.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Main Menu");
    }
    /*Intent for memeListFragment hosted Activity*/
    public void switchToMemeList(View view) {
        Intent intent = new Intent(this, MemeListActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void switchToFavoritesList(View view) {
        Intent intent = new Intent(this, FavoritesActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}

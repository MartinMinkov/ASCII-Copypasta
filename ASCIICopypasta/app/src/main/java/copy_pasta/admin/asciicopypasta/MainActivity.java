package copy_pasta.admin.asciicopypasta;

import android.app.FragmentManager;
import android.app.ListFragment;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private static ArrayList<String> test = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragManager = getFragmentManager();
        if(fragManager.findFragmentById(android.R.id.content) == null) {
            fragManager.beginTransaction().add(android.R.id.content, new MemeListFragment()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public class MemeListFragment extends ListFragment {
        private static final String TAG = "MemeListFragment On Click";
        android.content.ClipboardManager clipBoard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            test.add("( ͡° ͜ʖ ͡°)┌∩┐");
            test.add("(º‿º✿) PEACEFUL PROTEST (º‿º✿)");
            test.add("ヽ(ຈل͜ຈ)ﾉ ( ºل͟º ) ୧༼ ͡◉ل͜ ͡◉༽୨ (ง ͠° ل͜ °)ง ヽ(ຈل͜ຈ)ﾉ\n ( " +
                    "ºل͟º ) ୧༼ ͡◉ل͜ ͡◉༽୨ (ง ͠° ل͜ °)ง ヽ(ຈل͜ຈ)ﾉ ( ºل͟º ) ୧༼ ͡◉ل͜ ͡◉༽୨ \n" +
                    "(ง ͠° ل͜ °)ง \n Sorry, I dropped my bag of Dongers. \n ヽ(ຈل͜ຈ)ﾉ ( ºل͟º )\n " +
                    "୧༼ ͡◉ل͜ ͡◉༽୨ (ง ͠° ل͜ °)ง ヽ(ຈل͜ຈ)ﾉ ( ºل͟º ) ୧༼ ͡◉ل͜ ͡◉༽୨ (ง ͠° ل͜ °)ง\n" +
                    " ヽ(ຈل͜ຈ)ﾉ ( ºل͟º ) ୧༼ ͡◉ل͜ ͡◉༽୨ (ง ͠° ل͜ °)ง");
            test.add("---------------------------\n" +
                    "\n" +
                    "┈┈┈┈╱▏┈┈┈┈┈╱▔▔▔▔╲┈┈┈┈┈\n" +
                    "┈┈┈┈▏▏┈┈┈┈┈▏╲▕▋▕▋▏┈┈┈┈\n" +
                    "┈┈┈┈╲╲┈┈┈┈┈▏┈▏┈▔▔▔▆┈┈┈\n" +
                    "┈┈┈┈┈╲▔▔▔▔▔╲╱┈╰┳┳┳╯┈┈┈\n" +
                    "┈┈╱╲╱╲▏┈┈┈┈┈┈▕▔╰━╯┈┈┈┈\n" +
                    "┈┈▔╲╲╱╱▔╱▔▔╲╲╲╲┈┈┈┈┈┈┈\n" +
                    "┈┈┈┈╲╱╲╱┈┈┈┈╲╲▂╲▂┈┈┈┈┈\n" +
                    "┈┈┈┈┈┈┈┈┈┈┈┈┈╲╱╲╱┈┈┈┈┈");
            test.add("░░░░░░░░░░░░ \n" +
                    "░░░░░░░░░░░░▄▀▀▀▀▄░░░ \n" +
                    "░░░░░░░░░░▄▀░░▄░▄░█░░ \n" +
                    "░▄▄░░░░░▄▀░░░░▄▄▄▄█░░ \n" +
                    "█░░▀▄░▄▀░░░░░░░░░░█░░ \n" +
                    "░▀▄░░▀▄░░░░█░░░░░░█░░ \n" +
                    "░░░▀▄░░▀░░░█░░░░░░█░░ \n" +
                    "░░░▄▀░░░░░░█░░░░▄▀░░░ \n" +
                    "░░░▀▄▀▄▄▀░░█▀░▄▀░░░░░ \n" +
                    "░░░░░░░░█▀▀█▀▀░░░░░░░ \n" +
                    "░░░░░░░░▀▀░▀▀░░░░░░░░");

            ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater
                    .getContext(),
                    android.R.layout.simple_list_item_1, test);
            setListAdapter(adapter);
            return super.onCreateView(inflater, container, savedInstanceState);
        }
        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            Context context = getApplicationContext();
            CharSequence toastText = "Text has been copied to clipboard.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, toastText, duration);

            ClipData clip = ClipData.newPlainText(TAG, test.get(position));
            clipBoard.setPrimaryClip(clip);

            toast.show();
        }
    }
}

package copy_pasta.admin.asciicopypasta;

import android.app.FragmentManager;
import android.app.ListFragment;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

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
    public static class MemeListFragment extends ListFragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            test.add("( ͡° ͜ʖ ͡°)┌∩┐");
            test.add("(◕‿◕✿) PEACEFUL PROTEST (◕‿◕✿)");
            test.add("ヽ༼ຈل͜ຈ༽ﾉ ༼ ºل͟º ༽ ୧༼ ͡◉ل͜ ͡◉༽୨ (ง ͠° ل͜ °)ง ヽ༼ຈل͜ຈ༽ﾉ ༼ " +
                    "ºل͟º ༽ ୧༼ ͡◉ل͜ ͡◉༽୨ (ง ͠° ل͜ °)ง ヽ༼ຈل͜ຈ༽ﾉ ༼ ºل͟º ༽ ୧༼ ͡◉ل͜ ͡◉༽୨ " +
                    "(ง ͠° ل͜ °)ง Sorry, I dropped my bag of Dongers. ヽ༼ຈل͜ຈ༽ﾉ ༼ ºل͟º ༽ " +
                    "୧༼ ͡◉ل͜ ͡◉༽୨ (ง ͠° ل͜ °)ง ヽ༼ຈل͜ຈ༽ﾉ ༼ ºل͟º ༽ ୧༼ ͡◉ل͜ ͡◉༽୨ (ง ͠° ل͜ °)ง" +
                    " ヽ༼ຈل͜ຈ༽ﾉ ༼ ºل͟º ༽ ୧༼ ͡◉ل͜ ͡◉༽୨ (ง ͠° ل͜ °)ง");
            test.add("▒▒▒▒▒▒▄▄██████▄\n" +
                    "▒▒▒▒▒▒▒▒▒▒▄▄████████████▄\n" +
                    "▒▒▒▒▒▒▄▄██████████████████ \n" +
                    "▒▒▒▄████▀▀▀██▀██▌███▀▀▀████ \n"+
                    "▒▒▐▀████▌▀██▌▀▐█▌████▌█████▌\n" +
                    "▒▒█▒▒▀██▀▀▐█▐█▌█▌▀▀██▌██████\n" +
                    "▒▒█▒▒▒▒████████████████████▌\n" +
                    "▒▒▒▌▒▒▒▒█████░░░░░░░██████▀\n" +
                    "▒▒▒▀▄▓▓▓▒███░░░░░░█████▀▀\n" +
                    "▒▒▒▒▀░▓▓▒▐█████████▀▀▒\n" +
                    "▒▒▒▒▒░░▒▒▐█████▀▀▒▒▒▒▒▒ \n" +
                    "▒▒░░░░░▀▀▀▀▀▀▒▒▒▒▒▒▒▒▒\n" +
                    "▒▒▒░░░░░░░░▒▒");
            ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater
                    .getContext(),
                    android.R.layout.simple_list_item_1, test);
            setListAdapter(adapter);
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }
}

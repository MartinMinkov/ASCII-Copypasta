package copy_pasta.admin.asciicopypasta;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.ListActivity;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v7.internal.widget.ActivityChooserModel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Admin on 11/08/2015.
 */
public class MemeListActivity extends ListActivity {

    private static final String TAG = "MemeListActivity";
    private static ArrayList<Meme> mMemes;
    private static ArrayList<String> test = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragManager = getFragmentManager();
        if(fragManager.findFragmentById(android.R.id.content) == null) {
            fragManager.beginTransaction().add(android.R.id.content, new MemeListFragment()).commit();
        }
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
            test.add("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▄▄██████▄ ▒▒▒▒▒▒▒▒▒▒▄▄████████████▄ " +
                    "▒▒▒▒▒▒▄▄██████████████████ ▒▒▒▄████▀▀▀██▀██▌███▀▀▀████" +
                    " ▒▒▐▀████▌▀██▌▀▐█▌████▌█████▌ ▒▒█▒▒▀██▀▀▐█▐█▌█▌▀▀██▌██████ " +
                    "▒▒█▒▒▒▒████████████████████▌ ▒▒▒▌▒▒▒▒█████░░░░░░░██████▀ " +
                    "▒▒▒▀▄▓▓▓▒███░░░░░░█████▀▀ ▒▒▒▒▀░▓▓▒▐█████████▀▀▒ ▒▒▒▒▒░░▒▒▐█████▀▀▒▒▒▒▒▒" +
                    " ▒▒░░░░░▀▀▀▀▀▀▒▒▒▒▒▒▒▒▒ ▒▒▒░░░░░░░░▒▒ ");
            ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater
                    .getContext(),
                    android.R.layout.simple_list_item_1, test);
            setListAdapter(adapter);
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }
}

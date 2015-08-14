package copy_pasta.admin.asciicopypasta;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by root on 13/08/15.
 */
public class MemeListFragment extends ListFragment{
    private static ArrayList<String> test = new ArrayList<>();
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater
                    .getContext(),
                    android.R.layout.simple_list_item_1, test);
            setListAdapter(adapter);
            return super.onCreateView(inflater, container, savedInstanceState);
        }
        private void addMemes() {
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
                    "▒▒▒▄████▀▀▀██▀██▌███▀▀▀████ \n" +
                    "▒▒▐▀████▌▀██▌▀▐█▌████▌█████▌\n" +
                    "▒▒█▒▒▀██▀▀▐█▐█▌█▌▀▀██▌██████\n" +
                    "▒▒█▒▒▒▒████████████████████▌\n" +
                    "▒▒▒▌▒▒▒▒█████░░░░░░░██████▀\n" +
                    "▒▒▒▀▄▓▓▓▒███░░░░░░█████▀▀\n" +
                    "▒▒▒▒▀░▓▓▒▐█████████▀▀▒\n" +
                    "▒▒▒▒▒░░▒▒▐█████▀▀▒▒▒▒▒▒ \n" +
                    "▒▒░░░░░▀▀▀▀▀▀▒▒▒▒▒▒▒▒▒\n" +
                    "▒▒▒░░░░░░░░▒▒");
        }
        @Override
        public void onPause() {
            super.onPause();
            test.clear();
        }
        @Override
        public void onResume() {
            super.onResume();
            addMemes();
        }
}

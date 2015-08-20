package copy_pasta.admin.asciicopypasta;

import android.app.ListFragment;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by root on 13/08/15.
 */
public class MemeListFragment extends ListFragment{
    private static ArrayList<String> test = new ArrayList<>();
    private static final String TAG = "MemeListFragment On Click";
    private String sort;
    ClipboardManager clipBoard;
    View V;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
             clipBoard = (ClipboardManager) getActivity().
                    getSystemService(getActivity().getApplicationContext().CLIPBOARD_SERVICE);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater
                    .getContext(),
                    android.R.layout.simple_list_item_1, test);
            setListAdapter(adapter);
            V = new View(getActivity());
            return super.onCreateView(inflater, container, savedInstanceState);
        }
        private void addMemes() {
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
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //Set up a Toast message when an element is highlighted
        Context context = getActivity().getApplicationContext();
        CharSequence toastText = "Text has been copied to clipboard.";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, toastText, duration);

        //Set up the ClipBoard object to copy the meme to the clipboard.
        ClipData clip = ClipData.newPlainText(TAG, test.get(position));
        clipBoard.setPrimaryClip(clip);
        V.setBackgroundResource(0);
        v.setBackgroundResource(R.color.button_material_light);
        V = v;

        toast.show();
    }
    private boolean getSharedPreference() {
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String button = sharedPref.getString("button", null);
        return sharedPref.getBoolean(button, false);
    }
}

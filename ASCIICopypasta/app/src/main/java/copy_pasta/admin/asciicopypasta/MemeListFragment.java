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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * Created by root on 13/08/15.
 */
public class MemeListFragment extends ListFragment{
    private static ArrayList<String> test = new ArrayList<>();
    private static ArrayList<String> twitch = new ArrayList<>();
    private static ArrayList<String> reddit = new ArrayList<>();
    private static final String TAG = "MemeListFragment On Click";
    private String sort;
    private Boolean categories;
    ClipboardManager clipBoard;
    View V;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

             clipBoard = (ClipboardManager) getActivity().
                    getSystemService(getActivity().getApplicationContext().CLIPBOARD_SERVICE);
            MemeAdapter adapter = new MemeAdapter(test);
            setListAdapter(adapter);
            V = new View(getActivity());
            return super.onCreateView(inflater, container, savedInstanceState);
        }
        private void addMemes() {
            twitch.add("( ͡° ͜ʖ ͡°)┌∩┐");
            twitch.add("(º‿º✿) PEACEFUL PROTEST (º‿º✿)");
            twitch.add("ヽ(ຈل͜ຈ)ﾉ ( ºل͟º ) ୧༼ ͡◉ل͜ ͡◉༽୨ (ง ͠° ل͜ °)ง ヽ(ຈل͜ຈ)ﾉ\n ( " +
                    "ºل͟º ) ୧༼ ͡◉ل͜ ͡◉༽୨ (ง ͠° ل͜ °)ง ヽ(ຈل͜ຈ)ﾉ ( ºل͟º ) ୧༼ ͡◉ل͜ ͡◉༽୨ \n" +
                    "(ง ͠° ل͜ °)ง \n Sorry, I dropped my bag of Dongers. \n ヽ(ຈل͜ຈ)ﾉ ( ºل͟º )\n " +
                    "୧༼ ͡◉ل͜ ͡◉༽୨ (ง ͠° ل͜ °)ง ヽ(ຈل͜ຈ)ﾉ ( ºل͟º ) ୧༼ ͡◉ل͜ ͡◉༽୨ (ง ͠° ل͜ °)ง\n" +
                    " ヽ(ຈل͜ຈ)ﾉ ( ºل͟º ) ୧༼ ͡◉ل͜ ͡◉༽୨ (ง ͠° ل͜ °)ง");
            reddit.add("---------------------------\n" +
                    "\n" +
                    "┈┈┈┈╱▏┈┈┈┈┈╱▔▔▔▔╲┈┈┈┈┈\n" +
                    "┈┈┈┈▏▏┈┈┈┈┈▏╲▕▋▕▋▏┈┈┈┈\n" +
                    "┈┈┈┈╲╲┈┈┈┈┈▏┈▏┈▔▔▔▆┈┈┈\n" +
                    "┈┈┈┈┈╲▔▔▔▔▔╲╱┈╰┳┳┳╯┈┈┈\n" +
                    "┈┈╱╲╱╲▏┈┈┈┈┈┈▕▔╰━╯┈┈┈┈\n" +
                    "┈┈▔╲╲╱╱▔╱▔▔╲╲╲╲┈┈┈┈┈┈┈\n" +
                    "┈┈┈┈╲╱╲╱┈┈┈┈╲╲▂╲▂┈┈┈┈┈\n" +
                    "┈┈┈┈┈┈┈┈┈┈┈┈┈╲╱╲╱┈┈┈┈┈");
            reddit.add("░░░░░░░░░░░░ \n" +
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
            twitch.clear();
            reddit.clear();
        }
        @Override
        public void onResume() {
            super.onResume();
            categories = getSharedPreference();
            addMemes();
            setList();
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
        sort = sharedPref.getString("button", null);
        return sharedPref.getBoolean(sort, false);
    }
    //Adds the correct memes to the correct lists.
    private void setList() {
        if(sort == null || categories == false) {
                test.addAll(twitch);
                test.addAll(reddit);
        } else {
            switch (sort) {
                case "twitch_memes":
                    test.addAll(twitch);
                    break;
                case "reddit_memes":
                    test.addAll(reddit);
                    break;
            }
        }
    }
    private class MemeAdapter extends ArrayAdapter<String> {
        public MemeAdapter(ArrayList<String> memes) {
            super(getActivity(), 0, memes);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // If we weren't given a view, inflate one
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.listfragment_main, null);
            }
            // Configure the view for this Crime
            String c = getItem(position);
            ImageView favoriteIcon = (ImageView)convertView.findViewById(R.id.row_icon);
            favoriteIcon.setBackgroundResource(R.drawable.favorite_icon);
            TextView titleTextView =
                    (TextView)convertView.findViewById(R.id.row_title);
            titleTextView.setText(c);
            return convertView;
        }
    }
}

package copy_pasta.admin.asciicopypasta;

import android.app.ListFragment;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by Martin on 13/08/15.
 */
public class MemeListFragment extends ListFragment{
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;
    private HashSet<String> favorites = new HashSet<>();
    private static ArrayList<Meme> memeList = new ArrayList<>();
    private ArrayList<String> memeStrings = new ArrayList<>();
    private static final String TAG = "MemeListFragment On Click";
    private String sort;
    private Boolean categories;
    ClipboardManager clipBoard;
    View V;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
             clipBoard = (ClipboardManager) getActivity().
                    getSystemService(getActivity().getApplicationContext().CLIPBOARD_SERVICE);
            sharedPref = getActivity().getSharedPreferences(getString(R.string.favorite_memes),
                    Context.MODE_PRIVATE);
            editor = sharedPref.edit();
            if(sharedPref != null) {
                favorites = new HashSet<>(sharedPref.getStringSet("FavoritesSet", null));
            }
            MemeAdapter adapter = new MemeAdapter(memeStrings);
            setListAdapter(adapter);
            V = new View(getActivity());
            return super.onCreateView(inflater, container, savedInstanceState);
        }
        private void addMemes() {
            memeList.add(new Meme("( ͡° ͜ʖ ͡°)┌∩┐", "twitch_memes", false));
            memeList.add(new Meme("---------------------------\n" +
                    "\n" +
                    "┈┈┈┈╱▏┈┈┈┈┈╱▔▔▔▔╲\n" +
                    "┈┈┈┈▏▏┈┈┈┈┈▏╲▕▋▕▋▏\n" +
                    "┈┈┈┈╲╲┈┈┈┈┈▏┈▏┈▔▔▔▆\n" +
                    "┈┈┈┈┈╲▔▔▔▔▔╲╱┈╰┳┳┳╯\n" +
                    "┈┈╱╲╱╲▏┈┈┈┈┈┈▕▔╰━╯\n" +
                    "┈┈▔╲╲╱╱▔╱▔▔╲╲╲╲\n" +
                    "┈┈┈┈╲╱╲╱┈┈┈┈╲╲▂╲▂\n" +
                    "┈┈┈┈┈┈┈┈┈┈┈┈┈╲╱╲╱", "reddit_memes", false));
            memeList.add(new Meme("(ಠ_ಠ)┌∩┐", "twitch_memes", false));
            memeList.add(new Meme("Table Flip (╯°□°）╯︵ ┻━┻", "twitch_memes", false));
            memeList.add(new Meme("(º‿º✿) PEACEFUL PROTEST (º‿º✿)", "twitch_memes", false));
            memeList.add(new Meme("(ಠ_ಠ)", "twitch_memes", false));
            memeList.add(new Meme("( ͡° ͜ʖ ͡°)", "twitch_memes", false));
            memeList.add(new Meme("ヽ(ຈل͜ຈ)ﾉ ( ºل͟º ) ୧༼ ͡◉ل͜ ͡◉༽୨ (ง ͠° ل͜ °)ง ヽ(ຈل͜ຈ)ﾉ\n" +
                    "(ง ͠° ل͜ °)ง \n Sorry, I dropped my bag of Dongers. \n ヽ(ຈل͜ຈ)ﾉ ( ºل͟º )\n" +
                    "ヽ(ຈل͜ຈ)ﾉ ( ºل͟º ) ୧༼ ͡◉ل͜ ͡◉༽୨ (ง ͠° ل͜ °)ง", "twitch_memes", false));
            memeList.add(new Meme("░░░░░░░░░░░░ \n" +
                    "░░░░░░░░░░░░▄▀▀▀▀▄\n" +
                    "░░░░░░░░░░▄▀░░▄░▄░█\n" +
                    "░▄▄░░░░░▄▀░░░░▄▄▄▄█\n" +
                    "█░░▀▄░▄▀░░░░░░░░░░█\n" +
                    "░▀▄░░▀▄░░░░█░░░░░░█\n" +
                    "░░░▀▄░░▀░░░█░░░░░░█\n" +
                    "░░░▄▀░░░░░░█░░░░▄▀\n" +
                    "░░░▀▄▀▄▄▀░░█▀░▄▀\n" +
                    "░░░░░░░░█▀▀█▀▀\n" +
                    "░░░░░░░░▀▀░▀▀", "reddit_memes", false));
            memeList.add(new Meme("◑ ◑\n" +
                    "╔═╗\n" +
                    "║▓▒░░░░░░░░░\n" +
                    "╚═╝", "reddit_memes", false));
        }
        @Override
        public void onPause() {
            super.onPause();
            memeStrings.clear();
            memeList.clear();
            editor.putStringSet("FavoritesSet", favorites);
            editor.commit();
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
        ClipData clip = ClipData.newPlainText(TAG, memeStrings.get(position));
        clipBoard.setPrimaryClip(clip);
        V.setBackgroundResource(0);
        v.setBackgroundResource(R.color.button_material_light);
        V = v;

        toast.show();
    }
    /*Gets the shared preferences from MainAcitivity and stores them into values */
    private boolean getSharedPreference() {
        SharedPreferences sharedPref = getActivity().getSharedPreferences
                (getString(R.string.categories_settings), Context.MODE_PRIVATE);
        sort = sharedPref.getString("button", null);
        return sharedPref.getBoolean(sort, false);
    }
    /*Sets the lists based on which button has been set to filter, or if no button is active it
     * defaults to adding all memes to the main list. */
    private void setList() {
        //Check for if it is the first time opening the app or the button was set to false
        if(sort == null || categories == false) {
            initMemeString("none");
        } else {
            //Which memes to add to the main list.
            switch (sort) {
                case "twitch_memes":
                    initMemeString("twitch_memes");
                    break;
                case "reddit_memes":
                    initMemeString("reddit_memes");
                    break;
            }
        }
    }
    /*Initializes the memeString arraylist to hold the proper memes. This is dependant on which
    category the user is searching for, by default ("none" category) it adds all memes to the list*/
    private void initMemeString(String category) {
        if(category.equals("none")) {
            for(Meme m: memeList) {
                memeStrings.add(m.getMeme());
            }
        } else {
            for(Meme m: memeList) {
                if(m.getCategory().equals(category)) {
                    memeStrings.add(m.getMeme());

                }
            }
        }
    }

    /*
    Custom adapter class that represents each row in the ListFragment. Row consits of text and a button.
     */
    private class MemeAdapter extends ArrayAdapter<String> {
        public MemeAdapter(ArrayList<String> memes) {
            super(getActivity(), 0, memes);
        }
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            // If we weren't given a view, inflate one
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.listfragment_main, null);
            }
            String c = getItem(position);
            ImageButton imageButton;
            imageButton = (ImageButton) convertView.findViewById(R.id.row_icon);
            //If the meme is in the favorites list set the default imageButton to be favorited
            if(favorites.contains(c)) {
                imageButton.setBackgroundResource(R.drawable.favorite_icon);
                imageButton.setSelected(true);
            }
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.setSelected(!v.isSelected());
                    if (v.isSelected()) {
                        v.setBackgroundResource(R.drawable.favorite_icon);
                        favorites.add(memeStrings.get(position));
                    } else {
                        v.setBackgroundResource(R.drawable.unfavorite_icon);
                        favorites.remove(memeStrings.get(position));
                    }

                }
            });

            TextView titleTextView =
                    (TextView)convertView.findViewById(R.id.row_title);
            titleTextView.setText(c);
            return convertView;
        }
    }
}

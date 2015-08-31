package copy_pasta.admin.asciicopypasta;

import android.app.ListFragment;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Martin on 13/08/15.
 * A fragment which displays all of the memes based on which category the user selected. The class
 * also contains the listFragments custom array adapter class.
 */
public class MemeListFragment extends ListFragment{
    private SharedPreferences.Editor editor;
    private HashSet<String> favorites = new HashSet<>();
    private final static ArrayList<Meme> memeList = new ArrayList<>();
    private final ArrayList<String> memeStrings = new ArrayList<>();
    private static final String TAG = "MemeListFragment On Click";
    private ClipboardManager clipBoard;
    private View V;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            setHasOptionsMenu(true);
            SharedPreferences sharedPref;
             clipBoard = (ClipboardManager) getActivity().
                    getSystemService(getActivity().getApplicationContext().CLIPBOARD_SERVICE);
            sharedPref = getActivity().getSharedPreferences(getString(R.string.favorite_memes),
                    Context.MODE_PRIVATE);
            editor = sharedPref.edit();
            if(sharedPref != null) {
                if (sharedPref.getStringSet("FavoritesSet", null) != null) {
                    favorites = new HashSet<>(sharedPref.getStringSet("FavoritesSet", null));
                }
            }
            editor.apply();
            MemeAdapter adapter = new MemeAdapter(memeStrings);
            setListAdapter(adapter);
            V = new View(getActivity());
            return super.onCreateView(inflater, container, savedInstanceState);
        }
        private void addMemes() {
            memeList.add(new Meme("⇎_⇎", "twitch memes"));
            memeList.add(new Meme("( ͡° ͜ʖ ͡°)┌∩┐", "twitch_memes"));
            memeList.add(new Meme("---------------------------\n" +
                    "\n" +
                    "┈┈┈┈╱▏┈┈┈┈┈╱▔▔▔▔╲\n" +
                    "┈┈┈┈▏▏┈┈┈┈┈▏╲▕▋▕▋▏\n" +
                    "┈┈┈┈╲╲┈┈┈┈┈▏┈▏┈▔▔▔▆\n" +
                    "┈┈┈┈┈╲▔▔▔▔▔╲╱┈╰┳┳┳╯\n" +
                    "┈┈╱╲╱╲▏┈┈┈┈┈┈▕▔╰━╯\n" +
                    "┈┈▔╲╲╱╱▔╱▔▔╲╲╲╲\n" +
                    "┈┈┈┈╲╱╲╱┈┈┈┈╲╲▂╲▂\n" +
                    "┈┈┈┈┈┈┈┈┈┈┈┈┈╲╱╲╱", "reddit_memes"));
            memeList.add(new Meme("(ಠ_ಠ)┌∩┐", "twitch_memes"));
            memeList.add(new Meme("Table Flip (╯°□°）╯︵ ┻━┻", "twitch_memes"));
            memeList.add(new Meme("(º‿º✿) PEACEFUL PROTEST (º‿º✿)", "twitch_memes"));
            memeList.add(new Meme("(ಠ_ಠ)", "twitch_memes"));
            memeList.add(new Meme("( ͡° ͜ʖ ͡°)", "twitch_memes"));
            memeList.add(new Meme("ヽ(ຈل͜ຈ)ﾉ ( ºل͟º ) ୧༼ ͡◉ل͜ ͡◉༽୨ (ง ͠° ل͜ °)ง ヽ(ຈل͜ຈ)ﾉ\n" +
                    "(ง ͠° ل͜ °)ง \n Sorry, I dropped my bag of Dongers. \n ヽ(ຈل͜ຈ)ﾉ ( ºل͟º )\n" +
                    "ヽ(ຈل͜ຈ)ﾉ ( ºل͟º ) ୧༼ ͡◉ل͜ ͡◉༽୨ (ง ͠° ل͜ °)ง", "twitch_memes"));
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
                    "░░░░░░░░▀▀░▀▀", "reddit_memes"));
            memeList.add(new Meme("◑ ◑\n" +
                    "╔═╗\n" +
                    "║▓▒░░░░░░░░░\n" +
                    "╚═╝", "reddit_memes"));
            memeList.add(new Meme("I sexually Identify as an Attack Helicopter. \n" +
                    "Ever since I was a boy I dreamed of soaring over the oilfields dropping \n" +
                    "hot sticky loads on disgusting foreigners. People say to me that a person \n" +
                    "being a helicopter is Impossible and I’m fucking retarded but I don’t care, \n" +
                    "I’m beautiful. I’m having a plastic surgeon install rotary blades, 30 mm cannons \n" +
                    "and AMG-114 Hellfire missiles on my body. From now on I want you guys to call \n" +
                    "me “Apache” and respect my right to kill from above and kill needlessly. \n" +
                    "If you can’t accept me you’re a heliphobe and need to check your vehicle privilege.\n" +
                    " Thank you for being so understanding.\n", "twitch_memes"));
            memeList.add(new Meme("(ಠ_ಠ)┌∩┐", "twitch_memes"));
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
            int categoriesFalseCounter = 0;
            Map<String, ?> categoriesPreferences = getSharedPreference();
            addMemes();
            for(String s: categoriesPreferences.keySet()) {
                if((Boolean) categoriesPreferences.get(s)) {
                    setList(s);
                } else {
                    categoriesFalseCounter++;
                }
            }
            if(categoriesFalseCounter == categoriesPreferences.size()) {
                setList("none");
            }
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
    private Map<String, ?> getSharedPreference() {
        SharedPreferences sharedPref = getActivity().getSharedPreferences
                (getString(R.string.categories_settings), Context.MODE_PRIVATE);
        return sharedPref.getAll();
    }
    /*Sets the lists based on which button has been set to filter, or if no button is active it
     * defaults to adding all memes to the main list. */
    private void setList(String category) {
            //Which memes to add to the main list.
            switch (category) {
                case "twitch_memes":
                    initMemeString("twitch_memes");
                    break;
                case "reddit_memes":
                    initMemeString("reddit_memes");
                    break;
                case "none":
                    initMemeString("none");
                    break;
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
                    //Set up a Toast message when an element is favorited
                    Context context = getActivity().getApplicationContext();
                    CharSequence favToastText = "Favorited this meme";
                    CharSequence unfavToastText = "Unfavorited this meme";
                    int duration = Toast.LENGTH_SHORT;
                    v.setSelected(!v.isSelected());
                    if (v.isSelected()) {
                        v.setBackgroundResource(R.drawable.favorite_icon);
                        favorites.add(memeStrings.get(position));
                        Toast toast = Toast.makeText(context, favToastText, duration);
                        toast.show();
                    } else {
                        v.setBackgroundResource(R.drawable.unfavorite_icon);
                        favorites.remove(memeStrings.get(position));
                        Toast toast = Toast.makeText(context, unfavToastText, duration);
                        toast.show();
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

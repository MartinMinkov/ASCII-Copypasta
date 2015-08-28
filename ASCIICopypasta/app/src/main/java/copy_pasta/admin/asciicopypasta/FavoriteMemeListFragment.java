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
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Scott on 25/08/15.
 * A ListFragment which holds all of the favorited memes that the user selects. The favorited memes
 * can also be copied to the clipboard like normal.
 */
public class FavoriteMemeListFragment extends ListFragment {
    private static final String TAG = "MemeListFragment On Click";
    private ClipboardManager clipBoard;
    private View V;
    private ArrayList<String> favorites = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        clipBoard = (ClipboardManager) getActivity().
                getSystemService(getActivity().getApplicationContext().CLIPBOARD_SERVICE);
        SharedPreferences sharedPref = getActivity().getSharedPreferences(getString(R.string.favorite_memes),
                Context.MODE_PRIVATE);
        if(sharedPref != null) {
            favorites = new ArrayList<>(sharedPref.getStringSet("FavoritesSet", null));
        }
        ArrayAdapter<String> favoritesAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, favorites);
        setListAdapter(favoritesAdapter);
        V = new View(getActivity());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //Set up a Toast message when an element is highlighted
        Context context = getActivity().getApplicationContext();
        CharSequence toastText = "Text has been copied to clipboard.";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, toastText, duration);

        //Set up the ClipBoard object to copy the meme to the clipboard.
        ClipData clip = ClipData.newPlainText(TAG, favorites.get(position));
        clipBoard.setPrimaryClip(clip);
        V.setBackgroundResource(0);
        v.setBackgroundResource(R.color.button_material_light);
        V = v;

        toast.show();
    }
}

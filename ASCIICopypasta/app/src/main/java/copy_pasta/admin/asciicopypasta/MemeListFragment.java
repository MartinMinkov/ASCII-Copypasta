package copy_pasta.admin.asciicopypasta;

import android.app.ListFragment;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by Admin on 11/08/2015.
 */
public class MemeListFragment extends ListFragment {

    private static final String TAG = "MemeListFragment";
    private ArrayList<Meme> mMemes;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.memes_title);
        mMemes = MemeList.get(getActivity()).getMemes();
    }
}

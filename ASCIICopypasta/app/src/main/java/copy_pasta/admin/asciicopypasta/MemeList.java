package copy_pasta.admin.asciicopypasta;

import android.content.Context;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Admin on 11/08/2015.
 */
public class MemeList {

    private ArrayList<Meme> mMemes;
    private static MemeList sMemeList;
    private Context mAppContext;

    private MemeList(Context appContext) {
        mAppContext = appContext;
        mMemes = new ArrayList<Meme>();
    }
    public static MemeList get(Context c) {
        if (sMemeList == null) {
            sMemeList = new MemeList(c.getApplicationContext());
        }
        return sMemeList;
    }
    public ArrayList<Meme> getMemes() {
        return mMemes;
    }
    public Meme getMeme(UUID ID) {
        for (Meme m : mMemes) {
            if (m.getID().equals(ID))
                return m;
        }
        return null;
    }
}

package copy_pasta.admin.asciicopypasta;

import java.util.UUID;

/**
 * Created by Admin on 11/08/2015.
 */
public class Meme {

    private UUID mID;
    private String mTitle;
    private String mMeme;

    public Meme() {
        mID = UUID.randomUUID();
    }
    public UUID getID() {
        return mID;
    }
    public String getTitle() {
        return mTitle;
    }
    public void setTitle(String title) {
        mTitle = title;
    }
    public String getMeme() {
        return mMeme;
    }
    public void setMeme(String meme) {
        mMeme = meme;
    }
}

package copy_pasta.admin.asciicopypasta;

/**
 * Created by root on 24/08/15.
 */
public class Meme {
    private String meme;
    private String category;
    private Boolean favorited;
    public Meme(String memeText, String cat, Boolean fav) {
        meme = memeText;
        category = cat;
        favorited = fav;
    }

    public String getMeme() {
        return meme;
    }
    public String getCategory() {
        return category;
    }

    public Boolean getFavorited() {
        return favorited;
    }
    
    public void updateFavorited(Boolean fav) {
        favorited = fav;
    }
}

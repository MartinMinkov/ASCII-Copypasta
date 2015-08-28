package copy_pasta.admin.asciicopypasta;

/**
 * Created by Scott on 24/08/15.
 * A class for the meme, which holds the category the meme belongs to, and what the meme text is.
 */
class Meme {
    private final String meme;
    private final String category;
    public Meme(String memeText, String cat) {
        meme = memeText;
        category = cat;
    }

    public String getMeme() {
        return meme;
    }
    public String getCategory() {
        return category;
    }
}

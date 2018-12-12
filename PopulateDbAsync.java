package room_example.juangarcia.room_codelabs;

import android.os.AsyncTask;

class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final WordDAO mDao;

    public PopulateDbAsync(WordRoomDataBase db) {
        mDao = db.wordDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
        mDao.deleteAllWords();
        Word word = new Word("Hello");
        mDao.insertOneWord(word);
        word = new Word("World");
        mDao.insertOneWord(word);
        return null;
    }
}

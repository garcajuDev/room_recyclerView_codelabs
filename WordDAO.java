package room_example.juangarcia.room_codelabs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WordDAO {

    @Insert
    void insertOneWord(Word word);

    @Query("DELETE FROM tblword")
    void deleteAllWords();

    @Query("SELECT * FROM tblWord ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();
}

package room_example.juangarcia.room_codelabs;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository repository;
    private LiveData<List<Word>> allwords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        repository = new WordRepository(application);
        allwords = repository.getAllWords();
    }

    LiveData<List<Word>> getAllwords() { return allwords; }

    public void insert(Word word){ repository.insert(word); }
}

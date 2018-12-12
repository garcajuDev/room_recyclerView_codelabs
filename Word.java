package room_example.juangarcia.room_codelabs;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "tblWord")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo( name = "word")
    private String mWord;

    public Word (String word) { this.mWord = word;}

    public String getWord() { return this.mWord; }
}

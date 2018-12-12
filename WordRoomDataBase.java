package room_example.juangarcia.room_codelabs;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDataBase extends RoomDatabase {
    public abstract WordDAO wordDao();

    private static volatile WordRoomDataBase INSTANCE;

    static WordRoomDataBase getDB(final Context context){
        if (INSTANCE == null) synchronized (WordRoomDataBase.class) {
            if (INSTANCE == null) INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    WordRoomDataBase.class, "word_db").addCallback(sRoomDatabaseCallback).build();
        }
        return INSTANCE;
    }


    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };
}

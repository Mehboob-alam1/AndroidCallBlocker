package com.mehboob.androidcallblocker.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mehboob.androidcallblocker.dao.BlockedNumberDao;
import com.mehboob.androidcallblocker.entitites.BlockedNumber;

@Database(entities = {BlockedNumber.class}, version = 1)
public abstract class BlockedNumberDatabase extends RoomDatabase {
    public abstract BlockedNumberDao blockedNumberDao();

    private static volatile BlockedNumberDatabase INSTANCE;

    public static BlockedNumberDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BlockedNumberDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    BlockedNumberDatabase.class, "blocked_number_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

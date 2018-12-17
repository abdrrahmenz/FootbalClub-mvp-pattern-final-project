package com.example.abdurrahman.footbalclub.data.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.abdurrahman.footbalclub.data.local.TeamsDao;
import com.example.abdurrahman.footbalclub.model.Teams;

@Database(entities = Teams.class, version = 1)
public abstract class TeamsDb extends RoomDatabase {

    public abstract TeamsDao teamsDao();

    public static TeamsDb INSTANCE;

    public static TeamsDb getTeamsDatabase(Context context) {
        synchronized (TeamsDb.class) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, TeamsDb.class, "teams_db")
                        .allowMainThreadQueries().build();
            }
        }
        return INSTANCE;
    }
}

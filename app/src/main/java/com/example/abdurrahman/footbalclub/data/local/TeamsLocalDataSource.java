package com.example.abdurrahman.footbalclub.data.local;

import android.content.Context;

import com.example.abdurrahman.footbalclub.data.TeamsDataSource;
import com.example.abdurrahman.footbalclub.data.local.db.TeamsDb;

public class TeamsLocalDataSource implements TeamsDataSource {

    @Override
    public void getListTeams(Context context, GetListTeamsCallback callback) {
        TeamsDb teamsDb = TeamsDb.getTeamsDatabase(context);
        if (teamsDb.teamsDao().select() != null) {
            callback.onSuccess(teamsDb.teamsDao().select());
        }else {
            callback.onFailure(" no database on Local");
        }
    }
}

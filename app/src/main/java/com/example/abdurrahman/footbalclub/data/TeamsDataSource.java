package com.example.abdurrahman.footbalclub.data;

import android.content.Context;

import com.example.abdurrahman.footbalclub.model.Teams;

import java.util.List;

public interface TeamsDataSource {

    void getListTeams(Context context, GetListTeamsCallback callback);

    interface GetListTeamsCallback {
        void onSuccess(List<Teams> data);

        void onFailure(String errorMessage);
    }
}

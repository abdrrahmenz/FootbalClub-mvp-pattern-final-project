package com.example.abdurrahman.footbalclub.ui.teams;

import android.content.Context;

import com.example.abdurrahman.footbalclub.model.Teams;

import java.util.List;

public interface TeamsContract {

    interface View {
        void showProgress();
        void hideProgress();
        void showDataList(List<Teams> data);
        void showFailureMessage(String message);
        void showNoDataList();
    }

    interface Presenter {
        void getDataListTeams(Context context);
    }
}

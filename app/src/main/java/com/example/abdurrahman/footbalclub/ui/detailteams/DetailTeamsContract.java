package com.example.abdurrahman.footbalclub.ui.detailteams;

import com.example.abdurrahman.footbalclub.model.Teams;

import java.util.List;

public interface DetailTeamsContract {
    interface View {
        void showProgress();
        void hideProgress();
        void showDetailTeams(List<Teams> data);
        void showFailureMessage(String message);
    }
}

package com.example.abdurrahman.footbalclub.ui.detailteams;

import com.example.abdurrahman.footbalclub.data.TeamsRepository;

public class DetailTeamsPresenter implements DetailTeamsContract{

    private TeamsRepository repositoryTeams;
    private DetailTeamsContract.View view;

    public DetailTeamsPresenter(TeamsRepository repositoryTeams, DetailTeamsContract.View view) {
        this.repositoryTeams = repositoryTeams;
        this.view = view;
    }
}

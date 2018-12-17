package com.example.abdurrahman.footbalclub.ui.teams;

import android.content.Context;
import android.widget.Toast;

import com.example.abdurrahman.footbalclub.data.TeamsDataSource;
import com.example.abdurrahman.footbalclub.data.TeamsRepository;
import com.example.abdurrahman.footbalclub.model.Teams;

import java.util.List;

public class TeamsPresenter implements TeamsContract.Presenter {

    private TeamsRepository repository;
    private TeamsContract.View view;

    TeamsPresenter(TeamsRepository repository, TeamsContract.View view) {
        this.repository = repository;
        this.view = view;
    }

    @Override
    public void getDataListTeams(Context context) {
        view.showProgress();
        repository.getListTeams(context, new TeamsDataSource.GetListTeamsCallback() {
            @Override
            public void onSuccess(List<Teams> data) {
                if (data != null){
                    view.hideProgress();
                    view.showDataList(data);
                }else {
                    view.showNoDataList();
                }
            }

            @Override
            public void onFailure(String errorMessage) {
                view.hideProgress();
                view.showFailureMessage(errorMessage);
            }
        });
    }
}

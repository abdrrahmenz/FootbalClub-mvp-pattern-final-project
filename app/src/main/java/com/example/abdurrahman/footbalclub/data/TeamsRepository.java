package com.example.abdurrahman.footbalclub.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.example.abdurrahman.footbalclub.data.local.TeamsLocalDataSource;
import com.example.abdurrahman.footbalclub.data.local.db.TeamsDb;
import com.example.abdurrahman.footbalclub.data.remote.TeamsRemoteDataSource;
import com.example.abdurrahman.footbalclub.model.Teams;

import java.util.List;

public class TeamsRepository implements TeamsDataSource {

    private TeamsLocalDataSource localDataSource;
    private TeamsRemoteDataSource remoteDataSource;
    private TeamsDb teamsDb;

    public TeamsRepository(TeamsRemoteDataSource remoteDataSource, TeamsLocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    @Override
    public void getListTeams(Context context, GetListTeamsCallback callback) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        teamsDb = TeamsDb.getTeamsDatabase(context);
        if (teamsDb.teamsDao().select().size() != 0){
            Toast.makeText(context, "local database", Toast.LENGTH_SHORT).show();
            localDataSource.getListTeams(context, new GetListTeamsCallback() {
                @Override
                public void onSuccess(List<Teams> data) {
                    callback.onSuccess(data);
                }

                @Override
                public void onFailure(String errorMessage) {
                    callback.onFailure(errorMessage);
                }
            });
        } else if (networkInfo != null && networkInfo.isConnected()){
            Toast.makeText(context, "database cloud", Toast.LENGTH_SHORT).show();
            remoteDataSource.getListTeams(context, new GetListTeamsCallback() {
                @Override
                public void onSuccess(List<Teams> data) {
                    callback.onSuccess(data);
                    teamsDb.teamsDao().insert(data);
                }

                @Override
                public void onFailure(String errorMessage) {
                    callback.onFailure(errorMessage);
                }
            });
        }else {
            callback.onSuccess(null);
            callback.onFailure("Please check your connection to first open this apps !");
        }
    }
}

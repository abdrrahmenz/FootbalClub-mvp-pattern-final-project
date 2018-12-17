package com.example.abdurrahman.footbalclub.data.remote;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.abdurrahman.footbalclub.data.TeamsDataSource;
import com.example.abdurrahman.footbalclub.model.TeamsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamsRemoteDataSource implements TeamsDataSource {

    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void getListTeams(Context context, GetListTeamsCallback callback) {
        Call<TeamsResponse> call = apiInterface.getListTeams();
        call.enqueue(new Callback<TeamsResponse>() {
            @Override
            public void onResponse(@NonNull Call<TeamsResponse> call, @NonNull Response<TeamsResponse> response) {
                if (response.body() != null){
                    callback.onSuccess(response.body().teams);
                }
            }

            @Override
            public void onFailure(@NonNull Call<TeamsResponse> call, @NonNull Throwable t) {
                callback.onFailure(t.toString());
            }
        });
    }
}

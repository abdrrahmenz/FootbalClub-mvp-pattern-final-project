package com.example.abdurrahman.footbalclub.data.remote;

import com.example.abdurrahman.footbalclub.model.TeamsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("v1/json/1/search_all_teams.php?l=English%20Premier%20League")
    Call<TeamsResponse> getListTeams();

    @GET("v1/json/1/lookupteam.php")
    Call<TeamsResponse> getDetailTeams(@Query("id")String idTeam);
}

package com.example.abdurrahman.footbalclub.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TeamsResponse {

    @SerializedName("teams")
    public ArrayList<Teams> teams;

    public ArrayList<Teams> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Teams> teams) {
        this.teams = teams;
    }
}

package com.example.abdurrahman.footbalclub.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "teams")
public class Teams {

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        private int id_;

        @ColumnInfo(name = "idTeam")
        @SerializedName("idTeam")
        public String idTeam;

        @ColumnInfo(name = "strTeam")
        @SerializedName("strTeam")
        public String strTeam;

        @ColumnInfo(name = "intFormedYear")
        @SerializedName("intFormedYear")
        public String intFormedYear;

        @ColumnInfo(name = "strLeague")
        @SerializedName("strLeague")
        public String strLeague;

        @ColumnInfo(name = "strStadium")
        @SerializedName("strStadium")
        public String strStadium;

        @ColumnInfo(name = "strStadiumThumb")
        @SerializedName("strStadiumThumb")
        public String strStadiumThumb;

        @ColumnInfo(name = "strDescriptionEN")
        @SerializedName("strDescriptionEN")
        public String strDescriptionEN;

        @ColumnInfo(name = "strTeamBadge")
        @SerializedName("strTeamBadge")
        public String strTeamBadge;

        public Teams(int id_, String idTeam, String strTeam, String intFormedYear, String strLeague, String strStadium, String strStadiumThumb, String strDescriptionEN, String strTeamBadge) {
                this.id_ = id_;
                this.idTeam = idTeam;
                this.strTeam = strTeam;
                this.intFormedYear = intFormedYear;
                this.strLeague = strLeague;
                this.strStadium = strStadium;
                this.strStadiumThumb = strStadiumThumb;
                this.strDescriptionEN = strDescriptionEN;
                this.strTeamBadge = strTeamBadge;
        }

        public int getId_() {
                return id_;
        }

        public String getIdTeam() {
                return idTeam;
        }

        public String getStrTeam() {
                return strTeam;
        }

        public String getIntFormedYear() {
                return intFormedYear;
        }

        public String getStrLeague() {
                return strLeague;
        }

        public String getStrStadium() {
                return strStadium;
        }

        public String getStrStadiumThumb() {
                return strStadiumThumb;
        }

        public String getStrDescriptionEN() {
                return strDescriptionEN;
        }

        public String getStrTeamBadge() {
                return strTeamBadge;
        }
}

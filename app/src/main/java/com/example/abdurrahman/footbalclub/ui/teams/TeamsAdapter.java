package com.example.abdurrahman.footbalclub.ui.teams;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abdurrahman.footbalclub.R;
import com.example.abdurrahman.footbalclub.data.local.db.Constant;
import com.example.abdurrahman.footbalclub.model.Teams;
import com.example.abdurrahman.footbalclub.ui.detailteams.DetailTeamsActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {

    private List<Teams> teamsList;
    private Context context;
    private Bundle bundle;

    TeamsAdapter(Context context, List<Teams> teamsList) {
        this.teamsList = teamsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_row, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Teams teams = teamsList.get(i);
        viewHolder.bind(teams);
        viewHolder.itemView.setOnClickListener(v -> {
            bundle = new Bundle();
            bundle.putInt(Constant.TAG_ID, teamsList.get(i).getId_());
            bundle.putString(Constant.TAG_ID_TEAM, teamsList.get(i).getIdTeam());
            bundle.putString(Constant.TAG_TEAM, teamsList.get(i).getStrTeam());
            bundle.putString(Constant.TAG_YEAR, teamsList.get(i).getIntFormedYear());
            bundle.putString(Constant.TAG_STADIUM, teamsList.get(i).getStrStadium());
            bundle.putString(Constant.TAG_DESC, teamsList.get(i).getStrDescriptionEN());
            bundle.putString(Constant.TAG_LEAGUE, teamsList.get(i).getStrLeague());
            bundle.putString(Constant.TAG_LOGO, teamsList.get(i).getStrTeamBadge());
            bundle.putString(Constant.TAG_LOGO_STADIUM, teamsList.get(i).getStrStadiumThumb());
            context.startActivity(new Intent(context, DetailTeamsActivity.class).putExtras(bundle));
        });
    }

    @Override
    public int getItemCount() {
        return teamsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageTeams;
        TextView textName;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageTeams = itemView.findViewById(R.id.imageTeams);
            textName = itemView.findViewById(R.id.nameTeams);
        }

        private void bind(final Teams teams) {
            Picasso.get().load(teams.strTeamBadge).into(imageTeams);
            textName.setText(teams.strTeam);
        }
    }
}

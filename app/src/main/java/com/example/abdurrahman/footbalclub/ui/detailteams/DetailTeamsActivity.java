package com.example.abdurrahman.footbalclub.ui.detailteams;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abdurrahman.footbalclub.R;
import com.example.abdurrahman.footbalclub.data.local.db.Constant;
import com.example.abdurrahman.footbalclub.model.Teams;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailTeamsActivity extends AppCompatActivity implements DetailTeamsContract.View{

    private ProgressDialog progressDialog;
    private TextView txtNameTeams, txtDesc, txtYear,txtStadium,txtLeague;
    private ImageView imageLogoTeams, imageStadium;

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_teams);
        initViews();
        bundle = getIntent().getExtras();
        showDetailFromBundle();
    }

    private void initViews() {
        txtNameTeams = findViewById(R.id.teamNameDetail);
        txtLeague = findViewById(R.id.teamLeagueDetail);
        txtDesc = findViewById(R.id.teamDescDetail);
        txtStadium = findViewById(R.id.teamStadiumDetail);
        txtYear = findViewById(R.id.teamYearDetail);
        imageLogoTeams = findViewById(R.id.imageLogoDetail);
        imageStadium = findViewById(R.id.imageStadiumDetail);
    }

    private void showDetailFromBundle(){
        String sTeam = bundle.getString(Constant.TAG_TEAM);
        String sYear = bundle.getString(Constant.TAG_YEAR);
        String sStadium = bundle.getString(Constant.TAG_STADIUM);
        String sDesc = bundle.getString(Constant.TAG_DESC);
        String sLeague = bundle.getString(Constant.TAG_LEAGUE);
        String sLogoStadium = bundle.getString(Constant.TAG_LOGO_STADIUM);
        String sLogo = bundle.getString(Constant.TAG_LOGO);

        txtYear.setText(sYear);
        txtLeague.setText(sLeague);
        txtStadium.setText(sStadium);
        txtNameTeams.setText(sTeam);
        txtDesc.setText(sDesc);
        Picasso.get().load(sLogo).into(imageLogoTeams);
        Picasso.get().load(sLogoStadium).into(imageStadium);
        setTitle(sTeam);
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setTitle("Harap Tunggu");
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showDetailTeams(List<Teams> data) { }

    @Override
    public void showFailureMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}

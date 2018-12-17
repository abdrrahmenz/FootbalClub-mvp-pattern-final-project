package com.example.abdurrahman.footbalclub.ui.teams;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abdurrahman.footbalclub.Injection;
import com.example.abdurrahman.footbalclub.R;
import com.example.abdurrahman.footbalclub.model.Teams;

import java.util.ArrayList;
import java.util.List;

public class TeamsActivity extends AppCompatActivity implements TeamsContract.View{

    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private TextView errorText;
    private TeamsAdapter adapter;
    private List<Teams> data = new ArrayList<>();

    private TeamsPresenter presenter = new TeamsPresenter(Injection.provideRepository(),this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        recyclerView = findViewById(R.id.recyclerView);
        errorText = findViewById(R.id.errorText);
        initAdapter();
        presenter.getDataListTeams(TeamsActivity.this);

    }

    private void initAdapter() {
        adapter = new TeamsAdapter(this, data);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
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
    public void showNoDataList() {
        errorText.setVisibility(View.VISIBLE);
    }

    @Override
    public void showDataList(List<Teams> data) {
        errorText.setVisibility(View.GONE);
        this.data.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showFailureMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}

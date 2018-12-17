package com.example.abdurrahman.footbalclub;

import com.example.abdurrahman.footbalclub.data.TeamsRepository;
import com.example.abdurrahman.footbalclub.data.local.TeamsLocalDataSource;
import com.example.abdurrahman.footbalclub.data.remote.TeamsRemoteDataSource;

public class Injection {

    public static TeamsRepository provideRepository() {
        return new TeamsRepository(new TeamsRemoteDataSource(), new TeamsLocalDataSource());
    }
}

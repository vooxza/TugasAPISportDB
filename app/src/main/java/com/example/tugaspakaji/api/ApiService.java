package com.example.tugaspakaji.api;

import com.example.tugaspakaji.model.TeamResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("https://www.thesportsdb.com/api/v1/json/3/search_all_teams.php?l=English%20Premier%20League")
    Call<TeamResponse> getAllTeams(@Query("l") String league);
}
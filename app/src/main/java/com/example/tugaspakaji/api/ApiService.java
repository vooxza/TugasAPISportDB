package com.example.tugaspakaji.api;

import com.example.tugaspakaji.model.TeamResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    // For endpoint like: /api/v1/json/3/search_all_teams.php?l=English%20Premier%20League
    @GET("api/v1/json/3/search_all_teams.php")
    Call<TeamResponse> getTeamsByLeague(
            @Query("l") String leagueName
    );

    // For endpoint like: /api/v1/json/3/search_all_teams.php?s=Soccer&c=Spain
    @GET("api/v1/json/3/search_all_teams.php")
    Call<TeamResponse> getTeamsBySportAndCountry(
            @Query("s") String sport,
            @Query("c") String country
    );
}
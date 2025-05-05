package com.example.tugaspakaji;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugaspakaji.adapter.teamAdapter;
import com.example.tugaspakaji.api.ApiService;
import com.example.tugaspakaji.api.RetrofitClient;
import com.example.tugaspakaji.model.Team;
import com.example.tugaspakaji.model.TeamResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private teamAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Getting the league passed from the previous activity (EPL or La Liga)
        String selectedLeague = getIntent().getStringExtra("SELECTED_LEAGUE");
        if (selectedLeague != null) {
            getTeams(selectedLeague);
        }
    }

    private void getTeams(String league) {
        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        Call<TeamResponse> call;

        if ("EPL".equals(league)) {
            // Call for English Premier League
            call = apiService.getTeamsByLeague("English Premier League");
        } else if ("LL".equals(league)) {
            // Call for La Liga (Spain)
            call = apiService.getTeamsBySportAndCountry("Soccer", "Spain");
        } else {
            // Default case (you might want to handle this differently)
            call = apiService.getTeamsByLeague("English Premier League");
        }

        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Team> teams = response.body().getTeams();
                    adapter = new teamAdapter(MainActivity.this, teams);
                    recyclerView.setAdapter(adapter);
                } else {
                    Log.e("MainActivity", "No teams found or API issue. Response code: " + response.code());
                    // You might want to show a message to the user here
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                Log.e("MainActivity", "Error: " + t.getMessage());
                // You might want to show a network error message to the user here
            }
        });
    }
}
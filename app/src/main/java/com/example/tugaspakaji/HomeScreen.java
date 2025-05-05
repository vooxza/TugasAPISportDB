package com.example.tugaspakaji;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeScreen extends AppCompatActivity {

    private Button btnEPL, btnLL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        btnEPL = findViewById(R.id.btnEPL);
        btnLL = findViewById(R.id.btnLL);

        View.OnClickListener leagueClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String league = "";
                int id = v.getId();

                if (id == R.id.btnEPL) {
                    league = "EPL";
                } else if (id == R.id.btnLL) {
                    league = "LL";
                }

                Intent intent = new Intent(HomeScreen.this, MainActivity.class);
                intent.putExtra("SELECTED_LEAGUE", league);
                startActivity(intent);
            }
        };

        btnEPL.setOnClickListener(leagueClickListener);
        btnLL.setOnClickListener(leagueClickListener);
    }
}

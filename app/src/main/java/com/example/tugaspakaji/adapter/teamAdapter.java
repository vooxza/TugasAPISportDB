package com.example.tugaspakaji.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tugaspakaji.R;
import com.example.tugaspakaji.model.Team;

import java.util.List;

public class teamAdapter extends RecyclerView.Adapter<teamAdapter.ViewHolder> {

    private final List<Team> teams;
    private final Context context;

    public teamAdapter(Context context, List<Team> teams) {
        this.context = context;
        this.teams = teams;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_team, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.tvTeamName.setText(team.getStrTeam());

        // Get the badge URL - now using the correct field name
        String badgeUrl = team.getStrTeamBadge(); // Changed from getStrTeamBadge()

        // Fix common URL issues with TheSportsDB API
        if (badgeUrl != null && badgeUrl.startsWith("//")) {
            badgeUrl = "https:" + badgeUrl;
        }

        // Load image with Glide
        Glide.with(context)
                .load(badgeUrl)
                .into(holder.imgTeamBadge);
    }

    @Override
    public int getItemCount() {
        return teams != null ? teams.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTeamName;
        final ImageView imgTeamBadge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTeamName = itemView.findViewById(R.id.tvTeamName);
            imgTeamBadge = itemView.findViewById(R.id.imgTeamBadge);
        }
    }
}
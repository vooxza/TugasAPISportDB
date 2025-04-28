package com.example.tugaspakaji.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tugaspakaji.R;
import com.example.tugaspakaji.model.Team;
import com.example.tugaspakaji.R;
import com.example.tugaspakaji.model.Team;

import java.util.List;

public class teamAdapter extends RecyclerView.Adapter<teamAdapter.ViewHolder> {

    private List<Team> teams;
    private Context context;

    public teamAdapter(Context context, List<Team> teams) {
        this.context = context;
        this.teams = teams;
    }

    @Override
    public teamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_team, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(teamAdapter.ViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.tvTeamName.setText(team.getStrTeam());
        Glide.with(context)
                .load(team.getStrTeamBadge())
                .into(holder.imgTeamBadge);
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTeamName;
        ImageView imgTeamBadge;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTeamName = itemView.findViewById(R.id.tvTeamName);
            imgTeamBadge = itemView.findViewById(R.id.imgTeamBadge);
        }
    }
}
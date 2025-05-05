package com.example.tugaspakaji.model;

import com.google.gson.annotations.SerializedName;

public class Team {
    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strBadge")  // Maps JSON's "strBadge" to Java's "strTeamBadge"
    private String strTeamBadge;

    // Getters
    public String getStrTeam() {
        return strTeam;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }
}
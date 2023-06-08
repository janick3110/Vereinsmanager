package com.kaldev.vereinsmanager.tools.tournament.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idOfClub;
    private String title;
    private  int[] teams;
    private int[] playfields;
    private int[] games;
    private int pointsPerVictory;
    private int pointsPerEqual;
    private int lengthOfGame;
    private int lengthOfBreak;
    private int tournamentMode;

    public Tournament() {
    }

    public int getId() {
        return id;
    }

    public int getIdOfClub() {
        return idOfClub;
    }

    public String getTitle() {
        return title;
    }

    public int[] getTeams() {
        return teams;
    }

    public int[] getPlayfields() {
        return playfields;
    }

    public int getPointsPerVictory() {
        return pointsPerVictory;
    }

    public int getPointsPerEqual() {
        return pointsPerEqual;
    }

    public int getLengthOfGame() {
        return lengthOfGame;
    }

    public int getLengthOfBreak() {
        return lengthOfBreak;
    }

    public int getTournamentMode() {
        return tournamentMode;
    }
}

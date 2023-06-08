package com.kaldev.vereinsmanager.tools.tournament.entity;

import jakarta.persistence.*;

@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idOfClub;
    private String title;
    private String teams;
    private String playfields;
    private String games;
    private int pointsPerVictory = 3;
    private int pointsPerEqual = 1;
    private int lengthOfGame;
    private int lengthOfBreak;
    private int tournamentMode;
    private int amountGroups;

    private String _group;


    public Tournament() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOfClub() {
        return idOfClub;
    }

    public void setIdOfClub(int idOfClub) {
        this.idOfClub = idOfClub;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public String getPlayfields() {
        return playfields;
    }

    public void setPlayfields(String playfields) {
        this.playfields = playfields;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public int getPointsPerVictory() {
        return pointsPerVictory;
    }

    public void setPointsPerVictory(int pointsPerVictory) {
        this.pointsPerVictory = pointsPerVictory;
    }

    public int getPointsPerEqual() {
        return pointsPerEqual;
    }

    public void setPointsPerEqual(int pointsPerEqual) {
        this.pointsPerEqual = pointsPerEqual;
    }

    public int getLengthOfGame() {
        return lengthOfGame;
    }

    public void setLengthOfGame(int lengthOfGame) {
        this.lengthOfGame = lengthOfGame;
    }

    public int getLengthOfBreak() {
        return lengthOfBreak;
    }

    public void setLengthOfBreak(int lengthOfBreak) {
        this.lengthOfBreak = lengthOfBreak;
    }

    public int getTournamentMode() {
        return tournamentMode;
    }

    public void setTournamentMode(int tournamentMode) {
        this.tournamentMode = tournamentMode;
    }

    public int getAmountGroups() {
        return amountGroups;
    }

    public void setAmountGroups(int tournamentGroups) {
        this.amountGroups = tournamentGroups;
    }

    public String getGroup() {
        return _group;
    }

    public void setGroup(String group) {
        this._group = group;
    }
}

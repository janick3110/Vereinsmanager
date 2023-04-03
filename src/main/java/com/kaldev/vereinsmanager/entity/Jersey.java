package com.kaldev.vereinsmanager.entity;

import com.kaldev.vereinsmanager.Misc.Teams;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Jersey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sponsor;
    @ElementCollection
    private List<Integer> numbers;
    private Teams.teams team;

    public Jersey(Long id, String sponsor, List<Integer> numbers) {
        this.id = id;
        this.sponsor = sponsor;
        this.numbers = numbers;
    }

    public Jersey() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Teams.teams getTeam() {
        return team;
    }

    public void setTeam(Teams.teams team) {
        this.team = team;
    }
}

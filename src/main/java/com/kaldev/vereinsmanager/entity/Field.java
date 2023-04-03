package com.kaldev.vereinsmanager.entity;

import com.kaldev.vereinsmanager.Misc.Teams;
import jakarta.persistence.*;
import jdk.jfr.Timespan;

import java.util.*;

@Entity
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int segments;

    @OneToMany(cascade = CascadeType.ALL)
    private Map<Integer, SegmentData> occupiedElements = new HashMap<>();

    public Field() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSegments() {
        return segments;
    }

    public void setSegments(int segments) {
        this.segments = segments;
    }

    public Map<Integer, SegmentData> getOccupiedElements() {
        return occupiedElements;
    }

    public void setOccupiedElements(Map<Integer, SegmentData> occupiedElements) {
        this.occupiedElements = occupiedElements;
    }

    // getters and setters
}

@Entity
class SegmentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int segmentNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TimeSpan> timeSpans;

    public SegmentData() {}

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSegmentNumber() {
        return segmentNumber;
    }

    public void setSegmentNumber(int segmentNumber) {
        this.segmentNumber = segmentNumber;
    }

    public List<TimeSpan> getTimeSpans() {
        return timeSpans;
    }

    public void setTimeSpans(List<TimeSpan> timeSpans) {
        this.timeSpans = timeSpans;
    }
}

@Entity
class TimeSpan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date start;
    private Date end;
    private Teams.teams team;
    private String description;

    public TimeSpan() {}

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Teams.teams getTeam() {
        return team;
    }

    public void setTeam(Teams.teams team) {
        this.team = team;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

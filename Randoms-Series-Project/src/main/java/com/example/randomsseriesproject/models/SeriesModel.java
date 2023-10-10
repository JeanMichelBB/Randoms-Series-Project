package com.example.randomsseriesproject.models;

public class SeriesModel {
    private int id;
    private String name;
    private String overview;
    private double popularity;
    private double vote_average;
    private String Key;

    public SeriesModel(int id, String name, String overview, int popularity, int vote_average , String Key) {
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.popularity = popularity;
        this.vote_average = vote_average;
        this.Key = Key;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getOverview() {
        return overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public double getVote_average() {
        return vote_average;
    }
    public String getKey() {
        return Key;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public void setVote_average(int vote_average) {
        this.vote_average = vote_average;
    }

    public void setKey(String Key) { this.Key = Key; }

    @Override
    public String toString() {
        return "MovieModel{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity='" + popularity + '\'' +
                ", vote_average='" + vote_average + '\'' +
                ", Key='" + Key + '\'' +
                '}';
    }
}
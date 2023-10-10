package com.example.randomsseriesproject.data;

import java.io.IOException;
import java.util.ArrayList;

import com.example.randomsseriesproject.data.APIClient;
import com.example.randomsseriesproject.models.SeriesModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

public class main {
    public static void main(String[] args) throws IOException{
        ArrayList<SeriesModel> seriesList = APIClient.getSeries();
        int random = (int) (Math.random() * seriesList.size());
        SeriesModel randomSeries = seriesList.get(random);


        String name = randomSeries.getName();
        String overview = randomSeries.getOverview();
        double popularity = randomSeries.getPopularity();
        double vote_average = randomSeries.getVote_average();
        String key = randomSeries.getKey();

        System.out.println("Random Series: " + name);
        System.out.println("Overview: " + overview);
        System.out.println("Popularity: " + popularity);
        System.out.println("Vote Average: " + vote_average);
        System.out.println("Key: " + key);


    }
}

package com.example.RandomShowProject.Controller;

import com.example.RandomShowProject.Data.APIClient;
import com.example.RandomShowProject.Models.ShowModel;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class RandomShowController {

    @GetMapping
    public String index(Model model) throws JSONException, IOException {
        ArrayList<ShowModel> showsList = APIClient.getShows();
        int random = (int) (Math.random() * showsList.size());
        ShowModel randomShows = showsList.get(random);

        String color;
        double Vote_average = randomShows.getVote_average();
        if (Vote_average >= 0 && Vote_average <= 5) {
            color = "#f54242";
        } else if (Vote_average >= 6 && Vote_average <= 7) {
            color = "#f5e042";
        } else if (Vote_average >= 8 && Vote_average <= 10) {
            color = "#04AA6D";
        } else {
            color = "Invalid";
        }

        model.addAttribute("name", randomShows.getName());
        model.addAttribute("overview", randomShows.getOverview());
        model.addAttribute("popularity", "Popularity: " + randomShows.getPopularity());
        model.addAttribute("vote_average", "Rating: " + randomShows.getVote_average());
        model.addAttribute("key", randomShows.getKey());
        model.addAttribute("color", color);

        return "index";
    }
}

package com.example.RandomShowProject;

import com.example.RandomShowProject.Data.APIClient;
import com.example.RandomShowProject.Models.ShowModel;
import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;

@SpringBootApplication
public class RandomShowProjectApplication {

    public static void main(String[] args) throws JSONException, IOException {
		SpringApplication.run(RandomShowProjectApplication.class, args);
	}
}

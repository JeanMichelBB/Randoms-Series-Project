package com.example.RandomShowProject.Data;

import com.example.RandomShowProject.Models.ShowModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class APIClient {
    public static ArrayList<ShowModel> getShows() throws IOException, JSONException {

        URL url = new URL("https://api.themoviedb.org/3/tv/top_rated?api_key=53e1583141045810cb1911af442d5981");
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        ArrayList<ShowModel> showList;
        int status = con.getResponseCode();

        if (status == HttpURLConnection.HTTP_OK) {
            StringBuilder response = new StringBuilder();
            Scanner scanner = new Scanner(con.getInputStream());
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            JSONObject jsonObject = new JSONObject(response.toString());
            System.out.println(response);
            JSONArray shows = jsonObject.getJSONArray("results");
            showList = new ArrayList<>();
            for (int i = 0; i < shows.length(); i++) {
                JSONObject show = shows.getJSONObject(i);
                int id = show.getInt("id");
                String name = show.getString("name");
                String overview = show.getString("overview");
                int popularity = show.getInt("popularity");
                int vote_average = show.getInt("vote_average");
                String key = getShowVideoId(id);
                ShowModel showModel = new ShowModel(id, name, overview, popularity, vote_average, key);
                showList.add(showModel);
            }
            return showList;
        }else {
            System.out.println("Error");
        }
        return null;
    }
    public static String getShowVideoId(int showId) throws IOException, JSONException {

        URL url = new URL("https://api.themoviedb.org/3/tv/" + showId + "/videos?api_key=53e1583141045810cb1911af442d5981");
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();

        if (status == HttpURLConnection.HTTP_OK) {
            StringBuilder response = new StringBuilder();
            Scanner scanner = new Scanner(con.getInputStream());
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            JSONObject jsonObject = new JSONObject(response.toString());
            System.out.println(response);
            JSONArray shows = jsonObject.getJSONArray("results");
            String key = "";
            for (int i = 0; i < shows.length(); i++) {
                JSONObject showVideo = shows.getJSONObject(i);
                key = showVideo.getString("key");
            }
            return key;
        }else {
            System.out.println("Error");
        }
        return null;
    }
}

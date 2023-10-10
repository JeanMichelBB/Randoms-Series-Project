package com.example.randomsseriesproject.data;

import java.io.IOException;
import java.util.ArrayList;

import com.example.randomsseriesproject.data.APIClient;
import com.example.randomsseriesproject.models.SeriesModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/RandomSeriesServlet")
public class RandomSeriesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ArrayList<SeriesModel> seriesList = APIClient.getSeries();
        int random = (int) (Math.random() * seriesList.size());
        SeriesModel randomSeries = seriesList.get(random);

        String name = randomSeries.getName();
        String overview = randomSeries.getOverview();
        double popularity = randomSeries.getPopularity();
        double vote_average = randomSeries.getVote_average();
        String key = randomSeries.getKey();

        request.setAttribute("series.name", name);
        request.setAttribute("series.overview", overview);
        request.setAttribute("series.popularity", popularity);
        request.setAttribute("series.vote_average", vote_average);
        request.setAttribute("series.key", key);

        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            response.sendRedirect("/index.jsp");
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

}

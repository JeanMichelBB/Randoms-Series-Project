<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Randoms Series</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<%
    String voteAverage = (String) request.getAttribute("vote_average");
    String style = "";

    if (voteAverage != null) {
        double average = Double.parseDouble(voteAverage);
        if (average >= 0 && average < 5) {
            style = "background-color: red;";
        } else if (average >= 5 && average < 7) {
            style = "background-color: yellow;";
        } else if (average >= 7 && average <= 10) {
            style = "background-color: green;";
        }
    } else {
        style = "color: gray;";
    }
%>
<div class="top">
    <h1>Looking for something to watch?</h1>
    <form action="RandomSeriesServlet" method="post">
        <button type="submit" id="randomsButton">Next Series</button>
    </form>
</div>

<div class="description-box">
    <div class="element" id="name"><%= (request.getAttribute("name") != null) ? request.getAttribute("name") : "Breaking Bad" %></div>
    <div class="element" id="popularity">Popularity: <%= (request.getAttribute("popularity") != null) ? request.getAttribute("popularity") : "271.348" %></div>
    <div class="element2" id="vote_average" style="<%= style %>">Vote: <%= (voteAverage != null) ? voteAverage : "8.9" %></div>
    <br>
    <div class="element3" id="overview"><%= (request.getAttribute("overview") != null) ? request.getAttribute("overview") : "When Walter White, a New Mexico chemistry teacher, is diagnosed with Stage III cancer and given a prognosis of only two years left to live. He becomes filled with a sense of fearlessness and an unrelenting desire to secure his family's financial future at any cost as he enters the dangerous world of drugs and crime." %></div>

</div>
<div class="center">
    <iframe class="video" src="<%= (request.getAttribute("key") != null) ? "https://www.youtube.com/embed/"+request.getAttribute("key") : "https://www.youtube.com/embed/VFLkMDEO-Xc" %>" allowfullscreen></iframe>
</div>
</body>
</html>
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MeteumServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String latitudeParam = request.getParameter("lat");
        String longitudeParam = request.getParameter("lon");

        double latitude = Double.parseDouble(latitudeParam);
        double longitude = Double.parseDouble(longitudeParam);

        Map<String, Object> forecast;
        try {
            forecast = Forecast.getForecast(latitude, longitude);
        } catch (Exception e) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Meteum API Example</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Error</h1>");
            out.println("<p>" + e.getMessage() + "</p>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Meteum API Example</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Forecast for latitude " + latitude + " and longitude " + longitude + "</h1>");
        out.println("<p>" + forecast.get("data") + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}

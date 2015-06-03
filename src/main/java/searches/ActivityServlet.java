package searches;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.MyServlet;

public class ActivityServlet extends MyServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        synchronized (request.getSession()) {
            super.doGet(request, response);
            System.out.println("text:" + getUrlParts().get(0));
            switch (getUrlParts().get(0)) {
            case "Intake": 
                forwardTo("/Intake.jsp");
                break;
            case "search":
                ActivitySearch activitySearch = new ActivitySearch();
                String activity = getRequest().getParameter("q");
                ArrayList<String> probActivity = activitySearch.activitySearch(activity);
                System.out.println("hier komen activities: " + probActivity + " dit was de zoekterm: " + activity);
                if (activity != null) {
                    request.setAttribute("activityList", probActivity);
                }
                forwardTo("/Intake.jsp");
                break;
            } 
        }
    }
    
    /**
     * Any POST request concerning the user.
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        synchronized (request.getSession()) {
            super.doPost(request, response);
            switch (getUrlParts().get(0)) {
            case "intake": 
                ActivityAdd activityAdd = new ActivityAdd();
                System.out.println("activity = " + getRequest().getParameter("activity") + " maybe user: " + ((core.User) request.getSession().getAttribute("user")).getIdUser() + " shizzle: " //getRequest().getParameterNames().toString()
                );
                activityAdd.addActivity(getRequest().getParameter("activity"), ((core.User) request.getSession().getAttribute("user")).getIdUser(), Double.parseDouble(getRequest().getParameter("amount")));
                forwardTo("/Intake.jsp");
                break;
            }
            // No page selected.
            doGet(getRequest(), getResponse());
        } 
    }
}
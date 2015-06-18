package searches;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IntakeServlet extends core.MyServlet{
    private static final long serialVersionUID = 1L;

    /**
     * Any GET requests concerning the food.
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        synchronized (request.getSession()) {
            super.doGet(request, response);
            FoodSearch foodSearch = new FoodSearch();
            ActivitySearch activitySearch = new ActivitySearch();
            System.out.println("text:" + getUrlParts().get(0));
            switch (getUrlParts().get(0)) {
            case "Intake": 
                ArrayList<ArrayList<String>> Foodlist = foodSearch.foodShow(((core.User) request.getSession().getAttribute("user")).getIdUser());
                request.setAttribute("myFood", Foodlist);
                System.out.println(Foodlist);
                ArrayList<ArrayList<String>> Activitylist = activitySearch.activityShow(((core.User) request.getSession().getAttribute("user")).getIdUser());
                request.setAttribute("myAct", Activitylist);
                System.out.println(Activitylist);
                forwardTo("/Intake.jsp");
                break;
            case "search":  
                String food = getRequest().getParameter("q");
                int userID = ((core.User) request.getSession().getAttribute("user")).getIdUser();
                ArrayList<String> probFood = foodSearch.foodsearch(food, userID);
                System.out.println("hier komt eten: " + probFood + " dit was de zoekterm: " + food);
                if (food != null) {
                    request.setAttribute("foodList", probFood);
                }
                forwardTo("/Intake");
                break;
            case "actsearch":
                String activity = getRequest().getParameter("q");
                ArrayList<String> probActivity = activitySearch.activitySearch(activity);
                System.out.println("hier komen activities: " + probActivity + " dit was de zoekterm: " + activity);
                if (activity != null) {
                    request.setAttribute("ActivityList", probActivity);
                }
                forwardTo("/Intake");
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
            FoodAdd foodAdd = new FoodAdd();
            SleepAdd sleepAdd = new SleepAdd();
            switch (getUrlParts().get(0)) {
            case "intake": 
              // System.out.println("food = " + getRequest().getParameter("food") + " maybe user: " + ((core.User) request.getSession().getAttribute("user")).getIdUser() + " shizzle: " //getRequest().getParameterNames().toString()
                //);
                foodAdd.addFood(getRequest().getParameter("food"), ((core.User) request.getSession().getAttribute("user")).getIdUser(), Double.parseDouble(getRequest().getParameter("amount")));
                forwardTo("/Intake");
                break;
            case "moreFood":
                System.out.println("holooaos: " + getRequest().getParameter("calorie") );
                System.out.println("holooaos1: " + getRequest().getParameter("amount") );
                System.out.println("holooaos2: " + getRequest().getParameter("unit") );
                foodAdd.addFoodToDB(Double.parseDouble(getRequest().getParameter("calorie")),Double.parseDouble(getRequest().getParameter("amount")), getRequest().getParameter("unit"), 0, 0, 0, ((core.User) request.getSession().getAttribute("user")).getIdUser(), getRequest().getParameter("name"));
                forwardTo("/Intake");
                break;
            case "intakeA": 
                ActivityAdd activityAdd = new ActivityAdd();
                //System.out.println("activity = " + getRequest().getParameter("activity") + " maybe user: " + ((core.User) request.getSession().getAttribute("user")).getIdUser() + " shizzle: " //getRequest().getParameterNames().toString()
                //);
                activityAdd.addActivity(getRequest().getParameter("activity"), ((core.User) request.getSession().getAttribute("user")).getIdUser(), Double.parseDouble(getRequest().getParameter("amount")));
                forwardTo("/Intake");
                break;
            case "sleep": 
                String sleepstart = request.getParameter("sleepstart");
                String sleepend = request.getParameter("sleepend");
                System.out.println();
                int sleepstarthour = Integer.parseInt(sleepstart.split(":")[0]);
                int sleepstartmin = Integer.parseInt(sleepstart.split(":")[1]);
                int sleependhour = Integer.parseInt(sleepend.split(":")[0]);
                int sleependmin = Integer.parseInt(sleepend.split(":")[1]);
                double sleepstartper = ((double)sleepstartmin / 60.0);
                double sleependper = ((double) sleependmin / 60.0);
                double sleepStart = sleepstarthour + sleepstartper;
                double sleepEnd = sleependhour + sleependper;
                double sleepDuration;
                if (sleepStart > sleepEnd) {
                    double tmpStart = 24 - sleepStart;
                    sleepDuration = tmpStart + sleepEnd;
                } else if (sleepStart < sleepEnd) {
                    sleepDuration = sleepEnd - sleepStart;
                } else {
                    sleepDuration = 0;
                }
                System.out.println("slaapjez: " + sleepDuration + " begin " + sleepstart + " eind " + sleepend + " sleepper " + sleepstartper + " + " + sleependper);
                sleepAdd.addSleep(sleepDuration,((core.User) request.getSession().getAttribute("user")).getIdUser());
                int sleepdurationhour = (int) sleepDuration;
                double sleepdurationmin = sleepDuration - sleepdurationhour;
                String times = ("je hebt: " + sleepdurationhour + " uur en " + sleepdurationmin + " minuten geslapen");
                request.setAttribute("sleepdur", times);
                forwardTo("/Intake");
                break;
            }
            // No page selected.
            doGet(getRequest(), getResponse());
        } 
    }
}



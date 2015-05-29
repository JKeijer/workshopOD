package searches;



    import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.MyServlet;

    public class FoodServlet extends MyServlet {
        private static final long serialVersionUID = 1L;

        // --- Instance variables ----------------------------------------------------------------
        
        // --- Getters ---------------------------------------------------------------------------

        // --- Request handlers ------------------------------------------------------------------
        
        /**
         * Any GET requests concerning the food.
         */
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
                    FoodSearch foodSearch = new FoodSearch();
                    String food = getRequest().getParameter("q");
                    ArrayList<String> probFood = foodSearch.foodsearch(food);
                    System.out.println("hier komt eten: " + probFood + " dit was de zoekterm: " + food);
                    if (food != null) {
                        request.setAttribute("foodList", probFood);
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
                    FoodAdd foodAdd = new FoodAdd();
                    System.out.println("food = " + getRequest().getParameter("food") + " maybe user: " + ((core.User) request.getSession().getAttribute("user")).getIdUser() + " shizzle: " //getRequest().getParameterNames().toString()
                    );
                    foodAdd.addFood(getRequest().getParameter("food"), ((core.User) request.getSession().getAttribute("user")).getIdUser(), Double.parseDouble(getRequest().getParameter("amount")));
                    forwardTo("/Intake.jsp");
                    break;
                }
                // No page selected.
                doGet(getRequest(), getResponse());
            } 
        }
}
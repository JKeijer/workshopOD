package core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInOutServlet extends MyServlet {
    private static final long serialVersionUID = 1L;
    private Menu menu;
    private TrainingMenu train;
    private StoredRules storedRules;
    /**
     * Any GET requests concerning the food.
     */
    
    public UserInOutServlet() {
    	//System.out.println("deze wordt aangemaakt");
    	menu = new Menu();
    	train = new TrainingMenu();
    	storedRules = new StoredRules();
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        synchronized (request.getSession()) {
            super.doGet(request, response);
            //UserInOut inOut = new UserInOut();
            //System.out.println("text:" + getUrlParts().get(0) + " - " + getAction() + " - " + request.getSession());
            switch (getAction()) {
            case "start":
                request.setAttribute("beginning", "please give input to start");
                forwardTo("/start.jsp");
                break;
            case "rule":
                forwardTo("/start.jsp");
                break;
            case "begin":
            	//System.out.println("play the introduction");
                //Introduction1 intro = new Introduction1();
                //String thebeginning = intro.playIntroduction1();
                request.setAttribute("beginning", "debug this"); //thebeginning);
                forwardTo("/start.jsp");
                break;
            default:
                forwardTo("/start.jsp");
            }
        }
    }

    /**
     * Any POST request concerning the user.
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse
            response)
                    throws ServletException, IOException {
        synchronized (request.getSession()) {
        	//System.out.println("session: "+ request.getSession() + " menu: " + menu.getClass());
            super.doPost(request, response);
            //System.out.println(menu.storedRules);
            menu.storedRules.getStoreSize();
            String answer = "";
            String output = "";
            String token = getRequest().getParameter("token");
            if (token.equals("")) {
            	token = storedRules.getClientToken();
            	request.setAttribute("clientToken", token);
            } else {
            	request.setAttribute("clientToken", token);
            }
            switch (getAction()) {
            case "begin":
                answer = getRequest().getParameter("q").toLowerCase();
                //System.out.println(answer);
                //System.out.println("play the introduction 2");
                if (answer.equals("ghjkl;'")) {
                    request.setAttribute("beginning", menu.menu1());
                    request.setAttribute("position", "menu2");
                } else if (answer.equals("fghjkl;'")) {
                	request.setAttribute("beginning", "next");
                    request.setAttribute("position", "training1");
                } else {
                    Introduction1 intro = new Introduction1();
                    String thebeginning = intro.playIntroduction1();
                    request.setAttribute("beginning", thebeginning);
                    request.setAttribute("position", "training1");
                }
                //forwardTo("start.jsp");
                break;
            case "menu1":
                request.setAttribute("beginning", menu.menu1());
                request.setAttribute("position", "menu2");
                //forwardTo("start.jsp");
                break;
            case "menu2":
                answer = getRequest().getParameter("q").toLowerCase();
                if (answer.equals("play")) {
                    output = menu.menu2(answer, token);
                    request.setAttribute("beginning", output);
                    request.setAttribute("position", "menu3");
                } else if (answer.equals("rule")){
                    output = menu.menu2(answer, token);
                    request.setAttribute("beginning", output);
                    request.setAttribute("position", "menu4");
                } else {
                    request.setAttribute("beginning", "please insert 'play' or 'rule'");
                    request.setAttribute("position", "menu2");
                }
                //forwardTo("start.jsp");
                break;
            case "menu3":
                answer = getRequest().getParameter("q").toLowerCase();
                String menu3answer = menu.menu3(answer, token);
                if (menu3answer.contains("please input 1, 2, 3 or 4")) {
                    request.setAttribute("beginning", menu3answer);
                    request.setAttribute("position", "menu3");
                } else {
                    request.setAttribute("beginning", menu.menu3(answer, token).concat(menu.menu1()));
                    request.setAttribute("position", "menu2");
                }
                //forwardTo("start.jsp");
                break;
            case "menu4":
                answer = getRequest().getParameter("q").toLowerCase();
                request.setAttribute("beginning", menu.menu4(answer, token));
                request.setAttribute("position", "menu5");
                //forwardTo("start.jsp");
                break;
            case "menu5":
                answer = getRequest().getParameter("q").toLowerCase();
                if (answer.equals("yes")) {
                    request.setAttribute("beginning", menu.menu1());
                    request.setAttribute("position", "menu2");
                } else if (answer.equals("no")) {
                    request.setAttribute("beginning", "Which rule do you want to add?-");
                    request.setAttribute("position", "menu4");
                } else {
                    request.setAttribute("beginning", "please insert yes or no-");
                    request.setAttribute("position", "menu5");
                }
                //forwardTo("start.jsp");
                break;
            case "training1":
                output = train.playtraining(menu.storedRules.getRules(token));
                output = output.concat("Rule: if a car comes from the ... - "
                        + "type what should be on the dots");
                request.setAttribute("beginning", output);
                request.setAttribute("position", "training2");
                //forwardTo("start.jsp");
                break;
            case "training2":
                answer = getRequest().getParameter("q").toLowerCase();
                if (answer.equals("right")) {
                    output = "What should your car do in this situation -"
                            + "Rule: if a car comes from the right -"
                            + "Do: ...";   
                    request.setAttribute("beginning", output);
                    request.setAttribute("position", "training3");
                } else {
                    output = "That is not a correct input, maybe you should try something else-";
                    output = output.concat("Rule: if a car comes from the ... - "
                            + "type what should be on the dots");
                    request.setAttribute("beginning", output);
                    request.setAttribute("position", "training2");
                }
                //forwardTo("start.jsp");
                break;
            case "training3":
                answer = getRequest().getParameter("q").toLowerCase();
                if (answer.equals("stop")) {
                    //train.addRule("carComingRight");
                    menu.storedRules.addTrainingRule(token, "carComingRight");
                    output = "That is correct -"
                            + "give input to try again";
                    request.setAttribute("beginning", output);
                    request.setAttribute("position", "training4");
                } else {
                    output = "That is not a correct input, maybe you should try something else-";
                    output = output.concat("What should your car do in this situation -"
                            + "Rule: if a car comes from the right -"
                            + "Do: ...");   
                    request.setAttribute("beginning", output);
                    request.setAttribute("position", "training3");
                }
                //forwardTo("start.jsp");
                break;
            case "training4":
            	output = train.playtraining(menu.storedRules.getRules(token));
                output = output.concat("Rule: If ... car");
                request.setAttribute("beginning", output);
                request.setAttribute("position", "training5");
                //forwardTo("start.jsp");
                break;
            case "training5":
                answer = getRequest().getParameter("q").toLowerCase();
                if (answer.equals("no")) {
                    output = "Rule: if no car comes from the ... -";   
                    request.setAttribute("beginning", output);
                    request.setAttribute("position", "training6");
                } else {
                    output = "That is not a correct input, maybe you should try something else-";
                    output = output.concat("Rule: if ... car ");
                    request.setAttribute("beginning", output);
                    request.setAttribute("position", "training5");
                }
                //forwardTo("start.jsp");
                break;
            case "training6":
                answer = getRequest().getParameter("q").toLowerCase();
                if (answer.equals("right")) {
                    output = "What should your car do in this situation -"
                            + "Rule: if no car comes from the right -"
                            + "Do: ...";   
                    request.setAttribute("beginning", output);
                    request.setAttribute("position", "training7");
                } else {
                    output = "That is not a correct input, maybe you should try something else-";
                    output = output.concat("Rule: if no car comes from the ... ");
                    request.setAttribute("beginning", output);
                    request.setAttribute("position", "training6");
                }
                //forwardTo("start.jsp");
                break;
            case "training7":
                answer = getRequest().getParameter("q").toLowerCase();
                if (answer.equals("drive")|| answer.equals("go")) {
                    //train.addRule("noCarComingRight");
                    menu.storedRules.addTrainingRule(token, "noCarComingRight");
                    output = "That is correct -"
                            + "give input to try again";
                    request.setAttribute("beginning", output);
                    request.setAttribute("position", "training8");
                } else {
                    output = "That is not a correct input, maybe you should try something else-";
                    output = output.concat("What should your car do in this situation -"
                            + "Rule: if no car comes from the right -"
                            + "Do: ...");   
                    request.setAttribute("beginning", output);
                    request.setAttribute("position", "training7");
                }
                //forwardTo("start.jsp");
                break;
            case "training8":
            	output = train.playtraining(menu.storedRules.getRules(token));
                output = output.concat("which rule do you want to change? -"
                        + "1. If a car comes from the right stop -"
                        + "2. if no car comes from the right drive");
                request.setAttribute("beginning", output);
                request.setAttribute("position", "training9");
                //forwardTo("start.jsp");
                break;
            case "training9":
                answer = getRequest().getParameter("q").toLowerCase();
                if (answer.equals("2")) {
                    output = "if no car comes from the right - "
                             + "Do: drive -" 
                            + "Then: ...";
                    request.setAttribute("beginning", output);
                    request.setAttribute("position", "training10");
                } else {
                    output = "That is not a correct input, maybe you should try something else-";
                    output = output.concat("which rule do you want to change? -"
                        + "1. If a car comes from the right stop -"
                        + "2. if no car comes from the right drive");   
                    request.setAttribute("beginning", output);
                    request.setAttribute("position", "training9");
                }
                //forwardTo("start.jsp");
                break;
            case "training10":
                answer = getRequest().getParameter("q").toLowerCase();
                if (answer.contains("speed") && answer.contains("limit")) {
                    //train.addRule("speedLimitCity");
                    menu.storedRules.addTrainingRule(token, "speedLimitCity");
                    Introduction2 intro2 = new Introduction2();
                    output = "That is correct -" + intro2.playIntroduction2();
                    request.setAttribute("beginning", output);
                    request.setAttribute("position", "menu1");
                } else {
                    output = "That is not a correct input, maybe you should try something else-";
                    output = output.concat("if no car comes from the right - "
                             + "Do: drive -" 
                            + "Then: ...");   
                    request.setAttribute("beginning", output);
                    request.setAttribute("position", "training10");
                }
                //forwardTo("start.jsp");
                break;

            // No page selected.
            
        }
            request.setAttribute("tried", menu.storedRules.getTries(token));
            //System.out.println("tries:");
            //System.out.println(menu.storedRules.getTries(token));
            //System.out.println(storedRules.getTries(token));
            //System.out.println(menu.triedRules);
            forwardTo("start.jsp");
            
            //doGet(getRequest(), getResponse());
    }
    }
}
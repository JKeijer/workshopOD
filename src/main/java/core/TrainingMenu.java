package core;

import java.util.ArrayList;

/**
 *
 * @author Julik
 */
public class TrainingMenu {

    // Rules for the game
    public TrainingLevel trainingLevel = new TrainingLevel();;
    //public ArrayList<String> ruleList = new ArrayList<String>();

/*    public String trainingLevelStart(String position) throws InterruptedException {
        ArrayList<String> ruleList = new ArrayList<String>();
        trainingLevel.trainLevel(ruleList);
        UserInOut inOut = new UserInOut();
        String x = "";
        boolean start = true;
        String options = "";
        while (start) {
            boolean var1 = true;
            boolean var2 = true;
            boolean var3 = true;
            boolean var4 = true;
            boolean var5 = true;
            boolean var6 = true;
            boolean var7 = true;
            boolean var8 = true;
            while (var1) {
                String direction = inOut
                        .getString("Rule: if a car comes from the ... \n "
                                + "type what should be on the dots");
                if (direction.equals("right")) {
                    var1 = false;
                } else {
                    inOut.giveOutput("That is not a correct input, maybe you should try something else");
                }
            }
            while (var2) {
                String action = inOut
                        .getString("What should your car do in this situation \n"
                                + "Do: ...");
                if (action.equals("stop") || action.equals("brake")) {
                    ruleList.add("carCommingRight"); 
                    var2 = false;
                } else {
                    inOut.giveOutput("That is not the correct input, maybe you should try something else");
                }
            }
            while (var8) {
                options = inOut.getString("do you want to try again?");
                if (options.contains("again") || options.contains("yes")) {
                    trainingLevel.trainLevel(ruleList);
                    var8 = false;
                } else {
                    inOut.giveOutput("That is not the correct input, maybe you should try something else");
                }
            }
            var8 = true;
            while (var3) {
                // String menuOptions =
                // inOut.getString("Current rules or add a new one? (current/new)");
                // if (menuOptions.equals("new")) {
                String variable = inOut.getString("Rule: If ... car");
                if (variable.equals("no")) {
                    var3 = false;
                } else {
                    inOut.giveOutput("That is not the correct input, maybe you should try something else");
                }
                // }
            }
            while (var4) {
                String direction = inOut
                        .getString("Rule: If no car comes from the ...");
                if (direction.equals("right")) {
                    var4 = false;
                } else {
                    inOut.giveOutput("That is not the correct input, maybe you should try something else");
                }
            }
            while (var5) {
                String action = inOut.getString("Do: ...");
                if (action.equals("drive") || action.equals("go")
                        || action.equals("start")) {
                    ruleList.add("noCarCommingRight");
                    var5 = false;
                } else {
                    inOut.giveOutput("That is not the correct input, maybe you should try something else");
                }
            }
            while (var8) {
                options = inOut.getString("do you want to try again?");
                if (options.equals("again") || options.contains("yes")) {
                    trainingLevel.trainLevel(ruleList);
                    var8 = false;
                } else {
                    inOut.giveOutput("That is not the correct input, maybe you should try something else");
                }
            }
            var8 = true;
            while (var6) {
                String menuOptions = inOut
                        .getString("Current rules or add a new one? (current/new)");
                if (menuOptions.equals("current")) {
                    String choice = inOut.getString("Rules \n"
                            + "1. If a car comes from the right stop \n"
                            + "2. if no car comes from the right drive \n \n"
                            + "which rule do you want to change");
                    if (choice.equals("2")) {
                        var6 = false;
                    }
                } else {
                    inOut.giveDirectOutput("That is not the correct input, maybe you should try something else");
                }
            }
            while (var7) {
                String variable = inOut
                        .getString("if no car comes from the right \n "
                                + "Do: drive \n" + "Then: ...");
                if (variable.contains("speed") && variable.contains("limit")) {
                    ruleList.add("speedLimitCity");
                    var7 = false;
                } else {
                    inOut.giveOutput("That is not the correct input, maybe you should try something else");
                }
            }
            while (var8) {
                options = inOut.getString("do you want to try again?");
                if (options.contains("again") || options.contains("yes")) {
                    trainingLevel.trainLevel(ruleList);
                    var8 = false;
                } else {
                    inOut.giveOutput("That is not the correct input, maybe you should try something else");
                }
            }
            start = false;
        }
        return x;
    }*/
    
    public String playtraining(ArrayList<String> ruleList) {
        String output = "";
        output = trainingLevel.trainLevel(ruleList);
        return output;
    }
    public void addRule(String rule) {
        //System.out.print(rule);
        //ruleList.add(rule);
    }
}

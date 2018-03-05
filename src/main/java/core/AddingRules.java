package core;

//import java.util.ArrayList;

public class AddingRules {
    /*private ArrayList<String> addedRules = new ArrayList<String>();

    public ArrayList<String> addRule(String input){
        TekstParsing tekstRule = new TekstParsing();
        // System.out.println(ruleList.size());
        // String tmpstring =
        // "for what situation do you want to change a rule? \n";
        // for(String key : ruleList.keySet()) {
        // tmpstring += key + "\n";
        // }
        // String string3;
        // string3 = inOut.getString(tmpstring);
        // if (ruleList.containsKey(string3)) {
        // inOut.giveDirectOutput("changing rules for " + string3);
        // if (string3.equals("trafficlight")) {
        // addedRules.add(rulesTrafficlights());
        // } else if (string3.equals("intersection")) {
        // addedRules.add(rulesIntersection());
        // }
        // }
        String rule = tekstRule.parseRule(input);
        if (!rule.equals("noRule")) {
            addedRules.add(rule);
        }
        return addedRules;
    }
*/
    // private String rulesTrafficlights() {
    // String rule = "";
    // String propRule = "";
    // propRule = inOut.getString("what rule do you want to add?");
    // if (propRule.split(" ")[0].equals("if") && propRule.contains("do:")) {
    // if (propRule.contains("red")) {
    // if (propRule.contains("stop")) {
    // rule = "lightRed";
    // }
    // } else if (propRule.contains("yellow") || propRule.contains("orange")) {
    // if (propRule.contains("slow")) {
    // rule = "lightOrange";
    // }
    // } else if (propRule.contains("green")) {
    // if (propRule.contains("drive") || propRule.contains("start") ||
    // propRule.contains("go")) {
    // rule = "lightGreen";
    // }
    // } else if (propRule.contains("opposite")) {
    // inOut.giveDirectOutput("maybe you need to add this rule somewhere else...");
    // }
    // } else {
    // inOut.giveDirectOutput("start a rule with If and make sure it contains do:");
    // }
    // if (!rule.equals("")) {
    // inOut.giveDirectOutput("Rule added!");
    // }
    // return rule;
    // }
    //
    // private String rulesIntersection() {
    // String rule = "";
    // String propRule = "";
    // propRule = inOut.getString("what rule do you want to add?");
    // if (propRule.split(" ")[0].equals("if") && propRule.contains("do:")) {
    // if (propRule.contains("and")) {
    // if (propRule.contains("i") && propRule.contains("left") &&
    // propRule.contains("opposite")) {
    // rule = "oppositedirectionleft";
    // if (propRule.contains("then") && (propRule.contains("go") ||
    // propRule.contains("drive"))) {
    // rule = "oppositedirectionleftwait";
    // }
    // }
    // if (propRule.contains("right") && propRule.contains("left") &&
    // propRule.contains("opposite")) {
    // if ((propRule.contains("all cars wait") ||
    // propRule.contains("all cars stop")) && (propRule.contains("go") ||
    // propRule.contains("drive"))) {
    // rule = "alldirectionsStraight";
    // } else if (propRule.contains("wait") || propRule.contains("stop")) {
    // rule = "alldirectionsWaitStraight";
    // if (propRule.contains("then") && (propRule.contains("drive") ||
    // propRule.contains("go"))) {
    // rule = "alldirectionsWaitStraightGo";
    // }
    // }
    // } else if (propRule.contains("right") && propRule.contains("opposite") &&
    // (propRule.contains("drive") || propRule.contains("go"))) {
    // rule = "rightoppositeStraight";
    // }
    // } else if (propRule.contains("right") && propRule.contains("stop")) {
    // inOut.giveDirectOutput("this rule already exists \n"
    // + "but maybe if you use the word 'and' ...");
    // }
    // } else {
    // inOut.giveDirectOutput("start a rule with If and make sure it contains do:");
    // }
    //
    // if (!rule.equals("")) {
    // inOut.giveDirectOutput("Rule added!");
    // }
    // return rule;
    // }

}

package core;

import java.util.ArrayList;
import java.util.HashMap;

public class TekstParsing {

/*    HashMap<String, ArrayList<String>> strippedRule = new HashMap<String, ArrayList<String>>();
    ArrayList<String> conditionTokens = new ArrayList<String>();
    ArrayList<String> actionTokens = new ArrayList<String>();*/
/*    private String[] conditions;
    private String[] actions;*/

    public String parseRule(String rule) {
        String finalrule = "";
        ArrayList<String> distilledConditions = new ArrayList<String>();
        ArrayList<String> distilledActions = new ArrayList<String>();
        String adjustedRule = rule.toLowerCase();
        ArrayList<String> conditionTokens = buildConditionTokens();
        ArrayList<String> actionTokens = buildActionTokens();
        // TODO /MK: Ik heb ook mensen gezien die 'if:' typen of bijvoorbeeld
        // 'do', je zou kunnen overwegen gewoon alle leestekens weg te halen
        // voor het parsen
        if (adjustedRule.split(" ")[0].equals("if")
                && adjustedRule.contains("do:")) {
            String compconditions = adjustedRule.split("do:")[0];
            String compactions = adjustedRule.split("do:")[1];
            compconditions = compconditions.split("if")[1];
            // System.out.println("de rule is: " + compconditions + " and " +
            // compactions);
            String[] conditions = parseConditions(compconditions);
            String[] actions = parseActions(compactions);
            distilledConditions = getConditions(conditions, conditionTokens);
            distilledActions = getActions(actions, actionTokens);
            finalrule = getRule(distilledConditions, distilledActions);
        } else {
            finalrule = "noRule";
        }
        return finalrule;
    }

    private String[] parseConditions(String compcondition) {
    	String[] conditions;
    	if (compcondition.contains("and")) {
            conditions = compcondition.split("and");
        } else {
            conditions = new String[1];
            conditions[0] = compcondition;
        }
        // conditions = stripConditions(conditions);
        return conditions;
    }

    private String[] parseActions(String compactions) {
        String[] actions;
    	if (compactions.contains("and")) {
            actions = compactions.split("and");
        } else {
            actions = new String[1];
            actions[0] = compactions;
        }
        // conditions = stripConditions(conditions);
        return actions;
    }

    private ArrayList<String> getConditions(String[] conditions, ArrayList<String> conditionTokens) {
        HashMap<Integer, ArrayList<String>> disConditions = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> sumConditions = new ArrayList<String>();
        int i = 0;
        for (String x : conditions) {
            // System.out.println("conditions" + x);
        }
        for (String condition : conditions) {
            String[] partCondition = condition.split(" ");
            for (String singleConditions : partCondition) {
                if (conditionTokens.contains(singleConditions)) {
                    // System.out.println("single conditions " +
                    // singleConditions);
                    sumConditions.add(singleConditions);
                }
            }
            for (String x : sumConditions) {
                // System.out.println("int i " + i + " the sum of conditions " +
                // x);
            }
            // disConditions.put(i, sumConditions);
            i++;
        }
        return sumConditions;
    }

    private ArrayList<String> getActions(String[] actions, ArrayList<String> actionTokens) {
        HashMap<Integer, ArrayList<String>> disActions = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> sumActions = new ArrayList<String>();
        int i = 0;
        for (String action : actions) {

            String[] partAction = action.split(" ");
            for (String singleAction : partAction) {
                if (actionTokens.contains(singleAction)) {
                    sumActions.add(singleAction);
                }
            }
            // disActions.put(i, sumActions);
            i++;
        }
        return sumActions;
    }

    /*private String[] stripConditions(String[] conditions, ArrayList<String> conditionTokens) {
        String[] stripedConditions = null;
        ArrayList<String> stripCons = new ArrayList<String>();
        for (String condition : conditions) {
            if (conditionTokens.contains(condition)) {
                stripCons.add(condition);
            }
        }
        stripedConditions = stripCons.toArray(new String[stripCons.size()]);
        return stripedConditions;
    }*/

    private String getRule(ArrayList<String> distilledConditions,
            ArrayList<String> distilledActions) {
        String finalrule = "";
        // for (int i = 0; i < distilledConditions.size(); i++) {
        // //System.out.println("the nullpointer " + i + " : " );
        // for (String cond : distilledConditions.get(i)) {
        // finalrule += normalizeCondition(cond);
        // }
        // }
        for (String cond : distilledConditions) {
            finalrule += normalizeCondition(cond);
        }
        // for (int i = 0; i < distilledActions.size(); i++) {
        // for (String act : distilledActions.get(0)) {
        // finalrule += normalizeAction(act);
        // }
        // }
        for (String act : distilledActions) {
            finalrule += normalizeAction(act);
        }
        // System.out.println("the complete rule " + finalrule);
        return finalrule;
    }

    private String normalizeCondition(String condition) {
        String normalCondition = "";

        switch (condition) {
        case "yellow":
            normalCondition = "yellow";
            break;
        case "orange":
            normalCondition = "yellow";
            break;
        default:
            normalCondition = condition;
        }
        return normalCondition;
    }

    private String normalizeAction(String action) {
        String normalAction = "";

        switch (action) {
        case "drive":
            normalAction = "drive";
            break;
        case "go":
            normalAction = "drive";
            break;
        case "start":
            normalAction = "drive";
            break;
        case "stop":
            normalAction = "stop";
            break;
        case "wait":
            normalAction = "stop";
            break;
        case "brake":
            normalAction = "stop";
            break;
        default:
            normalAction = action;
        }
        return normalAction;
    }

    public ArrayList<String> buildConditionTokens() {
    	ArrayList<String> conditionTokens = new ArrayList<String>();
        conditionTokens.add("green");
        conditionTokens.add("yellow");
        conditionTokens.add("orange");
        conditionTokens.add("red");
        conditionTokens.add("light");
        conditionTokens.add("left");
        conditionTokens.add("right");
        conditionTokens.add("straight");
        conditionTokens.add("ahead");
        conditionTokens.add("opposite");
        conditionTokens.add("i");
        conditionTokens.add("no");
        conditionTokens.add("car");
        conditionTokens.add("biker");
        conditionTokens.add("bike");
        conditionTokens.add("firetruck");
        conditionTokens.add("ambulance");
        conditionTokens.add("police");
        conditionTokens.add("tram");
        conditionTokens.add("all");
        conditionTokens.add("direction");
        conditionTokens.add("coming");
        conditionTokens.add("wait");
        conditionTokens.add("every");
        conditionTokens.add("drives");
        conditionTokens.add("roundabout");
        conditionTokens.add("country");
        conditionTokens.add("urban");
        return conditionTokens;
    }

    private ArrayList<String> buildActionTokens() {
    	ArrayList<String> actionTokens = new ArrayList<String>();
        actionTokens.add("stop");
        actionTokens.add("slow");
        actionTokens.add("down");
        actionTokens.add("start");
        actionTokens.add("drive");
        actionTokens.add("go");
        actionTokens.add("wait");
        return actionTokens;
    }
}

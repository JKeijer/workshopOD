package core;

import java.util.ArrayList;
import java.util.HashMap;

public class RuleValues {

    public HashMap<String, String> makeRuleList() {
        HashMap<String, String> ruleList = new HashMap<String, String>();
        // general
        ruleList.put("general", "cityStartDriving");
        ruleList.put("general", "citySpeedLimit");
        // intersection
        ruleList.put("intersection", "cityIntersectionNoCarRight");
        ruleList.put("intersection", "cityIntersectionCarRight");
        // intersectiontrafficlight
        ruleList.put("trafficlight", "lightOrange");
        ruleList.put("trafficlight", "lightRed");
        ruleList.put("trafficlight", "lightGreen");
        ruleList.put("trafficlight", "carRightLightGreen");
        // tram
        ruleList.put("tram", "NoTram");
        // publicservice
        ruleList.put("publicservice", "policeCarLeft");
        // roudabout
        ruleList.put("roundabout", "carOnRoudabout");
        ruleList.put("roundabout", "noCarOnRoundabout");
        ruleList.put("roundabout", "carCommingRightRoundabout");
        // T-intersections
        ruleList.put("T-intersection", "goingLeftCarCommingFront");

        // highway

        // country
        // System.out.println(ruleList.size());
        return ruleList;
    }

    public ArrayList<String> makeSituationList() {
        ArrayList<String> situationList = new ArrayList<String>();

        // situationList.put("intersection");
        // situationList.put("traficlight");

        return situationList;
    }
}

package core;

import java.util.ArrayList;

/**
 *
 * @author Julik
 */
public class TrainingLevel {

    // rules
    public boolean startDriving;
    public boolean speedLimitCity;
    public boolean carComingRight;
    public boolean noCarComingRight;
    private boolean goOn;

    public String trainLevel(ArrayList<String> ruleList){
        String r = "";
        // if (this.startDriving) {
        // System.out.println("Your car starts driving");
        // } else {
        // System.out.println("We are waiting... maybe you should add a rule");
        // }
        // Thread.sleep(500);
        // if (this.speedLimitCity) {
        // System.out.println("Your car accelrates up to the speed limit");
        // }
        System.out.println(ruleList);
        r = r.concat("Introduction level: --- ");
        r = r.concat("You are driving in the city-");
        r = r.concat("you approach an intersection-");
        r = r.concat("there is a car coming from the right-");
        if (ruleList.contains("carComingRight")) {
            r = r.concat("you stop and let the car pass-");
            this.goOn = true;
        } else {
            r = r.concat("you don't slow down and hit the car coming from the right-");
            r = r.concat("You crash!-");
            r = r.concat("FAIL!-");
            r = r.concat("maybe you should add some more rules --");
            this.goOn = false;
        }
        if (this.goOn && ruleList.contains("noCarComingRight")) {
            r = r.concat("You start driving again-");
            this.goOn = true;
        } else if (this.goOn) {
            r = r.concat("You are waiting...-");
            r = r.concat("And waiting...-");
            r = r.concat("And waiting...-");
            r = r.concat("And waiting...-");
            r = r.concat("Maybe you need some more rules-");
            this.goOn = false;
        }
        if (this.goOn && ruleList.contains("speedLimitCity")) {
            r = r.concat("You accelerate up to the speed limit-");
            this.goOn = true;
        } else if (this.goOn) {
            r = r.concat("you are accelerating...-");
            r = r.concat("and accelerating...-");
            r = r.concat("and accelerating...-");
            r = r.concat("you are driving too fast-");
            r = r.concat("and you got a ticket-");
            r = r.concat("maybe you need to change a rule..-");
            this.goOn = false;
        }
        if (this.goOn) {
            r = r.concat("Congratulation you passed the first mission and are underway to make your own selfdriving car-");
        }
        return r;
    }
    
}
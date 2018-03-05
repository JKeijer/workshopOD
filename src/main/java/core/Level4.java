package core;

import java.util.ArrayList;

public class Level4 implements Level {
    // You are driving in the city
    // a police car comes from behind you
    // you pull over
    // an ambulance comes from behind you
    // you pull over
    // a firetruck comes from behind you
    // you pull over
    // that wasn't so hard...

    private boolean goOn;

    @Override
    public String[] startLevel(ArrayList<String> ruleList) {
        String[] m = new String[2];
        String r = "";
        String finished = "false";
        //UserInOut inOut = new UserInOut();
        this.goOn = true;
        r = r.concat("Level 4: ---- ");
        r = r.concat("there is a police car coming from behind you-");
        if (ruleList.contains("policecarstop")) { // police car
            r = r.concat("you pull over and wait for the police car to pass-");
        } else {
            r = r.concat("you blocked the police car--");
            r = r.concat("now some criminals got away");
            this.goOn = false;
        }
        if (this.goOn) {
            r = r.concat("there is an ambulance coming from behind you");
            if (ruleList.contains("ambulancestop")) { // police car
                r = r.concat("you pull over and wait for the ambulance to pass-");
            } else {
                r = r.concat("you blocked the ambulance-");
                r = r.concat("now the ambulance was late to the accident-");
                r = r.concat("and this one not that hard to figure out...-");
                this.goOn = false;
            }
        }
        if (this.goOn) {
            r = r.concat("there is an firetruck coming from behind you-");
            if (ruleList.contains("firetruckstop")) { // police car
                r = r.concat("you pull over and wait for the fire truck to pass-");
            } else {
                r = r.concat("you blocked the fire truck-");
                r = r.concat("now the house burned down-");
                r = r.concat("this one was also really easy...-");
                r = r.concat("have you been paying attention?-");
                this.goOn = false;
            }
        }
        if (this.goOn) {
            r = r.concat("congratulations you passed level 4-");
            r = r.concat("this one was really easy ;)-");
            finished = "true";
        }
        m[0] = r;
        m[1] = finished;
        return m;
    }

}

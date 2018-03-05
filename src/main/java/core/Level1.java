package core;

import java.util.ArrayList;

public class Level1 implements Level {
    // you are approuching an intersection with traffic lights
    // there is no car coming from the right side
    // but the light is red
    // the light turns green with a car on the right
    // next intersection the light is yellow you are too far away
    // light turns red
    // light turns green
    // next intersection is more complicated
    // there is one green light for going straight ahead and going left
    // you want to go left
    // but there is a car coming from the opposite direction who wants to go
    // straight ahead
    // the light is green and you drive
    // the light in the opposite direction is also green
    // the other car has the right of way
    // you finished!

    public Level1() {

    }

    private boolean goOn;

    @Override
    public String[] startLevel(ArrayList<String> ruleList) {
/*        for (String x : ruleList) {
            System.out.println(x);
        }*/
        String[] m = new String[2];
        String finished = "false";
        //UserInOut inOut = new UserInOut();
        this.goOn = true;
        String r = "";
        r =r.concat("Level 1: ----");
        r = r.concat("you are approaching an intersection with traffic lights-");
        r = r.concat("there is no car on the right-");
        if (ruleList.contains("lightredstop")) {
            r = r.concat("you wait in front of the red light-");
        } else {
            r = r.concat("you drive through the red light-");
            r = r.concat("you get a ticket!-");
            this.goOn = false;
        }
        if (this.goOn) {
            r = r.concat("the light turns green-");
            if (ruleList.contains("lightgreendrive")) {
                r = r.concat("you start driving-");
            } else {
                r = r.concat("you are waiting in front of a green light...-");
                r = r.concat("the people behind you are getting really annoyed...-");
                this.goOn = false;
            }
        }
        if (this.goOn) {
            r = r.concat("you approach the next traffic light-");
            r = r.concat("the light is yellow-");
            if (ruleList.contains("lightyellowslowdown")) { // light is yellow
                r = r.concat("you slow down-");
                r = r.concat("the light turns red-");
                if (ruleList.contains("lightredstop")) {
                    r = r.concat("you stop in front of the red light-");
                    if (ruleList.contains("lightgreendrive")) { // light is
                                                                // green
                        r = r.concat("the light turns green-");
                        r = r.concat("you start driving-");
                    } else {
                        r = r.concat("still waiting in front of that green light...-");
                        this.goOn = false;
                    }
                } else {
                    r = r.concat("you get a ticket-");
                    this.goOn = false;
                }
            } else {
                r = r.concat("you do not slow down-");
                r = r.concat("the light turns red-");
                r = r.concat("you drive too fast and can not slow down-");
                r = r.concat("that is another ticket-");
                this.goOn = false;
            }
        }
        if (this.goOn) {
            r = r.concat("This next light is a little bit more complicated-");
            r = r.concat("there is one lane for going right-");
            r = r.concat("And one for going left and straight ahead-");
            r = r.concat("you approaching the traffic lights and want to turn left-");
            r = r.concat("The light is green-");
            r = r.concat("But there is a car coming from the opposite direction-");
            if (ruleList.contains("ileftcarcomingoppositedirectionstop")
                    || ruleList
                            .contains("ileftcarcomingoppositedirectionstopdrive")) { // rechtdoor
                                                                                      // heeft
                                                                                      // voorrang
                r = r.concat("you let the car pass-");
                if (ruleList
                        .contains("ileftcarcomingoppositedirectionstopdrive")) { // geen
                                                                                  // auto
                                                                                  // in
                                                                                  // de
                                                                                  // andere
                                                                                  // rijrichting
                                                                                  // =
                                                                                  // rijden
                    r = r.concat("you start driving again-");
                } else {
                    r = r.concat("you are waiting in the middle of the intersection...-");
                    r = r.concat("Other drivers are getting really annoyed...-");
                    this.goOn = false;
                }
            } else {
                r = r.concat("that other car had the right of way...-");
                r = r.concat("you crash into the other car!-");
                this.goOn = false;
            }
        }
        if (this.goOn) {
            r = r.concat("Congratulations you completed level 1-");
            finished = "true";
        }
        m[0] = r;
        m[1] = finished;
        return m;
    }
}

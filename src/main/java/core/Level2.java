package core;

import java.util.ArrayList;

public class Level2 implements Level {
    // you approach a normal intersection
    // there is a car coming from the right, left and straight ahead
    // you cross
    // you approach a t-intersection
    // there is a car on the right and coming in the opposite direction
    // the car from the right wants to go right
    // the car from the opposite direction wants to go left
    // you want to go straight ahead
    // you cross
    // at the next t-intersection there is a car on the right
    // you want to go right
    // there is a biker next to you who wants to go straight ahead
    // you wait and turn right
    // you finished

    // TODO add changing level
    // TODO it doens't make sense that the biker can pass...

    private boolean goOn;

    public Level2() {

    }

    @Override
    public String[] startLevel(ArrayList<String> ruleList) {
        String[] m = new String[2];
        String r = "";
        String finished = "false";
        //UserInOut inOut = new UserInOut();
        this.goOn = true;
        r = r.concat("Level 2: ---- ");
        r = r.concat("you aproach an intersection-");
        r = r.concat("there is a car coming from the right-");
        r = r.concat("there is a car coming from the opposite direction-");
        r = r.concat("there is a car coming from the left-");
        r = r.concat("all cars want to go straight ahead-");
        // TODO make more complicated
        int i = (int) (Math.random() * 2.0);
        if (i == 0) {
            r = r.concat("all the other cars wait-");
            if (ruleList.contains("carcomingeverydirectionnocardrive")) { // solve
                                                                           // deadlock
                                                                           // 4
                                                                           // cars
                r = r.concat("you decide to drive-");
                r = r.concat("you pass the intersection-");
            } else {
                r = r.concat("everybody is waiting...-");
                r = r.concat("and waiting...-");
                this.goOn = false;
            }
        } else if (i == 1) {
            r = r.concat("one of the cars decides to drive-");
            if (ruleList.contains("carcomingeverydirectioncardrivesstop")) { // solve
                                                                              // deadlock
                                                                              // 4
                                                                              // cars
                r = r.concat("you wait for the other car-");
                r = r.concat("you decide to drive-");
                r = r.concat("you pass the intersection-");
            } else {
                r = r.concat("you crash into the other car-");
                this.goOn = false;
            }
        }
        if (this.goOn) {
            r = r.concat("you aproach a t-intersection-");
            r = r.concat("there is a car coming from the right-");
            r = r.concat("that car wants to go left-");
            r = r.concat("there is a car coming from the opposite direction-");
            r = r.concat("that car wants to go left-");
            r = r.concat("you want to go straight ahead-");
            if (ruleList
                    .contains("carcomingrightcarcomingoppositedirectiondrive")) { // solve
                                                                                    // deadlock
                                                                                    // 3
                                                                                    // cars
                r = r.concat("you start driving-");
                r = r.concat("you pass the t-intersection-");
            } else {
                r = r.concat("everybody is waiting...-");
                r = r.concat("and waiting...-");
                this.goOn = false;
            }
        }
        if (this.goOn) {
            r = r.concat("you aproach a t-intersection-");
            r = r.concat("you want to go right-");
            r = r.concat("there is a biker next to you-");
            r = r.concat("there are a lot of cars coming from the right-");
            if (ruleList.contains("irightdrive")) { // if i want to go right it
                                                    // doesn't
                // matter
                if (ruleList.contains("bikercomingbehindstop")) { // wait for
                                                                   // bikers
                                                                   // going the
                                                                   // same
                    // direction
                    r = r.concat("you wait for the biker to pass-");
                    r = r.concat("you turn right-");
                } else {
                    r = r.concat("you run into the biker-");
                    r = r.concat("now the biker has to go to the hospital-");
                    this.goOn = false;
                }
            } else {
                r = r.concat("you are waiting on the cars from the right-");
                r = r.concat("why?-");
                this.goOn = false;
            }
        }
        if (this.goOn) {
            r = r.concat("you passed level 2!-");
            finished = "true";
        }
        m[0] = r;
        m[1] = finished;
        return m;
    }

}

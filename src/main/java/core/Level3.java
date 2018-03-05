package core;

import java.util.ArrayList;

public class Level3 implements Level {

    // rotonde buiten de bebouwde kom

    // you approach a roundabout
    // there is a biker coming from the left
    // you enter the roundabout
    // there is a car coming from the right
    // there is a biker coming from the right
    // you exit the roundabout
    // you leave the urban area
    // you approach a roundabout
    // there is a biker coming from the left
    // there is a car coming from the left
    // you enter the roundabout
    // there is a biker on the right
    // you leave the roundabout

    // turborotonde

    // TODO

    private boolean goOn;

    @Override
    public String[] startLevel(ArrayList<String> ruleList){
        String finished = "false";
        String[] m = new String[2];
        String r = "";
        //UserInOut inOut = new UserInOut();
        this.goOn = true;
        r = r.concat("Level 3: -------");
        r = r.concat("you approach a roundabout-");
        r = r.concat("you want to go straight ahead-");
        r = r.concat("there is a biker on the roundabout coming from the left-");
        if (ruleList.contains("iroundaboutbikercomingleftstop")
                || ruleList.contains("iroundaboutbikercomingleftiurbanstop")
                || ruleList.contains("iroundaboutbikercomingleftstopdrive")
                || ruleList
                        .contains("iroundaboutbikercomingleftiurbanstopdrive")) { // wait
                                                                                   // for
                                                                                   // bikers
            r = r.concat("you wait for the biker-");
            if (ruleList.contains("iroundaboutbikercomingleftstopdrive")
                    || ruleList
                            .contains("iroundaboutbikercomingleftiurbanstopdrive")) {
                r = r.concat("you start driving-");
            } else {
                r = r.concat("you are waiting in front of a empty roundabout...-");
                r = r.concat("still waiting...-");
            }
        } else {
            r = r.concat("you hit the biker-");
            r = r.concat("stop hitting those bikers!-");
            this.goOn = false;
        }
        if (this.goOn) {
            r = r.concat("you enter the roundabout-");
            r = r.concat("there is a car coming from the right-");
            if (ruleList.contains("iroundaboutcarcomingrightdrive")) { // dont
                                                                        // stop
                                                                        // for
                                                                        // cars
                                                                        // off
                                                                        // the
                                                                        // roundabout
                r = r.concat("you continue on the roundabout-");
            } else {
                r = r.concat("you wait for the car that wants to enter the roundabout-");
                r = r.concat("why?-");
                this.goOn = false;
            }
        }
        if (this.goOn) {
            r = r.concat("there is a biker on the roundabout coming from the right-");
            if (ruleList.contains("iroundaboutbikercomingrightstop")
                    || ruleList
                            .contains("iroundaboutbikercomingrightiurbanstop")
                    || ruleList
                            .contains("iroundaboutbikercomingrightstopdrive")
                    || ruleList
                            .contains("iroundaboutbikercomingrightiurbanstopdrive")) { // bikers
                                                                                        // from
                                                                                        // the
                                                                                        // right
                r = r.concat("you wait for the biker to pass-");
                if (ruleList.contains("iroundaboutbikercomingrightstopdrive")
                        || ruleList
                                .contains("iroundaboutbikercomingrightiurbanstopdrive")) {
                    r = r.concat("you exit the roundabout-");
                } else {
                    r = r.concat("so waiting in the middle of the roundabout...");
                    r = r.concat("you must like waiting...");
                }
            } else {
                r = r.concat("you hit the biker-");
                r = r.concat("stop that, most of them are nice people-");
                this.goOn = false;
            }
        }
        if (this.goOn) {
            r = r.concat("you drive out of the urban area onto the country side-");
            r = r.concat("you aproach a roundabout-");
            r = r.concat("you want to go right-");
            r = r.concat("there is a biker on the roundabout coming from the left-");
            if (ruleList.contains("iroundaboutbikercomingleftcountrydrive")) {
                r = r.concat("you enter the roundabout-");
                r = r.concat("no other traffic-");
                r = r.concat("you leave the roundabout on the first exit-");
            } else {
                r = r.concat("you wait for the biker...-");
                r = r.concat("the cars behind you are getting annoyed...-");
                this.goOn = false;
            }
        }
        if (this.goOn) {
            r = r.concat("you approach a roundabout-");
            r = r.concat("you want to go right-");
            r = r.concat("there is a car on the roundabout coming from the left-");
            if (ruleList.contains("iroundaboutcarcomingleftstop")
                    || ruleList.contains("iroundaboutcarcomingleftstopdrive")) { // car
                                                                                  // on
                                                                                  // roundabout
                                                                                  // coming
                                                                                  // from
                                                                                  // the
                                                                                  // left
                r = r.concat("you wait for the car to pass-");
                if (ruleList.contains("iroundaboutcarcomingleftstopdrive")) {
                    r = r.concat("you enter the roundabout-");
                    r = r.concat("you drive up to the first exit-");
                } else {
                    r = r.concat("waiting in front of an empty roundabout...-");
                    r = r.concat("aren't you tired of waiting on things?...-");
                }
            } else {
                r = r.concat("you crash into the car-");
                r = r.concat("well at least it is't a biker this time-");
                this.goOn = false;
            }
        }
        if (this.goOn) {
            r = r.concat("there is a biker coming from the right-");
            if (ruleList.contains("iroundaboutbikercomingrightcountrydrive")) { // bikers
                                                                                 // roundabout
                                                                                 // countryside
                r = r.concat("you exit the roundabout-");
            } else {
                r = r.concat("you are waiting on the biker to pass...-");
                r = r.concat("why?-");
                this.goOn = false;
            }
        }
        if (this.goOn) {
            r = r.concat("you passed level 3!-");
            finished = "true";
        }
        m[0] = r;
        m[1] = finished;
        return m;
    }

}

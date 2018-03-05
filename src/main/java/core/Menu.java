package core;

import java.util.ArrayList;
//import java.util.HashMap;

public class Menu {
    //private RuleValues ruleValue = new RuleValues();
    private LevelValues levelValue;
    //private AddingRules addingRules = new AddingRules();
    public StoredRules storedRules;
    //public HashMap<String, String> ruleList = new HashMap<String, String>();
    //public ArrayList<String> addedRules = new ArrayList<String>();
    // public HashMap<String, Boolean> levelList = new HashMap<String,
    // Boolean>();
    //public ArrayList<String> levelList = new ArrayList<String>();
    //public ArrayList<String> completedLevels = new ArrayList<String>();
    //public ArrayList<String> triedRules = new ArrayList<String>();

/*    public void startMenu() throws InterruptedException {
        //UserInOut inOut = new UserInOut();
        //this.ruleList = ruleValue.makeRuleList();
       // this.levelList = levelValue.makeLevelList();
        //boolean menu1 = true;
        //boolean menu2 = false;
        //boolean menu3 = false;
        //inOut.giveOutput("Here we go");
    }
    */
    
    public Menu() {
    	//System.out.println("deze wordt ook aangemaakt");
        levelValue = new LevelValues();
        storedRules = new StoredRules();
    }
    
    public String menu1() {
        String question = "what do you want to do? -"
                    + "play: play a level -rule: adjust a rule";
        return question;
    }
    
    public String menu2(String choice, String clientToken) {
        String tmpstring = "";
        ArrayList<String> levelList = new ArrayList<String>();
        if (choice.equals("play")) {
        //this.ruleList = ruleValue.makeRuleList();
        levelList = levelValue.makeLevelList();
        tmpstring = "which level do you want to play? -";
        int x = 0;
        for (String key : levelList) {
/*            if (completedLevels.contains(key)) {
                x++;
                tmpstring += key + "        completed-";
            } else {
                tmpstring += key + " " + "-";
            }*/
            tmpstring += key + " " + "-";
        }
        if (x == 4) {
            tmpstring = "Congratulations you completed every level!-";
        }
        } else if (choice.equals("rule")) {
            tmpstring = "Which rule do you want to add?-";
        }
        return tmpstring;
    }
    
    public String menu3(String string2, String clientToken) {
        String output = "";
        storedRules.getStoreSize();
        //System.out.println(storedRules);
        if (string2.equals("1")) {
            Level1 level1 = new Level1();
            String[] level1list = level1.startLevel(storedRules.getRules(clientToken));
            String level1Bool = level1list[1];
            output = level1list[0];
            if (level1Bool.equals("true")) {
                //completedLevels.add("1: Traffic Lights");
            }
            // levelList.put("1: Traffic Lights", level1Bool);
        } else if (string2.equals("2")) {
            Level2 level2 = new Level2();
            String[] level2list = level2.startLevel(storedRules.getRules(clientToken));
            String level2Bool = level2list[1];
            output = level2list[0];
            if (level2Bool.equals("true")) {
                //completedLevels.add("2: Advanced Intersections");
            }
        } else if (string2.equals("3")) {
            Level3 level3 = new Level3();
            String[] level3list = level3.startLevel(storedRules.getRules(clientToken));
            String level3Bool = level3list[1];
            output = level3list[0];
            if (level3Bool.equals("true")) {
                //completedLevels.add("3: Roundabouts");
            }
        } else if (string2.equals("4")) {
            Level4 level4 = new Level4();
            String[] level4list = level4.startLevel(storedRules.getRules(clientToken));
            String level4Bool = level4list[1];
            output = level4list[0];
            if (level4Bool.equals("true")) {
                //completedLevels.add("4: Special vehicles");
            }
        } else {
            output = "please input 1, 2, 3 or 4-";
        }
        return output;
    }
    
    public String menu4(String string3, String clientToken){
        //triedRules.add(string3);
        storedRules.addTrie(clientToken, string3);
        String output;
        boolean ruleValid;
        //ArrayList<String> tmp = addedRules;
        //addedRules = addingRules.addRule(string3);
        ruleValid = storedRules.addRule(clientToken, string3);
        //System.out.println(addedRules);
        //System.out.println(tmp);
        //System.out.println(storedRules.getRules(clientToken));
        //System.out.println(ruleValid);
        //System.out.println(clientToken);
        //System.out.println(storedRules.getTries(clientToken));
        if (!ruleValid) {
            output = "A rule starts with 'if' and contains 'do:'-"
                    + "Are you done changing rules? (yes/no)-";
        } else {
            output = "Rule added!-"
                    + "Are you done changing rules? (yes/no)-";
        }
        return output;
    }
}

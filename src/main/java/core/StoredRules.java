package core;

//import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

public class StoredRules {
	//private ArrayList<String> addedRules = new ArrayList<String>();
	//private ArrayList<String> triedRules = new ArrayList<String>();
	private HashMap<String, ArrayList<String>> clientRules;
	private HashMap<String, ArrayList<String>> clientTries;
	private TekstParsing tekstRule;
	
	public StoredRules() {
		clientRules = new HashMap<String, ArrayList<String>>();
		clientTries = new HashMap<String, ArrayList<String>>();
		tekstRule = new TekstParsing();
		/*System.out.println("stored ellende");
		System.out.println(clientRules.size());
		System.out.println(clientTries.size());*/
		
	}
	
	public void getStoreSize() {
		//System.out.println(clientRules);
		//System.out.println(clientTries);
	}
	
	public ArrayList<String> getRules(String clientToken) {
		ArrayList<String> MyClientRules = new ArrayList<String>();
		if (clientRules.containsKey(clientToken)) {
			MyClientRules = clientRules.get(clientToken);
		}
		return MyClientRules;
	}
	
	public ArrayList<String> getTries(String clientToken) {
		ArrayList<String> MyClientTries = new ArrayList<String>();
		if (clientTries.containsKey(clientToken)) {
			MyClientTries = clientTries.get(clientToken);
		}
		return MyClientTries;
	}
	
	public void setRules(String clientToken, ArrayList<String> myClientRules) {
		clientRules.put(clientToken, myClientRules);
	}
	
	public boolean addRule(String clientToken, String newRule) {
		ArrayList<String> tmp = new ArrayList<String>();
		String rule = tekstRule.parseRule(newRule);
		System.out.println("Rule: " + rule);
		boolean answer = false;
	    if (!rule.equals("noRule")) {
	    	if (clientRules.containsKey(clientToken)) {
				tmp = clientRules.get(clientToken);
				tmp.add(rule);
				clientRules.put(clientToken, tmp);
			} else {
				tmp.add(rule);
				clientRules.put(clientToken, tmp);
			}
	    	answer = true;
	    } else {
	    	answer = false;
	    }
	    return answer;
	}
	
	public void addTrainingRule(String clientToken, String trainingRule) {
		ArrayList<String> tmp = new ArrayList<String>();
		if (clientRules.containsKey(clientToken)) {
			tmp = clientRules.get(clientToken);
			tmp.add(trainingRule);
			clientRules.put(clientToken, tmp);
		} else {
			tmp.add(trainingRule);
			clientRules.put(clientToken, tmp);
		}
	}
	
	public void addTrie(String clientToken, String newTrie) {
		ArrayList<String> tmp = new ArrayList<String>();
	    	if (clientTries.containsKey(clientToken)) {
				tmp = clientTries.get(clientToken);
				tmp.add(newTrie);
				clientTries.put(clientToken, tmp);
			} else {
				tmp.add(newTrie);
				clientTries.put(clientToken, tmp);
			}
	}
	
	public String getClientToken() {
		String rndToken = "";
		boolean newRnd = false;
		while (!newRnd) {
		int rndNumber1 = (int) (Math.random() * 32000);
		int rndNumber2 = (int) (Math.random() * 32000);
		int rndNumber3 = (int) (Math.random() * 32000);
		int rndNumber4 = (int) (Math.random() * 32000);
		String rndString = "" + rndNumber1 + rndNumber2 + rndNumber3 + rndNumber4;
		rndToken = Base64.getEncoder().encodeToString(rndString.getBytes());
		//System.out.println("Random = " + rndString +" : " + rndToken);
		if (clientRules.containsKey(rndToken)) {
			newRnd = false;
		} else {
			newRnd = true;
			ArrayList<String> tmp = new ArrayList<String>();
			clientRules.put(rndToken, tmp);
		}
		}
		return rndToken;
	}
}

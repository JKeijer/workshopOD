package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class UserInOut {
    //private UserInOutServlet inOut = new UserInOutServlet();

    public void giveOutput2(String output) throws InterruptedException {
        // for (String word : output.split("")) {
        // TimeUnit.MILLISECONDS.sleep(70);
        // System.out.print(word);
        // }
        // System.out.println("");
        // TimeUnit.MILLISECONDS.sleep(400);

    }

/*    public void giveOutput(String output) throws InterruptedException {
        for (String letter : output.split("")) {
            TimeUnit.MILLISECONDS.sleep(40);
            System.out.print(letter);
        }
        System.out.println("");
        TimeUnit.MILLISECONDS.sleep(600);
    }

    public void giveDirectOutput(String output) {
        System.out.println(output);
    }

    public String getString(String prompt) {
        String res = "";
        System.out.println(prompt);
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
            res = in.readLine().toLowerCase();
        } catch (IOException e) {
            res = "";
        }
        return res;
    }*/
}

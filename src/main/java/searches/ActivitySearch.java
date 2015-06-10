package searches;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActivitySearch extends core.MyServlet{
    

    private static final long serialVersionUID = 1L;   
    
    public ArrayList<String> activitySearch(String activity) {
        PreparedStatement ps;
        ArrayList<String> activities = new ArrayList<String>();
        try {
            ps = getConnection().prepareStatement(
                    " SELECT  name "
                            + " FROM uber.activities "
                            + " WHERE name LIKE ? ");
            ps.setString(1, activity + "%");
            ResultSet rs = ps.executeQuery();
            int i = 0;
                while (rs.next() && i<=5) {
                    activities.add(rs.getString(1));
                    i++;
                }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return activities;
    }
    
    public ArrayList<ArrayList<String>> activityShow(int iduser) {
        super.init();
        PreparedStatement ps;
        PreparedStatement gs;
        ArrayList<ArrayList<String>> activitjes = new ArrayList<ArrayList<String>>();
        try {
            System.out.println("Twerks " + iduser);
            ps = getConnection().prepareStatement (
                    "SELECT activities_name, amount "
                    + "FROM    uber.usage " 
                    + "WHERE user_iduser = ? "
                    + "AND usagedate = current_date"
                    );
            System.out.println("Gelukt 1");
            ps.setInt(1, iduser);
            System.out.println("Rekt 2");
            ResultSet rs = ps.executeQuery();
            System.out.println("GG WP");
            while (rs.next()) {
                ArrayList<String> activitjez = new ArrayList<String>();
                System.out.println("1:" + rs.getString(1));
                activitjez.add(rs.getString(2));
                System.out.println("2:" + rs.getString(2));
                gs = super.getConnection().prepareStatement(
                        "SELECT name, calorie"
                        + "FROM uber.activities"
                        + "WHERE activities_name = ?"
                        );
                gs.setInt(1, Integer.parseInt(rs.getString(1)));
                ResultSet hs = gs.executeQuery();
                while (hs.next()) {
                    activitjez.add(hs.getString(1));
                    System.out.println("2.1:" + rs.getString(1));
                    activitjez.add(rs.getString(2));
                    System.out.println("2.2:" + rs.getString(2));       
                }
                activitjes.add(activitjez);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return activitjes;
    }
    
    public static void main(String args[]) { 
        ActivitySearch activitySearch = new ActivitySearch();
        ArrayList<ArrayList<String>> activityshizzle = activitySearch.activityShow(1);
        System.out.println(activityshizzle.toString());
    }
}

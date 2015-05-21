package searches;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import core.User;

public class ActivitySearch extends core.MyServlet{
    private static final long serialVersionUID = 1L;
	// --- Class variables -------------------------------------------------------------------

    private static Connection connection;
    
    // --- Getters ---------------------------------------------------------------------------
    
    //TODO: make this thread safe.
    public static Connection getThisConnection() {
        return connection;
    }
    
    // --- Setters ---------------------------------------------------------------------------
    
    public static void setConnection(Connection connection) {
        ActivitySearch.connection = connection;
    }
    
    
    // --- Commands --------------------------------------------------------------------------
    
    
    public static User validate(String username, String password) {
        User user = null;
        try {
            PreparedStatement ps = getThisConnection().prepareStatement(
                      " SELECT Name "
                    + " FROM ? "
                    + " WHERE  "
                    + " AND passwordHash = ?; ");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
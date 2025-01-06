package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Registering MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Creating the connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system", "root", "Rushi123@#");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

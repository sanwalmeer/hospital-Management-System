import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=HospitalDB;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "DbUser";
    private static final String PASSWORD = "Admin@123";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database Connected Successfully!");
        } catch (SQLException e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }
        return conn;
    }

}

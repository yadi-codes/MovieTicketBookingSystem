import java.sql.*;

public class DatabaseOperation {
    static final String DB_URL = "jdbc:mysql://localhost:3306/movie_ticket";
    static final String USER = "root";
    static final String PASS = "ponnarukannan";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}

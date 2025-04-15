import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Movie {
    String theatrename, moviename, showtime;
    int totalseats, price;

    public Movie(String theatrename, String moviename, String showtime, int totalseats, int price) {
        this.theatrename = theatrename;
        this.moviename = moviename;
        this.showtime = showtime;
        this.totalseats = totalseats;
        this.price = price;
    }

    public void insertMovie() {
        try {
            // 1. Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish connection
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/movie_ticket", // change this
                "root", // change this
                "ponnarukannan"  // change this
            );

            // 3. Prepare SQL insert
            String sql = "INSERT INTO movies (theatrename, moviename, showtime, totalseats, price) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, theatrename);
            pstmt.setString(2, moviename);
            pstmt.setString(3, showtime);
            pstmt.setInt(4, totalseats);
            pstmt.setInt(5, price);

            // 4. Execute insert
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Movie inserted successfully!");
            }

            conn.close();

        } catch (Exception e) {
            System.out.println("❌ Error inserting movie: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

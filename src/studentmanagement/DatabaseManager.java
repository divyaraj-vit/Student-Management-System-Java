package studentmanagement;

import java.sql.*;
import java.util.List;

public class DatabaseManager {
    static {
    try {
        Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException e) {
        System.out.println("SQLite JDBC driver not found.");
    }
    }
    private static final String URL = "jdbc:sqlite:students.db";

    public static void initialize() {
        String sql = "CREATE TABLE IF NOT EXISTS students (" +
                "id INTEGER PRIMARY KEY, name TEXT NOT NULL, course TEXT NOT NULL, " +
                "java_marks INTEGER, dbms_marks INTEGER, networking_marks INTEGER)";
        try (Connection con = DriverManager.getConnection(URL);
             Statement st = con.createStatement()) {
            st.execute(sql);
        } catch (SQLException e) {
            System.out.println("Database initialization error: " + e.getMessage());
        }
    }

    public static void saveStudents(List<Student> students) {
        String sql = "INSERT OR REPLACE INTO students " +
                "(id,name,course,java_marks,dbms_marks,networking_marks) VALUES (?,?,?,?,?,?)";

        try (Connection con = DriverManager.getConnection(URL);
             PreparedStatement ps = con.prepareStatement(sql)) {

            for (Student s : students) {
                ps.setInt(1, s.getId());
                ps.setString(2, s.getName());
                ps.setString(3, s.getCourse());

                if (s.getMarks() != null) {
                    ps.setInt(4, s.getMarks().getJavaMarks());
                    ps.setInt(5, s.getMarks().getDbmsMarks());
                    ps.setInt(6, s.getMarks().getNetworkingMarks());
                } else {
                    ps.setNull(4, Types.INTEGER);
                    ps.setNull(5, Types.INTEGER);
                    ps.setNull(6, Types.INTEGER);
                }
                ps.executeUpdate();
            }
            System.out.println("Data saved to SQLite database.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public static void displayDatabaseStudents() {
        String sql = "SELECT * FROM students ORDER BY id";

        try (Connection con = DriverManager.getConnection(URL);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\n===== DATABASE RECORDS =====");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + ", Name: " + rs.getString("name")
                        + ", Course: " + rs.getString("course"));
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}

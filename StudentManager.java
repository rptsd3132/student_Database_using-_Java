import java.sql.*;
import java.util.Scanner;

public class StudentManager {

    // --- Database connection info ---
    static final String DB_URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "Dilhara3132"; // your MySQL user
    static final String PASS = "Dilhara@3132"; // your MySQL password

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Connect to MySQL database
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {

            while (true) {
                System.out.println("\n=== Student Management ===");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1: addStudent(conn, sc); break;
                    case 2: viewStudents(conn); break;
                    case 3: updateStudent(conn, sc); break;
                    case 4: deleteStudent(conn, sc); break;
                    case 5: System.out.println("Exiting..."); return;
                    default: System.out.println("Invalid choice. Try again.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }

    // --- Add a new student ---
    static void addStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter course: ");
        String course = sc.nextLine();

        String sql = "INSERT INTO students (name, email, course) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, course);
            int rows = stmt.executeUpdate();
            System.out.println(rows + " student added successfully!");
        }
    }

    // --- View all students ---
    static void viewStudents(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("\nID\tName\tEmail\tCourse");
            while (rs.next()) {
                System.out.printf("%d\t%s\t%s\t%s\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("course"));
            }
        }
    }

    // --- Update student by ID ---
    static void updateStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        System.out.print("Enter new email: ");
        String email = sc.nextLine();
        System.out.print("Enter new course: ");
        String course = sc.nextLine();

        String sql = "UPDATE students SET name=?, email=?, course=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, course);
            stmt.setInt(4, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Student updated successfully!");
            else System.out.println("Student ID not found!");
        }
    }

    // --- Delete student by ID ---
    static void deleteStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt(); sc.nextLine();

        String sql = "DELETE FROM students WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Student deleted successfully!");
            else System.out.println("Student ID not found!");
        }
    }
}


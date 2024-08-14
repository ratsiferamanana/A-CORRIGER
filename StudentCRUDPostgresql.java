package org.StudentPortail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentCRUDPostgresql implements StudentCRUD {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/student_portail";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "Tsiferana5865$";

    // Méthode pour obtenir la connexion à la base de données
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    @Override
    public void ajouterStudent(Student student) {
        String sql = "INSERT INTO students (id, userName, phone, email, address, firstName, lastName, field) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getId());
            stmt.setString(2, student.getUserName());
            stmt.setString(3, student.getPhone());
            stmt.setString(4, student.getEmail());
            stmt.setString(5, student.getAddress());
            stmt.setString(6, student.getFirstName());
            stmt.setString(7, student.getLastName());
            stmt.setObject(8, student.getField().name(), Types.OTHER); // Utilisez setObject pour les types ENUM

            stmt.executeUpdate();
            System.out.println("Student inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Student getOneStudent(String id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getString("id"),
                        rs.getString("userName"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        Field.valueOf(rs.getString("field")) // Conversion du nom de l'énumération
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retourne null si l'étudiant n'est pas trouvé
    }

    @Override
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM students";
        List<Student> students = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getString("id"),
                        rs.getString("userName"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        Field.valueOf(rs.getString("field")) // Conversion du nom de l'énumération
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE students SET userName = ?, phone = ?, email = ?, address = ?, firstName = ?, lastName = ?, field = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getUserName());
            stmt.setString(2, student.getPhone());
            stmt.setString(3, student.getEmail());
            stmt.setString(4, student.getAddress());
            stmt.setString(5, student.getFirstName());
            stmt.setString(6, student.getLastName());
            stmt.setString(7, student.getField().name()); // Utilisation du nom de l'énumération
            stmt.setString(8, student.getId());

            stmt.executeUpdate();
            System.out.println("Student updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprierStudent(String id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();
            System.out.println("Student removed successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StudentCRUDPostgresql studentCRUDPostgresql = new StudentCRUDPostgresql();

        // Création d'un nouvel étudiant
        Student newStudent = new Student(
                "STD23081", // ID
                "john_doe", // UserName
                "123-456-7890", // Phone
                "john.doe@example.com", // Email
                "123 Main St", // Address
                "John", // FirstName
                "Doe", // LastName
                Field.Java_Developer // Field
        );
        Student newStudent2 = new Student(
                "STD23082",
                "Mota",
                "01234",
                "hei.jimmy.5@gmail.com",
                "Ilafy",
                "rafara",
                "fara",
                Field.Artificial_Intelligence
        );

        // Ajout de l'étudiant à la base de données


        // Récupération et affichage de l'étudiant
        Student retrievedStudent = studentCRUDPostgresql.getOneStudent("STD23082");

        if (retrievedStudent != null) {
            System.out.println("Student Details:");
            System.out.println("ID: " + retrievedStudent.getId());
            System.out.println("UserName: " + retrievedStudent.getUserName());
            System.out.println("Phone: " + retrievedStudent.getPhone());
            System.out.println("Email: " + retrievedStudent.getEmail());
            System.out.println("Address: " + retrievedStudent.getAddress());
            System.out.println("FirstName: " + retrievedStudent.getFirstName());
            System.out.println("LastName: " + retrievedStudent.getLastName());
            System.out.println("Field: " + retrievedStudent.getField());
        } else {
            System.out.println("Student with ID STD23081 not found.");
        }
    }
}

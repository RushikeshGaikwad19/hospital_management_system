package hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private Connection connection;

    // Constructor for creating a new doctor
    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.connection = DatabaseConnection.getConnection();
    }

    // Method to add doctor details to the database
    public void addDoctorToDatabase() {
        try {
            String sql = "INSERT INTO doctors (name, specialization) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, this.name);
            stmt.setString(2, this.specialization);
            stmt.executeUpdate();
            System.out.println("Doctor added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding doctor: " + e.getMessage());
        }
    }

    // Method to delete a doctor from the database
    public void deleteDoctorFromDatabase(int doctorId) {
        try {
            String sql = "DELETE FROM doctors WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, doctorId);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Doctor deleted successfully!");
            } else {
                System.out.println("Doctor not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting doctor: " + e.getMessage());
        }
    }

    // Method to display doctor performance (stub implementation)
    public void displayDoctorPerformance(int doctorId) {
        System.out.println("Displaying performance for Doctor ID: " + doctorId);
    }
}

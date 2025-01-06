package hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Patient {
	private int id;
	private String name;
	private int age;
	private String contactInfo;
	private Connection connection;

	public Patient(String name, int age, String contactInfo) {
		this.name = name;
		this.age = age;
		this.contactInfo = contactInfo;
		this.connection = DatabaseConnection.getConnection();
	}

	public void addPatientToDatabase() {
		try {
			String sql = "INSERT INTO patients (name, age, contact_info) VALUES (?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, this.name);
			stmt.setInt(2, this.age);
			stmt.setString(3, this.contactInfo);
			stmt.executeUpdate();
			System.out.println("Patient added successfully!");
		} catch (SQLException e) {
			System.out.println("Error adding patient: " + e.getMessage());
		}
	}

	public void deletePatientFromDatabase(int patientId) {
		try {
			String sql = "DELETE FROM patients WHERE id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, patientId);
			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Patient deleted successfully!");
			} else {
				System.out.println("Patient not found!");
			}
		} catch (SQLException e) {
			System.out.println("Error deleting patient: " + e.getMessage());
		}
	}
}

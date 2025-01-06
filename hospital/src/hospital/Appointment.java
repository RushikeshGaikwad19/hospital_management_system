package hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Appointment {
	private int patientId;
	private int doctorId;
	private String appointmentDate;
	private Connection connection;

	public Appointment() {
		this.connection = DatabaseConnection.getConnection();
	}

	public void bookAppointment(int patientId, int doctorId, String appointmentDate) {
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;

		System.out.println("Booking appointment with Doctor ID: " + doctorId + " on " + appointmentDate);

		getPatientFeedback();
	}

	public void getPatientFeedback() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("\nEnter your rating for the doctor (1 to 5): ");
		int rating = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter your feedback for the doctor: ");
		String feedback = scanner.nextLine();

		storeFeedback(rating, feedback);
	}

	public void storeFeedback(int rating, String feedback) {
		try {
			String sql = "INSERT INTO doctor_feedback (doctor_id, rating, feedback) VALUES (?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, doctorId);
			stmt.setInt(2, rating);
			stmt.setString(3, feedback);
			stmt.executeUpdate();
			System.out.println("\nFeedback submitted successfully.");
		} catch (SQLException e) {
			System.out.println("Error storing feedback: " + e.getMessage());
		}
	}
}

package hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class Bill {
    private Connection connection;

    // Constructor for initializing database connection
    public Bill() {
        connection = DatabaseConnection.getConnection();  // Assuming DatabaseConnection handles DB connections
    }

    // Method to generate and display bill receipt
    public void generateBill(int patientId, double amount) {
        try {
            String query = "SELECT name, contact_number FROM patients WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, patientId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Fetch patient's name and contact details
                String patientName = rs.getString("name");
                String contactNumber = rs.getString("contact_number");

                // Simple bill formatting and displaying the receipt
                System.out.println("\n========== BILL RECEIPT ==========");
                System.out.println("Patient ID: " + patientId);
                System.out.println("Patient Name: " + patientName);
                System.out.println("Contact: " + contactNumber);
                System.out.println("=================================");
                System.out.println("Amount: " + formatAmount(amount));
                System.out.println("---------------------------------");
                System.out.println("Total Bill: " + formatAmount(amount));
                System.out.println("\nThank you for using our services!");
            } else {
                System.out.println("Patient with ID " + patientId + " not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error while generating the bill: " + e.getMessage());
        }
    }

    // Method to format the amount in a proper format
    private String formatAmount(double amount) {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return df.format(amount);
    }
}

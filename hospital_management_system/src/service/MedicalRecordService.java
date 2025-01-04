package service;

import model1.MedicalRecord;
import util.DatabaseConnection;  // Assuming a utility for DB connection
import java.sql.*;

public class MedicalRecordService {

    public MedicalRecord getMedicalRecordByPatientId(int patientId) throws SQLException {
        String query = "SELECT * FROM medical_records WHERE patient_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, patientId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String details = rs.getString("details");
                    return new MedicalRecord(id, patientId, details);
                }
            }
        }
        return null;  // No record found
    }

    // You can add more methods here for inserting or updating records
}

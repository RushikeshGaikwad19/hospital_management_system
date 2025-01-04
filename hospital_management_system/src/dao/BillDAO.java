package dao;

import config.DatabaseConnection;
import model1.Bill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {
    public void addBill(Bill bill) throws SQLException {
        String sql = "INSERT INTO bills (patient_id, amount, date) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bill.getPatientId());
            stmt.setDouble(2, bill.getAmount());
            stmt.setString(3, bill.getDate());
            stmt.executeUpdate();
        }
    }

    public List<Bill> getAllBills() throws SQLException {
        List<Bill> bills = new ArrayList<>();
        String sql = "SELECT * FROM bills";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                bills.add(new Bill(
                        rs.getInt("id"),
                        rs.getInt("patient_id"),
                        rs.getDouble("amount"),
                        rs.getString("date")
                ));
            }
        }
        return bills;
    }

    public Bill getBillById(int id) throws SQLException {
        String sql = "SELECT * FROM bills WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Bill(
                        rs.getInt("id"),
                        rs.getInt("patient_id"),
                        rs.getDouble("amount"),
                        rs.getString("date")
                );
            }
        }
        return null;
    }

    public void updateBill(Bill bill) throws SQLException {
        String sql = "UPDATE bills SET patient_id = ?, amount = ?, date = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bill.getPatientId());
            stmt.setDouble(2, bill.getAmount());
            stmt.setString(3, bill.getDate());
            stmt.setInt(4, bill.getId());
            stmt.executeUpdate();
        }
    }
}
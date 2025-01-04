package service;

import dao.BillDAO;
import model1.Bill;

import java.sql.SQLException;
import java.util.List;

public class BillService {
    private final BillDAO billDAO = new BillDAO();

    public void addBill(Bill bill) throws SQLException {
        billDAO.addBill(bill);
    }

    public List<Bill> getAllBills() throws SQLException {
        return billDAO.getAllBills();
    }

    public Bill getBillById(int id) throws SQLException {
        return billDAO.getBillById(id);
    }

    public void updateBill(Bill bill) throws SQLException {
        billDAO.updateBill(bill);
    }
}

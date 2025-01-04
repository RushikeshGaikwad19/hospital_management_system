package service;

import dao.DoctorDAO;
import model1.Doctor;

import java.sql.SQLException;
import java.util.List;

public class DoctorService {
    private final DoctorDAO doctorDAO = new DoctorDAO();

    public void addDoctor(Doctor doctor) throws SQLException {
        doctorDAO.addDoctor(doctor);
    }

    public List<Doctor> getAllDoctors() throws SQLException {
        return doctorDAO.getAllDoctors();
    }

    public Doctor getDoctorById(int id) throws SQLException {
        return doctorDAO.getDoctorById(id);
    }

    public void updateDoctor(Doctor doctor) throws SQLException {
        doctorDAO.updateDoctor(doctor);
    }

    public void deleteDoctor(int id) throws SQLException {
        doctorDAO.deleteDoctor(id);
    }
}

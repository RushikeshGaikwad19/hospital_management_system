package service;

import dao.PatientDAO;
import model1.Patient;

import java.sql.SQLException;
import java.util.List;

public class PatientService {
    private final PatientDAO patientDAO = new PatientDAO();

    public void addPatient(Patient patient) throws SQLException {
        patientDAO.addPatient(patient);
    }

    public List<Patient> getAllPatients() throws SQLException {
        return patientDAO.getAllPatients();
    }

    public Patient getPatientById(int id) throws SQLException {
        return patientDAO.getPatientById(id);
    }

    public void updatePatient(Patient patient) throws SQLException {
        patientDAO.updatePatient(patient);
    }

    public void deletePatient(int id) throws SQLException {
        patientDAO.deletePatient(id);
    }
}

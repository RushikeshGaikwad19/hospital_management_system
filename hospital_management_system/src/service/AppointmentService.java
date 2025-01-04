package service;

import dao.AppointmentDAO;
import model1.Appointment;

import java.sql.SQLException;
import java.util.List;

public class AppointmentService {
    private final AppointmentDAO appointmentDAO = new AppointmentDAO();

    public void addAppointment(Appointment appointment) throws SQLException {
        appointmentDAO.addAppointment(appointment);
    }

    public List<Appointment> getAllAppointments() throws SQLException {
        return appointmentDAO.getAllAppointments();
    }

    public Appointment getAppointmentById(int id) throws SQLException {
        return appointmentDAO.getAppointmentById(id);
    }

    public void updateAppointment(Appointment appointment) throws SQLException {
        appointmentDAO.updateAppointment(appointment);
    }

    public void deleteAppointment(int id) throws SQLException {
        appointmentDAO.deleteAppointment(id);
    }
}
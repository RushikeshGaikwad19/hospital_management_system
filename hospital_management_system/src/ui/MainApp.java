package ui;

import service.PatientService;
import service.DoctorService;
import service.AppointmentService;
import service.BillService;
import service.MedicalRecordService;
import model1.Patient;
import model1.Doctor;
import model1.Appointment;
import model1.Bill;
import model1.MedicalRecord;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        AppointmentService appointmentService = new AppointmentService();
        BillService billService = new BillService();
        MedicalRecordService medicalRecordService = new MedicalRecordService();

        while (true) {
            try {
                displayMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline character

                switch (choice) {
                    case 1: // Add Patient
                        addPatient(patientService);
                        break;
                    case 2: // View All Patients
                        viewAllPatients(patientService);
                        break;
                    case 3: // Add Doctor
                        addDoctor(doctorService);
                        break;
                    case 4: // Add Appointment
                        addAppointment(appointmentService);
                        break;
                    case 5: // Add Bill
                        addBill(billService);
                        break;
                    case 6: // View Medical Record
                        viewMedicalRecord(medicalRecordService);
                        break;
                    case 7: // Exit
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;
                }
            } catch (SQLException e) {
                System.err.println("Error interacting with the database: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- Hospital Management System ---");
        System.out.println("1. Add Patient");
        System.out.println("2. View All Patients");
        System.out.println("3. Add Doctor");
        System.out.println("4. Add Appointment");
        System.out.println("5. Add Bill");
        System.out.println("6. View Medical Record");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addPatient(PatientService patientService) throws SQLException {
        System.out.println("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        System.out.println("Enter Address: ");
        String address = scanner.nextLine();
        System.out.println("Enter Contact: ");
        String contact = scanner.nextLine();

        Patient patient = new Patient(0, name, age, address, contact); // 0 for auto-generated ID
        patientService.addPatient(patient);
        System.out.println("Patient added successfully!");
    }

    private static void viewAllPatients(PatientService patientService) throws SQLException {
        List<Patient> patients = patientService.getAllPatients();
        System.out.println("Patients List:");
        for (Patient patient : patients) {
            System.out.println(patient.getId() + ". " + patient.getName());
        }
    }

    private static void addDoctor(DoctorService doctorService) throws SQLException {
        System.out.println("Enter Doctor's Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Specialization: ");
        String specialization = scanner.nextLine();
        System.out.println("Enter Contact: ");
        String contact = scanner.nextLine();

        Doctor doctor = new Doctor(0, name, specialization, contact); // 0 for auto-generated ID
        doctorService.addDoctor(doctor);
        System.out.println("Doctor added successfully!");
    }

    private static void addAppointment(AppointmentService appointmentService) throws SQLException {
        System.out.println("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.println("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.println("Enter Appointment Date: ");
        String date = scanner.nextLine();
        System.out.println("Enter Appointment Time: ");
        String time = scanner.nextLine();

        Appointment appointment = new Appointment(0, patientId, doctorId, date, time); // 0 for auto-generated ID
        appointmentService.addAppointment(appointment);
        System.out.println("Appointment added successfully!");
    }

    private static void addBill(BillService billService) throws SQLException {
        System.out.println("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.println("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        System.out.println("Enter Bill Date: ");
        String date = scanner.nextLine();

        Bill bill = new Bill(0, patientId, amount, date); // 0 for auto-generated ID
        billService.addBill(bill);
        System.out.println("Bill added successfully!");
    }

    private static void viewMedicalRecord(MedicalRecordService medicalRecordService) throws SQLException {
        System.out.println("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        MedicalRecord medicalRecord = medicalRecordService.getMedicalRecordByPatientId(patientId);
        if (medicalRecord != null) {
            System.out.println("Medical Record for Patient ID " + patientId + ": " + medicalRecord.getDetails());
        } else {
            System.out.println("No medical record found for Patient ID " + patientId);
        }
    }
}

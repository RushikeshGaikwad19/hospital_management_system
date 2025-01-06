package hospital;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Doctor doctor = new Doctor("", "");
        Patient patient = null;
        Bill bill = new Bill(); // Bill object for generating bills
        
        while (true) {
            System.out.println("\nWelcome to the Hospital Management System");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Patient");
            System.out.println("3. Book Appointment");
            System.out.println("4. Generate Bill");
            System.out.println("5. View Doctor Performance");
            System.out.println("6. Delete Doctor");
            System.out.println("7. Delete Patient");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Doctor
                    System.out.print("Enter Doctor Name: ");
                    scanner.nextLine();  // Consume newline
                    String doctorName = scanner.nextLine();
                    
                    System.out.print("Enter Doctor Specialization: ");
                    String specialization = scanner.nextLine();

                    Doctor newDoctor = new Doctor(doctorName, specialization);
                    newDoctor.addDoctorToDatabase();
                    break;

                case 2:
                    // Add Patient
                    System.out.print("Enter Patient Name: ");
                    scanner.nextLine();  // Consume newline
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter Patient Age: ");
                    int age = scanner.nextInt();
                    
                    System.out.print("Enter Patient Contact Info: ");
                    scanner.nextLine();  // Consume newline
                    String contactInfo = scanner.nextLine();

                    Patient newPatient = new Patient(name, age, contactInfo);
                    newPatient.addPatientToDatabase();
                    patient = newPatient;
                    break;

                case 3:
                    // Book Appointment
                    if (patient == null) {
                        System.out.println("No patient found. Please add a patient first.");
                        break;
                    }
                    System.out.print("Enter Doctor ID for appointment: ");
                    int doctorId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Appointment Date (yyyy-MM-dd HH:mm:ss): ");
                    String date = scanner.nextLine();
                    System.out.println("Appointment booked with Doctor ID " + doctorId);
                    break;

                case 4:
                    // Generate Bill
                    if (patient == null) {
                        System.out.println("No patient found. Please add a patient first.");
                        break;
                    }
                    System.out.print("Enter Patient ID: ");
                    int patientId = scanner.nextInt();

                    System.out.print("Enter Doctor ID: ");
                    int billDoctorId = scanner.nextInt();
                    
                    // Ask for the bill amount (dynamic entry)
                    System.out.print("Enter Bill Amount: ");
                    double billAmount = scanner.nextDouble();
                    
                    // Call method to generate bill with custom amount
                    bill.generateBill(patientId, billAmount);
                    break;

                case 5:
                    // View Doctor Performance
                    System.out.print("Enter Doctor ID to view performance: ");
                    int perfDoctorId = scanner.nextInt();
                    doctor.displayDoctorPerformance(perfDoctorId);
                    break;

                case 6:
                    // Delete Doctor
                    System.out.print("Enter Doctor ID to delete: ");
                    int deleteDoctorId = scanner.nextInt();
                   //  newDoctor.deleteDoctorFromDatabase(deleteDoctorId);
                    break;

                case 7:
                    // Delete Patient
                    System.out.print("Enter Patient ID to delete: ");
                    int deletePatientId = scanner.nextInt();
                    patient.deletePatientFromDatabase(deletePatientId);
                    break;

                case 8:
                    // Exit
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
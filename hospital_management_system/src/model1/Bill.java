package model1;

public class Bill {
    private int id;
    private int patientId;
    private double amount;
    private String date;

    public Bill(int id, int patientId, double amount, String date) {
        this.id = id;
        this.patientId = patientId;
        this.amount = amount;
        this.date = date;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
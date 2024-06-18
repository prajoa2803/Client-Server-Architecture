/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.dao;

/**
 *
 * @author Acer
 */
import com.mycompany.api.model.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    private static List<Patient> patients = new ArrayList<>();

    // Add mock data
    static {
        patients.add(new Patient("John Doe", "john@example.com", "123 Main St", "Allergic to peanuts", "Stable"));
        patients.add(new Patient("Jane Smith", "jane@example.com", "456 Oak St", "No major health issues", "Good"));
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        return patients;
    }

    // Get patient by ID
    public Patient getPatientById(int id) {
        return id >= 0 && id < patients.size() ? patients.get(id) : null;
    }

    // Add a new patient
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Update patient
    public void updatePatient(int id, Patient updatedPatient) {
        if (id >= 0 && id < patients.size()) {
            patients.set(id, updatedPatient);
        }
    }

    // Delete patient
    public void deletePatient(int id) {
        if (id >= 0 && id < patients.size()) {
            patients.remove(id);
        }
    }
}

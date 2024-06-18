/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.dao;

/**
 *
 * @author Acer
 */
import com.mycompany.api.model.Doctor;
import com.mycompany.api.model.Patient;
import com.mycompany.api.model.Prescription;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionDAO {
    private static List<Prescription> prescriptions = new ArrayList<>();

    // Add mock data
    static {
        Patient johnDoe = new Patient("John Doe", "john@example.com", "123 Main St", "Allergic to peanuts", "Stable");
        Doctor drSmith = new Doctor("Dr. Smith", "smith@example.com", "789 Elm St", "Cardiologist");
        prescriptions.add(new Prescription(1, johnDoe, drSmith, "Ibuprofen", "200mg", "Take one tablet every 6 hours"));

        Patient janeSmith = new Patient("Jane Smith", "jane@example.com", "456 Oak St", "No major health issues", "Good");
        Doctor drJohnson = new Doctor("Dr. Johnson", "johnson@example.com", "101 Pine St", "Pediatrician");
        prescriptions.add(new Prescription(2, janeSmith, drJohnson, "Amoxicillin", "500mg", "Take one capsule three times a day"));
    }

    // Get all prescriptions
    public List<Prescription> getAllPrescriptions() {
        return prescriptions;
    }

    // Get prescription by ID
    public Prescription getPrescriptionById(int id) {
        for (Prescription prescription : prescriptions) {
            if (prescription.getId() == id) {
                return prescription;
            }
        }
        return null;
    }

    // Add a new prescription
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    // Update prescription
    public void updatePrescription(int id, Prescription updatedPrescription) {
        for (int i = 0; i < prescriptions.size(); i++) {
            if (prescriptions.get(i).getId() == id) {
                prescriptions.set(i, updatedPrescription);
                break;
            }
        }
    }

    // Delete prescription
    public void deletePrescription(int id) {
        prescriptions.removeIf(prescription -> prescription.getId() == id);
    }
}


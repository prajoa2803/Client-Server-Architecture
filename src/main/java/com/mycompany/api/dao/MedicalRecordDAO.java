/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.dao;

/**
 *
 * @author Acer
 */
import com.mycompany.api.model.MedicalRecord;
import com.mycompany.api.model.Patient;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordDAO {
    private static List<MedicalRecord> medicalRecords = new ArrayList<>();

    // Add mock data
    static {
        Patient johnDoe = new Patient("John Doe", "john@example.com", "123 Main St", "Allergic to peanuts", "Stable");
        List<String> diagnoses1 = new ArrayList<>();
        diagnoses1.add("Common cold");
        List<String> treatments1 = new ArrayList<>();
        treatments1.add("Rest and fluids");
        medicalRecords.add(new MedicalRecord(1, johnDoe, diagnoses1, treatments1));

        Patient janeSmith = new Patient("Jane Smith", "jane@example.com", "456 Oak St", "No major health issues", "Good");
        List<String> diagnoses2 = new ArrayList<>();
        diagnoses2.add("Influenza");
        List<String> treatments2 = new ArrayList<>();
        treatments2.add("Antiviral medication");
        medicalRecords.add(new MedicalRecord(2, janeSmith, diagnoses2, treatments2));
    }

    // Get all medical records
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecords;
    }

    // Get medical record by ID
    public MedicalRecord getMedicalRecordById(int id) {
        for (MedicalRecord record : medicalRecords) {
            if (record.getId() == id) {
                return record;
            }
        }
        return null;
    }

    // Add a new medical record
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
    }

    // Update medical record
    public void updateMedicalRecord(int id, MedicalRecord updatedMedicalRecord) {
        for (int i = 0; i < medicalRecords.size(); i++) {
            if (medicalRecords.get(i).getId() == id) {
                medicalRecords.set(i, updatedMedicalRecord);
                break;
            }
        }
    }

    // Delete medical record
    public void deleteMedicalRecord(int id) {
        medicalRecords.removeIf(record -> record.getId() == id);
    }
}


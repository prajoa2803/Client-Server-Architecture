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
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    private static List<Doctor> doctors = new ArrayList<>();

    // Add mock data
    static {
        doctors.add(new Doctor("Dr. Smith", "smith@example.com", "789 Elm St", "Cardiologist"));
        doctors.add(new Doctor("Dr. Johnson", "johnson@example.com", "101 Pine St", "Pediatrician"));
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    // Get doctor by ID
    public Doctor getDoctorById(int id) {
        return id >= 0 && id < doctors.size() ? doctors.get(id) : null;
    }

    // Add a new doctor
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Update doctor
    public void updateDoctor(int id, Doctor updatedDoctor) {
        if (id >= 0 && id < doctors.size()) {
            doctors.set(id, updatedDoctor);
        }
    }

    // Delete doctor
    public void deleteDoctor(int id) {
        if (id >= 0 && id < doctors.size()) {
            doctors.remove(id);
        }
    }
}

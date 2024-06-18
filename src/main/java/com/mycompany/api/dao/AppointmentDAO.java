/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.dao;

/**
 *
 * @author Acer
 */
import com.mycompany.api.model.Appointment;
import com.mycompany.api.model.Doctor;
import com.mycompany.api.model.Patient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentDAO {
    private static List<Appointment> appointments = new ArrayList<>();

    // Add mock data
    static {
        Patient johnDoe = new Patient("John Doe", "john@example.com", "123 Main St", "Allergic to peanuts", "Stable");
        Doctor drSmith = new Doctor("Dr. Smith", "smith@example.com", "789 Elm St", "Cardiologist");
        appointments.add(new Appointment(2, new Date(), "10:00 AM", johnDoe, drSmith));

        Patient janeSmith = new Patient("Jane Smith", "jane@example.com", "456 Oak St", "No major health issues", "Good");
        Doctor drJohnson = new Doctor("Dr. Johnson", "johnson@example.com", "101 Pine St", "Pediatrician");
        appointments.add(new Appointment(3, new Date(), "11:00 AM", janeSmith, drJohnson));
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    // Get appointment by ID
    public Appointment getAppointmentById(int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                return appointment;
            }
        }
        return null;
    }

    // Add a new appointment
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    // Update appointment
    public void updateAppointment(int id, Appointment updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getId() == id) {
                appointments.set(i, updatedAppointment);
                break;
            }
        }
    }

    // Delete appointment
    public void deleteAppointment(int id) {
        appointments.removeIf(appointment -> appointment.getId() == id);
    }
    
    // Schedule an appointment
    public void scheduleAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    // Cancel an appointment
    public void cancelAppointment(int id) {
        appointments.removeIf(appointment -> appointment.getId() == id);
    }
}

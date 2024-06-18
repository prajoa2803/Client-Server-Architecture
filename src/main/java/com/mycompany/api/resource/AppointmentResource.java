/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.resource;

/**
 *
 * @author Acer
 */
import com.mycompany.api.dao.AppointmentDAO;
import com.mycompany.api.model.Appointment;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/appointments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AppointmentResource {
    private static final Logger LOGGER = Logger.getLogger(AppointmentResource.class.getName());
    private AppointmentDAO appointmentDAO = new AppointmentDAO();

    @GET
    public Response getAllAppointments() {
        try {
            List<Appointment> appointments = appointmentDAO.getAllAppointments();
            return Response.ok(appointments).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while fetching all appointments", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while fetching all appointments").build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getAppointmentById(@PathParam("id") int id) {
        try {
            Appointment appointment = appointmentDAO.getAppointmentById(id);
            if (appointment != null) {
                return Response.ok(appointment).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Appointment not found with ID: " + id).build();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while fetching appointment with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while fetching appointment with ID: " + id).build();
        }
    }

    @POST
    @Path("/schedule")
    public Response scheduleAppointment(Appointment appointment) {
        try {
            appointmentDAO.scheduleAppointment(appointment);
            return Response.status(Response.Status.CREATED).entity("Appointment scheduled").build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while scheduling appointment", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while scheduling appointment").build();
        }
    }

    @DELETE
    @Path("/cancel/{id}")
    public Response cancelAppointment(@PathParam("id") int id) {
        try {
            appointmentDAO.cancelAppointment(id);
            return Response.ok().entity("Appointment canceled").build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while canceling appointment with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while canceling appointment with ID: " + id).build();
        }
    }
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.resource;

/**
 *
 * @author Acer
 */
import com.mycompany.api.dao.DoctorDAO;
import com.mycompany.api.model.Doctor;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/doctors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoctorResource {
    private static final Logger LOGGER = Logger.getLogger(DoctorResource.class.getName());
    private DoctorDAO doctorDAO = new DoctorDAO();

    @GET
    public Response getAllDoctors() {
        try {
            List<Doctor> doctors = doctorDAO.getAllDoctors();
            return Response.ok(doctors).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while fetching all doctors", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while fetching all doctors").build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getDoctorById(@PathParam("id") int id) {
        try {
            Doctor doctor = doctorDAO.getDoctorById(id);
            if (doctor != null) {
                return Response.ok(doctor).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Doctor not found with ID: " + id).build();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while fetching doctor with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while fetching doctor with ID: " + id).build();
        }
    }

    @POST
    public Response addDoctor(Doctor doctor) {
        try {
            doctorDAO.addDoctor(doctor);
            return Response.status(Response.Status.CREATED).entity("Doctor added").build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while adding doctor", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while adding doctor").build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateDoctor(@PathParam("id") int id, Doctor updatedDoctor) {
        try {
            doctorDAO.updateDoctor(id, updatedDoctor);
            return Response.ok().entity("Doctor updated").build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating doctor with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while updating doctor with ID: " + id).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDoctor(@PathParam("id") int id) {
        try {
            doctorDAO.deleteDoctor(id);
            return Response.ok().entity("Doctor deleted").build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting doctor with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while deleting doctor with ID: " + id).build();
        }
    }
}

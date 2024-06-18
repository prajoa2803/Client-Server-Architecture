/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.resource;

/**
 *
 * @author Acer
 */
import com.mycompany.api.dao.PrescriptionDAO;
import com.mycompany.api.model.Prescription;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/prescriptions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PrescriptionResource {
    private static final Logger LOGGER = Logger.getLogger(PrescriptionResource.class.getName());
    private PrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    @GET
    public Response getAllPrescriptions() {
        try {
            List<Prescription> prescriptions = prescriptionDAO.getAllPrescriptions();
            return Response.ok(prescriptions).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while fetching all prescriptions", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while fetching all prescriptions").build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getPrescriptionById(@PathParam("id") int id) {
        try {
            Prescription prescription = prescriptionDAO.getPrescriptionById(id);
            if (prescription != null) {
                return Response.ok(prescription).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Prescription not found with ID: " + id).build();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while fetching prescription with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while fetching prescription with ID: " + id).build();
        }
    }

    @POST
    public Response addPrescription(Prescription prescription) {
        try {
            prescriptionDAO.addPrescription(prescription);
            return Response.status(Response.Status.CREATED).entity("Prescription added").build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while adding prescription", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while adding prescription").build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updatePrescription(@PathParam("id") int id, Prescription updatedPrescription) {
        try {
            prescriptionDAO.updatePrescription(id, updatedPrescription);
            return Response.ok().entity("Prescription updated").build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating prescription with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while updating prescription with ID: " + id).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletePrescription(@PathParam("id") int id) {
        try {
            prescriptionDAO.deletePrescription(id);
            return Response.ok().entity("Prescription deleted").build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting prescription with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while deleting prescription with ID: " + id).build();
        }
    }
}


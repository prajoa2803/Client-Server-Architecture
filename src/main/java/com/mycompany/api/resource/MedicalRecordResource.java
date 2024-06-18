/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.resource;

/**
 *
 * @author Acer
 */
import com.mycompany.api.dao.MedicalRecordDAO;
import com.mycompany.api.model.MedicalRecord;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/medicalrecords")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicalRecordResource {
    private static final Logger LOGGER = Logger.getLogger(MedicalRecordResource.class.getName());
    private MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();

    @GET
    public Response getAllMedicalRecords() {
        try {
            List<MedicalRecord> medicalRecords = medicalRecordDAO.getAllMedicalRecords();
            return Response.ok(medicalRecords).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while fetching all medical records", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while fetching all medical records").build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getMedicalRecordById(@PathParam("id") int id) {
        try {
            MedicalRecord medicalRecord = medicalRecordDAO.getMedicalRecordById(id);
            if (medicalRecord != null) {
                return Response.ok(medicalRecord).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Medical record not found with ID: " + id).build();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while fetching medical record with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while fetching medical record with ID: " + id).build();
        }
    }

    @POST
    public Response addMedicalRecord(MedicalRecord medicalRecord) {
        try {
            medicalRecordDAO.addMedicalRecord(medicalRecord);
            return Response.status(Response.Status.CREATED).entity("Medical record added").build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while adding medical record", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while adding medical record").build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateMedicalRecord(@PathParam("id") int id, MedicalRecord updatedMedicalRecord) {
        try {
            medicalRecordDAO.updateMedicalRecord(id, updatedMedicalRecord);
            return Response.ok().entity("Medical record updated").build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating medical record with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while updating medical record with ID: " + id).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMedicalRecord(@PathParam("id") int id) {
        try {
            medicalRecordDAO.deleteMedicalRecord(id);
            return Response.ok().entity("Medical record deleted").build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting medical record with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while deleting medical record with ID: " + id).build();
        }
    }
}


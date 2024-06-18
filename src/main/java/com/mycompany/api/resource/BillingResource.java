/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.resource;

/**
 *
 * @author Acer
 */
import com.mycompany.api.dao.BillingDAO;
import com.mycompany.api.model.Billing;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/billing")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BillingResource {
    private static final Logger LOGGER = Logger.getLogger(BillingResource.class.getName());
    private BillingDAO billingDAO = new BillingDAO();

    @GET
    public Response getAllBills() {
        try {
            List<Billing> bills = billingDAO.getAllBills();
            return Response.ok(bills).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while fetching all bills", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while fetching all bills").build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getBillById(@PathParam("id") int id) {
        try {
            Billing bill = billingDAO.getBillById(id);
            if (bill != null) {
                return Response.ok(bill).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Billing not found with ID: " + id).build();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while fetching billing with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while fetching billing with ID: " + id).build();
        }
    }

    @POST
    public Response addBill(Billing bill) {
        try {
            billingDAO.addBill(bill);
            return Response.status(Response.Status.CREATED).entity("Billing added").build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while adding billing", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while adding billing").build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateBill(@PathParam("id") int id, Billing updatedBill) {
        try {
            billingDAO.updateBill(id, updatedBill);
            return Response.ok().entity("Billing updated").build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating billing with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while updating billing with ID: " + id).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBill(@PathParam("id") int id) {
        try {
            billingDAO.deleteBill(id);
            return Response.ok().entity("Billing deleted").build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting billing with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while deleting billing with ID: " + id).build();
        }
    }

    @PUT
    @Path("/pay/{id}")
    public Response markBillAsPaid(@PathParam("id") int id) {
        try {
            billingDAO.markBillAsPaid(id);
            return Response.ok().entity("Billing marked as paid").build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while marking billing with ID: " + id + " as paid", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while marking billing with ID: " + id + " as paid").build();
        }
    }

    @PUT
    @Path("/unpay/{id}")
    public Response markBillAsUnpaid(@PathParam("id") int id) {
        try {
            billingDAO.markBillAsUnpaid(id);
            return Response.ok().entity("Billing marked as unpaid").build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while marking billing with ID: " + id + " as unpaid", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while marking billing with ID: " + id + " as unpaid").build();
        }
    }
}


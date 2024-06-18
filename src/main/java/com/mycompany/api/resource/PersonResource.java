/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.resource;

/**
 *
 * @author Acer
 */
import com.mycompany.api.dao.PersonDAO;
import com.mycompany.api.model.Person;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {
    private static final Logger LOGGER = Logger.getLogger(PersonResource.class.getName());
    private PersonDAO personDAO = new PersonDAO();

    @GET
    public Response getAllPersons() {
        try {
            List<Person> persons = personDAO.getAllPersons();
            return Response.ok(persons).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while fetching all persons", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while fetching all persons").build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getPersonById(@PathParam("id") int id) {
        try {
            Person person = personDAO.getPersonById(id);
            if (person != null) {
                return Response.ok(person).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Person not found with ID: " + id).build();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while fetching person with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while fetching person with ID: " + id).build();
        }
    }

    @POST
    public Response addPerson(Person person) {
        try {
            personDAO.addPerson(person);
            return Response.status(Response.Status.CREATED).entity("Person added").build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while adding person", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while adding person").build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updatePerson(@PathParam("id") int id, Person updatedPerson) {
        try {
            personDAO.updatePerson(id, updatedPerson);
            return Response.ok().entity("Person updated").build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating person with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while updating person with ID: " + id).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") int id) {
        try {
            personDAO.deletePerson(id);
            return Response.ok().entity("Person deleted").build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting person with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while deleting person with ID: " + id).build();
        }
    }
}



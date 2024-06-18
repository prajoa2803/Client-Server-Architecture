/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.dao;

/**
 *
 * @author Acer
 */

import com.mycompany.api.model.Person;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private static List<Person> persons = new ArrayList<>();

    // Add mock data
    static {
        persons.add(new Person("John Doe", "john@example.com", "123 Main St"));
        persons.add(new Person("Jane Smith", "jane@example.com", "456 Oak St"));
    }

    // Get all persons
    public List<Person> getAllPersons() {
        return persons;
    }

    // Get person by ID
    public Person getPersonById(int id) {
        return id >= 0 && id < persons.size() ? persons.get(id) : null;
    }

    // Add a new person
    public void addPerson(Person person) {
        persons.add(person);
    }

    // Update person
    public void updatePerson(int id, Person updatedPerson) {
        if (id >= 0 && id < persons.size()) {
            persons.set(id, updatedPerson);
        }
    }

    // Delete person
    public void deletePerson(int id) {
        if (id >= 0 && id < persons.size()) {
            persons.remove(id);
        }
    }
}


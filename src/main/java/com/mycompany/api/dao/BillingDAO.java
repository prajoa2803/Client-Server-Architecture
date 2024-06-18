/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.dao;

/**
 *
 * @author Acer
 */

import com.mycompany.api.model.Billing;
import com.mycompany.api.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class BillingDAO {
    private static List<Billing> bills = new ArrayList<>();
    private static int nextId = 1; // to generate unique IDs

    static {
        Patient johnDoe = new Patient("John Doe", "john@example.com", "123 Main St", "Allergic to peanuts", "Stable");
        bills.add(new Billing(nextId++, johnDoe, 100.0, true));

        Patient janeSmith = new Patient("Jane Smith", "jane@example.com", "456 Oak St", "No major health issues", "Good");
        bills.add(new Billing(nextId++, janeSmith, 150.0, false));
    }

    public List<Billing> getAllBills() {
        return bills;
    }

    public Billing getBillById(int id) {
        for (Billing bill : bills) {
            if (bill.getId() == id) {
                return bill;
            }
        }
        return null;
    }

    public void addBill(Billing bill) {
        bill.setId(nextId++);
        bills.add(bill);
    }

    public void updateBill(int id, Billing updatedBill) {
        for (int i = 0; i < bills.size(); i++) {
            if (bills.get(i).getId() == id) {
                bills.set(i, updatedBill);
                updatedBill.setId(id);
                break;
            }
        }
    }

    public void deleteBill(int id) {
        bills.removeIf(bill -> bill.getId() == id);
    }

    public void markBillAsPaid(int id) {
        for (Billing bill : bills) {
            if (bill.getId() == id) {
                bill.setPaid(true);
                break;
            }
        }
    }

    public void markBillAsUnpaid(int id) {
        for (Billing bill : bills) {
            if (bill.getId() == id) {
                bill.setPaid(false);
                break;
            }
        }
    }
}



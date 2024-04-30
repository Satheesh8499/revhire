package org.revhire.controller;

import org.revhire.model.Employer;
import org.revhire.service.EmployerService;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployerController {
    private EmployerService employerService = new EmployerService();
    private Scanner scanner = new Scanner(System.in);

    // Register a new employer
    public void registerEmployer() {
        System.out.println("Employer Registration:");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter company name: ");
        String companyName = scanner.nextLine();

        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter company description: ");
        String companyDescription = scanner.nextLine();

        System.out.print("Enter industry: ");
        String industry = scanner.nextLine();

        Employer employer = new Employer(0, username, password, email, companyName, contactNumber, address, companyDescription, industry);

        try {
            employerService.registerEmployer(employer);
            System.out.println("Employer registered successfully.");
        } catch (SQLException e) {
            System.out.println("Error registering employer: " + e.getMessage());
        }
    }

    public void showMenu(int loggedInEmployerId) {
    }
}


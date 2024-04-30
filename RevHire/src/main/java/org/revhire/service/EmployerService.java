package org.revhire.service;

import org.revhire.dao.EmployerDAO;
import org.revhire.model.Employer;

import java.sql.SQLException;

public class EmployerService {
    private EmployerDAO employerDAO = new EmployerDAO();

    // Register a new employer
    public void registerEmployer(Employer employer) throws SQLException {
        employerDAO.registerEmployer(employer);
    }

    // Retrieve an employer by username
    public Employer getEmployerByUsername(String username) throws SQLException {
        return employerDAO.getEmployerByUsername(username);
    }
}


package org.revhire.dao;

import org.revhire.model.Employer;
import org.revhire.model.EmployerDetails;
import org.revhire.util.ConnectionUtil;
import org.revhire.util.DatabaseConnection;

import java.sql.*;

public class EmployerDAO {
    // Register a new employer
    public void registerEmployer(Employer employer) throws SQLException {
        String query = "INSERT INTO employers (username, password, email, company_name, contact_number, address, company_description, industry) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, employer.getUsername());
            statement.setString(2, employer.getPassword());
            statement.setString(3, employer.getEmail());
            statement.setString(4, employer.getCompanyName());
            statement.setString(5, employer.getContactNumber());
            statement.setString(6, employer.getAddress());
            statement.setString(7, employer.getCompanyDescription());
            statement.setString(8, employer.getIndustry());
            statement.executeUpdate();
        }
    }

    // Retrieve an employer by username
    public Employer getEmployerByUsername(String username) throws SQLException {
        String query = "SELECT * FROM employers WHERE username = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String password = resultSet.getString("password");
                    String email = resultSet.getString("email");
                    String companyName = resultSet.getString("company_name");
                    String contactNumber = resultSet.getString("contact_number");
                    String address = resultSet.getString("address");
                    String companyDescription = resultSet.getString("company_description");
                    String industry = resultSet.getString("industry");
                    return new Employer(id, username, password, email, companyName, contactNumber, address, companyDescription, industry);
                }
            }
        }
        return null; // Employer not found
    }
    public EmployerDetails  getById(int id){
        String  query= "select employer_name,company_name,contact_number,address from emolyers where id = ?";

    }
}


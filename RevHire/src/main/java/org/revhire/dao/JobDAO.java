package org.revhire.dao;

import org.revhire.model.Job;
import org.revhire.util.ConnectionUtil;
import org.revhire.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {
    // Post a new job
    public void postJob(Job job) throws SQLException {
        String query = "INSERT INTO jobs (employer_id, title, description, location, salary) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, job.getEmployerId());
            statement.setString(2, job.getTitle());
            statement.setString(3, job.getDescription());
            statement.setString(4, job.getLocation());
            statement.setDouble(5, job.getSalary());
            statement.executeUpdate();
        }
    }

    // Retrieve jobs based on filters
    public List<Job> searchJobs(String title, String location, int experience) throws SQLException {
        List<Job> jobs = new ArrayList<>();
        String query = "SELECT * FROM jobs WHERE title LIKE ? AND location LIKE ? AND experience_required <= ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + title + "%");
            statement.setString(2, "%" + location + "%");
            statement.setInt(3, experience);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int employerId = resultSet.getInt("employer_id");
                    String jobTitle = resultSet.getString("title");
                    String jobDescription = resultSet.getString("description");
                    String jobLocation = resultSet.getString("location");
                    double salary = resultSet.getDouble("salary");
                    int exp=resultSet.getInt("experience");
                    jobs.add(new Job(id, employerId, jobTitle, jobDescription, jobLocation,salary,experience));
                }
            }
        }
        return jobs;
    }

    public void postJob() {

    }


}


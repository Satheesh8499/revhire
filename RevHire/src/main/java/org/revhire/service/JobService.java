package org.revhire.service;

import org.revhire.dao.JobDAO;
import org.revhire.model.Job;

import java.sql.SQLException;
import java.util.List;

public class JobService {
    private JobDAO jobDAO = new JobDAO();

    // Post a new job
    public void postJob(Job job) throws SQLException {
        jobDAO.postJob(job);
    }

    // Retrieve jobs based on filters
    public List<Job> searchJobs(String title, String location, int experience) throws SQLException {
        return jobDAO.searchJobs(title, location, experience);
    }
}


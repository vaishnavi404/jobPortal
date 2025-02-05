package com.Vaishnavi.jobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.Vaishnavi.jobPortal.entity.JobSeekerProfile;



public interface JobSeekerProfileRepository extends JpaRepository<JobSeekerProfile, Integer> {
}

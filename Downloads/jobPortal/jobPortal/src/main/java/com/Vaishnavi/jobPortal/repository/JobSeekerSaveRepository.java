package com.Vaishnavi.jobPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Vaishnavi.jobPortal.entity.JobPostActivity;
import com.Vaishnavi.jobPortal.entity.JobSeekerApply;
import com.Vaishnavi.jobPortal.entity.JobSeekerProfile;
import com.Vaishnavi.jobPortal.entity.JobSeekerSave;

@Repository
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave,Integer>{

	 List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);
	 List<JobSeekerSave> findByJob(JobPostActivity job);
}

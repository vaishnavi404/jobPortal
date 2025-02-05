package com.Vaishnavi.jobPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Vaishnavi.jobPortal.entity.JobPostActivity;
import com.Vaishnavi.jobPortal.entity.JobSeekerApply;
import com.Vaishnavi.jobPortal.entity.JobSeekerProfile;

public interface JobSeekerApplyRepository extends JpaRepository<JobSeekerApply,Integer>{

	List<JobSeekerApply> findByUserId(JobSeekerProfile userId);
	List<JobSeekerApply> findByjob(JobPostActivity job);
}

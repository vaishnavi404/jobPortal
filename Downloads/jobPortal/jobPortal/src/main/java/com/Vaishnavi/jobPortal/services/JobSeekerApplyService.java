package com.Vaishnavi.jobPortal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vaishnavi.jobPortal.entity.JobPostActivity;
import com.Vaishnavi.jobPortal.entity.JobSeekerApply;
import com.Vaishnavi.jobPortal.entity.JobSeekerProfile;
import com.Vaishnavi.jobPortal.repository.JobSeekerApplyRepository;

@Service
public class JobSeekerApplyService {
private final JobSeekerApplyRepository jobSeekerApplyRepository;

@Autowired
public JobSeekerApplyService(JobSeekerApplyRepository jobSeekerApplyRepository) {
	super();
	this.jobSeekerApplyRepository = jobSeekerApplyRepository;
}
public List<JobSeekerApply> getCandidatesJobs(JobSeekerProfile userAccountId){
	return jobSeekerApplyRepository.findByUserId(userAccountId);
}
public List<JobSeekerApply> getJobCandidates(JobPostActivity job){
	return jobSeekerApplyRepository.findByjob(job);
}
public void addNew(JobSeekerApply jobSeekerApply) {
	// TODO Auto-generated method stub
  jobSeekerApplyRepository.save(jobSeekerApply);	
}

}

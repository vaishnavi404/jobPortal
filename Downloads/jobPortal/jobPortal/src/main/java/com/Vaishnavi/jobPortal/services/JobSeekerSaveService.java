package com.Vaishnavi.jobPortal.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Vaishnavi.jobPortal.entity.JobPostActivity;
import com.Vaishnavi.jobPortal.entity.JobSeekerProfile;
import com.Vaishnavi.jobPortal.entity.JobSeekerSave;
import com.Vaishnavi.jobPortal.repository.JobSeekerSaveRepository;

@Service
public class JobSeekerSaveService {

	private final JobSeekerSaveRepository jobSeekerSaveRepository;
	public JobSeekerSaveService(JobSeekerSaveRepository jobSeekerSaveRepository) {
		this.jobSeekerSaveRepository=jobSeekerSaveRepository;
	}
	public List<JobSeekerSave> getCandidatesJob(JobSeekerProfile userAccountId){
		return jobSeekerSaveRepository.findByUserId(userAccountId);
	}
	public List<JobSeekerSave>getJobCandidates(JobPostActivity job){
		return jobSeekerSaveRepository.findByJob(job);
	}
	public void addNew(JobSeekerSave jobSeekerSave) {
		jobSeekerSaveRepository.save(jobSeekerSave);
	}
}

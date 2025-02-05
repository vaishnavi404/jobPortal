package com.Vaishnavi.jobPortal.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.Vaishnavi.jobPortal.entity.IRecruiterJob;
import com.Vaishnavi.jobPortal.entity.JobCompany;
import com.Vaishnavi.jobPortal.entity.JobLocation;
import com.Vaishnavi.jobPortal.entity.JobPostActivity;
import com.Vaishnavi.jobPortal.entity.RecruiterJobsDto;
import com.Vaishnavi.jobPortal.repository.JobPostActivityRepository;

@Service
public class JobPostActivityService {

	private final JobPostActivityRepository jobPostActivityRepository;
	
	public JobPostActivity addNew(JobPostActivity jobPostActivity) {
	return jobPostActivityRepository.save(jobPostActivity);	
	}
	public JobPostActivityService(JobPostActivityRepository jobPostActivityRepository) {
		super(); 
		this.jobPostActivityRepository = jobPostActivityRepository;
	}
	public List<RecruiterJobsDto> getRecruiterJobs(int recruiter){
		List<IRecruiterJob> recruiterJobsDtos=jobPostActivityRepository.getRecruiterJobs(recruiter);
	List<RecruiterJobsDto> recruiterJobsDtoList= new ArrayList<>();
		for(IRecruiterJob rec : recruiterJobsDtos) {
			JobLocation loc= new JobLocation(rec.getLocationId(),rec.getCity(),rec.getState(),rec.getCountry());
			JobCompany jobCompany = new JobCompany(rec.getCompanyId(),rec.getName(),"");
			recruiterJobsDtoList.add(new RecruiterJobsDto(rec.getTotalCandidates(),rec.getJob_post_id(),rec.getJob_title(),loc,jobCompany));
		}
		return recruiterJobsDtoList;
	}
	public JobPostActivity getOne(int id) {
		// TODO Auto-generated method stub
		return jobPostActivityRepository.findById(id).orElseThrow(()->new RuntimeException("Job not Found"));
	}
	public List<JobPostActivity> getAll() {
		return jobPostActivityRepository.findAll();
	}
	public List<JobPostActivity> search(String job, String location, List<String> type, List<String> remote,
			LocalDate searchDate) {
		// TODO Auto-generated method stub
		return Objects.isNull(searchDate)?jobPostActivityRepository.searchWithoutDate(job,location,remote,type):jobPostActivityRepository.search(job,location,remote,type,searchDate);
	}
}

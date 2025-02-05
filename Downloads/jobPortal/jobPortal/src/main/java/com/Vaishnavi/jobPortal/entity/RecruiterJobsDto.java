package com.Vaishnavi.jobPortal.entity;

public class RecruiterJobsDto {
private long totalCandidates;
private Integer jobPostId;
private String jobTitle;
private JobLocation jobLocationId;
private JobCompany jobCompanyId;

public RecruiterJobsDto(long totalCandidates, Integer jobPostId, String jobTitle, JobLocation jobLocationId,
		JobCompany jobCompanyId) {
	super();
	this.totalCandidates = totalCandidates;
	this.jobPostId = jobPostId;
	this.jobTitle = jobTitle;
	this.jobLocationId = jobLocationId;
	this.jobCompanyId = jobCompanyId;
}
public long getTotalCandidates() {
	return totalCandidates;
}
public void setTotalCandidates(long totalCandidates) {
	this.totalCandidates = totalCandidates;
}
public Integer getJobPostId() {
	return jobPostId;
}
public void setJobPostId(Integer jobPostId) {
	this.jobPostId = jobPostId;
}
public String getJobTitle() {
	return jobTitle;
}
public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
}
public JobLocation getJobLocationId() {
	return jobLocationId;
}
public void setJobLocationId(JobLocation jobLocationId) {
	this.jobLocationId = jobLocationId;
}
public JobCompany getJobCompanyId() {
	return jobCompanyId;
}
public void setJobCompanyId(JobCompany jobCompanyId) {
	this.jobCompanyId = jobCompanyId;
}


}

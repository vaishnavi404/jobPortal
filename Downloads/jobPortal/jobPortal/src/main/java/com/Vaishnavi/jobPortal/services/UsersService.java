package com.Vaishnavi.jobPortal.services;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Vaishnavi.jobPortal.entity.JobSeekerProfile;
import com.Vaishnavi.jobPortal.entity.RecruiterProfile;
import com.Vaishnavi.jobPortal.entity.Users;
import com.Vaishnavi.jobPortal.repository.JobSeekerProfileRepository;
import com.Vaishnavi.jobPortal.repository.RecruiterProfileRepository;
import com.Vaishnavi.jobPortal.repository.UsersRepository;


@Service
public class UsersService {
private final UsersRepository usersRepository;
private final JobSeekerProfileRepository jobSeekerProfileRepository;
private final RecruiterProfileRepository recruiterProfileRepository;

private final PasswordEncoder passwordEncoder;
@Autowired
public UsersService(UsersRepository usersRepository,JobSeekerProfileRepository jobSeekerProfileRepository,RecruiterProfileRepository recruiterProfileRepository,PasswordEncoder passwordEncoder) {
	super();
	this.usersRepository = usersRepository;
	this.jobSeekerProfileRepository=jobSeekerProfileRepository;
	this.recruiterProfileRepository=recruiterProfileRepository;
	this.passwordEncoder=passwordEncoder;
}

public Users addNew(Users users) {
	users.setActive(true);
	users.setRegistrationDate(new Date(System.currentTimeMillis()));
	users.setPassword(passwordEncoder.encode(users.getPassword()));
	Users savedUsers=usersRepository.save(users);
	int userTypeId=users.getUserTypeId().getUserTypeId();
	if(userTypeId==1) {
		recruiterProfileRepository.save(new RecruiterProfile(savedUsers));
	}
	else {
		jobSeekerProfileRepository.save(new JobSeekerProfile(savedUsers));
	}
	return savedUsers;
} 
public Optional<Users> getUserByEmail(String email){
	return usersRepository.findByEmail(email);
}

public Object getCurrentUserProfile() {
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

if(!(authentication instanceof AnonymousAuthenticationToken)) {
	
	String username=authentication.getName();
	Users users = usersRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("Could not found"+"user"));
	int userId=users.getUserId();
	if(authentication.getAuthorities().contains(
			new SimpleGrantedAuthority("Recruiter"))) {
		RecruiterProfile recruiterProfile =recruiterProfileRepository.findById(userId).orElse(new RecruiterProfile());
		return recruiterProfile;
	}else {
		JobSeekerProfile jobSeekerProfile = jobSeekerProfileRepository.findById(userId).orElse(new JobSeekerProfile());
		return jobSeekerProfile;
	}
}
return null;
}

public Users getCurrentUser() {
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	if(!(authentication instanceof AnonymousAuthenticationToken)) {
	String username=	authentication.getName();
	Users user = usersRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("Could not found"+"user"));
   return user;
	}
	return null;
}

public Users findByEmail(String currentUserName) {
	// TODO Auto-generated method stub
	return usersRepository.findByEmail(currentUserName).orElseThrow(()->new UsernameNotFoundException("User not"+"found"));
}

}

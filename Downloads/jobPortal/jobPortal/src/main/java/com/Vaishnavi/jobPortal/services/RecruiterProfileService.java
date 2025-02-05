package com.Vaishnavi.jobPortal.services;

import java.util.Optional;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Vaishnavi.jobPortal.entity.RecruiterProfile;
import com.Vaishnavi.jobPortal.entity.Users;
import com.Vaishnavi.jobPortal.repository.RecruiterProfileRepository;
import com.Vaishnavi.jobPortal.repository.UsersRepository;

@Service
public class RecruiterProfileService {
private final RecruiterProfileRepository recruiterProfileRepository;
private final UsersRepository usersRepository;
public RecruiterProfileService(RecruiterProfileRepository recruiterProfileRepository,UsersRepository usersRepository) {
	super();
	this.recruiterProfileRepository = recruiterProfileRepository;
	this.usersRepository = usersRepository;
}
public Optional<RecruiterProfile> getOne(Integer id){
	return recruiterProfileRepository.findById(id);
}
public RecruiterProfile addNew(RecruiterProfile recruiterProfile) {
	// TODO Auto-generated method stub
	return recruiterProfileRepository.save(recruiterProfile);
}
public RecruiterProfile getCurrentRecruiterProfile() {
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	if(!(authentication instanceof AnonymousAuthenticationToken)) {
		String currentUsername = authentication.getName();
		Users users=usersRepository.findByEmail(currentUsername).orElseThrow(()->new UsernameNotFoundException("User not"+"found"));
		Optional<RecruiterProfile> recruiterProfile =getOne(users.getUserId());
		return recruiterProfile.orElse(null);
	}else return null;
}

}
 
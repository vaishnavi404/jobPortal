package com.Vaishnavi.jobPortal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Vaishnavi.jobPortal.entity.Users;
import com.Vaishnavi.jobPortal.repository.UsersRepository;
import com.Vaishnavi.jobPortal.util.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService{
private final UsersRepository userRepository;

@Autowired
	public CustomUserDetailsService(UsersRepository userRepository) {
	super();
	this.userRepository = userRepository;
}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("Could not Found user"));
		return new CustomUserDetails(user);
	}

}

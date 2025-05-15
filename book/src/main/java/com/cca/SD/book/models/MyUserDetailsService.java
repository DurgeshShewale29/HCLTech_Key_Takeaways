package com.cca.SD.book.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private MyUserDetailsRepository repo;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return new AppUserPrincipal(repo.getAppUserByEmail(userName));
	}

}
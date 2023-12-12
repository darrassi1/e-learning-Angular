package com.spa.projet.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.spa.projet.model.User; 
import com.spa.projet.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}

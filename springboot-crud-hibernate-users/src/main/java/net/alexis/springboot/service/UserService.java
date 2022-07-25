package net.alexis.springboot.service;


import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import net.alexis.springboot.exception.PasswordValidationException;
import net.alexis.springboot.exception.UserNotFoundException;
import net.alexis.springboot.model.entity.Phone;
import net.alexis.springboot.model.entity.User;
import net.alexis.springboot.repository.UserRepository;
import net.alexis.springboot.validation.EmailValidation;
import net.alexis.springboot.validation.PasswordValidation;

@Service
public class UserService{

	private final UserRepository userRepository;
	private final PhoneService phoneService;
	
	@Autowired
	public UserService(UserRepository userRepository, PhoneService phoneService) {
		this.userRepository = userRepository;
		this.phoneService = phoneService;
		
	}
	
	public User addUser(User user) {
		
		if(!PasswordValidation.isValid(user.getPassword())) {
			throw new PasswordValidationException("Password format error");
		}
		
		
		if(!EmailValidation.isValid(user.getEmail())) {
			throw new PasswordValidationException("Email format error");
		}
				
		
		if(!ObjectUtils.isEmpty(userRepository.findByEmail(user.getEmail()))) {
			throw new PasswordValidationException("Email is already assigned");
		}
		
		user.setIsactive(Boolean.TRUE);
		user.setLast_login(new Date());
		
		return userRepository.save(user);
		
		
	}
	
	
}

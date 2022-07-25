package net.alexis.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.alexis.springboot.model.dto.PhoneRequest;
import net.alexis.springboot.model.dto.UserRequest;
import net.alexis.springboot.model.dto.UserResponse;
import net.alexis.springboot.model.dto.mapper.UserMapper;
import net.alexis.springboot.model.entity.Phone;
import net.alexis.springboot.model.entity.User;
import net.alexis.springboot.service.PhoneService;
import net.alexis.springboot.service.UserService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;
		
	@Autowired
	public UserController (UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<UserResponse> addUser(@RequestBody final UserRequest userRequest){
			
		User user = userService.addUser(UserMapper.requestToEntity(userRequest));
		return new ResponseEntity<UserResponse>(UserMapper.entityToResponse(user), HttpStatus.CREATED);
	}
	    
}

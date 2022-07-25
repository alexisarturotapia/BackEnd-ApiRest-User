package net.alexis.springboot.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.h2.command.dml.MergeUsing.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import net.alexis.springboot.exception.PasswordValidationException;
import net.alexis.springboot.model.dto.UserRequest;
import net.alexis.springboot.model.entity.User;
import net.alexis.springboot.service.UserService;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	UserController userController;
	
	@Mock
	UserService userService;
	
		
	@BeforeEach
	void setUp() throws Exception {
		userController = new UserController(userService);
	}

	@Test
	void testAddUser() {
		UserRequest userRequestMock = new UserRequest();
		userRequestMock.setName("Jhon");
		
		User userMock = new User();
		userMock.setName("Jhon");
		
		when(userService.addUser(userMock)).thenThrow(PasswordValidationException.class);
		Assertions.assertThrows(PasswordValidationException.class, () -> userController.addUser(userRequestMock));
	}
	/*
	@Test
	void returnUserWhenInsertIntoDataBase() {
		String expectedName="Jhon";
		//TODO: Retorna un User después de insertar en la Base de datos
		//TODO: Completar UserRequestMock para que haga la inserción
		UserRequest userRequestMock = new UserRequest();
		userRequestMock.setName("Jhon");
		
		User userMock = new User();
		userMock.setName("Jhon");
		
		when(userService.addUser(userMock))
		.thenReturn(userMock);
		
		User expectedResponse= userService.addUser(userMock);
		
		assertThat(expectedName.equals(expectedResponse.getName()));
	}
	*/

}

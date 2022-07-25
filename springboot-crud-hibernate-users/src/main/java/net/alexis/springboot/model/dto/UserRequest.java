package net.alexis.springboot.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import net.alexis.springboot.model.entity.Phone;
import net.alexis.springboot.model.entity.User;

@Data
public class UserRequest {
	
	private String name;
	private String email;
	private String password;
	private List<PhoneRequest> phones = new ArrayList<>();
	
	
}

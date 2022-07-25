package net.alexis.springboot.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import net.alexis.springboot.model.entity.Phone;
import net.alexis.springboot.model.entity.User;

@Data
public class UserResponse {
	private Long id;
	private String name;
	private String email;
	private String password;
	private Date created;
	private Date modifed;
	private Date last_login;
	private String token;
	private Boolean isactive;
	private List<PhoneResponse> phones = new ArrayList<>();
	
	
}

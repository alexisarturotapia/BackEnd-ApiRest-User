package net.alexis.springboot.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import net.alexis.springboot.model.dto.UserRequest;

@Data
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@CreationTimestamp
	private Date created;
	
	@CreationTimestamp
	private Date modifed;
	
	@Column(name = "last_login")
	private Date last_login;
	
	@Column(name = "token")
	private String token;
	
	@Column(name = "isactive")
	private Boolean isactive;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id")
	private List<Phone> phones = new ArrayList<>();

		
	public void addPhone(Phone phone) {
		phones.add(phone);
	}
	
	public void removePhone(Phone phone) {
		phones.remove(phone);
	}
		
}

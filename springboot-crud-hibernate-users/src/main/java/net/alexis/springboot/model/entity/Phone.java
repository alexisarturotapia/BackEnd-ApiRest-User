package net.alexis.springboot.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import net.alexis.springboot.model.dto.PhoneRequest;

@Data
@Entity
@Table(name = "phone")
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "number")
	private String number;
	
	@Column(name = "citycode")
	private Integer citycode;
	
	@Column(name = "contrycode")
	private Integer contrycode;
	
	
}

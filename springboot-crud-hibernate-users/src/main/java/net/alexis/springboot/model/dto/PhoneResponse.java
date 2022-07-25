package net.alexis.springboot.model.dto;

import lombok.Data;
import net.alexis.springboot.model.entity.Phone;

@Data
public class PhoneResponse {

	private Long id;	
	private String number;
	private Integer citycode;
	private Integer contrycode;
	
	
}

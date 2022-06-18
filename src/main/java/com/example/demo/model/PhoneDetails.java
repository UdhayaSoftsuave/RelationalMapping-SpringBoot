package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "PhoneDetails")
@NoArgsConstructor
public class PhoneDetails {
	@Id
	@GeneratedValue
	private Long id;
	
	private String provider;
	
	private String technology;

	public PhoneDetails(String provider, String technology) {
		super();
		this.provider = provider;
		this.technology = technology;
	}
	

}

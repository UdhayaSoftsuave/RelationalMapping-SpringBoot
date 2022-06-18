package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Phone")
@NoArgsConstructor
public class Phone {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String number;
	
	@OneToOne(cascade=CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name = "details_id")
	
	private PhoneDetails details;

	public Phone(String number, PhoneDetails details) {
		super();
		this.number = number;
		this.details = details;
	}
	
	

}

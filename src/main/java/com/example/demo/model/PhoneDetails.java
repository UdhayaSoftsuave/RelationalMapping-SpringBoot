package com.example.demo.model;

import javax.persistence.CascadeType;
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
@Entity(name = "PhoneDetails")
@NoArgsConstructor
public class PhoneDetails {
	@Id
	@GeneratedValue
	private Long id;
	
	private String provider;
	
	private String technology;
	
	@OneToOne(cascade=CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name = "phone_id")
	@JsonIgnore
	private Phone phone;

	public PhoneDetails(String provider, String technology, Phone phone) {
		super();
		this.provider = provider;
		this.technology = technology;
		this.phone = phone;
	}
	
}

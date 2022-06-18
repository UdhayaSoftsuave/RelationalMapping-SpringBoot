package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Phone;
import com.example.demo.model.PhoneDetails;
import com.example.demo.repository.PhoneDetailsRepository;
import com.example.demo.repository.PhoneRepo;

@RestController
public class PhoneController {
	
	@Autowired
	private  PhoneRepo phoneRepo;
	@Autowired
	private PhoneDetailsRepository details;
	
	@GetMapping("/run")
	private void run() {
		System.out.println("Api got hitted");
		PhoneDetails phoneDetails1 = new PhoneDetails();
		phoneDetails1.setProvider("AAA");
		phoneDetails1.setTechnology("IT");
		
		Phone phone = new Phone("101", phoneDetails1);
		
		phoneDetails1.setPhone(phone);
		
		Phone save = phoneRepo.save(phone);
		System.out.println(save);
	}
	
	@GetMapping("/getphone")
	private List<Phone> getPhone() {
		List<Phone> save = phoneRepo.findAll();
		return save;
		
	}
	
	@GetMapping("/getphoneDetails")
	private List<PhoneDetails> getPhoneDetails() {
		List<PhoneDetails> save = details.findAll();
		return save;
		
	}

}

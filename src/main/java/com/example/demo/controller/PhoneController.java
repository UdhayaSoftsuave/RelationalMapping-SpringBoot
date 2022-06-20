package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/run")
	private void run() {
		System.out.println("Api got hitted");
		
		PhoneDetails phoneDetails1 = details.findById(9l).get();
		
		phoneDetails1.setProvider("333");
		phoneDetails1.setTechnology("fff");
		
		Phone phone = phoneRepo.findById(phoneDetails1.getPhone().getId()).get();
		
		phone.setNumber("666");
		
		phoneDetails1.setPhone(phone);
		phone.setDetails(phoneDetails1);
		
		PhoneDetails save = details.save(phoneDetails1);
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

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
		PhoneDetails phoneDetails1 = new PhoneDetails("AAA", "spring");
		PhoneDetails phoneDetails2 = new PhoneDetails("BBB", "Angular");
		
		Phone phone = new Phone("101", phoneDetails1);
		
		Phone save = phoneRepo.save(phone);
		System.out.println(save);
	}
	
	@GetMapping("/getphone")
	private List<Phone> getPhone() {
		List<Phone> save = phoneRepo.findAll();
		for (Phone phone : save) {
			System.out.println(phone.getDetails().getProvider());
		}
		return save;
		
	}
	
	@GetMapping("/getphoneDetails")
	private List<PhoneDetails> getPhoneDetails() {
		List<PhoneDetails> save = details.findAll();
		return save;
		
	}

}

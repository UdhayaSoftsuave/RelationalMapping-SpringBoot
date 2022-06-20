package com.example.demo.OneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/onetomany")
public class OneToManyConroller {
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("/save")
	public PersonDTO save() {
		
		List<PhoneDTO> dtos = new ArrayList<PhoneDTO>();
		
		PhoneDTO phone1 = new PhoneDTO();
		phone1.setNumber("9898786754");
		dtos.add(phone1);
		
		PhoneDTO phone2 = new PhoneDTO();
		phone2.setNumber("9898786754");
		dtos.add(phone2);
		
		PhoneDTO phone3 = new PhoneDTO();
		phone3.setNumber("9898786754");
		dtos.add(phone3);
		
		PersonDTO dto = new PersonDTO();
		dto.setPhones(dtos);

		
		PersonDTO save = personRepository.save(dto);
		
		return save;

	}
	
	@GetMapping("/person")
	public List<PersonDTO> findAll() {
		return personRepository.findAll();
	}
	
	@GetMapping("/phone")
	public List<PhoneDTO> findAllPhoneDTO() {
		return phoneRepository.findAll();
	}
	
	@GetMapping("/deletePerson/{id}")
	public Boolean deletePeron(@PathVariable(value = "id") int value) {
		personRepository.deleteById((long) value);
		return personRepository.existsById(Long.valueOf(value));
	}

}

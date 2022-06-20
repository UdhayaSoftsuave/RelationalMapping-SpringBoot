package com.example.demo.OneToMany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonDTO, Long> {

}

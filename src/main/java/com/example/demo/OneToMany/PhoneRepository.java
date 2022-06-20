package com.example.demo.OneToMany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<PhoneDTO, Long> {

}

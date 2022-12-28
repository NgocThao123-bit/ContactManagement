package net.javaguides.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	Optional<Contact> findByName(String name);
	


}

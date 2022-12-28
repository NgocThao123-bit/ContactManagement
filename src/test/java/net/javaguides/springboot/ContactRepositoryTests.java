package net.javaguides.springboot;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import net.javaguides.springboot.model.Contact;
import net.javaguides.springboot.repository.ContactRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ContactRepositoryTests {

	@Autowired private ContactRepository repo;
	
//	@Test
//	public void testAddNew() {
//		Contact contact = new Contact();
//		contact.setName("Thao");
//		contact.setPhoneNumber("1234567890");
//		contact.setEmail("ntnThao@gmail.com");
//		
//		Contact saveContact = repo.save(contact);
//		Assertions.assertThat(saveContact).isNotNull();
//		Assertions.assertThat(saveContact.getId()).isGreaterThan(0);
//	}
//	
//	@Test
//	public void testListAll() {
//		Iterable<Contact> contacts = repo.findAll();
//		
//		Assertions.assertThat(contacts).hasSizeGreaterThan(0);
//		
//		for(Contact contact : contacts) {
//			System.out.println(contact);
//		}
//	}
//	
//	@Test
//	public void testUpdate() {
//		long id = 1;
//		Optional<Contact> optionalContact = repo.findById(id);
//		
//		Contact contact = optionalContact.get();
//		contact.setEmail("ntnNoname@gmail.com");
//		repo.save(contact);
//		
//		Contact updateContact = repo.findById(id).get();
//		Assertions.assertThat(updateContact.getEmail()).isEqualTo("ntnNoname@gmail.com");
//	}
//	
//	@Test
//	public void testGet() {
//		long id = 1;
//		Optional<Contact> optionalContact = repo.findById(id);
//		Assertions.assertThat(optionalContact).isPresent();
//		System.out.println(optionalContact.get());
//	}
	
	@Test
	public void testDelete() {
		long id = 52;
		repo.deleteById(id);
		
		Optional<Contact> optionalContact = repo.findById(id);
		Assertions.assertThat(optionalContact).isNotPresent();
	}
	
}

package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.model.Contact;
import net.javaguides.springboot.repository.ContactRepository;

@Service
public class ContactService {
@Autowired
private ContactRepository contactRepository;

public List<Contact> findAllContacts() {
    return contactRepository.findAll();
}

public Contact findContactById(long id) {
    return contactRepository.findById(id).get();
}
public Contact findContactByName(String name) {
    return contactRepository.findByName(name).get();
}
public void saveContact(Contact contact) {
    contactRepository.save(contact);
}

public void updateContact(Contact contact) {
    contactRepository.save(contact);
}

public void deleteContact(long id) {
    contactRepository.deleteById(id);
}
}

package net.javaguides.springboot.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.model.Contact;
import net.javaguides.springboot.service.ContactService;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contacts")
	public String getAllContacts(Model model) {
	    List<Contact> contacts = contactService.findAllContacts();
	    
	    model.addAttribute("contacts", contacts);
	    return "contacts";
	}
	
	@GetMapping("/contacts/{id}")
	public String getContactById(@PathVariable("id") long id, Model model) {
	    Contact contact = contactService.findContactById(id);
	    model.addAttribute("contact", contact);
	    return "contact_detail";
	}
	
	@GetMapping("/contactsByname/{name}")
	public String getContactByName(@PathVariable("name") String name, Model model) {
	    Contact contact = contactService.findContactByName(name);
	    model.addAttribute("contact", contact);
	    return "contact_detail";
	}

    @GetMapping("/showNewContactForm")
    public String showNewContactForm(Model model) {
        // create model attribute to bind form data
    	Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "new_contact";
    }
	@PostMapping("/saveContact")
	public String saveContact(@ModelAttribute("contact") Contact contact) {
	    contactService.saveContact(contact);
	    return "redirect:/contacts";
	}
	
	 @GetMapping("/showFormForUpdateContact/{id}")
	    public String showFormForUpdateContact(@PathVariable(value = "id") long id, Model model) {	        
		 Contact contact = contactService.findContactById(id);
	        model.addAttribute("contact", contact);
	        return "update_contact";
	    }
	 
	@PutMapping("/contacts/{id}")
	public String updateContact(@PathVariable("id") long id, @ModelAttribute Contact contact) {
	    contact.setId(id);
	    contactService.updateContact(contact);
	    return "redirect:/contacts";
	}
	
	@GetMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable(value = "id") long id) {
	    contactService.deleteContact(id);
	    return "redirect:/contacts";
	}
	
//	*********************************** Try With Postman
	
	
	
//	@DeleteMapping("/deleteContact/{id}")
//	public String deleteContactById(@PathVariable(value = "id") long id) {
//	    contactService.deleteContact(id);
//	    return "redirect:/contacts";
//	}
	

//	@GetMapping("/employees/{id}")
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
//	 throws ResourceNotFoundException {
//	    Employee employee = employeeRepository.findById(employeeId)
//	      .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//	    return ResponseEntity.ok().body(employee);
//	}

}

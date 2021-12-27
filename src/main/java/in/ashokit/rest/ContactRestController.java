package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.ContactForm;
import in.ashokit.service.ContactService;

@RestController
public class ContactRestController {

	@Autowired
	private ContactService service;

	@PostMapping("/save")
	public String saveContact(@RequestBody ContactForm form) {
		String message = service.saveContact(form);

		return message;

	}
	
	@GetMapping("/viewContacts")
	public List<ContactForm> viewContacts(){
		System.out.println("====viewContacts method=====");
		List<ContactForm> contacts = service.viewContacts();
		return contacts;
		
	}
	@GetMapping("/editContact/{contactId}")
	public ContactForm editContact(@PathVariable Integer contactId) {
		ContactForm form = service.editContact(contactId);
		return form;
		
	}
	
	@DeleteMapping("/Delete/{contactId}")
	public List<ContactForm> deleteContact(Integer contactId){
		return service.deleteContact(contactId);
		
	}

}

package in.ashokit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ashokit.bindings.ContactForm;

@Service
public interface ContactService {
	
	public String saveContact(ContactForm contactForm);
	public List<ContactForm> viewContacts();
	public ContactForm editContact(Integer contactId);
	public List<ContactForm> deleteContact(Integer contactId);

}

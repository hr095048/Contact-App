package in.ashokit.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.ContactForm;
import in.ashokit.entities.Contact;
import in.ashokit.repository.ContactRepository;
import in.ashokit.service.ContactService;
@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public String saveContact(ContactForm contactForm) {
		// we have received form from binding object
		//repository save method expecting entity object
		// so copy the the data from form bindings to contact object
		Contact contact = new Contact();
		BeanUtils.copyProperties(contactForm, contact);
		contact.setActiveSwitch("Y");
		contact =contactRepo.save(contact);
		if(contact.getContactId()!=null) {
			return "success";
			
		}
		
		return "failure";
	}

	@Override
	public List<ContactForm> viewContacts() {
		List<ContactForm> dataList = new ArrayList<>();
		List<Contact> listcontacts =contactRepo.findAll();
		
		for(Contact contacts:listcontacts) {
			ContactForm contactform = new ContactForm();
			BeanUtils.copyProperties(contacts ,contactform);
			dataList.add(contactform);
		}
		return dataList;
	}

	@Override
	public ContactForm editContact(Integer contactId) {
		// find by id and return the form 
		 Optional<Contact> findById = contactRepo.findById(contactId);
		 if(findById.isPresent()) {
			 Contact contact = findById.get();
			 ContactForm form = new ContactForm();
			 BeanUtils.copyProperties(contact, form);
			 return form;
		 }
		
		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {
		contactRepo.deleteById(contactId);
		// getting latest data from table and returing
		List<ContactForm> dataList = new ArrayList<>();
		List<Contact> findAll =contactRepo.findAll();
		
		for(Contact contacts:findAll) {
			ContactForm contactform = new ContactForm();
			BeanUtils.copyProperties(contacts ,contactform);
			dataList.add(contactform);
		}
		return dataList;
		
	}

}

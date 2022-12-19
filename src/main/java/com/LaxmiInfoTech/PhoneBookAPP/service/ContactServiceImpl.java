package com.LaxmiInfoTech.PhoneBookAPP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LaxmiInfoTech.PhoneBookAPP.entities.Contact;
import com.LaxmiInfoTech.PhoneBookAPP.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactServiceI{

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	
	public boolean saveContact(Contact contact) {
		
		Contact contact2 = contactRepository.save(contact);
		if(contact2!=null) {
			return true;
		}else {
		return false;
		
	}
	}

	@Override
	public List<Contact> getAllContact() {
		List<Contact> all = contactRepository.findAll();
		
		
		return all;
	}
}

package com.LaxmiInfoTech.PhoneBookAPP.service;

import java.util.List;

import com.LaxmiInfoTech.PhoneBookAPP.entities.Contact;

public interface ContactServiceI {

	public abstract boolean saveContact(Contact contact);
	
	public abstract List<Contact> getAllContact();
	
	public abstract Contact getContactByID(Integer ID);
	
	public abstract boolean updateContact(Contact contact);
	
	public abstract boolean deleteContact(Integer id);
	
	public abstract boolean deleteContactSoft(Integer id);
}

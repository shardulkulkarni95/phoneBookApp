package com.LaxmiInfoTech.PhoneBookAPP.service;

import java.util.List;

import com.LaxmiInfoTech.PhoneBookAPP.entities.Contact;

public interface ContactServiceI {

	public abstract boolean saveContact(Contact contact);
	
	public abstract List<Contact> getAllContact();
}

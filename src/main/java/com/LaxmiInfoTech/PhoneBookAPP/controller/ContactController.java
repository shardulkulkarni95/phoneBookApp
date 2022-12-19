package com.LaxmiInfoTech.PhoneBookAPP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.LaxmiInfoTech.PhoneBookAPP.entities.Contact;
import com.LaxmiInfoTech.PhoneBookAPP.service.ContactServiceI;

@RestController
public class ContactController {
	@Autowired
	private ContactServiceI contactServiceI;
	
	@PostMapping(value ="/saveContact", consumes = "application/json")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact){
		boolean saveContact = contactServiceI.saveContact(contact);
		
		if(saveContact) {
			
			return new ResponseEntity<String>("contact saved succsessfully",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("contact not saved succsessfully",HttpStatus.CREATED);
		
		}
	}
	
	@GetMapping(value = "/getAllContact",  produces = "application/json")
	public ResponseEntity<List<Contact>> getAllContact(){
		
		List<Contact> allContact = contactServiceI.getAllContact();
		
		return new ResponseEntity<List<Contact>>(allContact,HttpStatus.OK);
		
	}
	
	

}

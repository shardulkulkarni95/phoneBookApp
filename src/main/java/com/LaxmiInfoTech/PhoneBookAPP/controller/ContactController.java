package com.LaxmiInfoTech.PhoneBookAPP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(value = "/getContactByID/{contactid}", produces = "application/json")
	public ResponseEntity<Contact> getContactByID(@PathVariable Integer contactid){
		
		Contact contact = contactServiceI.getContactByID(contactid);
		
		return new ResponseEntity<Contact>(contact,HttpStatus.OK);
	}
	
	@PostMapping(value ="/updateContact", consumes = "application/json")
	public ResponseEntity<String> updateContact(@RequestBody Contact contact){
		boolean saveContact = contactServiceI.updateContact(contact);
		
		if(saveContact) {
			
			return new ResponseEntity<String>("contact updated succsessfully",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("contact not updated succsessfully",HttpStatus.CREATED);
		
		}
	}
	
	
	@DeleteMapping(value = "deleteContact/{contactid}")
	public ResponseEntity<String> deleteContact(@PathVariable Integer contactid){
		
		boolean deleteContact = contactServiceI.deleteContact(contactid);
		if(deleteContact) {
			return new ResponseEntity<String>("contact deleted succsessfully",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("contact not deleted succsessfully",HttpStatus.CREATED);
		
		}
		}
		


}

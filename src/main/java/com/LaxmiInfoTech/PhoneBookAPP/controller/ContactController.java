package com.LaxmiInfoTech.PhoneBookAPP.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
		
		Stream<Contact> stream = allContact.stream();
		Stream<Contact> filter = stream.filter((contact)-> contact.getActiveSwitch()=='Y');
		List<Contact> collect = filter.collect(Collectors.toList());
		
		return new ResponseEntity<List<Contact>>(collect,HttpStatus.OK);
		
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
	
	@DeleteMapping(value = "deleteContactSot/{contactid}")
	public ResponseEntity<String> deleteContactSot(@PathVariable Integer contactid){
		
		boolean deleteContactSoft = contactServiceI.deleteContactSoft(contactid);
		if(deleteContactSoft) {
			return new ResponseEntity<String>("contact deleted soft succsessfully",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("contact not deleted soft succsessfully",HttpStatus.CREATED);
		
		}
		}
		


}

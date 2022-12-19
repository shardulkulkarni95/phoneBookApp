package com.LaxmiInfoTech.PhoneBookAPP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LaxmiInfoTech.PhoneBookAPP.entities.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

}

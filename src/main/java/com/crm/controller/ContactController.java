package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.entities.Contact;
import com.crm.entities.Lead;
import com.crm.services.ContactService;
import com.crm.services.LeadService;

@Controller
public class ContactController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;
	
	
	@RequestMapping("/convertToContact")
	 public String convertToContact(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadService.findLeadById(id);
		
		Contact contact = new Contact();
		contact.setEmail(lead.getEmail());
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setLeadSource(lead.getLeadSource());
		contact.setMobile(lead.getMobile());
		
		contactService.saveContact(contact);
		
		leadService.deleteLeadById(id);
		
		List<Contact> contacts = contactService.getAllContacts();
		
		model.addAttribute("contacts", contacts);
		return "contact_result";
	 }
	
	@RequestMapping("/listcontacts")
	public String listcontacts(ModelMap model) {
	List<Contact> contacts = contactService.getAllContacts();
	model.addAttribute("contacts", contacts);
	return "contact_result";	
		
	}
	
	@RequestMapping("/getContactById")
	public String getContactById(@RequestParam("id") long id,ModelMap model) {
	Contact contact  =	contactService.findContactbyId(id);
	model.addAttribute("contact", contact);
	return "contact_info";
		
	}
	
	@RequestMapping("/getIdForBilling")
	public String getIdForBilling(@RequestParam("id") long id,ModelMap model) {
		Contact contact  =	contactService.findContactbyId(id);
		model.addAttribute("contact", contact);
		return "billing_info";	
	}
	
	
	

	
}

package com.crm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entities.Lead;
import com.crm.repositories.Leadrepository;

@Service
public class LeadSreviceImpl implements LeadService {
	
	@Autowired
	private Leadrepository leadRepo;
	
	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);
	}

	@Override
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public Lead findLeadById(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

	@Override
	public void deleteLeadById(long id) {
		leadRepo.deleteById(id);
		
	}

}

package com.crm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.entities.Billing;
import com.crm.repositories.BillingRepository;


@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	private BillingRepository billingRepo;
	
	@Override
	public void saveBill(Billing bill) {
		billingRepo.save(bill);
	}

	@Override
	public List<Billing> getAllBilling() {
		List<Billing> bills = billingRepo.findAll();
		return bills;
	}

	@Override
	public Billing findBillById(long id) {
		Optional<Billing> findById = billingRepo.findById(id);
		Billing billing = findById.get();
		return billing;
	}

}

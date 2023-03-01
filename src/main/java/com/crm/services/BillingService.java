package com.crm.services;

import java.util.List;

import com.crm.entities.Billing;

public interface BillingService {
	
	public void saveBill(Billing bill);

	public List<Billing> getAllBilling();

	public Billing findBillById(long id);

}

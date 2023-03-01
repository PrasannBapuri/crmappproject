package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.entities.Billing;
import com.crm.services.BillingService;

@Controller
public class BillingController {
	
	@Autowired 
	private BillingService billingService;
	
	@RequestMapping("/generateBill")
	public String generateBill(Billing bill) {
		billingService.saveBill(bill);
		return "final_billing_info";
	}
	
	@RequestMapping("/allbilling")
	public String allbilling(ModelMap model) {
	List<Billing> bill = billingService.getAllBilling();
	model.addAttribute("Billing", bill);
		return "final_billing_info";
	}
	
	@RequestMapping("/getBillById")
	public String getBillById(@RequestParam("id") long id,ModelMap model) {
		Billing billing = billingService.findBillById(id);
		model.addAttribute("Billing", billing);
		return "final_billing_info";
	}
	
	
	
	
	
	
	
	
	

}

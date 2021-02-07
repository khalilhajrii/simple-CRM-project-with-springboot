package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.dao.CrmRepository;
import com.crm.model.Customer;

@Service
public class crmService {
	 @Autowired
	public
	CrmRepository metier;
	 
	 public List<Customer> listAll() {
	        return metier.findAll();
	    }
	     
	    public void save(Customer ctr) {
	    	metier.save(ctr);
	    }
	     
	    public Customer get(long id) {
	        return metier.findById(id).get();
	    }
	     
	    public void delete(long id) {
	    	metier.deleteById(id);

}
}

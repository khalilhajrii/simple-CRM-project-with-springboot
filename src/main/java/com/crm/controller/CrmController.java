package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.crm.model.Customer;
import com.crm.service.crmService;

@Controller
public class CrmController {

	@Autowired
    crmService service;
	
	
	//page d'acceuil
	@RequestMapping(value="/")
	public String acceuil() {
		return "acceuil";
	}
	
   //liste des clients 
    @RequestMapping(value="/list")
    public String listeclients(Model model) {
        List<Customer> listcustomer = service.listAll();
        model.addAttribute("listcustomer", listcustomer);
        return "index";
    }
    
    //nouvelle client
    @RequestMapping(value="/new")
    public String ajouterclient(Model model) {
        model.addAttribute("customer", new Customer());
        return "new";
    }
    
    //enregistrer un client 
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String enregistrerclient(@ModelAttribute("customer") Customer cu) {
        service.save(cu);
        return "redirect:/list";
        
    }
    
    //modifier client 
    @RequestMapping("/edit/{id}")
    public ModelAndView AfficherModifierClient(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Customer ctr = service.get(id);
        mav.addObject("customer", ctr);
        return mav;
        
    }
    
    //supprimer client
    @RequestMapping("/delete/{id}")
    public String supprimerClient(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/list";
    }
    
    
    
}

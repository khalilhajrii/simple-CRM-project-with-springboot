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
	
	@RequestMapping(value="/")
	public String acceuil() {
		return "acceuil";
	}
	

    @RequestMapping(value="/list")
    public String viewHomePage(Model model) {
        List<Customer> listcustomer = service.listAll();
        model.addAttribute("listcustomer", listcustomer);
        System.out.print("Get / "); 
        return "index";
    }

    @RequestMapping(value="/new")
    public String add(Model model) {
        model.addAttribute("customer", new Customer());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("customer") Customer std) {
        service.save(std);
        return "redirect:/list";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Customer ctr = service.get(id);
        mav.addObject("customer", ctr);
        return mav;
        
    }
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/list";
    }
}

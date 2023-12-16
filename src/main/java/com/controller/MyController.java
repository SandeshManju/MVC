package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.mvc.model.Customer;
import com.mvc.dao.*;
import com.mvc.config.*;

@Controller
public class MyController 
{
	@Autowired
	CustomerDao dao;
	  @RequestMapping("/add")    
	    public String showform(@ModelAttribute("register")Customer m){    
	         
	        return "AddCustomer";   
	    }    
	  @RequestMapping(value="/save",method = RequestMethod.POST)    
	    public String save(@ModelAttribute("cust") Customer c){    
	        dao.insert(c);    
	        return "redirect:/viewcust";//will redirect to viewemp request mapping    
	    }    
	  @RequestMapping("/viewcust")    
	    public String viewemp(Model m){    
	        List<Customer> list=dao.getCustomers();    
	        m.addAttribute("list",list);  
	        return "viewcust";    
	    }    
	  @RequestMapping(value="/edit",method = RequestMethod.POST)    
	    public String editsave(@ModelAttribute("cust") Customer c){    
	        dao.update(c);    
	        return "/viewcust";    
	    }  
	  @RequestMapping(value="/editcust/{id}")    
	    public String edit(@PathVariable int id, Model m){    
	        Customer c=dao.getCustomerById(id);    
	        m.addAttribute("command",c);  
	        return "edit";    
	    }    
	  @RequestMapping(value="/deletecust/{id}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int id){    
	        dao.delete(id);    
	        return "redirect:/viewcust";    
	    }     
	
}

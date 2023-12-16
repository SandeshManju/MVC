package com.mvc.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mvc.model.Customer;

public class CustomerImpl {
	JdbcTemplate template;
	public List<Customer> getCustomers(){    
	    return template.query("select * from Customer",new RowMapper<Customer>(){    
	        public Customer mapRow(ResultSet rs, int row) throws SQLException {    
	        	Customer e=new Customer();    
	            e.setId(rs.getInt(1));    
	            e.setCname(rs.getString(2));    
	            e.setEmail(rs.getString(3));    
	            e.setPhone(rs.getLong(4));    
	            return e;    
	        }  
	    });    
	}    
	

}

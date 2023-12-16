package com.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mvc.model.Customer;


public class CustomerDao {
	
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template)
	{
		this.template=template;
	}
	public int insert(Customer c)
	{
		String query="insert into Customer values("+c.getId()+",'"+c.getCname()+"','"+c.getEmail()+"',"+c.getPhone()+")";
		return template.update(query);
		
	}
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
	public int update(Customer c){    
	    String sql="update Customer set cname='"+c.getCname()+"', email="+c.getEmail()+",phone='"+c.getPhone()+"' where id="+c.getId()+"";    
	    return template.update(sql);    
	}    
	@SuppressWarnings("deprecation")
	public Customer getCustomerById(int id){    
	    String sql="select * from Customer where id=?";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Customer>(Customer.class));    
	}    
	public int delete(int id){    
	    String sql="delete from Customer where id="+id+"";    
	    return template.update(sql);    
	}    

}

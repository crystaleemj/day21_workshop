package sg.edu.nus.iss.paf_day21_workshop.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf_day21_workshop.model.Customer;

@Repository
public class CustomerRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    String listAllCustomers = "select * from customers";

    public List<Customer> getAllCustomers(){
        List<Customer> customerList = new ArrayList<>();

        customerList = jdbcTemplate.query(listAllCustomers, 
        BeanPropertyRowMapper.newInstance(Customer.class));

        return customerList;
    }
}

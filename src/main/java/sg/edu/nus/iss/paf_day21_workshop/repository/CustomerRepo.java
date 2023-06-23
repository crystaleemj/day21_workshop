package sg.edu.nus.iss.paf_day21_workshop.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf_day21_workshop.model.Customer;
import sg.edu.nus.iss.paf_day21_workshop.model.Order;

@Repository
public class CustomerRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    String listAllCustomers = "select * from customers limit ? offset ?";
    String getCustomerById = "select * from customers where id=?";
    String customerOrder = "select * from orders where customer_id = ?";

    public List<Customer> getAllCustomers(int limit, int offset){
        List<Customer> customerList = new ArrayList<>();

        customerList = jdbcTemplate.query(listAllCustomers, 
        BeanPropertyRowMapper.newInstance(Customer.class), limit, offset);

        return customerList;
    }

    public Customer findCustomerId(int id){
        Customer customer = new Customer();
        try {
            customer = jdbcTemplate.queryForObject(getCustomerById,
            BeanPropertyRowMapper.newInstance(Customer.class), id);
            
        } catch (EmptyResultDataAccessException e) {
            // TODO: handle exception
            throw new NoSuchElementException("Customer not found with id " + id);
        }


        return customer;
    }

    public List<Order> getOrdersById(int id){
        List<Order> orders = new ArrayList<>();

        orders = jdbcTemplate.query(customerOrder, 
        BeanPropertyRowMapper.newInstance(Order.class), id);

        return orders;
    }
}

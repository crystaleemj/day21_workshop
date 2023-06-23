package sg.edu.nus.iss.paf_day21_workshop.controller;

import java.util.List;
import java.util.NoSuchElementException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.paf_day21_workshop.model.Customer;
import sg.edu.nus.iss.paf_day21_workshop.repository.CustomerRepo;

@RestController
@RequestMapping (path = "/api/customers")
public class MainController {

    @Autowired
    CustomerRepo repo;

    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> allCustomers
    (@RequestParam(defaultValue = "5", required = false) int limit, 
    @RequestParam(defaultValue = "0", required = false)int offset){
        List<Customer> list = repo.getAllCustomers(limit, offset);
        
        return ResponseEntity.ok().body(list);
    }

    @GetMapping (path = "/{customer_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> customerById(@PathVariable("customer_id") int id){

        try {
            Customer customer = repo.findCustomerId(id);
            return ResponseEntity.ok().body(customer);

        } catch (NoSuchElementException e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
        
    }
    
}

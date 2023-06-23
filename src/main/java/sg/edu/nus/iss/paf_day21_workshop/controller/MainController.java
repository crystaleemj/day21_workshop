package sg.edu.nus.iss.paf_day21_workshop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.paf_day21_workshop.model.Customer;
import sg.edu.nus.iss.paf_day21_workshop.repository.CustomerRepo;

@RestController
@RequestMapping (path = "/api/customers")
public class MainController {

    @Autowired
    CustomerRepo repo;

    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> allCustomers(){
        List<Customer> list = repo.getAllCustomers();
        
        return ResponseEntity.ok().body(list);
    }
    
}

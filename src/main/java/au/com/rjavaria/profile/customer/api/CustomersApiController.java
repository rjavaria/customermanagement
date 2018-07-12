package au.com.rjavaria.profile.customer.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import au.com.rjavaria.profile.customer.service.ICustomerService;
import au.com.rjavaria.profile.entities.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
/*
 * REST controller for Customer management 
 * @author rjavaria
 */
@RestController
public class CustomersApiController implements CustomersApi {

    private static final Logger log = LoggerFactory.getLogger(CustomersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private ICustomerService customerService;

    @Autowired
    public CustomersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    
    @Override
    public ResponseEntity<Void> createCustomer(@Valid @RequestBody Customer customer) {
    	customerService.createCustomer(customer);
    	return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<Customer> deleteCustomer(@Valid @PathVariable String accountid) {
    	Customer customer = customerService.deleteCustomer(accountid);
    	return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Customer> getCustomer(@Valid @PathVariable String accountid) {
    	Customer customer = customerService.getCustomer(accountid);
    	return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<Customer> updateCustomer(@Valid @PathVariable String accountid,
    		                                       @Valid @RequestBody Customer customer) {
    	Customer udatedCustomer = customerService.updateCustomer(accountid, customer);
    	return new ResponseEntity<Customer>(udatedCustomer, HttpStatus.OK);
    }
}

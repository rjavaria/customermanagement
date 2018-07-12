package au.com.rjavaria.profile.customer.proxy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import au.com.rjavaria.profile.entities.Customer;

@Component
public class SiebelRESTProxy {

	private Map<String, Customer> customerMap = new HashMap<>();
	
	public boolean insertUser(String accountid, Customer customer) {
		if(customerMap.containsKey(accountid) ) {
			throw new SiebelException("SIEBEL-001", "Customer account exists.");
		}
		customerMap.put(accountid, customer);
		return true;
	}
	
	public Customer deleteUser(String accountid) {
		if(!customerMap.containsKey(accountid)) {
			throw new SiebelException("SIEBEL-002", "Customer not found.");
		}
		
		Customer customer = customerMap.get(accountid);
		customerMap.remove(accountid);
		return customer;
	}
	
	public Customer updateUser(String accountid, Customer customer) {
		if(!customerMap.containsKey(accountid)) {
			throw new SiebelException("SIEBEL-002", "Customer not found.");
		}
		customerMap.put(accountid, customer);
		return customerMap.get(accountid);
	}
	
	public Customer getUser(String accountid) {
		if(!customerMap.containsKey(accountid)) {
			throw new SiebelException("SIEBEL-002", "Customer not found.");
		}
		return customerMap.get(accountid);
	}
}

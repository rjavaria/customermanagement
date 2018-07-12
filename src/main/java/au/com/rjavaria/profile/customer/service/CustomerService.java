package au.com.rjavaria.profile.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.rjavaria.profile.customer.proxy.SiebelRESTProxy;
import au.com.rjavaria.profile.entities.Customer;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private SiebelRESTProxy siebelRestProxy;
	
	@Override
	public boolean createCustomer(Customer customer) {
		return siebelRestProxy.insertUser(customer.getAccountid(), customer);
	}
	
	@Override
	public Customer deleteCustomer(String accountid) {
		return siebelRestProxy.deleteUser(accountid);
	}
	
	@Override
	public Customer updateCustomer(String accountid, Customer customer) {
		return siebelRestProxy.updateUser(accountid, customer);
	}
	
	@Override
	public Customer getCustomer(String accountid) {
		return siebelRestProxy.getUser(accountid);
	}
}

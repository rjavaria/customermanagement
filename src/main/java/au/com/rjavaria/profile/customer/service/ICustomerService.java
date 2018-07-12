package au.com.rjavaria.profile.customer.service;

import au.com.rjavaria.profile.entities.Customer;
/**
 * Customer management service
 * 
 * @author rajesh
 *
 */
public interface ICustomerService {

	/**
	 * @param customer
	 * @return
	 */
	public boolean createCustomer(Customer customer);
	
	/**
	 * 
	 * @param accountid
	 * @return
	 */
	public Customer deleteCustomer(String accountid);
	
	/**
	 * 
	 * @param accountid
	 * @param customer
	 * @return
	 */
	public Customer updateCustomer(String accountid, Customer customer);
	
	/**
	 * 
	 * @param accountid
	 * @return
	 */
	public Customer getCustomer(String accountid);
}

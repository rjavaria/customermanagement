package au.com.rjavaria.profile.customer.api;

import io.swagger.annotations.*;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import javax.validation.Valid;

import au.com.rjavaria.profile.entities.Customer;
/**
 * 
 * @author rajesh javaria
 *
 */
@Api(value = "customers", description = "Customer Profile API")
public interface CustomersApi {

    /**
     * Create a new customer profile 
     *   
     * @param Customer
     * @return ResponseEntity<Void>
     */
    @ApiOperation( value = "Create a new customer", 
		           nickname = "customerAccountCreate", 
		           notes = "Create a new customer profile.", 
		           tags={ "customer", }
                 )
    @ApiResponses(
		           value = { 
                       @ApiResponse(code = 200, message = "Successfully created a new customer."),
                       @ApiResponse(code = 401, message = "Authorization information is missing or invalid"),
                       @ApiResponse(code = 501, message = "Unexpected error.") 
                    }
		         )
    @RequestMapping( 
		             value = "/customers",
                     method = POST,
                     produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                     consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
                   )
    public ResponseEntity<Void> createCustomer( 
    		                                    @ApiParam(value = "CustomerDataEntity object that needs to be created" ,required=true )  
                                                @Valid @RequestBody Customer customerDataEntity
    		                                  );

    /**
     * Delete the customer profile 
     *   
     * @param accountid
     * @return ResponseEntity<Customer> 
     */      
    @ApiOperation( value = "Delete a customer", 
    		       nickname = "customerAccountDelete", 
    		       notes = "Delete a customer profile.", 
    		       tags={ "customer", }
                 )
    @ApiResponses(
    		       value = { 
                              @ApiResponse(code = 200, message = "Successfully deleted the customer."),
                              @ApiResponse(code = 400, message = "Invalid Customer account id supplied."),
                              @ApiResponse(code = 401, message = "Authorization information is missing or invalid"),
                              @ApiResponse(code = 404, message = "Customer profile not found."),
                              @ApiResponse(code = 501, message = "Unexpected error.") 
                           }
    		      )
    @RequestMapping( 
    		         value = "/customers/{accountid}",
                     method = DELETE,
                     produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                     consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
                   )
    public ResponseEntity<Customer> deleteCustomer(
    		                                @ApiParam(value = "The account id of customer.",required=true) 
    		                                @Valid @PathVariable("accountid") String accountid
    		                                );


    /**
     * Get the customer profile 
     *   
     * @param accountid
     * @return ResponseEntity<Customer>
     */      
    @ApiOperation( value = "Get a customer", 
    		       nickname = "customerAccountGet", 
    		       notes = "Get a customer profile.", 
    		       tags={ "customer", }
                  )
    @ApiResponses( 
    		       value = { 
                             @ApiResponse(code = 200, message = "Successfully retrieved the customer profile."),
                             @ApiResponse(code = 400, message = "Invalid Customer account id supplied."),
                             @ApiResponse(code = 401, message = "Authorization information is missing or invalid"),                             
                             @ApiResponse(code = 404, message = "Customer profile not found."),
                             @ApiResponse(code = 501, message = "Unexpected error.")
    		    		   }
    		      )
    @RequestMapping( 
	                 value = "/customers/{accountid}",
                     method = GET,
                     produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                     consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
                   )
    public ResponseEntity<Customer> getCustomer(
    		                                @ApiParam(value = "The account id of customer.", required=true)
                                            @Valid @PathVariable("accountid") String accountid
                                            );

    /**
     * Update the customer profile 
     *   
     * @param accountid
     * @param Customer
     * @return ResponseEntity<Customer>
     */    
    @ApiOperation( value = "Update the customer profile", 
	               nickname = "customerAccountUpdate", 
	               notes = "Update the profile of existing customer", 
	               tags={ "customer", }
          )
    @ApiResponses(
	               value = { 
                             @ApiResponse(code = 200, message = "Successfully updated the customer."),
                             @ApiResponse(code = 400, message = "Invalid Customer account id supplied."),
                             @ApiResponse(code = 401, message = "Authorization information is missing or invalid"),                             
                             @ApiResponse(code = 404, message = "Customer profile not found."),
                             @ApiResponse(code = 501, message = "Unexpected error.") 
                           }
	             )
    @RequestMapping( 
	                 value = "/customers/{accountid}",
                     method = PUT,
                     produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                     consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
                   )
    public ResponseEntity<Customer> updateCustomer(
    		                               @ApiParam(value = "The account id of customer.", required=true)
                                           @Valid @PathVariable("accountid") String accountid,
    		                               @Valid @RequestBody Customer customerDataEntity
    		                            );       
}
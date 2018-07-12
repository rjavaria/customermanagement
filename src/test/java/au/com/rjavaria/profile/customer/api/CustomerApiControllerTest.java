package au.com.rjavaria.profile.customer.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import au.com.rjavaria.profile.CustomerApplicationBoot;
import au.com.rjavaria.profile.customer.service.ICustomerService;
import au.com.rjavaria.profile.entities.Customer;


/**
 * @author rjavaria
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CustomerApplicationBoot.class)
@SpringBootTest
public class CustomerApiControllerTest {
	
	@InjectMocks
	private CustomersApiController customersApiController;
	
	@Mock
	private ICustomerService customerService;
	
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customersApiController).build();
	}
	
	@Test
	public void testCreateCustomer() throws Exception {
		//Tests if API has been implemented in REST Controller.
		
		Customer customer = new Customer.Builder("rjava17")
				                        .firstname("raj")
				                        .lastname("javaria")
				                        .title("Mr")
				                        .dob("01/01/1987")
				                        .email("rajesh.javaria@gmail.com")
				                        .homeaddress(null)
				                        .officeaddress(null).build();
				             
		this.mockMvc.perform(post("/customers").
							 contentType(MediaType.APPLICATION_JSON_VALUE).
							 header("Authorization", "Basic cmFqZXNoOnBhc3MxMjM=").
							 content(objectMapper.writeValueAsString(customer)).
							 accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).
							 andDo(print());
	}
}

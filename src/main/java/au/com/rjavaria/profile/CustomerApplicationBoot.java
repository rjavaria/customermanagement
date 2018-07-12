package au.com.rjavaria.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Customer Application boot
 * 
 * @author rjavaria
 *
 */
@SpringBootApplication
@EnableSwagger2
public class CustomerApplicationBoot {
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplicationBoot.class, args);
	}
}

package com.laoumri.customerservice;

import com.laoumri.customerservice.configurations.GlobalConfig;
import com.laoumri.customerservice.entities.Customer;
import com.laoumri.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args->{

			List<Customer> customerList = List.of(
					Customer.builder()
							.firstname("issam")
							.lastName("laoumri")
							.email("issam@gmail.com")
							.build(),
					Customer.builder()
							.firstname("soufiane")
							.lastName("laoumri")
							.email("soufiane@gmail.com")
							.build(),
					Customer.builder()
							.firstname("hamza")
							.lastName("malih")
							.email("hamza@gmail.com")
							.build()
			);
			customerRepository.saveAll(customerList);
		};
	}
}

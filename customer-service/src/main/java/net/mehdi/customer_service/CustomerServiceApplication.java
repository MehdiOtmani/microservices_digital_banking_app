package net.mehdi.customer_service;

import net.mehdi.customer_service.entities.Customer;
import net.mehdi.customer_service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			List<Customer> customerList = List.of(

					Customer.builder()
							.email("elmehdielotmani11@gmail.com")
							.firstName("Mehdi")
							.lastName("El Otmani")
							.build(),

					Customer
							.builder()
							.email("Otmaneelotmani2002@gmail.com")
							.firstName("otmane")
							.lastName("El Otmani")
							.build(),

					Customer
							.builder()
							.email("Yassineelotmani2006@gmail.com")
							.firstName("Yassine")
							.lastName("El Otmani")
							.build());


			customerRepository.saveAll(customerList);
		};
    }
}

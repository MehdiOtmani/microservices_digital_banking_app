package net.mehdi.account_service.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.mehdi.account_service.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);
    @CircuitBreaker(name = "customerService",fallbackMethod = "getAllCustomers")
    @GetMapping("/customers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id,Exception exception){
        Customer customer=new Customer();
        customer.setEmail("Not Available");
        customer.setFirstName("Not Available");
        customer.setLastName("Not Available");
        customer.setId(id);
        return customer;
    }

    default List<Customer> getAllCustomers(Exception exception){
        return List.of();
    }
}


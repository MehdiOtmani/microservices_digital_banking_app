package net.mehdi.customer_service.repository;

import net.mehdi.customer_service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<Customer,Long> {
}

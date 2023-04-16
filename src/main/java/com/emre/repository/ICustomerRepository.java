package com.emre.repository;

import com.emre.repository.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findOptionalByEmail(String email);
    Optional<Customer> findOptionalByCustomerId(Long id);
    Optional<Customer> findOptionalByEmailAndPassword(String email,String password);

}

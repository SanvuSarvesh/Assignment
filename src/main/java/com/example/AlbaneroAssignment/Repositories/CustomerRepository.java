package com.example.AlbaneroAssignment.Repositories;

import com.example.AlbaneroAssignment.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}

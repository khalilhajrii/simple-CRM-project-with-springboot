package com.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.model.Customer;

@Repository
public interface CrmRepository extends JpaRepository<Customer, Long> {

}

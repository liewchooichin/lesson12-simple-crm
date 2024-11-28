package com.pace.app.lesson12_simple_crm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// we specify the entity type and the type of the primary key, 
// which in this case, are Customer and Long respectively.
@Repository
public interface CustomerRepository 
  extends JpaRepository<Customer, Long>{
  // the rest will be taken care of by JPA.
}

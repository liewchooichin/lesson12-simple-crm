package com.pace.app.lesson12_simple_crm;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InteractionRepository 
  extends JpaRepository<Interaction, Long> {
  // will be taken care of by JpaRepository
} 

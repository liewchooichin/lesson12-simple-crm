package com.pace.app.lesson12_simple_crm;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Activity
// 1: Create Interaction Entity
// 2: Create InteractionRepository interface
// 3: Create InteractionService interface
// 4: Create InteractionServiceImpl
// 5: Create InteractionController

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "interaction")
public class Interaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  // With the @ManyToOne annotation, we are saying that
  // MANY rows in the Interaction table can be associated
  // with ONE row in the Customer table.
  // By setting optional = false, we are telling JPA that the 
  // customer field is required and cannot be null. In other words, 
  // an interaction can only exist if it is associated with a 
  // customer.
  // The @JoinColumn annotation is used to specify the name of the 
  // foreign key column and the name of the column in the referenced 
  // table. In this case, the foreign key column is customer_id and 
  // it references the id column in the Customer table.
  @ManyToOne(optional = false)
  @JoinColumn(name = "customer_id", referencedColumnName = "id")
  private Customer customer;

  @Column(name = "remarks")
  private String remarks;

  @Column(name = "interaction_date")
  private LocalDate interactionDate;

}

package com.pace.app.lesson12_simple_crm;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/customers")
public class CustomerController {
  // service
  private CustomerService customerService; 

  // constructor
  // to specify the name of the bean in the @Qualifier annotation 
  // when we inject the dependency into the CustomerController.
  // The name of the bean is the name of the class with the first 
  // letter in lowercase.
  public CustomerController(
    //@Qualifier("customerServiceWithLoggingImpl") CustomerService customerService){
      @Qualifier("customerServiceImpl") CustomerService customerService){
    this.customerService = customerService;
  }

  // create
  // @PostMapping("/customers")
  @PostMapping("")
  public ResponseEntity<Customer> createCustomer(@RequestBody Customer newCustomer) {
    customerService.createCustomer(newCustomer);
    return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
  }

  // get all customers
  // @GetMapping("/customers")
  @GetMapping("")
  public ResponseEntity<ArrayList<Customer>> getAllCustomers() {
    ArrayList<Customer> allCustomers = customerService.getAllCustomers();
    return new ResponseEntity<>(allCustomers, HttpStatus.OK);
  }
 
  // @GetMapping("/customers/{id}")
  @GetMapping("/{id}")
  public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
    try {
      Customer foundCustomer = customerService.getCustomer(id);
      return new ResponseEntity<>(foundCustomer, HttpStatus.OK);
    } catch (CustomerNotFoundException exception) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // update
  // @PutMapping("/customers/{id}")
  @PutMapping("/{id}")
  public ResponseEntity<Customer> updateCustomer(
      @PathVariable Long id, @RequestBody Customer customer) {

    try {
      Customer updatedCustomer = customerService.updateCustomer(id, customer);
      return new ResponseEntity<>(updatedCustomer, HttpStatus.CREATED);
    } catch (CustomerNotFoundException exception) {
      // add a new customer

      return new ResponseEntity<>(customer, HttpStatus.NOT_FOUND);
    }
  }

  // delete
  // @DeleteMapping("/customers/{id}")
  @DeleteMapping("/{id}")
  // public Customer deleteCustomer(@PathVariable String id) {
  public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long id) {
    try {
      customerService.deleteCustomer(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (CustomerNotFoundException exception) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // nested route
  @PostMapping("/{id}/interactions")
  public ResponseEntity<Interaction> addInteractionToCustomer(
    @PathVariable Long id, @RequestBody Interaction interaction){
      Interaction newInteraction  = customerService.addInteractionToCustomer(id, interaction);
      return new ResponseEntity<>(newInteraction, HttpStatus.OK);
    }
  

  
} // end class

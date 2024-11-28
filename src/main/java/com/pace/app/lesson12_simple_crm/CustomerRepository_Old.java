package com.pace.app.lesson12_simple_crm;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository_Old {
  // fields
  private ArrayList<Customer> customers = new ArrayList<>();

  // add some customers
  // constructor of the controller's class
  public CustomerRepository_Old() {
    customers.add(new Customer("Super", "Dog"));
    customers.add(new Customer("Magnifient", "Cat"));
    customers.add(new Customer("Fantastic", "Fox"));
    customers.add(new Customer("Free", "Eagle"));
  }
  // Create data
  public Customer creaCustomer(Customer customer){
    customers.add(customer);
    return customer;
  }
  // Read - Get one
  public Customer getCustomer(int index){
    return customers.get(index);
  }
  // Read - Get all
  public ArrayList<Customer> getAllCustomers(){
    return customers;
  }
  // Update
  public Customer updateCustomer(int index, Customer newCustomer){
    Customer customerToUpdate = customers.get(index);
    customerToUpdate.setFirstName(newCustomer.getFirstName());
    customerToUpdate.setLastName(newCustomer.getLastName());
    customerToUpdate.setEmail(newCustomer.getEmail());
    customerToUpdate.setContactNo(newCustomer.getContactNo());
    customerToUpdate.setJobTitle(newCustomer.getJobTitle());
    customerToUpdate.setYearOfBirth(newCustomer.getYearOfBirth());
    return customerToUpdate;
  }
  // Delete
  public void deleteCustomer(int index){
    customers.remove(index);
  }

} // end of class

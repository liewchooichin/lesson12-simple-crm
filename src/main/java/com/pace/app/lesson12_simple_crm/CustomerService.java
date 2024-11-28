package com.pace.app.lesson12_simple_crm;

import java.util.ArrayList;

public interface CustomerService {
  Customer createCustomer(Customer customer);
  Customer getCustomer(Long id);
  ArrayList<Customer> getAllCustomers();
  Customer updateCustomer(Long id, Customer customer);
  void deleteCustomer(Long id);
  // nested route
  Interaction addInteractionToCustomer(Long id, Interaction interaction);
}
package com.pace.app.lesson12_simple_crm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl 
  implements CustomerService {
  // fields
  private CustomerRepository customerRepository; 
  private InteractionRepository interactionRepository;

  // constructor
  //@Autowired // unnecessary
  public CustomerServiceImpl(
    CustomerRepository customerRepository,
    InteractionRepository interactionRepository){
    this.customerRepository = customerRepository;
    this.interactionRepository = interactionRepository;
  }

  // create
  public Customer createCustomer(Customer customer){
    Customer newCustomer = customerRepository.save(customer);
    return newCustomer;
  }
  // get one
  public Customer getCustomer(Long id) {
    Customer foundCustomer = customerRepository.findById(id).get();
    return foundCustomer;
  }
  // get all
  public ArrayList<Customer> getAllCustomers() {
    List<Customer> allCustomers = customerRepository.findAll();
    return (ArrayList<Customer>) allCustomers;
  }
  // update
  public Customer updateCustomer(Long id, Customer customer) {
    // retrieve the customer from db
    Customer customerToUpdate = customerRepository.findById(id).get();
    // update the customer object that was retrieved
    customerToUpdate.setFirstName(customer.getFirstName());
    customerToUpdate.setLastName(customer.getLastName());
    customerToUpdate.setContactNo(customer.getContactNo());
    customerToUpdate.setEmail(customer.getEmail());
    customerToUpdate.setJobTitle(customer.getJobTitle());
    customerToUpdate.setYearOfBirth(customer.getYearOfBirth());
    // save updated customer back to the db
    Customer savedCustomer = customerRepository.save(customerToUpdate);
    return savedCustomer;
  }
  // delete
  public void deleteCustomer(Long id) {
    customerRepository.deleteById(id);
  }

  // nested route
  @Override
  public Interaction addInteractionToCustomer(Long id, Interaction interaction){
    // get the customer first
    Customer selectedCustomer = customerRepository.findById(id).get();
    // add customer to the interaction
    interaction.setCustomer(selectedCustomer);
    // save interaction to db
    return interactionRepository.save(interaction);
  }
} // end of class

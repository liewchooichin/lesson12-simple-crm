package com.pace.app.lesson12_simple_crm;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CustomerServiceWithLoggingImpl
    implements CustomerService {
  // fields
  private CustomerRepository customerRepository;
  private InteractionRepository interactionRepository;

  private final Logger logger = LoggerFactory.getLogger(
      CustomerServiceWithLoggingImpl.class);

  // constructor
  // @Autowired // unnecessary
  public CustomerServiceWithLoggingImpl(
    CustomerRepository customerRepository,
    InteractionRepository interactionRepository) {
    this.customerRepository = customerRepository;
    this.interactionRepository = interactionRepository;
  }

  // create
  public Customer createCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  // get one
  public Customer getCustomer(Long id) {
    Customer foundCustomer = customerRepository.findById(id).get();
    return foundCustomer;

  }

  // get all
  public ArrayList<Customer> getAllCustomers() {
    logger.info("✅ CustomerServiceWithLoggingImpl.getAllCustomers called");
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

  @Override
public Interaction addInteractionToCustomer(Long id, Interaction interaction) {
  // retrieve the customer from the database
  Customer selectedCustomer = customerRepository.findById(id).get();
  // add the customer to the interaction
  interaction.setCustomer(selectedCustomer);
  // save the interaction to the database
  return interactionRepository.save(interaction);
}
} // end of class

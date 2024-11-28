package com.pace.app.lesson12_simple_crm;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {
  private CustomerRepository customerRepository;

  // @Autowired
  // constructor
  public DataLoader(CustomerRepository customerRepository){
    this.customerRepository = customerRepository;
  }

  // post initialization of spring bean
  @PostConstruct
  public void loadData(){
    // clear the existing data first
    customerRepository.deleteAll();
    // load data here
    customerRepository.save(new Customer("Spring", "Bean"));
    customerRepository.save(new Customer("Magnificient", "Orchid"));
    customerRepository.save(new Customer("Leaping", "Pocket"));
    customerRepository.save(new Customer("Cooling", "Rain"));
  }
}

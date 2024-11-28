package com.pace.app.lesson12_simple_crm;

import java.util.UUID;

// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
public class Product {
  // fields
  private final String id;
  private String name;
  private String description;
  private double price;

  // constructors
  public Product(){
    this.id = UUID.randomUUID().toString();
  }

  public Product(String name, String description, double price) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.description = description;
    this.price = price;
  }

  // to string
  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("Product id: %s, ", id));
    sb.append(String.format("name: %s, ", name));
    sb.append(String.format("description: %s, ", description));
    sb.append(String.format("price: %s.%n", price));
    return sb.toString();
  }

  // getters and setters

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
  
  // getters and setters

  


}

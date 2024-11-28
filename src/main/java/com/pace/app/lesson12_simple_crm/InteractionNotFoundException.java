package com.pace.app.lesson12_simple_crm;

public class InteractionNotFoundException 
 extends RuntimeException {
  InteractionNotFoundException(String id) {
    super("Could not find interaction with id: " + id);
  }
}

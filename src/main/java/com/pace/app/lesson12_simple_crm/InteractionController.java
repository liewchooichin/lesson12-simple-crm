package com.pace.app.lesson12_simple_crm;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.apache.catalina.connector.Response;
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
@RequestMapping("/interactions")
public class InteractionController {
  // fields
  private InteractionService interactionService;

  // constructor
  public InteractionController(InteractionService interactionService) {
    this.interactionService = interactionService;
  }

  // get all
  @GetMapping("")
  public ResponseEntity<ArrayList<Interaction>> getAllInteractions() {
    ArrayList<Interaction> allInteractions = interactionService.getAllInteractions();
    return new ResponseEntity<>(allInteractions, HttpStatus.OK);
  }

  // get one
  @GetMapping("/{id}")
  public ResponseEntity<Interaction> getInteraction(@PathVariable Long id) {
    try {
      Interaction foundInteraction = interactionService.getInteraction(id);
      return new ResponseEntity<Interaction>(foundInteraction, HttpStatus.OK);
    } catch (NoSuchElementException exception) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // create
  @PostMapping("")
  public ResponseEntity<Interaction> createInteraction(@RequestBody Interaction newInteraction) {
    interactionService.createInteraction(newInteraction);
    return new ResponseEntity<Interaction>(newInteraction, HttpStatus.CREATED);
  }

  // update
  @PutMapping("/{id}")
  public ResponseEntity<Interaction> updateInteraction(
    @PathVariable Long id, @RequestBody Interaction interaction){
    Interaction updatedInteraction = interactionService.updateInteraction(id, interaction);
    return new ResponseEntity<>(updatedInteraction, HttpStatus.OK);
  }

  // delete
  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long id) {
    try {
      interactionService.deleteInteraction(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (InteractionNotFoundException exception) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (NoSuchElementException exception) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}

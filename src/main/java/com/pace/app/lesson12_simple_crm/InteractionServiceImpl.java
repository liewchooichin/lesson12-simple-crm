package com.pace.app.lesson12_simple_crm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class InteractionServiceImpl 
  implements InteractionService {
    // The repository
  private InteractionRepository interactionRepo;

  // constructor
  public InteractionServiceImpl(InteractionRepository interactionRepo){
    this.interactionRepo = interactionRepo;
  }

  // Implement methods
  @Override
  public Interaction createInteraction(Interaction interaction){
    Interaction newInteraction = interactionRepo.save(interaction);
    return newInteraction;
  }

  @Override
  public Interaction getInteraction(Long id){
    Interaction foundInteraction = interactionRepo.findById(id).get();
    return foundInteraction;
  }

  @Override
  public ArrayList<Interaction> getAllInteractions(){
    ArrayList<Interaction> allInteractions =
      (ArrayList<Interaction>) interactionRepo.findAll();
    return allInteractions;
  }

  @Override
  public Interaction updateInteraction(Long id, Interaction interaction){
    Interaction interactionToUpdate = interactionRepo.findById(id).get();
    interactionToUpdate.setRemarks(interaction.getRemarks());
    interactionToUpdate.setInteractionDate(interaction.getInteractionDate());
    Interaction savedInteraction = interactionRepo.save(interactionToUpdate);
    return savedInteraction;
  }

  @Override
  public void deleteInteraction(Long id){
    interactionRepo.deleteById(id);
  }
}

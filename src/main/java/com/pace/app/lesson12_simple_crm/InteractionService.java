package com.pace.app.lesson12_simple_crm;

import java.util.ArrayList;

public interface InteractionService {
  // CRUD method signatures
  Interaction createInteraction(Interaction interaction);
  Interaction getInteraction(Long id);
  ArrayList<Interaction> getAllInteractions();
  Interaction updateInteraction(Long id, Interaction interaction);
  void deleteInteraction(Long id);
}

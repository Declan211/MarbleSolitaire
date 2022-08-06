package cs3500.marblesolitaire.controller;

/**
 * interface for the Marble Solitaire Controller.
 */
public interface MarbleSolitaireController {

  /**
   * plays a new game.
   * Throws an IllegalStateException if controller cannot read input or
   * transmit output.
   */
  void playGame() throws IllegalStateException;
}

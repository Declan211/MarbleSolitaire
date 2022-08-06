package cs3500.marblesolitaire.controller;

import java.io.InputStreamReader;


import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * class for playing the game.
 */
public class PlayMain {

  /**
   * takes in the arguments.
   * @param args the inputs.
   */
  public static void main(String[] args) {
    MarbleSolitaireModel model1 = new TriangleSolitaireModel(5);
    MarbleSolitaireView view1 = new TriangleSolitaireTextView(model1);
    Readable reader = new InputStreamReader(System.in);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model1, view1, reader);
    controller.playGame();
  }

}



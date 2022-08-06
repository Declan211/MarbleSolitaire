package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * class for the implementation of the Marble Solitaire Controller.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private Readable input;


  /**
   * constructor for Marble Solitaire Controller.
   * @param model given model.
   * @param view given view.
   * @param input given input, usually StringReader.
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable input) {
    if (model == null || view == null || input == null) {
      throw new IllegalArgumentException("cannot be null");
    }
    this.model = model;
    this.view = view;
    this.input = input;
  }

  /**
   * plays a new game.
   * Throws an IllegalArgumentException if controller cannot read input or
   * transmit output.
   */
  @Override
  public void playGame() throws IllegalStateException {
    Scanner scan = new Scanner(this.input);

    this.renderBoardHelper();
    this.renderMessageHelper("\nScore: " + Integer.toString(model.getScore()) + "\n");

    while (scan.hasNext()) {

      if (this.model.isGameOver()) {
        this.renderMessageHelper("Game over!\n");
        this.renderBoardHelper();
        this.renderMessageHelper("\nScore: " + Integer.toString(model.getScore()));
        return;
      }


      ArrayList<Integer> workList = new ArrayList<Integer>();

      while (workList.size() < 4) {
        String n;
        try {
          n = scan.next();
        } catch (NoSuchElementException e) {
          throw new IllegalStateException("Run out of inputs");
        }
        if (n.equalsIgnoreCase("q")) {
          this.renderMessageHelper("\nGame quit!\n" + "State of game when quit:\n");
          this.renderBoardHelper();
          this.renderMessageHelper("\nScore: " + Integer.toString(model.getScore()));
          return;
        }
        try {
          int number = Integer.parseInt(n);
          if (number > 0) {
            workList.add(number - 1);
          } else {
            this.renderMessageHelper("Invalid move. Play again.\n");

          }
        } catch (NumberFormatException e) {
          this.renderMessageHelper("Invalid move. Play again.\n");
        }
      }


      try {
        model.move(workList.get(0), workList.get(1), workList.get(2), workList.get(3));
        this.renderBoardHelper();
        this.renderMessageHelper("\nScore: " + Integer.toString(model.getScore()) + "\n");
      } catch (IllegalArgumentException e) {
        this.renderMessageHelper("Invalid move. Play again.\n");
      }

    }
    if (this.model.isGameOver()) {
      this.renderMessageHelper("Game over!\n");
      this.renderBoardHelper();
      this.renderMessageHelper("\nScore: " + Integer.toString(model.getScore()));
      return;
    }
    throw new IllegalStateException("Run out of inputs");
  }

  private void renderBoardHelper() {
    try {
      this.view.renderBoard();
    } catch (IOException e) {
      throw new IllegalStateException("Transmission to view failed");
    }
  }

  private void renderMessageHelper(String s) {
    try {
      this.view.renderMessage(s);
    } catch (IOException e) {
      throw new IllegalStateException("Transmission to view failed");
    }
  }
}

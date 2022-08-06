package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * class for the text view of Marble Solitaire.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {
  protected final MarbleSolitaireModelState type;
  protected Appendable destination;

  /**
   * constructor for text view.
   *
   * @param type the Solitaire model state.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState type) {
    if (type == null) {
      throw new IllegalArgumentException("type cannot be null");
    }
    this.type = type;
    this.destination = System.out;
  }

  /**
   * constructor for Marble Solitaire Text View, takes in a destination.
   *
   * @param type        the model given.
   * @param destination the output of the information, usually a StringBuilder.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState type, Appendable destination) {
    if (type == null) {
      throw new IllegalArgumentException("type cannot be null");
    }
    if (destination == null) {
      throw new IllegalArgumentException("destination cannot be null");
    }
    this.type = type;
    this.destination = destination;
  }


  /**
   * displays the board.
   *
   * @return string rendition of board.
   */
  public String toString() {
    int boardSize = type.getBoardSize();
    int width = (boardSize + 2) / 3;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        if (type.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Invalid &&
                j < (width - 1)) {
          sb.append("  ");
        } else if (type.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble
                || type.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty) {
          try {
            if (type.getSlotAt(i, j + 1) == MarbleSolitaireModelState.SlotState.Invalid &&
                    i != boardSize - 1) {
              if (type.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
                sb.append("O\n");
              } else {
                sb.append("_\n");
              }
            } else if (i == boardSize - 1 &&
                    type.getSlotAt(i, j + 1) == MarbleSolitaireModelState.SlotState.Invalid) {
              if (type.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
                sb.append("O");
              } else {
                sb.append("_");
              }
            } else {
              if (type.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
                sb.append("O ");
              } else {
                sb.append("_ ");
              }
            }
          } catch (IndexOutOfBoundsException e) {
            if (type.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
              sb.append("O\n");
            } else {
              sb.append("_\n");
            }
          }

        }
      }
    }
    return sb.toString();
  }

  /**
   * Render the board to the provided data destination. The board should be rendered exactly
   * in the format produced by the toString method above
   *
   * @throws IOException if transmission of the board to the provided data destination fails
   */

  public void renderBoard() throws IOException {
    this.destination.append(this.toString());
  }

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */

  public void renderMessage(String message) throws IOException {
    this.destination.append(message);
  }
}

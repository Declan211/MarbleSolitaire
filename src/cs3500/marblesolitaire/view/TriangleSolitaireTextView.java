package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * class for the Triangle Solitaire Text View.
 */
public class TriangleSolitaireTextView extends MarbleSolitaireTextView {

  /**
   * constructor, initializes the model as the given type.
   *
   * @param type the model to be used.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState type) {
    super(type);
  }

  /**
   * constructor, initilizes the model as the given type and the
   * destination as the given destination.
   *
   * @param type        given model.
   * @param destination given output.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState type, Appendable destination) {
    super(type, destination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    int width = type.getBoardSize();
    for (int i = 0; i < width; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == i && i != width - 1 && i != 0) {
          if (type.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
            sb.append("O\n");
          } else if (type.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty) {
            sb.append("_\n");
          }
        } else if (j == 0 && i != width - 1) {
          StringBuilder spaces = new StringBuilder();
          for (int k = 1; k < width - i; k++) {
            spaces.append(" ");
          }
          if (i == 0 && j == 0) {
            if (type.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
              sb.append(spaces).append("O\n");
            } else {
              sb.append(spaces).append("_\n");
            }
          } else {
            if (type.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
              sb.append(spaces).append("O ");
            } else if (type.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty) {
              sb.append(spaces).append("_ ");
            }
          }
        } else if (i == width - 1 && j == width - 1) {
          if (type.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
            sb.append("O");
          } else {
            sb.append("_");
          }
        } else {
          if (type.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Marble) {
            sb.append("O ");
          } else if (type.getSlotAt(i, j) == MarbleSolitaireModelState.SlotState.Empty) {
            sb.append("_ ");
          }
        }
      }
    }
    return sb.toString();
  }
}

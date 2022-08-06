package cs3500.marblesolitaire.model.hw04;



/**
 * class for the European Solitaire Model.
 */
public class EuropeanSolitaireModel extends ASolitaireModel {

  /**
   * constructor for European Solitaire Model, initializes width as 3.
   * thickness - width of each side of board.
   */
  public EuropeanSolitaireModel() {
    super(3, 3, 3);
  }

  /**
   * constructor for European Solitaire Model,width at 3
   * and empty slot at given position. Throws exception if given slot is invalid.
   * sRow - empty row.
   * sColumn - empty Column.
   */
  public EuropeanSolitaireModel(int sRow, int sColumn) {
    super(3, sRow, sColumn);
  }

  /**
   * constructor for the European Solitaire Model. Initializes the width
   * as the given width and empty slot in the center. Throws exception if
   * arm thickness is not positive and odd.
   * thickness - arm thickness.
   */
  public EuropeanSolitaireModel(int thickness) {
    super(thickness, (thickness + (2 * (thickness - 1)) - 1) / 2,
            (thickness + (2 * (thickness - 1) - 1)) / 2);
    if (thickness % 2 != 1) {
      throw new IllegalArgumentException("thickness must be odd");
    }
  }

  /**
   * Constructor for European Solitaire Model. Throws an exception if the empty slot is invalid,
   * or if the thickness is not positive and odd.
   * thickness - board width
   * emptyRow - empty row.
   * emptyColumn - empty Column.
   */
  public EuropeanSolitaireModel(int thickness, int emptyRow, int emptyColumn) {
    super(thickness, emptyRow, emptyColumn);
    if (thickness % 2 != 1) {
      throw new IllegalArgumentException("thickness must be odd");
    }
  }

  @Override
  public void setSlots() {
    int size = this.getBoardSize();
    int middle = (size - 1) / 2;
    int outside = (thickness - 1) / 2;
    SlotState[][] slots = new SlotState[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if ((Math.abs(middle - j) > (middle - (Math.abs(middle - i)) + outside))) {
          slots[i][j] = SlotState.Invalid;
        } else {
          slots[i][j] = SlotState.Marble;
        }
      }
    }
    this.board = slots;
  }

}

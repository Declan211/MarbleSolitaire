package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.ASolitaireModel;


/**
 * represents the English Solitaire Model.
 */
public class EnglishSolitaireModel extends ASolitaireModel {
  /**
   * constructor for English Solitaire Model, initializes arm thickness as 3.
   * thickness - arm thickness.
   */
  public EnglishSolitaireModel() {
    super(3, 3, 3);
  }

  /**
   * constructor for English Solitaire Model, sets arm thickness at 3
   * and empty slot at given position. Throws exception if given slot is invalid.
   * sRow - empty row.
   * sColumn - empty Column.
   */
  public EnglishSolitaireModel(int sRow, int sColumn) {
    super(3, sRow, sColumn);
  }

  /**
   * constructor for the English Solitaire Model. Initializes the arm thickness
   * as the given width and empty slot in the center. Throws exception if
   * arm thickness is not positive and odd.
   * thickness - arm thickness.
   */
  public EnglishSolitaireModel(int thickness) {
    super(thickness, (thickness + (2 * (thickness - 1)) - 1) / 2,
            (thickness + (2 * (thickness - 1) - 1)) / 2);
    if (thickness % 2 != 1) {
      throw new IllegalArgumentException("thickness must be odd");
    }
  }

  /**
   * Constructor for English Solitaire Model. Throws an exception if the empty slot is invalid,
   * or if the thickness is not positive and odd.
   * thickness - arm thickness.
   * emptyRow - empty row.
   * emptyColumn - empty Column.
   */
  public EnglishSolitaireModel(int thickness, int emptyRow, int emptyColumn) {
    super(thickness, emptyRow, emptyColumn);
    if (thickness % 2 != 1) {
      throw new IllegalArgumentException("thickness must be odd");
    }
  }
}


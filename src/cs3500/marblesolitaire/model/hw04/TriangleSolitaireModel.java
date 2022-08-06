package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * class for the Triangle Solitaire Model.
 */
public class TriangleSolitaireModel extends ASolitaireModel {


  /**
   * constructor for Triangle Solitaire Model, initializes width as 5.
   */
  public TriangleSolitaireModel() {
    super(5, 0, 0);
  }

  /**
   * constructor for Triangle Solitaire Model, initializes width as given width, throws exception
   * if not positive.
   *
   * @param width width of bottom layer of triangle.
   */
  public TriangleSolitaireModel(int width) {
    super(width, 0, 0);
  }

  /**
   * A constructor with two parameters (row,col) that creates a 5-row
   * game with the empty slot at the specified position.
   */
  public TriangleSolitaireModel(int row, int column) {
    super(5, row, column);
  }

  /**
   * A constructor with three parameters (dimensions,row,col) that creates a game with
   * the specified dimension and an empty slot at the specified row and column.
   */
  public TriangleSolitaireModel(int width, int row, int column) {
    super(width, row, column);
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) {
    if (fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0 ||
            fromRow > this.getBoardSize() - 1 || fromCol > this.getBoardSize() - 1
            || toRow > this.getBoardSize() - 1 || toCol > this.getBoardSize() - 1) {
      throw new IllegalArgumentException("slots must be greater than 0 and less than board size");
    }
    if (this.board[fromRow][fromCol] == SlotState.Invalid ||
            this.board[toRow][toCol] == SlotState.Invalid) {
      throw new IllegalArgumentException("From and to slots must be valid");
    }
    if (this.board[fromRow][fromCol] == SlotState.Empty) {
      throw new IllegalArgumentException("From slot must have a marble");
    }
    if (this.board[toRow][toCol] != SlotState.Empty) {
      throw new IllegalArgumentException("To slot must be empty");
    }
    double v = (Math.pow(fromRow - toRow, 2)) + (Math.pow(fromCol - toCol, 2));
    if (!(v == 8 || v == 4)) {
      throw new IllegalArgumentException("Slots must be two spaces apart on board");
    }

    if (this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] != SlotState.Marble) {
      throw new IllegalArgumentException("Must be a marble between from and to slots");
    }
    this.board[fromRow][fromCol] = MarbleSolitaireModelState.SlotState.Empty;
    this.board[toRow][toCol] = MarbleSolitaireModelState.SlotState.Marble;
    this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] =
            MarbleSolitaireModelState.SlotState.Empty;
  }


  @Override
  public boolean isGameOver() {
    SlotState marble = SlotState.Marble;
    for (int i = 0; i < this.thickness; i++) {
      for (int j = 0; j < this.thickness; j++) {
        if (board[i][j] == SlotState.Empty) {
          if (i - j >= 2) {
            if ((this.board[i - 1][j] == marble && this.board[i - 2][j] == marble)
                    || (this.board[i][j + 1] == marble && this.board[i][j + 2] == marble)) {
              return false;
            }
          }
          if (j >= 2) {
            if (this.board[i][j - 1] == marble && this.board[i][j - 2] == marble) {
              return false;
            }
          }
          if (i < thickness - 2) {
            if ((this.board[i + 1][j] == marble && this.board[i + 2][j] == marble)
                    || (this.board[i + 1][j + 1] == marble && this.board[i + 2][j + 2] == marble)) {
              return false;
            }
          }
          if (i >= 2 && j >= 2) {
            if (this.board[i - 1][j - 1] == marble && this.board[i - 2][j - 2] == marble) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  @Override
  public int getBoardSize() {
    return this.thickness;
  }


  /**
   * sets the slots accordingly to either marble or invalid.
   */
  public void setSlots() {
    MarbleSolitaireModelState.SlotState[][] slots = new
            MarbleSolitaireModelState.SlotState[thickness][thickness];
    for (int i = 0; i < this.thickness; i++) {
      for (int j = 0; j < this.thickness; j++) {
        if (j <= i) {
          slots[i][j] = SlotState.Marble;
        } else {
          slots[i][j] = SlotState.Invalid;
        }
      }
    }
    this.board = slots;
  }
}

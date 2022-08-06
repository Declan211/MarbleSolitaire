package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * abstract class for the SolitaireModel.
 */
public abstract class ASolitaireModel implements MarbleSolitaireModel {
  protected final int thickness;
  protected MarbleSolitaireModelState.SlotState[][] board;


  /**
   * Constructor for Solitaire Model. Throws an exception if the empty slot is invalid,
   * or if the thickness is not positive and odd.
   * thickness - arm thickness/ width.
   * emptyRow - empty row.
   * emptyColumn - empty Column.
   */
  public ASolitaireModel(int thickness, int emptyRow, int emptyColumn) {

    if (thickness <= 0) {
      throw new IllegalArgumentException("Arm thickness must be positive");
    }
    this.thickness = thickness;
    if (emptyRow < 0 || emptyRow >= this.getBoardSize() || emptyColumn < 0
            || emptyColumn >= this.getBoardSize()) {
      throw new IllegalArgumentException("slot must exist");
    }
    this.setSlots();

    if (board[emptyRow][emptyColumn] == MarbleSolitaireModelState.SlotState.Invalid) {
      throw new IllegalArgumentException("Invalid empty cell position (r,c)");
    }

    board[emptyRow][emptyColumn] = MarbleSolitaireModelState.SlotState.Empty;
  }


  /**
   * Move a single marble from a given position to another given position.
   * A move is valid only if the from and to positions are valid. Specific
   * implementations may place additional constraints on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   */
  public void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    if (fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0 ||
            fromRow > this.getBoardSize() - 1 || fromCol > this.getBoardSize() - 1
            || toRow > this.getBoardSize() - 1 || toCol > this.getBoardSize() - 1) {
      throw new IllegalArgumentException("slots must be greater than 0 and less than board size");
    }
    if (this.board[fromRow][fromCol] == MarbleSolitaireModelState.SlotState.Invalid ||
            this.board[toRow][toCol] == MarbleSolitaireModelState.SlotState.Invalid) {
      throw new IllegalArgumentException("From and to slots must be valid");
    }
    if (this.board[fromRow][fromCol] == MarbleSolitaireModelState.SlotState.Empty) {
      throw new IllegalArgumentException("From slot must have a marble");
    }
    if (this.board[toRow][toCol] != MarbleSolitaireModelState.SlotState.Empty) {
      throw new IllegalArgumentException("To slot must be empty");
    }
    if (!(Math.abs(fromRow - toRow) == 0 && Math.abs(fromCol - toCol) == 2)
            && (!(Math.abs(fromRow - toRow) == 2 && Math.abs(fromCol - toCol) == 0))) {
      throw new IllegalArgumentException("to and from positions must be exactly two spaces apart");
    }
    if (this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] !=
            MarbleSolitaireModelState.SlotState.Marble) {
      throw new IllegalArgumentException("Must be a marble between from and to slots");
    }
    this.board[fromRow][fromCol] = MarbleSolitaireModelState.SlotState.Empty;
    this.board[toRow][toCol] = MarbleSolitaireModelState.SlotState.Marble;
    this.board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] =
            MarbleSolitaireModelState.SlotState.Empty;
  }

  /**
   * determines if game is over.
   *
   * @return true if yes, false if no.
   */
  public boolean isGameOver() {
    int width = this.thickness + (2 * (this.thickness - 1));
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (board[i][j] == MarbleSolitaireModelState.SlotState.Empty) {
          if (i >= 2) {
            if ((board[i - 1][j] == MarbleSolitaireModelState.SlotState.Marble &&
                    board[i - 2][j] == MarbleSolitaireModelState.SlotState.Marble)) {
              return false;
            }
          }
          if (i < width - 2) {
            if ((board[i + 1][j] == MarbleSolitaireModelState.SlotState.Marble &&
                    board[i + 2][j] == MarbleSolitaireModelState.SlotState.Marble)) {
              return false;
            }
          }
          if (j >= 2) {
            if ((board[i][j - 1] == MarbleSolitaireModelState.SlotState.Marble &&
                    board[i][j - 2] == MarbleSolitaireModelState.SlotState.Marble)) {
              return false;
            }
          }
          if (j < width - 2) {
            if ((board[i][j + 1] == MarbleSolitaireModelState.SlotState.Marble &&
                    board[i][j + 2] == MarbleSolitaireModelState.SlotState.Marble)) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }


  /**
   * gets the board size.
   *
   * @return the width of the entire board.
   */
  public int getBoardSize() {
    return this.thickness + (2 * (this.thickness - 1));
  }

  /**
   * gets the slot state at a given slot.
   *
   * @param row given row.
   * @param col given column.
   * @return the slot state.
   * @throws IllegalArgumentException if the row or the column are beyond the board.
   */
  public MarbleSolitaireModelState.SlotState getSlotAt(int row, int col)
          throws IllegalArgumentException {
    return this.board[row][col];
  }

  /**
   * gets the score of the game.
   *
   * @return the score.
   */
  public int getScore() {
    int sum = 0;
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (this.board[i][j] == MarbleSolitaireModelState.SlotState.Marble) {
          sum = sum + 1;
        } else {
          sum = sum + 0;
        }
      }
    }
    return sum;
  }

  /**
   * Sets the slots accordingly to marble or invalid.
   */
  public void setSlots() {
    int width = this.thickness + (2 * (this.thickness - 1));
    MarbleSolitaireModelState.SlotState[][] slots = new
            MarbleSolitaireModelState.SlotState[width][width];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < width; j++) {
        if ((i > thickness - 2 && i < width - (this.thickness - 1))
                || (j > thickness - 2 && j < width - (this.thickness - 1))) {
          slots[i][j] = MarbleSolitaireModelState.SlotState.Marble;
        } else {
          slots[i][j] = MarbleSolitaireModelState.SlotState.Invalid;
        }
      }
    }
    this.board = slots;
  }
}

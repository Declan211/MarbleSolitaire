import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * class for mock model.
 */
public class MarbleSolitaireMock implements MarbleSolitaireModel {
  private StringBuilder output;

  public MarbleSolitaireMock(StringBuilder output) {
    this.output = output;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    output.append("move");
  }


  @Override
  public boolean isGameOver() {
    output.append("game over");
    return false;
  }


  public void setSlots() {
    return;

  }


  @Override
  public int getBoardSize() {
    return 7;
  }


  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return null;
  }

  @Override
  public int getScore() {
    output.append("getScore");
    return 0;
  }
}

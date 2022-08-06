package cs3500.marblesolitaire.model.hw04;

import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * test class for the Triangle Solitaire Text View.
 */
public class TriangleSolitaireTextViewTest {
  @Test
  public void testToString() {
    MarbleSolitaireModel model1 = new TriangleSolitaireModel(7);
    MarbleSolitaireView view1 = new TriangleSolitaireTextView(model1);
    assertEquals("      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", view1.toString());
    model1.move(2, 2, 0, 0);
    assertEquals("      O\n" +
            "     O _\n" +
            "    O O _\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", view1.toString());
    model1.move(2, 0, 2, 2);
    assertEquals("      O\n" +
            "     O _\n" +
            "    _ _ O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", view1.toString());
    model1.move(4, 3, 2, 1);
    assertEquals("      O\n" +
            "     O _\n" +
            "    _ O O\n" +
            "   O O _ O\n" +
            "  O O O _ O\n" +
            " O O O O O O\n" +
            "O O O O O O O", view1.toString());
  }

  @Test
  public void testRenderBoard() throws IOException {
    MarbleSolitaireModel model1 = new TriangleSolitaireModel(7);
    StringBuilder log = new StringBuilder();
    MarbleSolitaireView view1 = new TriangleSolitaireTextView(model1, log);
    view1.renderBoard();
    assertEquals("      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", log.toString());
    model1.move(2, 2, 0, 0);
    view1.renderMessage("Hello");
    assertEquals("      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O OHello", log.toString());
  }

}
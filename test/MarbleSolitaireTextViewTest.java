import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * class for testing MarbleSolitaireTextView.
 */
public class MarbleSolitaireTextViewTest {
  @org.junit.Test
  public void testInvalidInitialization() {
    try {
      MarbleSolitaireView nullify = new MarbleSolitaireTextView(null);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("type cannot be null")) {
        fail("Wrong exception thrown");
      }
    }
  }

  @org.junit.Test
  public void testToString() {
    MarbleSolitaireModel model1 = new EnglishSolitaireModel(3);
    MarbleSolitaireView view1 = new MarbleSolitaireTextView(model1);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", view1.toString());
    model1.move(5, 3, 3, 3);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O", view1.toString());
    MarbleSolitaireModel model2 = new EuropeanSolitaireModel(3);
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(model2);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", view2.toString());
    model2.move(5, 3, 3, 3);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "  O O _ O O\n" +
            "    O O O", view2.toString());
  }

  @org.junit.Test
  public void testRenderBoard() {
    MarbleSolitaireModel model1 = new EnglishSolitaireModel(3);
    StringBuilder log = new StringBuilder();
    MarbleSolitaireView view1 = new MarbleSolitaireTextView(model1, log);
    try {
      view1.renderBoard();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O", log.toString());
      view1.renderMessage("Hello");
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O OHello", log.toString());
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
    MarbleSolitaireModel model2 = new EuropeanSolitaireModel(3);
    StringBuilder log2 = new StringBuilder();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(model2, log2);
    try {
      view2.renderBoard();
      assertEquals("    O O O\n" +
              "  O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "  O O O O O\n" +
              "    O O O", log2.toString());
      view2.renderMessage("Hello");
      assertEquals("    O O O\n" +
              "  O O O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "  O O O O O\n" +
              "    O O OHello", log2.toString());
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
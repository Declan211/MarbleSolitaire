import org.junit.Test;


import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * test class for Marble Solitiare Controller.
 */
public class MarbleSolitaireControllerImplTest {

  @Test
  public void testInValidInitialization() {
    MarbleSolitaireModel model = new EnglishSolitaireModel(3);
    StringBuilder out = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MarbleSolitaireMock mock = new MarbleSolitaireMock(log);
    MarbleSolitaireView view = new MarbleSolitaireTextView(mock, log);
    Reader input = new StringReader("1 2 3 4");
    try {
      MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(null, null, input);
      MarbleSolitaireController controller2 = new MarbleSolitaireControllerImpl(model, view, null);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("cannot be null")) {
        fail("Wrong exception thrown");
      }
    }
  }

  @Test
  public void testConfirmInputs() {
    StringBuilder out = new StringBuilder();
    StringBuilder log = new StringBuilder();
    MarbleSolitaireMock mock = new MarbleSolitaireMock(log);
    MarbleSolitaireView view = new MarbleSolitaireTextView(mock, log);
    Reader input = new StringReader("3 1 3 3 3 4 3 2 3 6 3 4 5 3 3 3 2 3 4 3 0 3 2 3 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(mock, view, input);
    controller.playGame();
    assertTrue(log.toString().contains("move"));
    assertTrue(log.toString().contains("game over"));
    assertTrue(log.toString().contains("getScore"));
  }

  @Test
  public void testPlayGame() {
    MarbleSolitaireModel model1 = new EnglishSolitaireModel(3);
    StringBuilder log = new StringBuilder();
    MarbleSolitaireView view1 = new MarbleSolitaireTextView(model1, log);
    StringReader input1 = new StringReader("q");
    MarbleSolitaireController control1 = new MarbleSolitaireControllerImpl(model1, view1, input1);
    control1.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", log.toString());
    MarbleSolitaireModel model2 = new EnglishSolitaireModel(3);
    StringBuilder log2 = new StringBuilder();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(model2, log2);
    StringReader input2 = new StringReader("1 Q");
    MarbleSolitaireController control2 = new MarbleSolitaireControllerImpl(model2, view2, input2);
    control2.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", log2.toString());
    MarbleSolitaireModel model3 = new EnglishSolitaireModel(3);
    StringBuilder log3 = new StringBuilder();
    MarbleSolitaireView view3 = new MarbleSolitaireTextView(model3, log3);
    StringReader input3 = new StringReader("2 4 4 4 q");
    MarbleSolitaireController control3 = new MarbleSolitaireControllerImpl(model3, view3, input3);
    control3.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31", log3.toString());
    MarbleSolitaireModel model4 = new EnglishSolitaireModel(3);
    StringBuilder log4 = new StringBuilder();
    MarbleSolitaireView view4 = new MarbleSolitaireTextView(model4, log4);
    StringReader input4 = new StringReader("2 4 4 4 5 4 3 4 q");
    MarbleSolitaireController control4 = new MarbleSolitaireControllerImpl(model4, view4, input4);
    control4.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O _ O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O _ O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30", log4.toString());
  }

  @Test
  public void testPlayGame2() {
    MarbleSolitaireModel model = new EnglishSolitaireModel(3);
    StringBuilder log = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    StringReader input = new StringReader("w  1 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, input);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again.\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", log.toString());
    MarbleSolitaireModel model2 = new EnglishSolitaireModel(3);
    StringBuilder log2 = new StringBuilder();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(model2, log2);
    StringReader input2 = new StringReader("1 1 1 q");
    MarbleSolitaireController control2 = new MarbleSolitaireControllerImpl(model2, view2, input2);
    control2.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", log2.toString());
    MarbleSolitaireModel model3 = new EnglishSolitaireModel(3);
    StringBuilder log3 = new StringBuilder();
    MarbleSolitaireView view3 = new MarbleSolitaireTextView(model3, log3);
    StringReader input3 = new StringReader("-1 q");
    MarbleSolitaireController control3 = new MarbleSolitaireControllerImpl(model3, view3, input3);
    control3.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again.\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", log3.toString());
    MarbleSolitaireModel model4 = new EnglishSolitaireModel(3);
    StringBuilder log4 = new StringBuilder();
    MarbleSolitaireView view4 = new MarbleSolitaireTextView(model4, log4);
    StringReader input4 = new StringReader("4 6 4 4 0 q");
    MarbleSolitaireController control4 = new MarbleSolitaireControllerImpl(model4, view4, input4);
    control4.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Invalid move. Play again.\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31", log4.toString());
    MarbleSolitaireModel model5 = new EnglishSolitaireModel(3);
    StringBuilder log5 = new StringBuilder();
    MarbleSolitaireView view5 = new MarbleSolitaireTextView(model5, log5);
    StringReader input5 = new StringReader("4 2 4 4 4 5 4 3 4 7 4 5 6 4 4 4 3 4 5 4 1 4 3 4");
    MarbleSolitaireController control5 = new MarbleSolitaireControllerImpl(model5, view5, input5);
    control5.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O _ _ O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O _ O _ _\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O _ _\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O _ O O O\n" +
            "O _ O _ O _ _\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ O _ _\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 26\n" +
            "Game over!\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ O _ _\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 26", log5.toString());
  }

  @Test
  public void testPlayGame3() {
    MarbleSolitaireModel model = new EnglishSolitaireModel(3);
    StringBuilder log = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    StringReader input = new StringReader("q q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, input);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", log.toString());
    MarbleSolitaireModel model2 = new EnglishSolitaireModel(3);
    StringBuilder log2 = new StringBuilder();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(model2, log2);
    StringReader input2 = new StringReader("0.6, q");
    MarbleSolitaireController control2 = new MarbleSolitaireControllerImpl(model2, view2, input2);
    control2.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again.\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", log2.toString());
    MarbleSolitaireModel model3 = new EnglishSolitaireModel(3);
    StringBuilder log3 = new StringBuilder();
    MarbleSolitaireView view3 = new MarbleSolitaireTextView(model3, log3);
    StringReader input3 = new StringReader("2, 4, 4, 4, q");
    MarbleSolitaireController control3 = new MarbleSolitaireControllerImpl(model3, view3, input3);
    control3.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again.\n" +
            "Invalid move. Play again.\n" +
            "Invalid move. Play again.\n" +
            "Invalid move. Play again.\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32", log3.toString());
  }

  @Test
  public void testPlayGameExceptions() {
    MarbleSolitaireModel model = new EnglishSolitaireModel(3);
    StringBuilder log = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, log);
    StringReader input = new StringReader("2 4 4 4 6");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, input);
    try {
      controller.playGame();
      fail("Should have thrown an IllegalStateException");
    } catch (IllegalStateException e) {
      if (!e.getMessage().equals("Run out of inputs")) {
        fail("Wrong exception thrown");
      }
    }
    MarbleSolitaireModel model2 = new EnglishSolitaireModel(3);
    StringBuilder log2 = new StringBuilder();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(model2, log2);
    StringReader input2 = new StringReader("w -1");
    MarbleSolitaireController control2 = new MarbleSolitaireControllerImpl(model2, view2, input2);
    try {
      control2.playGame();
      fail("Should have thrown an IllegalStateException");
    } catch (IllegalStateException e) {
      if (!e.getMessage().equals("Run out of inputs")) {
        fail("Wrong exception thrown");
      }
    }
    MarbleSolitaireModel model3 = new EnglishSolitaireModel(3);
    StringBuilder log3 = new StringBuilder();
    MarbleSolitaireView view3 = new MarbleSolitaireTextView(model3, log3);
    StringReader input3 = new StringReader("");
    MarbleSolitaireController control3 = new MarbleSolitaireControllerImpl(model3, view3, input3);
    try {
      control3.playGame();
      fail("Should have thrown an IllegalStateException");
    } catch (IllegalStateException e) {
      if (!e.getMessage().equals("Run out of inputs")) {
        fail("Wrong exception thrown");
      }
    }
    MarbleSolitaireModel model4 = new EnglishSolitaireModel(3);
    CorruptClassAppendable corruptAppend = new CorruptClassAppendable();
    CorruptClassReadable corruptRead = new CorruptClassReadable();
    MarbleSolitaireView view4 = new MarbleSolitaireTextView(model4, corruptAppend);
    StringReader input4 = new StringReader("2 4 4 4 q");
    MarbleSolitaireController control4 =
            new MarbleSolitaireControllerImpl(model4, view4, corruptRead);
    try {
      control4.playGame();
      fail("Should have thrown an IOException");
    } catch (IllegalStateException e) {
      if (!e.getMessage().equals("Transmission to view failed")) {
        fail("Wrong exception thrown");
      }
    }
  }


}
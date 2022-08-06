import org.junit.Test;


import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * class for testing English Solitaire Model.
 */
public class EnglishSolitaireModelTest {


  @Test
  public void testValidInitialization() {


    MarbleSolitaireModel model1 = new EnglishSolitaireModel();
    MarbleSolitaireModel model2 = new EnglishSolitaireModel(3);
    MarbleSolitaireModel model3 = new EnglishSolitaireModel(3, 3);
    MarbleSolitaireModel model4 = new EnglishSolitaireModel(5, 6, 6);
    assertEquals(7, model1.getBoardSize());
    assertEquals(7, model2.getBoardSize());
    assertEquals(7, model3.getBoardSize());
    assertEquals(13, model4.getBoardSize());
  }


  @org.junit.Test
  public void testInvalidInitialization() {
    try {
      MarbleSolitaireModel invalidEmpty = new EnglishSolitaireModel(0, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Invalid empty cell position (r,c)")) {
        fail("Wrong exception thrown");
      }
    }
    try {
      MarbleSolitaireModel even = new EnglishSolitaireModel(2);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("thickness must be odd")) {
        fail("Wrong exception thrown");
      }
    }
    try {
      MarbleSolitaireModel invalidEmpty = new EnglishSolitaireModel(2);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("thickness must be odd")) {
        fail("Wrong exception thrown");
      }
    }
    try {
      MarbleSolitaireModel negative = new EnglishSolitaireModel(-3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Arm thickness must be positive")) {
        fail("Wrong exception thrown");
      }
    }
    try {
      MarbleSolitaireModel invalidEmpty2 = new EnglishSolitaireModel(3, 6, 6);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Invalid empty cell position (r,c)")) {
        fail("Wrong exception thrown");
      }
    }
  }

  @org.junit.Test
  public void testMove() {
    MarbleSolitaireModel model1 = new EnglishSolitaireModel(3);
    assertEquals(MarbleSolitaireModel.SlotState.Marble, model1.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModel.SlotState.Marble, model1.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModel.SlotState.Empty, model1.getSlotAt(3, 3));
    model1.move(1, 3, 3, 3);
    assertEquals(MarbleSolitaireModel.SlotState.Empty, model1.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModel.SlotState.Empty, model1.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModel.SlotState.Marble, model1.getSlotAt(3, 3));
    model1.move(4, 3, 2, 3);
    assertEquals(MarbleSolitaireModel.SlotState.Empty, model1.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModel.SlotState.Empty, model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModel.SlotState.Marble, model1.getSlotAt(2, 3));
    model1.move(3, 1, 3, 3);
    assertEquals(MarbleSolitaireModel.SlotState.Empty, model1.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModel.SlotState.Empty, model1.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModel.SlotState.Marble, model1.getSlotAt(3, 3));
    model1.move(3, 4, 3, 2);
    assertEquals(MarbleSolitaireModel.SlotState.Empty, model1.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModel.SlotState.Empty, model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModel.SlotState.Marble, model1.getSlotAt(3, 2));

    MarbleSolitaireModel model2 = new EnglishSolitaireModel(3);
    try {
      model2.move(0, 0, 0, 2);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("From and to slots must be valid")) {
        fail("Wrong exception thrown");
      }
    }
    try {
      model2.move(0, 2, 0, 4);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("To slot must be empty")) {
        fail("Wrong exception thrown");
      }
    }
    try {
      model2.move(3, 3, 1, 3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("From slot must have a marble")) {
        fail("Wrong exception thrown");
      }
    }
    try {
      model2.move(3, 3, 1, 3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("From slot must have a marble")) {
        fail("Wrong exception thrown");
      }
    }
    try {
      model2.move(6, 3, 3, 3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("to and from positions must be exactly two spaces apart")) {
        fail("Wrong exception thrown");
      }
    }
    model2.move(5, 3, 3, 3);
    try {
      model2.move(6, 3, 4, 3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Must be a marble between from and to slots")) {
        fail("Wrong exception thrown");
      }
    }
  }

  @org.junit.Test
  public void testIsGameOver() {
    MarbleSolitaireModel model1 = new EnglishSolitaireModel(3);
    assertFalse(model1.isGameOver());
    model1.move(3, 1, 3, 3);
    assertFalse(model1.isGameOver());
    model1.move(3, 4, 3, 2);
    assertFalse(model1.isGameOver());
    model1.move(3, 6, 3, 4);
    assertFalse(model1.isGameOver());
    model1.move(5, 3, 3, 3);
    assertFalse(model1.isGameOver());
    model1.move(2, 3, 4, 3);
    assertFalse(model1.isGameOver());
    model1.move(0, 3, 2, 3);
    assertTrue(model1.isGameOver());

  }

  @org.junit.Test
  public void testGetBoardSize() {
    MarbleSolitaireModel model1 = new EnglishSolitaireModel(3);
    MarbleSolitaireModel model2 = new EnglishSolitaireModel(5);
    MarbleSolitaireModel model3 = new EnglishSolitaireModel(15);
    assertEquals(7, model1.getBoardSize());
    assertEquals(13, model2.getBoardSize());
    assertEquals(43, model3.getBoardSize());
  }

  @org.junit.Test
  public void testGetSlotAt() {
    MarbleSolitaireModel model1 = new EnglishSolitaireModel(3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(5, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model1.getSlotAt(0, 1));
  }

  @org.junit.Test
  public void testGetScore() {
    MarbleSolitaireModel model1 = new EnglishSolitaireModel();
    MarbleSolitaireModel model2 = new EnglishSolitaireModel(5);
    assertEquals(32, model1.getScore());
    assertEquals(104, model2.getScore());

  }

  @org.junit.Test
  public void testSetSlots() {
    MarbleSolitaireModel model1 = new EnglishSolitaireModel(3);
    MarbleSolitaireModel model2 = new EnglishSolitaireModel(5);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(5, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model1.getSlotAt(0, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model1.getSlotAt(6, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model1.getSlotAt(1, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model2.getSlotAt(4, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model2.getSlotAt(8, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model2.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model2.getSlotAt(12, 9));
  }
}
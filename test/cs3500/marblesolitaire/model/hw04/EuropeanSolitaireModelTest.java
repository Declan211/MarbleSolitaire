package cs3500.marblesolitaire.model.hw04;


import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * test class for the European Solitaire Model.
 */
public class EuropeanSolitaireModelTest {

  @Test
  public void testValidInitialization() {
    MarbleSolitaireModel model1 = new EuropeanSolitaireModel();
    MarbleSolitaireModel model2 = new EuropeanSolitaireModel(3);
    MarbleSolitaireModel model3 = new EuropeanSolitaireModel(3, 3);
    MarbleSolitaireModel model4 = new EuropeanSolitaireModel(5, 6, 6);
    assertEquals(7, model1.getBoardSize());
    assertEquals(7, model2.getBoardSize());
    assertEquals(7, model3.getBoardSize());
    assertEquals(13, model4.getBoardSize());
  }

  @org.junit.Test
  public void testInvalidInitialization() {
    try {
      MarbleSolitaireModel invalidEmpty = new EuropeanSolitaireModel(0, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Invalid empty cell position (r,c)")) {
        fail("Wrong exception thrown");
      }
    }
    try {
      MarbleSolitaireModel even = new EuropeanSolitaireModel(2);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("thickness must be odd")) {
        fail("Wrong exception thrown");
      }
    }
    try {
      MarbleSolitaireModel invalidEmpty = new EuropeanSolitaireModel(2);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("thickness must be odd")) {
        fail("Wrong exception thrown");
      }
    }
    try {
      MarbleSolitaireModel negative = new EuropeanSolitaireModel(-3);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Arm thickness must be positive")) {
        fail("Wrong exception thrown");
      }
    }
    try {
      MarbleSolitaireModel invalidEmpty2 = new EuropeanSolitaireModel(3, 6, 6);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Invalid empty cell position (r,c)")) {
        fail("Wrong exception thrown");
      }
    }
  }

  @org.junit.Test
  public void testMove() {
    MarbleSolitaireModel model1 = new EuropeanSolitaireModel(3);
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

    MarbleSolitaireModel model3 = new EuropeanSolitaireModel(3);
    model3.move(1, 3, 3, 3);
    assertEquals(MarbleSolitaireModel.SlotState.Empty, model3.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModel.SlotState.Empty, model3.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModel.SlotState.Marble, model3.getSlotAt(3, 3));
    model3.move(1, 5, 1, 3);
    assertEquals(MarbleSolitaireModel.SlotState.Empty, model3.getSlotAt(1, 5));
    assertEquals(MarbleSolitaireModel.SlotState.Empty, model3.getSlotAt(1, 4));
    assertEquals(MarbleSolitaireModel.SlotState.Marble, model3.getSlotAt(1, 3));
    MarbleSolitaireModel model2 = new EuropeanSolitaireModel(3);
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
  public void testGetBoardSize() {
    MarbleSolitaireModel model1 = new EuropeanSolitaireModel(3);
    MarbleSolitaireModel model2 = new EuropeanSolitaireModel(5);
    MarbleSolitaireModel model3 = new EuropeanSolitaireModel(15);
    assertEquals(7, model1.getBoardSize());
    assertEquals(13, model2.getBoardSize());
    assertEquals(43, model3.getBoardSize());
  }

  @org.junit.Test
  public void testGetSlotAt() {
    MarbleSolitaireModel model1 = new EuropeanSolitaireModel(3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(5, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model1.getSlotAt(0, 1));
  }

  @org.junit.Test
  public void testGetScore() {
    MarbleSolitaireModel model1 = new EuropeanSolitaireModel();
    MarbleSolitaireModel model2 = new EuropeanSolitaireModel(5);
    assertEquals(36, model1.getScore());
    assertEquals(128, model2.getScore());
  }

  @org.junit.Test
  public void testIsGameOver() {
    MarbleSolitaireModel model1 = new EuropeanSolitaireModel(3);
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
    assertFalse(model1.isGameOver());
    model1.move(5, 1, 3, 1);
    model1.move(1, 5, 3, 5);
    model1.move(2, 1, 4, 1);
    model1.move(4, 5, 2, 5);
    model1.move(5, 5, 5, 3);
    model1.move(5, 2, 5, 4);
    model1.move(4, 3, 4, 5);
    model1.move(4, 1, 4, 3);
    model1.move(4, 6, 4, 4);
    model1.move(4, 3, 4, 5);
    model1.move(2, 2, 4, 2);
    model1.move(0, 2, 2, 2);
    model1.move(2, 3, 2, 1);
    model1.move(1, 1, 3, 1);
    model1.move(3, 0, 3, 2);
    model1.move(4, 2, 2, 2);
    model1.move(2, 4, 4, 4);
    model1.move(5, 4, 3, 4);
    model1.move(2, 6, 2, 4);
    model1.move(2, 4, 4, 4);
    model1.move(0, 4, 2, 4);
    model1.move(4, 5, 4, 3);
    assertTrue(model1.isGameOver());


  }

  @Test
  public void testSetSlots() {
    MarbleSolitaireModel model1 = new EuropeanSolitaireModel(3);
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(1, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model1.getSlotAt(6, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(5, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(5, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(6, 2));
  }


}
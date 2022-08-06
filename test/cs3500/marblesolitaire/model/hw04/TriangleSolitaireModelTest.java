package cs3500.marblesolitaire.model.hw04;

import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * test class for Triangle Solitaire Model.
 */
public class TriangleSolitaireModelTest {
  @Test
  public void testValidInitialization() {
    MarbleSolitaireModel model1 = new TriangleSolitaireModel(5);
    assertEquals(5, model1.getBoardSize());
    assertEquals(14, model1.getScore());
    MarbleSolitaireModel model2 = new TriangleSolitaireModel(5, 0, 0);
    assertEquals(5, model2.getBoardSize());
    assertEquals(14, model2.getScore());
    MarbleSolitaireModel model3 = new TriangleSolitaireModel(0, 0);
    assertEquals(5, model3.getBoardSize());
    assertEquals(14, model3.getScore());
    MarbleSolitaireModel model4 = new TriangleSolitaireModel();
    assertEquals(5, model4.getBoardSize());
    assertEquals(14, model4.getScore());
  }

  @Test
  public void testInvalidInitialization() {
    try {
      MarbleSolitaireModel model1 = new EnglishSolitaireModel(5, 0, 1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Invalid empty cell position (r,c)")) {
        fail("Wrong exception thrown");
      }
    }
    try {
      MarbleSolitaireModel model2 = new EnglishSolitaireModel(-1, 0, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Arm thickness must be positive")) {
        fail("Wrong exception thrown");
      }
    }
    try {
      MarbleSolitaireModel model2 = new EnglishSolitaireModel(0, 1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Invalid empty cell position (r,c)")) {
        fail("Wrong exception thrown");
      }
    }
  }

  @Test
  public void testSetSlots() {
    MarbleSolitaireModel model1 = new TriangleSolitaireModel(5);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(3, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(4, 4));
  }

  @Test
  public void testMove() {
    MarbleSolitaireModel model1 = new TriangleSolitaireModel(5);
    model1.move(2, 0, 0, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(0, 0));
    model1.move(2, 2, 2, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(2, 0));
    model1.move(3, 0, 1, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(1, 0));
    model1.move(4, 3, 2, 1);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(2, 1));
    model1.move(1, 0, 3, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(1, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(3, 2));
    model1.move(4, 1, 4, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(4, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(4, 3));
    model1.move(4, 4, 2, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(2, 2));
    model1.move(2, 2, 4, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(4, 2));

    MarbleSolitaireModel model2 = new TriangleSolitaireModel(5);
    try {
      model2.move(-1, 0, 0, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("slots must be greater than 0 and less than board size")) {
        fail("Wrong exception thrown");
      }
    }
    try {
      model2.move(0, 1, 0, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("From and to slots must be valid")) {
        fail("Wrong exception thrown");
      }
    }
    try {
      model2.move(0, 0, 0, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("From slot must have a marble")) {
        fail("Wrong exception thrown");
      }
    }
    try {
      model2.move(0, 0, 0, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("From slot must have a marble")) {
        fail("Wrong exception thrown");
      }
    }
    model2.move(2, 0, 0, 0);
    try {
      model2.move(3, 0, 1, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("Must be a marble between from and to slots")) {
        fail("Wrong exception thrown");
      }
    }
  }

  @Test
  public void testIsGameOver() {
    MarbleSolitaireModel model1 = new TriangleSolitaireModel(5);
    model1.move(2, 0, 0, 0);
    assertFalse(model1.isGameOver());
    model1.move(3, 2, 1, 0);
    assertFalse(model1.isGameOver());
    model1.move(4, 0, 2, 0);
    assertFalse(model1.isGameOver());
    model1.move(1, 0, 3, 0);
    assertFalse(model1.isGameOver());
    model1.move(4, 2, 2, 0);
    assertFalse(model1.isGameOver());
    model1.move(2, 0, 4, 0);
    assertFalse(model1.isGameOver());
    model1.move(4, 0, 4, 2);
    assertFalse(model1.isGameOver());
    model1.move(4, 3, 4, 1);
    assertTrue(model1.isGameOver());
  }

  @Test
  public void testGetScore() {
    MarbleSolitaireModel model1 = new TriangleSolitaireModel(5);
    assertEquals(14, model1.getScore());
    model1.move(2, 0, 0, 0);
    assertEquals(13, model1.getScore());
  }


}
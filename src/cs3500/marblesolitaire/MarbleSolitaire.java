package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * plays the game.
 */
public final class MarbleSolitaire {

  /**
   * takes in the arguments.
   * args - inputs
   */
  public static void main(String[] args) {
    if (args.length == 1) {
      if (args[0].equals("english")) {
        MarbleSolitaireModel model1 = new EnglishSolitaireModel();
        MarbleSolitaireView view1 = new MarbleSolitaireTextView(model1);
        Readable reader = new InputStreamReader(System.in);
        MarbleSolitaireController controller = new
                MarbleSolitaireControllerImpl(model1, view1, reader);
        controller.playGame();
      } else if (args[0].equals("european")) {
        MarbleSolitaireModel model1 = new EuropeanSolitaireModel();
        MarbleSolitaireView view1 = new MarbleSolitaireTextView(model1);
        Readable reader = new InputStreamReader(System.in);
        MarbleSolitaireController controller = new
                MarbleSolitaireControllerImpl(model1, view1, reader);
        controller.playGame();
      } else if (args[0].equals("triangular")) {
        MarbleSolitaireModel model1 = new TriangleSolitaireModel();
        MarbleSolitaireView view1 = new TriangleSolitaireTextView(model1);
        Readable reader = new InputStreamReader(System.in);
        MarbleSolitaireController controller = new
                MarbleSolitaireControllerImpl(model1, view1, reader);
        controller.playGame();
      }

    } else if (args.length == 3) {
      if (args[0].equals("english")) {
        MarbleSolitaireModel model1 = new EnglishSolitaireModel(Integer.parseInt(args[2]));
        MarbleSolitaireView view1 = new MarbleSolitaireTextView(model1);
        Readable reader = new InputStreamReader(System.in);
        MarbleSolitaireController controller = new
                MarbleSolitaireControllerImpl(model1, view1, reader);
        controller.playGame();
      } else if (args[0].equals("european")) {
        MarbleSolitaireModel model1 = new EuropeanSolitaireModel(Integer.parseInt(args[2]));
        MarbleSolitaireView view1 = new MarbleSolitaireTextView(model1);
        Readable reader = new InputStreamReader(System.in);
        MarbleSolitaireController controller = new
                MarbleSolitaireControllerImpl(model1, view1, reader);
        controller.playGame();
      } else if (args[0].equals("triangular")) {
        MarbleSolitaireModel model1 = new TriangleSolitaireModel(Integer.parseInt(args[2]));
        MarbleSolitaireView view1 = new TriangleSolitaireTextView(model1);
        Readable reader = new InputStreamReader(System.in);
        MarbleSolitaireController controller = new
                MarbleSolitaireControllerImpl(model1, view1, reader);
        controller.playGame();
      }
    } else if (args.length == 4) {
      if (args[0].equals("english")) {
        MarbleSolitaireModel model1 = new EnglishSolitaireModel(Integer.parseInt(args[2],
                Integer.parseInt(args[3])));
        MarbleSolitaireView view1 = new MarbleSolitaireTextView(model1);
        Readable reader = new InputStreamReader(System.in);
        MarbleSolitaireController controller = new
                MarbleSolitaireControllerImpl(model1, view1, reader);
        controller.playGame();
      } else if (args[0].equals("european")) {
        MarbleSolitaireModel model1 = new EuropeanSolitaireModel(Integer.parseInt(args[2]),
                Integer.parseInt(args[3]));
        MarbleSolitaireView view1 = new MarbleSolitaireTextView(model1);
        Readable reader = new InputStreamReader(System.in);
        MarbleSolitaireController controller = new
                MarbleSolitaireControllerImpl(model1, view1, reader);
        controller.playGame();
      } else if (args[0].equals("triangular")) {
        MarbleSolitaireModel model1 = new TriangleSolitaireModel(Integer.parseInt(args[2]),
                Integer.parseInt(args[3]));
        MarbleSolitaireView view1 = new TriangleSolitaireTextView(model1);
        Readable reader = new InputStreamReader(System.in);
        MarbleSolitaireController controller = new
                MarbleSolitaireControllerImpl(model1, view1, reader);
        controller.playGame();
      }
    } else if (args.length == 6) {
      if (args[0].equals("english")) {
        MarbleSolitaireModel model1 = new EnglishSolitaireModel(Integer.parseInt(args[2]),
                Integer.parseInt(args[4]),
                Integer.parseInt(args[5]));
        MarbleSolitaireView view1 = new MarbleSolitaireTextView(model1);
        Readable reader = new InputStreamReader(System.in);
        MarbleSolitaireController controller = new
                MarbleSolitaireControllerImpl(model1, view1, reader);
        controller.playGame();
      } else if (args[0].equals("european")) {
        MarbleSolitaireModel model1 = new EuropeanSolitaireModel(Integer.parseInt(args[2]),
                Integer.parseInt(args[4]),
                Integer.parseInt(args[5]));
        MarbleSolitaireView view1 = new MarbleSolitaireTextView(model1);
        Readable reader = new InputStreamReader(System.in);
        MarbleSolitaireController controller = new
                MarbleSolitaireControllerImpl(model1, view1, reader);
        controller.playGame();
      } else if (args[0].equals("triangular")) {
        MarbleSolitaireModel model1 = new TriangleSolitaireModel(Integer.parseInt(args[2]),
                Integer.parseInt(args[4]),
                Integer.parseInt(args[5]));
        MarbleSolitaireView view1 = new TriangleSolitaireTextView(model1);
        Readable reader = new InputStreamReader(System.in);
        MarbleSolitaireController controller =
                new MarbleSolitaireControllerImpl(model1, view1, reader);
        controller.playGame();
      }
    }
  }
}

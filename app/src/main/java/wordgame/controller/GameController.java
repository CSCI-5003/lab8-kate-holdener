// TODO: add a package here
package wordgame.controller;

import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.JButton;

// TODO: import dependencies
import wordgame.model.Game;
import wordgame.view.GameGUI;

public class GameController implements ActionListener{

   Game game;
   GameGUI gui;

   // TODO: implement the constructor
   public GameController(Game game) {
      this.game = game;
      this.gui = new GameGUI(game, this);   
   }

   @Override
   public void actionPerformed(ActionEvent event) {
      JButton button = (JButton)event.getSource();
      String text = button.getText();
      char letter = text.charAt(0);
      this.gui.disableLetter(letter);
      game.playLetter(letter);
   }
}

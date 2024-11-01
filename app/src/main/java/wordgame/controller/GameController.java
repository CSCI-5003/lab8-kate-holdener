// TODO: add a package here

import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.JButton;

// TODO: import dependencies

public class GameController implements ActionListener{

   Game game;
   GameGUI gui;

   // TODO: implement the constructor
   public GameController(Game game) {
   
   }

   @Override
   public void actionPerformed(ActionEvent event) {
      JButton button = (JButton)event.getSource();
      String text = button.getText();
      char letter = text.charAt(0);
      game.playLetter(letter);
   }
}

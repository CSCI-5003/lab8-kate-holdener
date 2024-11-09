package wordgame.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import wordgame.model.*;

public class GameGUI implements Observer{
   private JFrame mainFrame;
   private JPanel mainPanel;
   private LetterButtons buttons;

   // user's current guess will be shown here
   private JLabel wordLabel;
   private JLabel errorsLabel;
   private JLabel resultLabel;

   protected Game game;
   protected SecretWord secretWord;

   public GameGUI(Game game, ActionListener listener) {
      this.game = game;
      game.register(this);
      this.secretWord = game.getSecretWord();

      wordLabel = new JLabel(secretWord.getCurrentGuess());
      wordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      errorsLabel = new JLabel(" ");
      errorsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      resultLabel = new JLabel(" ");
      resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      JFrame mainFrame = new JFrame("Word Game");
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      mainPanel = new JPanel();
      mainPanel.setBackground(new Color(171, 229, 245));
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
      mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      mainPanel.add(wordLabel);

      buttons = new LetterButtons(listener);

      buttons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      buttons.setOpaque(false);
      mainPanel.add(buttons);

      mainPanel.add(errorsLabel);
      mainPanel.add(resultLabel);

      mainFrame.add(mainPanel);

      mainFrame.pack();
      mainFrame.setVisible(true);
   }

   public void disableLetter(char letter) {
      this.buttons.add(letter);
   }

   @Override
   public void update() {
      this.wordLabel.setText(secretWord.getCurrentGuess());
      this.errorsLabel.setText("Error count: " + game.getNumErrors());
      Result result = game.getResult();
      if (result != Result.NONE) {
         this.resultLabel.setText("You "+result);
      }
   }
}

package wordgame.model;
import java.util.ArrayList;

public class Game {

   protected SecretWord secret;
   protected int errorLimit = 3;
   protected int numErrors = 0;
   protected Result result = Result.NONE;
   protected ArrayList<Observer> observers = new ArrayList<Observer>();

   public Game(SecretWord word) {
      this.secret = word;
   }

   public void setErrorLimit(int errorLimit) {
      this.errorLimit = errorLimit;
   }

   public int getNumErrors() {
      return numErrors;
   }

   public SecretWord getSecretWord() {
      return secret;
   }

   // TODO: Read over the implementation of the playLetter method
   // it accepts one letter as an argument and plays "one step" of the game
   public void playLetter(char letter) {
      boolean correct = this.secret.makeGuess(letter);
      if (!correct) {
         this.numErrors++;
      }
      notifyObservers();

      if (this.secret.hasUnopenedLetters()) {
         this.result = Result.LOSE;
      } else {
         this.result = Result.WIN;
      }
      notifyObservers();
   }

   public Result getResult() {
      return this.result;
   }

   public void register(Observer observer) {
      observers.add(observer);
   }

   public void notifyObservers() {
      for (Observer o: observers) {
         o.update();
      }
   }
}

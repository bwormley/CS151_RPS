/*
 * Group: Lunar
 * Members: Raman Kaur, Brett Wormley, Swathi Kotturu, Akashaya Singh
 * Rock Paper Scissors 
 */
package cs151_rps;

import java.lang.Integer;
import static cs151_rps.MessageType.*;


public class Scorecard {
    private int playerOneScore = 0; 
    private int playerTwoScore = 0; 
    private int numOfTies = 0; 
    private Message message;
    private Player playerOne;
    private Player playerTwo;
    
    public Scorecard( Message message, Player playerOne, Player playerTwo )
    {
        this.message = message;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }
    
    public void setPlayerOneScore (int userScore) {
        playerOneScore = userScore; 
    }
    
    public void setPlayerTwoScore(int computerScore) {
        playerTwoScore = computerScore; 
    }
    
    public void setNumOfTies(int ties) {
        numOfTies = ties; 
    }
    
    public int getPlayerOneScore() {
        return playerOneScore; 
    }
    
    public int getPlayerTwoScore () {
        return playerTwoScore; 
    }
    
    public int getNumOfTies() {
        return numOfTies; 
    }
    
    public void displayScore() {
        System.out.print( playerOne.getName() + " " + message.getMessage(WINS_REPORT) + playerOneScore + ", " );
        System.out.print( playerTwo.getName() + " " + message.getMessage(WINS_REPORT) + playerTwoScore + ", " );
        System.out.println( message.getMessage(TIES_REPORT) + numOfTies );
    }
}

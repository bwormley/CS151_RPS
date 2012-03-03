/*
 * Group: Lunar
 * Members: Raman Kaur, Brett Wormley, Swathi Kotturu, Akashaya Singh
 * Rock Paper Scissors 
 */
package cs151_rps;

public class Scorecard {
    private int playerOneScore = 0; 
    private int playerTwoSocre = 0; 
    private int numofTies = 0; 
    
    public void setPlayerOneScore (int userScore) {
        playerOneScore = userScore; 
    }
    
    public void setPlayerTwoScore(int computerScore) {
        playerTwoSocre = computerScore; 
    }
    
    public void setNumofTies(int ties) {
        numofTies = ties; 
    }
    
    public int getPlayerOneScore() {
        return playerOneScore; 
    }
    
    public int getPlayerTwoScore () {
        return playerTwoSocre; 
    }
    
    public int getNumofTies() {
        return numofTies; 
    }
    
    public void displayScore() {
    }
}

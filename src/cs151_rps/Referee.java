/*
 * Group: Lunar
 * Members: Raman Kaur, Brett Wormley, Swathi Kotturu, Akashaya Singh
 * Rock Paper Scissors 
 */
package cs151_rps;

public class Referee { 
    
    public enum Winner {PLAYER1, PLAYER2, TIE}
    
    Scorecard thescoreCard;
    
    public Referee( Scorecard scorecard )
    {
        this.thescoreCard = scorecard;
    }
    
    public Winner determineWinner (GameObject playerOne, GameObject playerTwo){
        if (playerOne.equals(GameObject.ROCK) && playerTwo.equals(GameObject.ROCK)) {
            updateScore(Winner.TIE); 
            return Winner.TIE; 
        }
        else if (playerOne.equals(GameObject.ROCK) && playerTwo.equals(GameObject.PAPER)) {
            updateScore(Winner.PLAYER2); 
            return Winner.PLAYER2;
        }
        else if (playerOne.equals(GameObject.ROCK) && playerTwo.equals(GameObject.SCISSORS)) {
            updateScore(Winner.PLAYER1); 
            return Winner.PLAYER1;
        }
        else if (playerOne.equals(GameObject.PAPER) && playerTwo.equals(GameObject.ROCK)) {
            updateScore(Winner.PLAYER1); 
            return Winner.PLAYER1;
        }
        else if (playerOne.equals(GameObject.PAPER) && playerTwo.equals(GameObject.PAPER)) {
            updateScore(Winner.TIE); 
            return Winner.TIE;
        }
        else if (playerOne.equals(GameObject.PAPER) && playerTwo.equals(GameObject.SCISSORS)) {
            updateScore(Winner.PLAYER2); 
            return Winner.PLAYER2;
        }
        else if (playerOne.equals(GameObject.SCISSORS) && playerTwo.equals(GameObject.ROCK)) {
            updateScore(Winner.PLAYER2); 
            return Winner.PLAYER2;
        }
        else if (playerOne.equals(GameObject.SCISSORS) && playerTwo.equals(GameObject.PAPER)) {
            updateScore(Winner.PLAYER1); 
            return Winner.PLAYER1;
        }
        else //if playerOne.equals(GameObject.SCISSORS) && playerTwo.equals(GameObject.SCISSORS) 
        {
            updateScore(Winner.TIE); 
            return Winner.TIE;
        }
        
    }
    
    public void updateScore(Winner winner) {
        switch(winner) {
            case PLAYER1: 
                thescoreCard.setPlayerOneScore(thescoreCard.getPlayerOneScore() + 1); break;
            case PLAYER2:
                thescoreCard.setPlayerTwoScore(thescoreCard.getPlayerTwoScore()+1); break;
            case TIE:
                thescoreCard.setNumOfTies(thescoreCard.getNumOfTies() + 1); break;
        }
    }
}


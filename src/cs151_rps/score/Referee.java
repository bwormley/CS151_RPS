/*
 * Group: Lunar
 * Members: Raman Kaur, Brett Wormley, Swathi Kotturu, Akashaya Singh
 * Rock Paper Scissors 
 */
package cs151_rps.score;

import cs151_rps.GameObject;
import static cs151_rps.GameObject.*;
import cs151_rps.heuristics.History;

public class Referee { 
    
    public enum Winner {PLAYER1, PLAYER2, TIE}
    
    /**
     * Keeps track of players moves, depending on the persistence model
     */
    History history = null;
    
    Scorecard thescoreCard;
    
    
    public Referee( Scorecard scorecard, String persistenceModel )
    {
        this.thescoreCard = scorecard;
        history = History.factory( persistenceModel );
    }
    
    public Winner determineWinner (GameObject playerOne, GameObject playerTwo){
        
        // keep track of a history of moves
        if (history != null)
            history.addRound( playerOne, playerTwo );
        
        // determine who won
        if (playerOne==playerTwo)
            return Winner.TIE;
        
        if (    (playerOne==ROCK     && playerTwo==SCISSORS)
             || (playerOne==PAPER    && playerTwo==ROCK)
             || (playerOne==SCISSORS && playerTwo==PAPER) )
            return Winner.PLAYER1;
        
        return Winner.PLAYER2;
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


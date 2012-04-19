/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151_rps;

import cs151_rps.score.Referee;
import cs151_rps.score.Scorecard;

/**
 * GAME CONTROLLER
 * 
 * This class is the abstract controller for Swing-based IO or command line IO.
 *
 * @author Team Lunar
 */
public abstract class GameController {
    
    protected int maxNumberOfRounds;
    
     /**
     * Implements the rules of the game, updates scorecard for each round, 
     * and forwards player moves to be archived
     */
    protected Referee referee;

    /**
     * Maintains the current score for the match, and aggregates the 
     * persistence model required by any heuristic algorithm
     */
    protected Scorecard scorecard;
    
    /**
     * the number of the current round of play
     */
    protected int roundNumber;
    
    /**
     * called by the VIEW object once the user's desired number of 
     * rounds is input
     * 
     * @param numberOfRounds 
     */
    public void setNumberOfRounds( int numberOfRounds )
    {
        maxNumberOfRounds = numberOfRounds;
    }
    
    static public GameController factory( String gameType, ParseCL parse)
        {
            if (gameType.equalsIgnoreCase("active"))
                return new ActiveGameController(parse);
            if (gameType.equalsIgnoreCase("passive"))
                return new PassiveGameController();
            return null;
        }
    
    public abstract void run();    
}

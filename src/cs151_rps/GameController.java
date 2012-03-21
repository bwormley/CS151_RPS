/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151_rps;

import cs151_rps.io.Output;
import cs151_rps.io.UserInput;
import cs151_rps.player.ComputerPlayer;
import cs151_rps.player.Player;
import cs151_rps.player.UserPlayer;
import cs151_rps.score.Referee;
import cs151_rps.score.Scorecard;

/**
 * The top-level class that coordinates interaction among the actors and the underlying system.
 * 
 * @author bwormley
 */
public class GameController {
    
    /**
    * Constructor
    *
    * @param maxRounds number of rounds for this match, as (typically) input from CL.  If 0, user is prompted.
    */
    public GameController( int maxRounds, String level )
    {
        this.maxRounds = maxRounds;
        this.level = level;
    }

    /**
     * Implements the rules of the game, and updates scorecard for each round.
     */
    private Referee referee;
    
    /**
     * Maintains the score for the match.
     */
    private Scorecard scorecard;
    
    /**
     * Temp storage for user-inputted name, prior to being embedded in the player object.
     */
    private String playerName;
    
    /**
     * Input by the user, the number of rounds to play in this match.
     */
    private int maxRounds;
    
    /**
     * Indication of experience level for computer player
     */
    String level;
    
    /**
     * The actors in the game.
     */
    private Player player1;
    private Player player2;
    
    /**
     * The actors' throws for a single round
     */
    private GameObject player1Throw;
    private GameObject player2Throw;
    
    /**
     * Endpoint for all program output (e.g., command line, GUI, remote)
     */
    Output endpoint;
    
    /**
     * Source for all input for user
     */
    UserInput source;
    
    /**
     * Main controlling method for the game
     */
    public void main()
    {
        // set up selected input and output endpoints
        // TODO: endpoint and locale settable from command line
        endpoint = Output.factory( "CLI", java.util.Locale.ENGLISH );
        //TODO: resolve design ugliness: input here *and* UserPlayer class? wtf?
        source = UserInput.factory("CLI");
        
        // Welcome, and acquire user's name 
        try {
            endpoint.displayWelcome();
            endpoint.displayNamePrompt();
            playerName = source.getPlayerName();
            if(playerName.isEmpty())
            {
            	playerName = "player1";
            }
        }
        catch (Exception e) {
        	endpoint.displayQuit();
            System.exit(0);
           
        }

        // instantiate system objects
        scorecard = new Scorecard();
        referee = new Referee( scorecard, "shortTerm" );
        
        // instantiate human and AI players
        // TODO: make these types settable from the CLI
        try {
            player1 = Player.factory( "human",    playerName, endpoint );
            player2 = Player.factory( "computer", "HAL",      null );
        }
        catch (Exception e) {
        	endpoint.displayQuit();
            System.exit(0);
            //  fatal error instantiating player object: abort here, with consolation.
        }
        
        // decorate the players as needed
        // TODO: choose decoration from command line options
        // TODO: choose decoration types from 'instanceof' determination of classes
        ((UserPlayer)player1).setInputType("CLI");
        ((ComputerPlayer)player2).setExperienceLevel("random");
        
        // default to 5 rounds if not entered on command line
        if (maxRounds<=0)
            maxRounds = 5;
        
        // main game loop
        for ( int round=1; round <= maxRounds; round++ ) {

            // start new round; annouonce round number
            endpoint.displayNewRound();
            endpoint.displayRound( round, maxRounds );
            
            boolean score = false;
            // get each player's throw
            try {
                player1Throw = player1.queryThrow();
                endpoint.displayThrow( player1.getName(), player1Throw );
                player2Throw = player2.queryThrow();
                endpoint.displayThrow( player2.getName(), player2Throw );
            }
            catch (Exception e) {
            	if (e.getMessage() != null && e.getMessage().equalsIgnoreCase("score"))
            	{
            		score = true;
            		round--;
            	}
            	if(e.getMessage() != null && e.getMessage().equalsIgnoreCase("user abort"))
            	{
            		endpoint.displayQuit();
                System.exit(0);
                // fatal error: abort here, with specific cosolation.
            	}
   
            		
            }

            // determine the winner, and display it
            if(score == false)
            {
            Referee.Winner winner = referee.determineWinner( player1Throw, player2Throw );
            if (winner==Referee.Winner.PLAYER1)
                endpoint.displayRoundWinner( player1.getName() );
            else if (winner==Referee.Winner.PLAYER2)
                endpoint.displayRoundWinner( player2.getName() );
            else 
                endpoint.displayRoundTie( player1.getName(), player2.getName() );
            }
     
            // display match score so far
            endpoint.displayScore( player1.getName(), scorecard.getPlayerOneScore(),
                                   player2.getName(), scorecard.getPlayerTwoScore(),
                                                      scorecard.getNumOfTies() );
            
        }
        
        // display winner of the match
        
        if(scorecard.getPlayerOneScore() > scorecard.getPlayerTwoScore())
        {
        	endpoint.displayMatchWinner(player1.getName());
        }
        else if (scorecard.getPlayerOneScore() < scorecard.getPlayerTwoScore())
        {
        	endpoint.displayMatchWinner(player2.getName());
        }
        else 
        {
        	endpoint.displayMatchIsTie();
        }
        
        
    }
    
}

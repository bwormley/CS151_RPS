/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151_rps;

import java.util.Scanner;
import java.io.*;

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
    public GameController( int maxRounds )
    {
        this.maxRounds = maxRounds;
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
     * Main controlling method for the game
     */
    public void main()
    {
        // set up selected input and output endpoints
        // TODO: endpoint and locale settable from command line
        endpoint = Output.factory( "CLI", java.util.Locale.ENGLISH );
        
        // Welcome, and acquire user's name 
        endpoint.displayWelcome();
        endpoint.displayNamePrompt();
        try {
            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);
            playerName = in.readLine();
        }
        catch (Exception e) {
            System.out.println("Error!  Exception: " + e );
        }
        
        // instantiate human and AI players
        try {
            player1 = new UserPlayer(endpoint);
            player2 = new ComputerPlayer("The Computer",null);
        }
        catch (Exception e) {
            System.out.println("Error:  Exception: " + e );
            // TODO: fatal error instantiating player object: abort here, with consolation.
        }
        
        // instantiate system objects
        scorecard = new Scorecard( player1, player2 );
        referee = new Referee( scorecard );
        
        //prompt user for number of rounds if not already added to command line
        if (maxRounds<=0) {
            endpoint.displayRoundsPrompt();
            Scanner scan = new Scanner(System.in);
	    if(scan.hasNext())
                maxRounds = scan.nextInt();
        }
        
        // main game loop
        for ( int round=1; round <= maxRounds; round++ ) {
            
            try {
                player1Throw = player1.queryThrow();
                player2Throw = player2.queryThrow();
            }
            catch (Exception e) {
                System.out.println( "Error: Exception: " + e );
                // TODO: fatal error: abort here, with specific cosolation.
            }
            Referee.Winner winner = referee.determineWinner( player1Throw, player2Throw );
            if (winner==Referee.Winner.PLAYER1)
                endpoint.displayRoundWinner( player1.getName() );
            else if (winner==Referee.Winner.PLAYER2)
                endpoint.displayRoundWinner( player2.getName() );
            else 
                endpoint.displayRoundTie( player1.getName(), player2.getName() );

            endpoint.displayScore( player1.getName(), scorecard.getPlayerOneScore(),
                                   player2.getName(), scorecard.getPlayerTwoScore(),
                                                      scorecard.getNumOfTies() );
            
        }
        
        // TODO: display winner of the match
                                                    
    }
    
}

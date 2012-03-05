/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151_rps;

import static cs151_rps.MessageType.*;
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
        message = new Message(null); // note: null string signifies default locale
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
     * Object that converts a message (enum) into a language-specific string for display.
     */
    private Message message;

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
     * Main controlling method for the game
     */
    public void main()
    {
        // Welcome, and acquire user's name 
        System.out.print( message.getMessage(WELCOME) );
        System.out.print( message.getMessage(PROMPT_NAME) );
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
            player1 = new UserPlayer(playerName,message);
            player2 = new ComputerPlayer("The Computer",message);
        }
        catch (Exception e) {
            System.out.println("Error:  Exception: " + e );
            // TODO: fatal error: abort here, with cosolation.
        }
        
        // instantiate system objects
        scorecard = new Scorecard( message, player1, player2 );
        referee = new Referee( scorecard );
        
        player1.setScorecard( scorecard );
        player2.setScorecard( scorecard );
        
        //prompt user for number of rounds if not already added to command line
        if (maxRounds<=0) {
            System.out.print( message.getMessage(PROMPT_ROUNDS) );
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
                System.out.println( player1.getName() + " " + message.getMessage(WINS_ANNOUNCE));
            else if (winner==Referee.Winner.PLAYER2)
                System.out.println( player2.getName() + " " + message.getMessage(WINS_ANNOUNCE));
            else 
                System.out.println( player1.getName() + " " + message.getMessage(TIES_ANNOUNCE) + " " + player2.getName() );

            scorecard.displayScore();
            
        }
        
        // TODO: display winner of the match
                                                    
    }
    
}

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

import static cs151_rps.ParseCL.*;

/**
 * The top-level class that coordinates interaction among the actors and the underlying system.
 * 
 * @author bwormley
 */
public class GameController {
    
    /**
    * Constructor - create a game, and initialize with all parameters 
    * from the command line
    *
    * @param args parser object that has options found on the command 
    * line, and defaults
    */
    public GameController( ParseCL args )
    {
        this.args = args;
    }
    
    ParseCL args;

    /**
     * Implements the rules of the game, updates scorecard for each round, 
     * and forwards player moves to be archived
     */
    private Referee referee;
    
    /**
     * Maintains the current score for the match
     */
    private Scorecard scorecard;
    
    /**
     * The number of rounds to play in this match
     */
    private int maxRounds;
    
    /**
     * Indication of experience level for computer player
     */
    private String level;
    
    /**
     * The two ctors in the game
     */
    private Player player1;
    private Player player2;
    
    /**
     * The actors' throws for a single round
     */
    private GameObject player1Throw;
    private GameObject player2Throw;
    
    /**
     * Endpoint for all program output (e.g., CLI, Swing, Remote)
     */
    Output endpoint;
    
    /**
     * Source for all input for user
     */
    UserInput source;
    
    /**
     * Create a Player object based on runtime attributes from the command line
     * 
     * @param source - object abstracting all output
     * @param endpoint - object abstracting all input
     * @param playerType - human, AI, etc
     * @param inputType - CLI, Swing, etc
     * @param level - smart, etc
     * @return provisioned player object of the correct identity
     */
    Player provisionPlayer( 
            UserInput source, 
            Output endpoint, 
            String playerType, 
            String inputType, 
            String level  )
    {
        String name = "";
        if (playerType.equalsIgnoreCase("human"))
        {
            endpoint.displayWelcome();
            endpoint.displayNamePrompt();
            name = source.getPlayerName();
            if(name==null || name.isEmpty())
            {
            	name = "PLAYER";
            }
        }
        Player player = Player.factory( playerType, name, endpoint );
        if (player instanceof UserPlayer)
             ((UserPlayer)player).setInputType(inputType);
        if (player instanceof ComputerPlayer)
            ((ComputerPlayer)player).setExperienceLevel(level);
       return player;
    }

    /**
     * Main controlling method for the game
     */
    public void run()
    {
        // set up selected input and output endpoints
        endpoint = Output.factory( args.getStringParam(IO_OPTION), null );
        source = UserInput.factory(args.getStringParam(IO_OPTION));
        
        // flexibly provision two players
        player1 = provisionPlayer( 
                source, 
                endpoint, 
                args.getStringParam(PLAYER_ONE_OPTION),
                args.getStringParam(IO_OPTION),
                args.getStringParam(EXPERIENCE_OPTION) );
        player2 = provisionPlayer( 
                source, 
                endpoint, 
                args.getStringParam(PLAYER_TWO_OPTION),
                args.getStringParam(IO_OPTION) ,
                args.getStringParam(EXPERIENCE_OPTION) );

        // instantiate system objects
        // Design Pattern: Dependency Injection (Fowler, Type 3)
        scorecard = new Scorecard();
        referee = new Referee( scorecard, args.getStringParam(EXPERIENCE_OPTION) );
        
        // initialize any final runtime parameters
        maxRounds = args.getIntParam(NUM_ROUNDS_OPTION);
        
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

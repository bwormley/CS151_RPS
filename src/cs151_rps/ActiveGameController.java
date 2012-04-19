package cs151_rps;

import static cs151_rps.GameObject.ROCK;
import static cs151_rps.ParseCL.*;
import cs151_rps.io.UIO;
import cs151_rps.player.ComputerPlayer;
import cs151_rps.player.Player;
import cs151_rps.score.Referee;
import cs151_rps.score.Referee.Winner;
import static cs151_rps.score.Referee.Winner.PLAYER1;
import static cs151_rps.score.Referee.Winner.PLAYER2;
import cs151_rps.score.Scorecard;

/**
 * ROCK-PAPER-SCISSORS: The top-level class that coordinates interaction 
 * among the actors and the underlying system.
 * 
 * @author Team Lunar
 */
public class ActiveGameController extends GameController    {
    
    /**
     * Object encapsulating command line parser, and the command line 
     * argument values, and defaults
     */
    private ParseCL args;

    /**
     * The two actors (players) in the game.  From the perspective of this 
     * class, these types are generic, encapsulating whether or not they are 
     * human/AI, what i/o method they use, what heuristic they use, or even 
     * if the player is local or remote.
     */
    private Player player1;
    private Player player2;
    
    /**
     * Indication of experience level for the heuristics of the AI player
     */
    private String level;
    
    /**
    * Constructor - create a game, and initialize with all parameters 
    * from the command line
    *
    * @param args parser object that has options found on the command 
    * line, and defaults
    */
    public ActiveGameController( ParseCL args )
    {
        this.args = args;
    }

    /**
     * Endpoint for all program input and output (e.g., CLI, Swing, Remote)
     */
    UIO endpoint;
    
    /**
     * Create a Player object based on runtime attributes from the command line
     * 
     * @param endpoint - object abstracting all input and output
     * @param playerType - human, AI, etc
     * @param level - random, smart, etc
     * @return player object of the correct identity, 
     * provisioned with an io endpoint
     */
    private Player provisionPlayer( 
                   UIO endpoint, 
                   String playerType, 
                   String level  )
    {
        String name = "";
        
        // if a human player, ask for his name
        if (playerType.equalsIgnoreCase("human"))
        {
            endpoint.displayWelcome();
            endpoint.displayNamePrompt();
            name = endpoint.getPlayerName();
            if(name==null || name.isEmpty())
            	name = "HUMAN";
        }
        
        // create a player with the correct identity
        Player player = Player.factory( playerType, name, endpoint );
        
        // if an AI player, set the heuristic level
        if (player instanceof ComputerPlayer)
            ((ComputerPlayer)player).setExperienceLevel(level);
        
        return player;
    }

    /**
     * MAIN GAME CONTROLLER METHOD
     */
    public void run()
    {
        // the actors' throws for a single round
        GameObject player1Throw = ROCK;
        GameObject player2Throw = ROCK;
    
        // set up the input and output endpoint, set from the command line
        endpoint = UIO.factory( args.getStringParam(IO_OPTION), 
                                args.getStringParam(LANG_OPTION) );
        
        // flexibly provision the two players
        player1 = provisionPlayer( 
                endpoint, 
                args.getStringParam(PLAYER_ONE_OPTION),
                args.getStringParam(EXPERIENCE_OPTION) );
        player2 = provisionPlayer( 
                endpoint, 
                args.getStringParam(PLAYER_TWO_OPTION),
                args.getStringParam(EXPERIENCE_OPTION) );

        // instantiate the system objects
        scorecard = new Scorecard();
        referee = new Referee( scorecard, 
                               args.getStringParam(EXPERIENCE_OPTION) );
        
        // initialize any final runtime parameters
        //maxRounds = args.getIntParam(NUM_ROUNDS_OPTION);
        this.setNumberOfRounds(args.getIntParam(NUM_ROUNDS_OPTION));
        
        // MAIN GAME LOOP
        for ( roundNumber = 1; roundNumber <= maxNumberOfRounds; roundNumber++ ) {

            // start new round; announce the round number
            endpoint.displayNewRound();
            endpoint.displayRound( roundNumber, maxNumberOfRounds );
            
            boolean score = false;
            // get each player's throw
            try {
                player1Throw = player1.queryThrow();
                endpoint.displayThrow( player1.getName(), player1Throw );
                player2Throw = player2.queryThrow();
                endpoint.displayThrow( player2.getName(), player2Throw );
            }
            catch (Exception e) {
            	if (e.getMessage() != null 
                        && e.getMessage().equalsIgnoreCase("score")) {
                    score = true;
                    roundNumber--;
            	}
            	if(e.getMessage() != null 
                        && e.getMessage().equalsIgnoreCase("user abort")) {
                    endpoint.displayQuit();
                    System.exit(0);
                    // fatal error: abort here, with specific cosolation.
            	}
            }

            // determine the round's winner, and display him
            if(score == false) {
                Winner winner = referee.determineWinner( player1Throw, 
                                                         player2Throw );
                if (winner==PLAYER1)
                    endpoint.displayRoundWinner( player1.getName() );
                else if (winner==PLAYER2)
                    endpoint.displayRoundWinner( player2.getName() );
                else 
                    endpoint.displayRoundTie( player1.getName(), 
                                              player2.getName() );
            }
     
            // display match score so far
            endpoint.displayScore( 
                    player1.getName(), scorecard.getPlayerOneScore(),
                    player2.getName(), scorecard.getPlayerTwoScore(),
                                       scorecard.getNumOfTies() );
        }
        
        // display the winner of the match
        if(scorecard.getPlayerOneScore() > scorecard.getPlayerTwoScore())
            endpoint.displayMatchWinner(player1.getName());
        else if (scorecard.getPlayerOneScore() < scorecard.getPlayerTwoScore())
            endpoint.displayMatchWinner(player2.getName());
        else 
            endpoint.displayMatchIsTie();        
    }

}

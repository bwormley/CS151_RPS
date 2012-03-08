package cs151_rps;

import java.util.Locale;

/**
 *
 * @author Team Lunar
 */

abstract public class Output 
{
    
    /**
     * Create an object that encapsulates all output for the designated endpoint
     * 
     * @param endpoint one of several possible destinations for program output
     * @param locale designation text localization
     */
    static public Output factory( String endpoint, Locale locale )
    {
// TODO: expand endpoint choices when available
        if (endpoint.equalsIgnoreCase("CLI"))
            return new CLIOutput(locale);
//        if (endpoint.equalsIgnoreCase("Swing"))
//            return new SwingOutput(locale);
//        if (endpoint.equalsIgnoreCase("Remote"))
//            return new RockoffOutput(locale);
        return null;
    }

    /**
     * Object that localizes individual strings
     */
    protected Message msg;
    
    /**
     * Display the startup welcome message
     */
    abstract public void displayWelcome();
    
    /**
     * Display a message prompting the user to enter a name/identifier
     */
    // TODO: which user's name is being asked for? One ro Two?
    abstract public void displayNamePrompt();
    
    /**
     * Display a message prompting the user to enter the number of 
     * rounds desired for the match.
     */
    // TODO: which user is being prompted? One or Two?
    abstract public void displayRoundsPrompt();
    
    /**
     * Display a message announcing the winner of a round
     * @param playerName 
     */
    abstract public void displayRoundWinner( String playerName );
    
    /**
     * Display a message announcing a tie in the current round
     * @param player1Name
     * @param player2Name 
     */
    abstract public void displayRoundTie( String player1Name, String player2Name );

    /**
     * Display a message announcing the winner of the match
     * 
     * @param playerName
     */
    abstract public void displayMatchWinner( String playerName );

    /**
     * Display rules for the game
     */
    abstract public void displayHelp();
    
    /**
     * Display the running score for the match
     * 
     * @param player1Name the name/identifier for player #1
     * @param player1Wins the number of wins for player #1
     * @param player2Name the name/identifier for player #2
     * @param player2Wins the number of wins for player #2
     * @param ties the number of tied rounds
     */
    abstract public void displayScore( String player1Name, 
                                       long   player1Wins, 
                                       String player2Name, 
                                       long   player2Wins, 
                                       long   ties );
    
    /**
     * Display the round number
     * 
     * @param round the current round number
     */
    abstract public void displayRound( long round );
    
    /**
     * Display the player's choice (gesture)
     * 
     * @param playerName the name/identifier for the player
     * @param gesture { rock, paper, scissors }
     */
    abstract public void displayChoice( String playerName, 
                                        GameObject gesture );

    /**
     * Display a prompt for the user's throw gesture choice
     * 
     * @param playerName 
     */
    abstract public void displayUserPrompt( String playerName );
    
    /**
     * Display an indication of an input error to the user
     */
    abstract public void displayUserInputError();
}

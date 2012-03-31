package cs151_rps.io;

/**
 * Abstraction for generic input for the game
 *
 * @author Team Lunar
 */
abstract public class UserInput {
    
    /**
     * Factory for instance for a specific input source
     * 
     * @param source
     * @return 
     */
    
    static public UserInput factory( String source )
    {
        if (source.equalsIgnoreCase("CLI"))
            return new CLIUserInput();
// TODO expand user input types
//        if (source.equalsIgnoreCase("Swing"))
//            return new SwingUserInput();
//        if (source.equals("remote"))
//            return RockoffUserInput();
        return null;
    }
    
    /**
     * Query the choices for a round: rock/paper/scissors/help/score/quit
     * 
     * @return 0..5
     */
    abstract public int getThrow();
    
    /**
     * Query the proper name/identifier for a player
     * 
     * @return 
     */
    abstract public String getPlayerName();
    
}

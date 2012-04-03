
package cs151_rps.heuristics;  

/* The analysis will cretae a hashmap of strings. 
 * In hasmap, the keys will be strings and the value will be the number
 * of times those moves took place.*/

/* Analysis class doesn't know what the N level is. The History class will know 
 * the N level. And based on that N level, the History class will pass N length 
 * of string. */

abstract public class Analysis {
    
    /**
     * Constructor
     */
    public Analysis( String type )
    {
        // retrieve the pre-existing History singleton instance
        // (note: instance already created by Referee class)
        history = History.factory("");
    }
    
    /**
     * Implementation of a history persistence model
     */
    protected History history;
    
    /**
     * The analysis is to happen for patterns between these 
     * two lengths, inclusive
     */
    protected final int MIN_DEPTH = 2;
    protected final int MAX_DEPTH = 5;
    
    /**
     * Create an instance of a subclass to implement a game heuristic.
     * 
     * @param type - level of the heuristic algorithm
     * @return object implementing the heuristic algorithm
     */
    public static Analysis factory( String type )
    {
        return new ShortTermAnalysis(type);
    }
    
    /**
     * Update the ongoing analysis with the results of a new round.  This 
     * method is called once (and only once!) per round.  The History class 
     * will have a record of the last round's results.
     */
    public abstract void update();
    
    /**
     * Return the last gestures  made in the game
     * 
     * @param numberOfMoves number of moves made, 
     * or null if insufficient history
     */
    public String getLastMoves( int numberOfMoves )
    {
        return history.getLastMoves(numberOfMoves);
    }
    
    /**
     * Return the last gestures made in the game, with the order swapped
     * 
     * @param numberOfMoves number of moves made, 
     * or null if insufficient history
     */
    public String getLastMovesSwapped( int numberOfMoves )
    {
        return history.getLastMovesSwapped(numberOfMoves);
    }
    
    /**
     * Return the number of gestures currently saved in the archive
     * 
     * @return number of throws available
     */
    public int getArchiveSize()
    {
        return history.getArchiveSize();
    }
    
    /**
     * Return the number of times this pattern of gestures has occurred
     * 
     * @param pattern a string of r/p/s characters indicating a pattern of 
     * gestures
     * @return a non-negative number of times the pattern appeared
     */
    public abstract int frequencyOf( String pattern );
            
    //If the String moves already exist in the map, the value will be incremented
    //by one. Else the moves will be added and the value will be one. 
    //abstract protected void addMoves(String moves); 
    
    //This method will give the Smart Throw Generator class what the predicsted 
    //next move is. 
    //public String predictedMove(int N); 
    
    //This method will will fetch the recent N moves from the History class to 
    //predict the next move. 
    //public String pastNMoves(int N); 
}

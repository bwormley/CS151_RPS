package cs151_rps.heuristics;

import cs151_rps.GameObject;

/**
 * Implements storage and retrieval of a history of prior gestures 
 * in the game.  As rounds are played, the gestures are given to this class 
 * (addRound()), and may be retrieved up to a predetermined level 
 * (getLastMoves()).
 *
 * The sole purpose of this history is to feed the Analysis class for heuristic 
 * prediction of the human player.  This only requires keeping a fixed number of 
 * previous gestures, rather than the complete history of gestures.
 * 
 * This is a singleton class which creates a single instance of one of its  
 * subclasses via a factory.  The first instantiation designates which subclass 
 * to create; any subsequent requests for instantiation return the same 
 * subclass (same object), no matter what subclass was requested.
 * 
 * @author Team Lunar
 */
abstract public class History {
    
    /**
     * Constructor (protected from being used outside the class)
     */
    protected History() 
    {
        _instance = null;
        archive = "";
        archiveModified = false;
    }
    
    /**
     * Override clone to ensure we stay a singleton
     * 
     * @return never called
     * @throws CloneNotSupportedException 
     */
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }
    
    /**
     * the Singleton instance for this hierarchy
     */
    static History _instance = null;
    
    /**
     * Mash-up of Singleton and Factory design patterns: builds a subclass that 
     * implements a specific History persistence model.  Since it is a 
     * singleton, the reference to the created object is available anywhere in 
     * the program.
     * 
     * @param type what persistence model to use
     * @return the object implementing the requested model
     */
    public static synchronized History factory( String type )
    {
// TODO: update factory when another subclass is available 
        if (_instance==null) {
//        if (type.equalsIgnoreCase("smart"))
            _instance = new ShortTermHistory();
        }
        return _instance;
    }
    
    /**
     * Maximum number of gestures saved in archive, and retrievable 
     * by getLastMoves
     */
    protected int MAX_DEPTH = 8;
    
    /**
     * Ephemeral storage for the latest gestures in the game
     */
    protected String archive;
    
    /**
     * Will be set when new history added to archive, cleared when 
     * upToDate() called
     */
    protected boolean archiveModified;
    
    /**
     * Indicates whether the archive has been modified since the last 
     * call to upToDate()
     * 
     * @return status
     */
    public boolean isModified()
    {
        return archiveModified;
    }
    
    /**
     * Indicates that the consumer of history is up to date with the 
     * latest changes made to the archive
     */
    public void upToDate()
    {
        archiveModified = false;
    }
        
    /**
     * Add the two gestures during a single round of RPS to the archive
     * 
     * @param humanPlayerGesture - R/P/S from the human
     * @param computerPlayerGesture  - R/P/S from the computer
     */
    abstract public void addRound( GameObject humanPlayerGesture, 
                                   GameObject computerPlayerGesture );

    /**
     * Return the last N gestures made during playing the game.
     * 
     * The returned gestures are in the form of a string of characters, 
     * where the human player's gestures are represented by an upper case 
     * letter (R/P/S) and the computer's gestures are represented by a lower 
     * case letter (r/p/s).
     * 
     * Although an odd number of gestures can be requested, the history is 
     * accumulated from pairs of gestures, where the computer player's gesture 
     * comes first.
     * 
     * For example, a call of getLastMoves(4) may return "rPsR", representing 
     * the last two rounds, in the order of (computer, human, computer, human),
     * with the more recent round last in the sequence.
     * 
     * If there are insufficient stored gestures to satisfy the request to 
     * getLastMoves(), an empty String is returned.
     * 
     * @param numerOfMoves the number of gestures to be returned, if available
     * @return a string representing the last gestures, or an empty String if 
     * insufficient history
     */
    abstract String getLastMoves( int numberOfMoves );
    
    /**
     * Return the last N gestures made during playing the game, in a swapped order.
     * 
     * This function operates similarly to getLastMoves() except the order of 
     * the moves is (computer,human).  In all other respects it behaves 
     * identically.
     * 
     * @param numberOfMoves the number of gestures to be returned, if available
     * @return a string representing the last gestures, or an empty String if 
     * insufficient history
     */
    abstract String getLastMovesSwapped( int numberOfMoves );
    
    /**
     * Return the number of gestures currently available in the archive
     * 
     * @return 1 or more gestures available for retrieval via the 
     * getLastMoves() member function
     */
    abstract int getArchiveSize();
    
    /**
     * Save the current archive to a persistent store, for future retrieval 
     * upon future invocation of this program.
     * 
     * Not all subclasses will persist their store.  It is recommended that the
     * saveArchive method be called prior to exiting the RPS program, and if 
     * the specific polymorphic instance of History is appropriate, it will 
     * take appropriate action.  The subclass's constructor is responsible for 
     * retrieving the archive from the store.
     */
    abstract public void  saveArchive();
    
    /**
     * Return maximum size this archive can grow.
     * 
     * Note: this function only needed for JUnit testing.  Override in subclass 
     * if the max size is overridden too.
     * 
     * @return max size
     */
    public int getMaxArchiveSize() {
            return MAX_DEPTH;
    }
}

package cs151_rps;

/**
 * Singleton factory - this instantiates one form of history (currently, 
 * non-persistent and persistent) as a singleton for the abstract class
 * 
 * @author Team Lunar
 */

public abstract class History {
    
    protected History() { 
        history = null; 
        archive = "";
    }
    
    public static synchronized final History factory( String type )
    {
        if (history == null) {
            if (type.equalsIgnoreCase("ephemeral"))
                history = new EphemeralHistory();
        }
        return history;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException 
    { 
        throw new CloneNotSupportedException();
    }
    
    private static History history;
    
    protected String archive;
    
    abstract public void addRound( GameObject player1, GameObject player2 );
    
    abstract public String getHistory();
    
    abstract public int getHistoryLength();
}

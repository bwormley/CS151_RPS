package cs151_rps.player;

import cs151_rps.GameObject;
import cs151_rps.io.UIO;


/**
 * Abstraction of a player (human or automaton)
 * 
 * @author Team Lunar
 */
public abstract class Player {
	
	protected String name;
        protected UIO endpoint;

        public Player(String name, UIO endpoint)
	{
		this.name = name;
                this.endpoint = endpoint;
	}
        	
	public String getName()
	{
		return name;
	}
        
        static public Player factory( String species, String name, UIO endpoint )
        {
            if (species.equalsIgnoreCase("human"))
                return new UserPlayer( name, endpoint );
            if (species.equalsIgnoreCase("AI"))
                return new ComputerPlayer();
            return null;
        }
    
    /**
     * queryThrow() - query for a player's throw for one round
     * 
     * Note: this call may block if user input is required
     *
     * @return rock/paper/scissors chosen by the player
     * @throws Exception 
     */
    abstract public GameObject queryThrow() throws Exception;

}

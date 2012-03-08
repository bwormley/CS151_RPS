/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151_rps;

//import cs151_rps.GameObject;

/**
 * Abstraction of a player (human or automaton)
 * 
 * @author bwormley
 */
public abstract class Player {
	
	protected String name;
        protected Output endpoint;

        public Player(String name, Output endpoint)
	{
		this.name = name;
                this.endpoint = endpoint;
	}
        	
	public String getName()
	{
		return name;
	}
        
        static public Player factory( String species, String name, Output endpoint )
        {
            if (species.equalsIgnoreCase("human"))
                return new UserPlayer( name, endpoint );
            if (species.equalsIgnoreCase("computer"))
                return new ComputerPlayer( name );
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
    abstract GameObject queryThrow() throws Exception;

}

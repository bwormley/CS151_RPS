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
	
	private String name;
	protected Scorecard score;
	public Player(String name)
	{
		this.name = name;
	}
        
        public void setScorecard( Scorecard scorecard )
        {
            score = scorecard;
        }
	
	public String getName()
	{
		return name;
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

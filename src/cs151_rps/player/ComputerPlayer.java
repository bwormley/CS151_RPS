package cs151_rps.player;

import cs151_rps.GameObject;
import cs151_rps.play.ThrowGenerator;

/**
 * This class implements a derivation of a Player actor as an automaton, 
 * with selectable experience levels
 * 
 * @author Team Lunar
 */
public class ComputerPlayer extends Player
{
    
    /**
     * Holds an instance of a gesture generator, with selectable AI
     */
    ThrowGenerator throwGen;
    
    /**
     * Set the expertise level of this actor, by using the Throw Generator 
     * factory to create the right AI
     * 
     * @param level level of expertise of this actor
     */
    public void setExperienceLevel( String level )
    {
        throwGen = ThrowGenerator.factory(level);
    }
    
    /**
     * Generate a gesture
     * 
     * @return rock|paper|scissors
     * @throws Exception if the actor requests to quit
     */
    
    @Override
    public GameObject queryThrow() throws Exception
    {
        return throwGen.queryThrow();
    }
	
        /**
         * Constructor
         * 
         * @param name Proper Name given to this actor
         */
        ComputerPlayer()
        {
            super( null, null );
            this.name = "HAL";
        }

	
}	//end of ComputerPlayer

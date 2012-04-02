package cs151_rps.play;

import cs151_rps.GameObject;

/**
 * Abstraction of a gesture generator, for creating generators of varying expertise
 *
 * @author Team Lunar
 */
abstract public class ThrowGenerator {
    
    static public ThrowGenerator factory( String level )
    {
        if (level.equalsIgnoreCase("random"))
            return new RandomThrowGenerator();
        if (level.equalsIgnoreCase("Smart"))
            return new SmartThrowGenerator();
//        if (level.equalsIgnoreCase("expert"))
//            return new ExpertThrowGenerator();
        
        // default to the simplest generator
        return new RandomThrowGenerator();
    }
    
    /**
     * Generate a gesture
     * 
     * @return rock|paper|scissors
     */
    abstract public GameObject queryThrow();
}

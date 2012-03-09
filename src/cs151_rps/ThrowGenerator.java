package cs151_rps;

/**
 * Abstraction of a gesture generator, for creating generators of varying expertise
 *
 * @author Team Lunar
 */
abstract public class ThrowGenerator {
    
    static public ThrowGenerator factory( String level )
    {
        // TODO: implement smarter Throw Generators
        if (level.equalsIgnoreCase("random"))
            return new RandomThrowGenerator();
//        if (level.equalsIgnoreCase("Smart"))
//            return new SmartThrowGenerator();
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
    abstract GameObject queryThrow() throws Exception;
}

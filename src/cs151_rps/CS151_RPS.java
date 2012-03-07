package cs151_rps;

/**
 *
 * @author Team Lunar
 */
public class CS151_RPS {
    
    static private GameController game;
    static private String NUM_ROUNDS_OPTION = "-r";
    static int numRounds;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ParseCL clp = new ParseCL();
        clp.setOption( NUM_ROUNDS_OPTION, ParseCL.ParamType.INTEGER );
        try {
            clp.parse(args);
        }
        catch (Exception e) {
            System.out.println( "Command line error: " + e );
            System.exit(1);
        }
        numRounds = clp.getIntParam(NUM_ROUNDS_OPTION);
        game = new GameController( numRounds );
        game.main();    
    }
}

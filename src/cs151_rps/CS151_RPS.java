package cs151_rps;

/**
 *
 * @author Team Lunar
 */
public class CS151_RPS {
    
    static private GameController game;
    static private String NUM_ROUNDS_OPTION = "-r";
    static private String EXPERIENCE_OPTION = "--level";
    static int numRounds = 32;
    static String level = "smart";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // initialize command line processor with expected arguments
        ParseCL clp = new ParseCL();
        clp.setOption( NUM_ROUNDS_OPTION, ParseCL.ParamType.INTEGER );
        clp.setOption( EXPERIENCE_OPTION, ParseCL.ParamType.STRING );
        
        try {
            clp.parse(args);
        }
        catch (NumberFormatException e) {
            System.out.println( "Command line error: " + e );
            System.exit(1);
        }
        catch (Exception e) {
            System.out.println( "UNKNOWN Command line error: " + e );
            System.exit(1);
        }
        numRounds = clp.getIntParam(NUM_ROUNDS_OPTION);
        level = clp.getStringParam(EXPERIENCE_OPTION);
        game = new GameController( numRounds, level );
        game.main();    
    }
}

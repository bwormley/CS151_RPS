package cs151_rps;

/**
 *
 * @author Team Lunar
 */
public class CS151_RPS {
 
    static private GameController game;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // initialize command line processor with expected arguments
        ParseCL clp = new ParseCL();
        
        try {
            clp.parse(args);
        }
        catch (NumberFormatException e) {
            System.out.println( "Command line error: " + e );
            clp.displayUsage();
            System.exit(1);
        }
        catch (Exception e) {
            System.out.println( "UNKNOWN Command line error: " + e );
            clp.displayUsage();
            System.exit(1);
        }
        game = new GameController(clp);
        game.run();
    }
}

package cs151_rps;
import cs151_rps.io.*; 

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
        String type = "active";
        
        try {
            clp.parse(args);
        }
        catch (NumberFormatException e) {
            System.out.println( "Command line error: " + e );
            clp.displayUsage();
            System.exit(1);
        }
        catch (Exception e) {
            if(e.getMessage().equals("GUI"))
                type = "passive";
            else {
            System.out.println( "UNKNOWN Command line error: " + e );
            clp.displayUsage();
            System.exit(1);
            }
        }
        game = game.factory(type, clp);
        game.run();
    }
}

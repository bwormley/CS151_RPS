
package cs151_rps;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Team Lunar
 */
public class SmartThrowGenerator extends ThrowGenerator {
    
    SmartThrowGenerator()
    {
        history = History.factory("ephemeral");
        randGen = ThrowGenerator.factory("random");
    }

    private ThrowGenerator randGen;
    private History history;
    private String archive;
    
    private static final int MIN_DEPTH = 2;
    private static final int MAX_DEPTH = 5;
    private static final int ROCK     = 0;
    private static final int PAPER    = 1;
    private static final int SCISSORS = 2;
    
    private int incidence[][];
    int archiveLength;
    
    @Override
    GameObject queryThrow() throws Exception 
    {
        // random choices until we can be smart
        archiveLength = history.getHistoryLength();
        if (archiveLength < MAX_DEPTH+1)
            return randGen.queryThrow();
        
        // init
        incidence = new int[MAX_DEPTH-MIN_DEPTH+1][3];
        
        // construct incidence table
        archive = history.getHistory();
        for ( int depth = MIN_DEPTH; depth <= MAX_DEPTH; depth++ )
            countIncidence( depth );
        
        // determine next best move
        int totR = incidence[0][ROCK]     + incidence[1][ROCK]     + incidence[2][ROCK]     + incidence[3][ROCK];
        int totP = incidence[0][PAPER]    + incidence[1][PAPER]    + incidence[2][PAPER]    + incidence[3][PAPER];
        int totS = incidence[0][SCISSORS] + incidence[1][SCISSORS] + incidence[2][SCISSORS] + incidence[3][SCISSORS];
        if (totR>totP && totR>totS) return GameObject.PAPER;    // chooses ROCK most often,     counter with PAPER
        if (totP>totR && totP>totS) return GameObject.SCISSORS; // choosee PAPER most often,    counter with SCISSORS
        if (totS>totR && totS>totP) return GameObject.ROCK;     // chooses SCISSORS most often, counter with ROCK
        return randGen.queryThrow();
    }
    
    private void countIncidence( int depth )
    {
        int rc = 0;
        String pattern = archive.substring( archiveLength-depth, archiveLength );
        Pattern expression = Pattern.compile(pattern);
        Matcher matcher = expression.matcher(archive);
        int restart = 0;
        while (matcher.find(restart)) {
            restart = matcher.start()+2;
            if (matcher.end()<archiveLength-1) {
                char ch = Character.toUpperCase( archive.charAt(matcher.end()) );
                switch (ch) {
                    case 'R': incidence[depth-MIN_DEPTH][ROCK]++;     break;
                    case 'P': incidence[depth-MIN_DEPTH][PAPER]++;    break;
                    case 'S': incidence[depth-MIN_DEPTH][SCISSORS]++; break;
                }
            }
        }
        displayIncidenceRow( pattern, depth );
    }
    
    private void displayIncidenceRow( String pat, int depth ) {
        if (depth==MIN_DEPTH) {
            System.out.printf( "     INCIDENCE TABLE working with archive: %s\n", archive );
            System.out.printf( "  matching   R  P  S\n" );
        }
        System.out.printf( "    %5s  %3d%3d%3d\n", 
                pat, 
                incidence[depth-MIN_DEPTH][ROCK], 
                incidence[depth-MIN_DEPTH][PAPER], 
                incidence[depth-MIN_DEPTH][SCISSORS] );
    }
}

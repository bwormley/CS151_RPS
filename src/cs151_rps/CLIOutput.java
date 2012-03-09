package cs151_rps;

import java.util.Locale;
import static cs151_rps.Message.ID.*;

/**
 * Handle all output for the Command Line Interface endpoint
 * 
 * @author Team Lunar
 */
public class CLIOutput extends Output
{

    CLIOutput( Locale locale )
    {
        msg = Message.factory(locale);
    }

    @Override
    public void displayNewRound()
    {
        System.out.println();
    }
    
    @Override
    public void displayHelp()
    {
        System.out.println( msg.getMessage(HELP) );
    }

    @Override
    public void displayScore( String player1Name, 
                              long   player1Wins, 
                              String player2Name, 
                              long   player2Wins, 
                              long   ties )
    {
        System.out.print( "   " + msg.getMessage(SCORE_HEADER) + " " );
        System.out.print( player1Name + " " + msg.getMessage(ROUND_WIN_REPORT) + player1Wins + ", " );
        System.out.print( player2Name + " " + msg.getMessage(ROUND_WIN_REPORT) + player2Wins + ", " );
        System.out.println( msg.getMessage(ROUND_TIE_REPORT) + ties );
    }
    
    @Override
    public void displayWelcome()
    {
        System.out.println( msg.getMessage(WELCOME) );
    }
    
    @Override
    public void displayNamePrompt()
    {
        System.out.print( msg.getMessage(PROMPT_NAME) + " " );
    }

    @Override
    public void displayRound( long roundNumber, long maxRounds )
    {
        System.out.println( msg.getMessage(ROUND) + " " + roundNumber + "/" + maxRounds );
    }

    @Override
    public void displayRoundsPrompt()
    {
        System.out.println( msg.getMessage(PROMPT_ROUNDS) );
    }

    @Override
    public void displayRoundWinner( String playerName )
    {
        System.out.println( playerName + " " + msg.getMessage(ROUND_WIN_ANNOUNCE) );
    }

    @Override
    public void displayRoundTie( String player1Name, String player2Name )
    {
        //TODO: better message, using names?
        System.out.println( msg.getMessage(ROUND_TIE_ANNOUNCE) );
    }

    @Override
    public void displayMatchWinner( String playerName )
    {
        System.out.println( playerName + " " + msg.getMessage(MATCH_WIN_ANNOUNCE) );
    }

    @Override
    public void displayChoice( String playerName, 
                               GameObject gesture )
    {
        // TODO: displayChoice
    }
    
    @Override
    public void displayUserPrompt( String playerName )
    {
        System.out.print( playerName + ": " + msg.getMessage(USER_PROMPT) );
    }

    @Override
    public void displayUserInputError()
    {
        // TODO: displayUserInputError
    }
    
    @Override
    public void displayThrow( String name, GameObject gesture )
    {
        System.out.print( name + " " + msg.getMessage(GESTURE_VERB) + " " );

        switch (gesture)
        {
            case ROCK     : System.out.println(msg.getMessage(ROCK));     break;
            case PAPER    : System.out.println(msg.getMessage(PAPER));    break;
            case SCISSORS : System.out.println(msg.getMessage(SCISSORS)); break;
        }
    }

}

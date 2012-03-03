/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151_rps;

import static cs151_rps.MessageType.*;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author bwormley
 */
public class GameController {
    /**
    * Constructor
    */
    public GameController()
    {
        message = new Message("");
    }

    private Referee referee;
    private Scorecard scorecard;
    private Message message;
    private String playerName;
    private
    int maxRounds;
    Player player1;
    Player player2;
    
    public void main()
    {        
        System.out.print( message.getMessage(WELCOME) );
        System.out.print( message.getMessage(PROMPT_NAME) );
//        Scanner scan = new Scanner(System.in);
        try {
            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);
            playerName = in.readLine();
        }
        catch (Exception e) {
            System.out.println("Error!  Exception: " + e );
        }
        try {
            player1 = new UserPlayer(playerName);
            player2 = new ComputerPlayer("The Computer");
        }
        catch (Exception e) {
            System.out.println("Error:  Exception: " + e );
            // TODO: fatal error: abort here, with cosolation.
        }
        
        scorecard = new Scorecard( message, player1, player2 );
        
        referee = new Referee( scorecard );
        
        System.out.print( message.getMessage(PROMPT_ROUNDS) );
        
        Scanner scan = new Scanner(System.in);
	if(scan.hasNext())
            maxRounds = scan.nextInt();

        for ( int round=1; round <= maxRounds; round++ ) {
            
            GameObject player1Throw = player1.queryThrow();
            GameObject player2Throw = player2.queryThrow();
            Referee.Winner winner = referee.determineWinner( player1Throw, player2Throw );
            if (winner==Referee.Winner.PLAYER1)
                System.out.println( player1.getName() + " " + message.getMessage(WINS));
            else if (winner==Referee.Winner.PLAYER2)
                System.out.println( player2.getName() + " " + message.getMessage(WINS));
            else 
                System.out.println( player1.getName() + " " + message.getMessage(TIES) + " " + player2.getName() );

            scorecard.displayScore();
            
        }
                                                    
    }
    
}

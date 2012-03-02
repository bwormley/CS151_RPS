/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151_rps;

import static cs151_rps.MessageType.*;

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
        referee = new Referee();
        message = new Message("");
    }

    private Referee referee;
    private Message message;
    private String playerName;
    int maxRounds;
    
    public void main()
    {        
        System.out.print( message.getMessage(WELCOME) );
        System.out.print( message.getMessage(PROMPT_NAME) );
        // input player name
        Player player1 = new UserPlayer(playerName);
        Player player2 = new ComputerPlayer("Computer");
        System.out.print( message.getMessage(PROMPT_ROUNDS) );
        for ( int round=1; round < maxRounds; round++ ) {
            GameObject player1Throw = player1.queryThrow();
            GameObject player2Throw = player2.queryThrow();
            Referee.Winner winner = referee.determineWinner( player1Throw, player2Throw );
            if (winner==Referee.Winner.PLAYER1)
                System.out.println( player1.getName() + message.getMessage(WINS));
            else if (winner==Referee.Winner.PLAYER2)
                System.out.println( player2.getName() + message.getMessage(WINS));
            else 
                System.out.println( message.getMessage(TIES) );
            referee.getScore();
//          display score
            // PLAYER WINS: ###   TIES: ###   COMPUTER WINS: ###  
            // choice WINS THE MATCH
        }
                                                    
    }
    
}

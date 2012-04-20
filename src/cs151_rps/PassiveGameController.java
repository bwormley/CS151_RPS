package cs151_rps;

import static cs151_rps.GameObject.ROCK;
import cs151_rps.player.ComputerPlayer;
import cs151_rps.player.Player;
import cs151_rps.score.Referee;
import cs151_rps.score.Scorecard;
import cs151_rps.io.mainGameFrame;
import cs151_rps.score.Referee.Winner;

/**
 * PASSIVE GAME CONTROLLER
 * 
 * This class is the controller for Swing-based IO, such that inversion of 
 * control dictates passive functions here.  Either this class (for GUI) 
 * or the original controller class (for CLI and remote) coordinate the 
 * game -- but not both.
 *
 * @author Team Lunar
 */
public class PassiveGameController extends GameController{
    
    /**
     * The object that implements the AI player, of selectable degrees 
     * of experience
     */
    private ComputerPlayer computerPlayer;
    
    /**
     * determines experience level (heuristic) of AI player.  
     * May be either "random" or "smart:
     */
    private String gameType;
    
    public mainGameFrame gf;
    
    //method to return maxNumberOfRounds
    public int getNumberOfRounds() {
        return maxNumberOfRounds; 
    }
    
    
    
    /**
     * called by the VIEW object once the user has chosen an experience level 
     * desired for the AI opponent.  This may be either 'random' or 'smart'
     * 
     * @param gameType 
     */
    public void setGameType( String gameType )
    {
        this.gameType = gameType;
        computerPlayer = (ComputerPlayer) Player.factory( "AI", "HAL", null );
        computerPlayer.setExperienceLevel(gameType);
        scorecard = new Scorecard();
        referee = new Referee( scorecard, gameType );
    }
    
    /**
     * called by the VIEW object once the user has selected a gesture of 
     * ROCK/PAPER/SCISSORS.  This method completes the running of the round, 
     * and reports the results back to the VIEW for display.  The VIEW object 
     * may compare the roundNumber with maxNumberOfRounds to see whether there 
     * are still rounds left to play in this match.
     * 
     * @param humanGesture human's choice of ROCK, PAPER, or SCISSORS
     * @return complete match statistics
     */
    public BoxScore humanThrows( GameObject humanGesture )
    {
        // get the AI's move
        GameObject computerGesture = ROCK;
        try {
            computerGesture = computerPlayer.queryThrow();
        }
        catch (Exception e) {}
        
        // manage this round of play
        roundNumber++;
        Winner winner = referee.determineWinner( humanGesture, computerGesture );
        
        // prep results, and return it to the VIEW
        BoxScore score               = new BoxScore();
        score.computersMove          = computerGesture;
        score.computersPredictedMove = calculatePredictedMove(computerGesture);
        score.roundNumber            = roundNumber;
        score.maxNumberOfRounds      = maxNumberOfRounds;
        score.numberOfHumanWins      = scorecard.getPlayerOneScore();
        score.numberOfComputerWins   = scorecard.getPlayerTwoScore();
        score.numberOfTies           = scorecard.getNumOfTies();
        score.winner                 = winner;
        return score;
    }
    
    /*This method calculates what the computer predicted the human's move is,
     * based on the computer's move.
     */
    private GameObject calculatePredictedMove(GameObject compGesture)
    {
        if (gameType.equalsIgnoreCase("random"))
            return null;
        if(compGesture == GameObject.PAPER)
            return GameObject.ROCK;
        if(compGesture == GameObject.ROCK)
            return GameObject.SCISSORS;
        else
            return GameObject.PAPER;
    }
    
    public void run()
    {
        gf.start();
    }

}

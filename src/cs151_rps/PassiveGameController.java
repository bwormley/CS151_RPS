package cs151_rps;

import cs151_rps.player.ComputerPlayer;
import cs151_rps.player.Player;
import cs151_rps.score.Referee;
import cs151_rps.score.Scorecard;
import static cs151_rps.GameObject.*;

/**
 *
 * @author Team Lunar
 */
public class PassiveGameController {
    
    private Referee referee;
    private Scorecard scorecard;
    private ComputerPlayer computerPlayer;
    private int maxNumberOfRounds;
    private int roundNumber;
    
    public class BoxScore {
        public GameObject computersMove;
        GameObject computersPredictedMove;
        public int roundNumber;
        public int maxNumberOfRounds;
        public int numberOfHumanWins;
        public int numberOfComputerWins;
        public int numberOfTies;        
    }
        
    int maxRounds;
    public void setNumberOfRounds( int numberOfRounds )
    {
        maxNumberOfRounds = numberOfRounds;
    }
    
    public void setGameType( String gameType )
    {
        computerPlayer = (ComputerPlayer) Player.factory( "AI", "HAL", null );
        computerPlayer.setExperienceLevel(gameType);
        scorecard = new Scorecard();
        referee = new Referee( scorecard, gameType );
    }
    
    public BoxScore humanThrows( GameObject humanGesture )
    {
        GameObject computerGesture = ROCK;
        try {
            computerGesture = computerPlayer.queryThrow();
        }
        catch (Exception e) {}
        
        roundNumber++;
        BoxScore score = new BoxScore();
        referee.determineWinner( humanGesture, computerGesture );
        score.computersMove = computerGesture;
        score.roundNumber = roundNumber;
        score.maxNumberOfRounds = maxNumberOfRounds;
        score.numberOfHumanWins = scorecard.getPlayerOneScore();
        score.numberOfComputerWins = scorecard.getPlayerTwoScore();
        score.numberOfTies = scorecard.getNumOfTies();
        return score;
    }

}

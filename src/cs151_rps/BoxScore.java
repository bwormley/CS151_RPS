package cs151_rps;

import cs151_rps.GameObject;
import cs151_rps.score.Referee.Winner;

/**
 * this record used to return results to the VIEW class -- current match 
 * statistics to date
 * 
 * @author Team Lunar
 */
public class BoxScore {
    public GameObject computersMove;
    public GameObject computersPredictedMove;
    public int        roundNumber;
    public int        maxNumberOfRounds;
    public int        numberOfHumanWins;
    public int        numberOfComputerWins;
    public int        numberOfTies;
    public Winner     winner;
}

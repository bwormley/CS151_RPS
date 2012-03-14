package cs151_rps;


/**
 *
 * @author Team Lunar
 */
public class EphemeralHistory extends History {
    
    protected EphemeralHistory()
    {
        super();
    }

    @Override
    public void addRound(GameObject player1, GameObject player2) {
        switch (player1) {
            case ROCK: archive += "R"; break;
            case PAPER: archive += "P"; break;
            case SCISSORS: archive += "S"; break;
        }
        switch (player2) {
            case ROCK: archive += "r"; break;
            case PAPER: archive += "p"; break;
            case SCISSORS: archive += "s"; break;
        }
    }

    @Override
    public String getHistory() {
        return archive;
    }

    @Override
    public int getHistoryLength() {
        return archive.length();
    }
    
}

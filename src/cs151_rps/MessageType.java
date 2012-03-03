/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151_rps;

/**
 *
 * @author bwormley
 */
public enum MessageType {
    RUN_USAGE("Usage: rps [-r <number of rounds>]"),
    ROUND("round"),
    PLAY_USAGE("Enter 1=ROCK, 2=PAPER, 3=SCISSORS, h=help, s=score, q=quit [h]: "),
    HELP("Scissors beats paper. Papeer beats rock.  Rock beats scissors."),
    SHOW_SCORE("Score: "),
    PROMPT_NAME("Enter your name: "),
    PROMPT_ROUNDS("Enter the number of rounds you would like to play: "),
    INVALID_INPUT("Invalid input"),
    ROCK("ROCK"),
    PAPER("PAPER"),
    SCISSORS("SCISSORS"),
    WELCOME("Welcome to the Lunar Team's Rock/Paper/Scissors game."),
    WINS("wins!"),
    TIES("ties"),
    QUIT_CONFIRM("Are you sure you want to quit?"),
    WINS_MATCH("wins the match!");
    
    private String text;
    MessageType( String text ) 
    { 
        this.text = text; 
    }
    public String getText()
    { 
        return text;
    }
}

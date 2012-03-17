package cs151_rps.io;

import static cs151_rps.io.Message.ID.*;

/**
 * English localization: Implement English string associations with message IDs.
 *
 * @author Team Lunar
 */
public class EnglishMessage extends Message
{
    public EnglishMessage()
    {        
    }

    /**
     * Retrieve the localized string associated with the message ID
     * 
     * @param id message ID
     * @return localized string
     */
    @Override
    public String getMessage( ID id )
    {
        switch (id) {
            case RUN_USAGE:          return "Usage: rps [-r <number of rounds>]";
            case ROUND:              return "round";
            case USER_PROMPT:        return "Enter 1=ROCK, 2=PAPER, 3=SCISSORS, 4=help, 5=score, 6=quit [4]: ";
            case HELP:               return "Scissors beats paper. Paper beats rock.  Rock beats scissors.";
            case SHOW_SCORE:         return "Score: ";
            case PROMPT_NAME:        return "Enter your name: ";
            case PROMPT_ROUNDS:      return "Enter the number of rounds you would like to play: ";
            case INVALID_INPUT:      return "Invalid input";
            case ROCK:               return "ROCK";
            case PAPER:              return "PAPER";
            case SCISSORS:           return "SCISSORS";
            case WELCOME:            return "Welcome to the Lunar Team's Rock/Paper/Scissors game.";
            case ROUND_WIN_ANNOUNCE: return "wins!";
            case ROUND_WIN_REPORT:   return "Wins: ";
            case ROUND_TIE_ANNOUNCE: return "ties";
            case ROUND_TIE_REPORT:   return "Ties: ";
            case QUIT_CONFIRM:       return "Are you sure you want to quit?";
            case MATCH_WIN_ANNOUNCE: return "WINS THE MATCH!";
            case MATCH_TIE_ANNOUNCE: return "The match ends in a TIE!";
            case GESTURE_VERB:       return "gestures";
            case SCORE_HEADER:       return "MATCH STATUS";
            case QUIT:				 return "Quitting...\nProgram has exited"; 
            default: return "**loc not impl**";
        }
    }
}

package cs151_rps;

import java.util.Random;

/**
 *
 * @author Team Lunar
 */
public class RandomThrowGenerator extends ThrowGenerator
{
    
    /**
     * Finds out a computer's choice. A random decision.
     */
    @Override
    GameObject queryThrow() throws Exception
    {
        Random rand = new Random();
        int choice = rand.nextInt(3);

        if(choice == 1)
        {
            return GameObject.ROCK;
        }
        else if(choice == 2)
        {
            return GameObject.PAPER;
        }
        else 
        {
            return GameObject.SCISSORS;
        }
    }	//end of queryThrow

}

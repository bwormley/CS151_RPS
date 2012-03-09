package cs151_rps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Team Lunar
 */
public class CLIUserInput extends UserInput
{
    
    @Override 
    public String getPlayerName() throws Exception
    {
        try {
            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);
            return in.readLine();
        }
        catch (Exception e) {
            System.out.println("Error!  Exception: " + e );
        }
        return null;
    }
    
    @Override
    public int getThrow()
    {
        Scanner scan = new Scanner(System.in);
        int choice = 5;
        if(scan.hasNext())
            choice = scan.nextInt();
        return choice;
    }

}

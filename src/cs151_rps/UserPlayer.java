/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151_rps;

import java.util.Scanner;

import static cs151_rps.GameObject.*;



public class UserPlayer extends Player 
{
	
	public UserPlayer(String name, Message mess ) 
	{
		super(name,mess);
	}

	/**
	 * Finds out user's choice and returns it
	 * @throws Exception 
	 */
	@Override
	GameObject queryThrow() throws Exception 
	{
		
		// query for throw, loop until player chooses
                while (true) {

                    //Prompt for the user's choice
                    Scanner scan = new Scanner(System.in);
                    System.out.println(mess.getMessage(MessageType.USER_PROMPT));
                    int choice = 5;
                    if(scan.hasNext())
                        choice = scan.nextInt();
                    
                    switch(choice) {
                        case 1: // ROCK
                            return GameObject.ROCK;
                        case 2: // PAPER
                            return GameObject.PAPER;
                        case 3: // SCISSORS
                            return GameObject.SCISSORS;
                        case 5: // SCORE
                            score.displayScore();
                            break;
                        case 6: // QUIT
                            throw new Exception("user abort");
                        default: // INVALID INPUT
                            System.out.println(mess.getMessage(MessageType.INVALID_INPUT));                        
                        case 4: // HELP (default)
                            System.out.println(mess.getMessage(MessageType.HELP));
                            break;
                    }
                }		

	}	//end of queryThrow

}	//end of UserPlayer

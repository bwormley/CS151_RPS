/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151_rps;

import java.util.Scanner;

import cs151_rps.GameObject;



public class UserPlayer extends Player 
{
	
	/**
	 * Finds out user's choice and returns it
	 */
	@Override
	GameObject queryThrow() 
	{
		//Prompts for the user's choice
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter in your choice: /n" +
				"1 for rock /n" +
				"2 for paper /n" +
				"3 for scissor /n ");
		int object = 0;
		
		if(scan.hasNext())
		{
			object = scan.nextInt();
			object = object%3;
		}
		
		//decides the user's choice
		if(object == 0)
		{
			return GameObject.ROCK;
		}
		else if(object == 1)
		{
			return GameObject.PAPER;
		}
		else //default is scissors
		{
			return GameObject.SCISSORS;
		}
		

	}	//end of queryThrow
        
        UserPlayer( String name )
        {
            super( name );
        }


}	//end of UserPlayer

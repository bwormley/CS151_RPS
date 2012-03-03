/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151_rps;

import java.util.Scanner;

import cs151_rps.GameObject;



public class UserPlayer extends Player 
{
	
	public UserPlayer(String name) 
	{
		super(name);
	}

	/**
	 * Finds out user's choice and returns it
	 * @throws Exception 
	 */
	@Override
	GameObject queryThrow() throws Exception 
	{
		//Prompts for the user's choice
		Scanner scan = new Scanner(System.in);
		Message mess = new Message("English");
		System.out.println(mess.getMessage(MessageType.PLAY_USAGE));
		String choice = "";
		
		if(scan.hasNext())
		{
			choice = scan.next();
			choice = choice.trim();
			
		}
		
		//decides the user's choice
		if(choice.equalsIgnoreCase("rock"))
		{
			return GameObject.ROCK;
		}
		else if(choice.equalsIgnoreCase("paper"))
		{
			return GameObject.PAPER;
		}
		else if(choice.equalsIgnoreCase("scissors"))//default is scissors
		{
			return GameObject.SCISSORS;
		}
		else if(choice.equalsIgnoreCase("help"))
		{
			System.out.println(mess.getMessage(MessageType.PLAY_USAGE));
			
			return null;
		}
		else if(choice.equalsIgnoreCase("score"))
		{
			System.out.println(	score.getPlayerOneScore());	//output score
			return null;
		}
		else if(choice.equalsIgnoreCase("quit"))
		{
			throw new Exception();
		}
		else
		{
			System.out.println(mess.getMessage(MessageType.INVALID_INPUT));
			return null;
		}
		

	}	//end of queryThrow
        



}	//end of UserPlayer

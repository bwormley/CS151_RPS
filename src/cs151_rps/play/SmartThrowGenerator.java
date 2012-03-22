package cs151_rps.play;

import cs151_rps.GameObject;

public class SmartThrowGenerator extends ThrowGenerator
{
	private Analysis analysis;
	
	private RandomThrowGenerator rand;
	private int n;
	
	public SmartThrowGenerator()
	{
		analysis = Analysis.factory("shortTerm");
		
		rand = new RandomThrowGenerator();
		//default
		n = 3;
	}
	
	public setN(int x)
	{
		n = x;
	}
	
	/**
     * Finds out a computer's choice by looking back at the history. 
     * This player's moves are upper case and other player's moves are lower case.
     */
    @Override
	public GameObject queryThrow() throws Exception
	{
		if (analysis.numberOfMovesSoFar <= n) 
		{
			return rand.queryThrow();
		}
		else 
		{
			//last strings
			String pastNMoves = analysis.pastNMoves(n);
			//possible other player's moves
			String Rnext = lastNMoves + "r";
			String Pnext = lastNMoves + "p";
			String Snext = lastNMoves + "s";
			//freq of possible moves
			int freqOfRNext = analysis.getFreq(Rnext);
			int freqOfPNext = analysis.getFreq(Pnext);
			int freqOfSNext = analysis.getFreq(Snext);

			/**
			 * Covers: 
			 * R > P > S 
			 * R > S > P 
			 * S > R > P 
			 * S > P > R 
			 * P > R > S 
			 * P > S > R
			 */

			if (freqOfRNext >= freqOfPNext && freqOfRNext >= freqOfSNext) 
			{
				//if rock is most likely to be played -> return paper
				return GameObject.PAPER;
			} 
			else if (freqOfSNext >= freqOfPNext && freqOfSNext >= freqOfRNext) 
			{
				//if scissors is most likely to be played -> return rock
				return GameObject.ROCK;
			} 
			else
			{
				//if paper is most likely to be played -> return scissors
				return GameObject.SCISSORS;
			}

		}

	}// end of QueryThrow
}// end of SmartThrowGenerator

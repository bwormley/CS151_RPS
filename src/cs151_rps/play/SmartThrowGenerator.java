package cs151_rps.play;

import cs151_rps.GameObject;
import cs151_rps.heuristics.Analysis;

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
	
	public void setN(int x)
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
//		if (analysis.getNumberOfMovesSoFar() <= n) 
//		{
//			return rand.queryThrow();
//		}
//		else 
//		{
//			//last strings
			String pastNMoves = analysis.getLastMoves(n);
			//possible other player's moves
			String Rnext = pastNMoves + "r";
			String Pnext = pastNMoves + "p";
			String Snext = pastNMoves + "s";
			//freq of possible moves
			int freqOfRNext = analysis.frequencyOf(Rnext);
			int freqOfPNext = analysis.frequencyOf(Pnext);
			int freqOfSNext = analysis.frequencyOf(Snext);

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

		//}

	}// end of QueryThrow
}// end of SmartThrowGenerator

package cs151_rps.play;

import cs151_rps.GameObject;
import cs151_rps.heuristics.Analysis;

public class SmartThrowGenerator extends ThrowGenerator
{
	private Analysis analysis;
	
	private RandomThrowGenerator rand;
	private int n;
	private int MAX_INT;
	private int MIN_INT;
	
	public SmartThrowGenerator()
	{
		analysis = Analysis.factory("shortTerm");
		
		rand = new RandomThrowGenerator();
		//default
		MAX_INT = 5;
		MIN_INT = 3;
		n = MIN_INT;
	}
	
	public void setN(int max, int min)
	{
		MAX_INT = max;
		MIN_INT = min;
	}
	
	private String BestOf(int n)
	{
		//last strings
		String pastNMoves = analysis.getLastMoves(n);
		
                //possible other player's moves
		String Rnext = pastNMoves + "R";
		String Pnext = pastNMoves + "P";
		String Snext = pastNMoves + "S";

		//freq of possible moves
		int freqOfRNext = analysis.frequencyOf(Rnext); 
		int freqOfPNext = analysis.frequencyOf(Pnext);
		int freqOfSNext = analysis.frequencyOf(Snext);
                System.out.println("count for "+Rnext+" = "+freqOfRNext); 
                System.out.println("count for "+Pnext+" = "+freqOfPNext); 
                System.out.println("count for "+Snext+" = "+freqOfSNext); 
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
			return "PAPER";//return GameObject.PAPER;
		} 
		else if (freqOfSNext >= freqOfPNext && freqOfSNext >= freqOfRNext) 
		{
			//if scissors is most likely to be played -> return rock
			return "ROCK";//return GameObject.ROCK;
		} 
		else if (freqOfPNext >= freqOfSNext && freqOfPNext >= freqOfRNext) 
		{
			//if paper is most likely to be played -> return scissors
			return "SCISSORS";//return GameObject.SCISSORS;
		}
		else
		{
			return "NULL";
		}
	}
	
	/**
     * Finds out a computer's choice by looking back at the history. 
     * This player's moves are upper case and other player's moves are lower case.
     */
    @Override
	public GameObject queryThrow() throws Exception
	{
            analysis.update();
            
            if (analysis.getArchiveSize() <= n) 
		{
			return rand.queryThrow();
		}
		else 
		{
			//for(n = MAX_INT; n >= MIN_INT; n--)
			//{
				String ans = BestOf(n);
				if(ans.equals("PAPER"))
					return GameObject.PAPER;
				if(ans.equals("ROCK"))
					return GameObject.ROCK;
				if(ans.equals("SCISSORS"))
					return GameObject.SCISSORS;
			//}
			throw new Exception();

		}

	}// end of QueryThrow
}// end of SmartThrowGenerator

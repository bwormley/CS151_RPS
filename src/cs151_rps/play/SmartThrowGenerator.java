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
		MIN_INT = 2;
		n = MIN_INT;
	}
	
	public void setN(int max, int min)
	{
		MAX_INT = max;
		MIN_INT = min;
	}
        
	private String BestOf(int n)
	{
                // since we're looking for human's next move, but the order 
                // from the History archive is (computer,human) we need to 
                // swap the order of the throws to construct the search 
                // pattern
		String pastNMoves = analysis.getLastMovesSwapped(n);
                
		// now finish constructing patterns for all possible 
                // human moves
		String Rnext = pastNMoves + "R";
		String Pnext = pastNMoves + "P";
		String Snext = pastNMoves + "S";
                
		// get the analysis of the frequency of the possible moves

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

		if (freqOfRNext>0 && freqOfRNext >= freqOfPNext && freqOfRNext >= freqOfSNext) 
		{
			//if rock is most likely to be played -> return paper
			return "PAPER";//return GameObject.PAPER;
		} 
		else if (freqOfSNext>0 && freqOfSNext >= freqOfPNext && freqOfSNext >= freqOfRNext) 
		{
			//if scissors is most likely to be played -> return rock
			return "ROCK";//return GameObject.ROCK;
		} 
		else if (freqOfPNext>0 && freqOfPNext >= freqOfSNext && freqOfPNext >= freqOfRNext) 
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
	public GameObject queryThrow()
	{
            analysis.update();
            
            if (analysis.getArchiveSize() <= n) 
		{
			return rand.queryThrow();
		}
		else 
		{
			for(n = MAX_INT; n >= MIN_INT; n--)
			{
				String ans = BestOf(n);
				if(ans.equals("PAPER"))
					return GameObject.PAPER;
				if(ans.equals("ROCK"))
					return GameObject.ROCK;
				if(ans.equals("SCISSORS"))
					return GameObject.SCISSORS;
			}
		}
            return rand.queryThrow();
	}// end of queryThrow
}// end of SmartThrowGenerator

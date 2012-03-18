package cs151_rps.play;

import cs151_rps.GameObject;

public class SmartThrowGenerator extends ThrowGenerator
{
	private Analysis analysis;
	private History hist;
	
	public SmartThrowGenerator()
	{
		analysis = Analysis.factory("shortTerm");
		hist = History.factory("shortTerm");
	}
	
	/**
     * Finds out a computer's choice by looking back at the history.
     */
    @Override
	public GameObject queryThrow() throws Exception
	{
    	if(analysis.numberOfMovesSoFar <= 3)
    	{
    		//do whatever fits
    		return null;//TODO change
    	}
    	else
    	{
		int nMoves = 3;
		String lastNMoves = hist.getLastMoves(3);
		String Rnext = lastNMoves + "r";
		String Pnext = lastNMoves + "p";
		String Snext = lastNMoves + "s";
		
		int freqOfRNext = analysis.getFreq(Rnext);
		int freqOfPNext = analysis.getFreq(Pnext);
		int freqOfSNext = analysis.getFreq(Snext);
		
		
		/**
		 * Covers:
		 *  R > P > S
			R > S > P
			S > R > P
			S > P > R
			P > R > S
			P > S > R
		 */
		
		if(freqOfRNext >= freqOfPNext && freqOfRNext >= freqOfSNext)
		{
			return GameObject.ROCK;
		}
		else if(freqOfSNext >= freqOfPNext && freqOfSNext >= freqOfRNext)
		{
			return GameObject.SCISSORS;
		}
		else 
		{
			return GameObject.PAPER;
		}
    	
    	}
		
    	
	}
}

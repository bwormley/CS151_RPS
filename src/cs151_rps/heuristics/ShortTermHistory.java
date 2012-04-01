package cs151_rps.heuristics;

import cs151_rps.GameObject;

/**
 * Implements an ephemeral History of RPS gestures.  The store persists for the 
 * duration of the execution of the program.  See the base class for description 
 * of the member functions.
 * 
 * @author Team Lunar
 */
class ShortTermHistory extends History {

 
    
    /**
     * Constructor
     */
    protected ShortTermHistory() 
    {
        super();
        // this subclass does not persist its archive
        archive = new String();
    }

    
    
    @Override
    public void addRound(GameObject humanPlayerGesture, 
                         GameObject computerPlayerGesture) 
    {
        
        // set archive as having been modified
        archiveModified = true;
        
        // add computer gesture first
        switch (computerPlayerGesture)
        {
            case ROCK:     archive += "r"; break;
            case PAPER:    archive += "p"; break;
            case SCISSORS: archive += "s"; break;
        }

        // add human gesture second
        switch (humanPlayerGesture)
        {
            case ROCK:     archive += "R"; break;
            case PAPER:    archive += "P"; break;
            case SCISSORS: archive += "S"; break;
        }
        
        // only keep MAX_DEPTH gestures, max
        if (archive.length()>MAX_DEPTH)
            archive = archive.substring(archive.length()-MAX_DEPTH);
    }

    
    
    @Override
    String getLastMoves(int numberOfMoves) 
    {
        // retrieve the desired gestures
        if (numberOfMoves>0 && numberOfMoves<=archive.length())
            return archive.substring(archive.length()-numberOfMoves);
        return "";
    }
    
    // algorithm note: get number of moves, rounded up (ie, whole r/p/s rounds), 
    // then do the swap, then return the subset requested
    @Override
    String getLastMovesSwapped(int numberOfMoves)
    {
        if (numberOfMoves>0 && (numberOfMoves+numberOfMoves%2)<=archive.length())
        {
            String pattern = getLastMoves(numberOfMoves+numberOfMoves%2);
            char[] patternArray = pattern.toCharArray();
            int swaps = pattern.length()/2;
            for ( int i=0; i<swaps; i++ )
            {
                char tempChar = patternArray[i*2];
                patternArray[i*2] = patternArray[i*2+1];
                patternArray[i*2+1] = tempChar;
            }
            return String.copyValueOf( patternArray, numberOfMoves%2, numberOfMoves );
        }
        return "";
    }

    
    
    @Override
    int getArchiveSize() 
    {
        return archive.length();
    }

    
    
    @Override
    public void saveArchive() 
    {
        // this subclass does not persist its archive
    }
}

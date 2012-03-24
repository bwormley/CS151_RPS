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
        
        // add human gesture first
        switch (humanPlayerGesture)
        {
            case ROCK:     archive += "R"; break;
            case PAPER:    archive += "P"; break;
            case SCISSORS: archive += "S"; break;
        }
        
        // add computer gesture second
        switch (computerPlayerGesture)
        {
            case ROCK:     archive += "r"; break;
            case PAPER:    archive += "p"; break;
            case SCISSORS: archive += "s"; break;
        }

        // only keep MAX_DEPTH gestures, max
        if (archive.length()>MAX_DEPTH)
            archive = archive.substring(archive.length()-MAX_DEPTH);
    }

    
    
    @Override
    String getLastMoves(int numberOfMoves) 
    {
        // clear archiveModified bit: caller is now up-to-date
        archiveModified = false;
        
        // retrieve the desired gestures
        if (numberOfMoves>0 && numberOfMoves<=archive.length())
            return archive.substring(archive.length()-numberOfMoves);
        return null;
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

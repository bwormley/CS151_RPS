package cs151_rps.io;

import java.util.Locale;

/**
 * Abstract class which provides message IDs for all displayable messages, 
 * allowing subclasses to map IDs to localized strings
 * 
 * @author Team Lunar
 */

abstract public class Message {
    
    Message()
    {
    }
    
    /**
     * Generate an object capable of mapping message IDs to localized strings
     * 
     * Note: passing in a null locale is interpreted as using the default 
     * locale on the running platform.  If this localization is not supported, 
     * the default localization for this application is substituted.
     * 
     * @param locale the requested localization for all output
     * @return localized Message subclass
     */
    public static Message factory(String localeString)
    {
        
        // if needed, get the platform default locale
        if (localeString==null || localeString.isEmpty())
            localeString = 
                    Locale.getDefault().getISO3Language()
                    + "_"
                    + Locale.getDefault().getISO3Country();
        
        // instantiate the appropriate localized subclass
        if (localeString.equals("en_US"))
            return new EnglishMessage();
        
        if (localeString.equals("fa_IR"))
            return new PersianMessage();
        
        // if the locale is not supported, instantiate the application default locale
        return new EnglishMessage();
    }

    /**
     * Comprehensive list of IDs for all output strings
     * 
     * Note: these IDs are to be mapped to strings that can be represented 
     * atomically after localization.  More complex strings are composed 
     * in classes derived from the Output abstract class.
     */
    public enum ID {
        RUN_USAGE,
        ROUND,
        USER_PROMPT,
        HELP,
        SHOW_SCORE,
        PROMPT_NAME,
        PROMPT_ROUNDS,
        INVALID_INPUT,
        ROCK,
        PAPER,
        SCISSORS,
        WELCOME,
        ROUND_WIN_ANNOUNCE,
        ROUND_WIN_REPORT,
        ROUND_TIE_ANNOUNCE,
        ROUND_TIE_REPORT,
        QUIT_CONFIRM,
        MATCH_WIN_ANNOUNCE,
        MATCH_TIE_ANNOUNCE,
        GESTURE_VERB,
        SCORE_HEADER,
        QUIT
    }

    /**
     * Retrieve a locale-specific displayable string for a given message ID
     * 
     * @param id
     * @return the localized message
     */
    abstract public String getMessage( ID id );
    
}

package cs151_rps;

import java.util.HashMap;

/**
 * Parse a command line for arguments 
 * 
 * @author: CS151 Team Lunar
 */
public final class ParseCL
{
    static public final String NUM_ROUNDS_OPTION = "-r";
    static public final String EXPERIENCE_OPTION = "--level";
    static public final String IO_OPTION         = "--io";
    static public final String LANG_OPTION       = "--lang";
    static public final String PLAYER_ONE_OPTION = "--p1";
    static public final String PLAYER_TWO_OPTION = "--p2";
    
    static        final String Usage = 
"Usage: \n" +
"PARAMETER                        DESCRIPTION\n" +
"---------                        -----------\n" +
"-r <rounds>                      default: 32\n" +
"--level {random|smart|expert}    sets experience (default: smart)\n" +
"--io {cli|swing|remote}          interface (default: cli)\n" +
"--lang <locale>                  language (default: en_US)\n" +
"--p1 {human,AI}                  Player 1 identity (default: human)\n" +
"--p2 {human,AI}                  Player 2 identity {default: AI)\n";



    String defaultNumRounds = "32";
    String defaultLevel     = "smart";
    String defaultIO        = "cli";
    String defaultLang      = "";
    String defaultP1        = "human";
    String defaultP2        = "AI";
    
    
    /**
     * Enumerate the different command line parameter types
     */
    public enum ParamType { NONE, INTEGER, STRING }
    
    /**
     * Hold the parameters parsed from the command line
     */
    private HashMap<String,Object> param;
    
    /**
     * Hold the options available for a command line
     */
    private HashMap<String,ParamType> opt;
    
    /*
     * Constructor
     */
    ParseCL()
    {
        param = new HashMap<String,Object>();
        opt = new HashMap<String,ParamType>();
        
        setOption( NUM_ROUNDS_OPTION, ParamType.INTEGER );
        setOption( EXPERIENCE_OPTION, ParamType.STRING );
        setOption( IO_OPTION,         ParamType.STRING );
        setOption( LANG_OPTION,       ParamType.STRING );
        setOption( PLAYER_ONE_OPTION, ParamType.STRING );
        setOption( PLAYER_TWO_OPTION, ParamType.STRING );
    }
    
    /**
     * Set a command line option
     * 
     * @param key text of a command line option 
     * @param paramType type of command line option, including whether extra parameters
     */
    public void setOption( String key, ParamType paramType )
    {
       opt.put(key, paramType);
    }
    
    /**
     * Parse the tokens on the command line into valid options
     * 
     * @param args
     * @throws IllegalArgumentException 
     */
    public void parse( String[] args ) 
        throws IllegalArgumentException, Exception
    {
        if(args.length == 0) {
            throw new Exception("GUI");
        }
            for ( int ix = 0; ix<args.length; ix++ ) {
            String key = args[ix];
            String val = "";
            if (!opt.containsKey(key))
                throw new IllegalArgumentException(key+" not valid");
            if (opt.get(key)!=ParamType.NONE) {
                if (ix+1>=args.length)
                    throw new IllegalArgumentException(key+" requires an argument, which is missing");
                val = args[++ix];
            }
            param.put( key, val );
        }
        
        // inspect each potential option, and include a default if one is missing
        if (!getParam(NUM_ROUNDS_OPTION))
            param.put(NUM_ROUNDS_OPTION,defaultNumRounds);
        if (!getParam(EXPERIENCE_OPTION))
            param.put(EXPERIENCE_OPTION,defaultLevel);
        if (!getParam(IO_OPTION))
            param.put(IO_OPTION,defaultIO);
        if (!getParam(LANG_OPTION))
            param.put(LANG_OPTION,defaultLang);
        if (!getParam(PLAYER_ONE_OPTION))
            param.put(PLAYER_ONE_OPTION,defaultP1);
        if (!getParam(PLAYER_TWO_OPTION))
            param.put(PLAYER_TWO_OPTION,defaultP2);
    }
    
    public void displayUsage()
    {
        System.out.println(Usage);
    }
    
    /**
     * return value of a boolean option if specified
     * 
     * @param key
     * @return 
     */
    public boolean getParam( String key )
    {
        return param.containsKey(key);
    }
    
    /**
     * return value of an integer option
     * 
     * @param key expected on command line
     * @return integer value parsed from string
     * @throws IllegalArgumentException which wraps a NumberFormatException
     */
    public int getIntParam( String key ) throws IllegalArgumentException
    {
        int result = 0;
        
        if (param.containsKey(key)) {
            try {
                result = Integer.parseInt((String)param.get(key));
            }
            catch (NumberFormatException e) {
                throw new IllegalArgumentException(key+" requires numeric argument.\n"+e.toString());
            }
        }

        return result;
    }
    
    /**
     * return string associated with a parameter which required an option
     * 
     * @param key
     * @return the option
     * @throws IllegalArgumentException if argument not on command line
     * Note: test for existence with getParam()
     */
    public String getStringParam( String key ) throws IllegalArgumentException
    {
        String result;
        
        if (!param.containsKey(key))
            throw new IllegalArgumentException( key+" requires string argument");
        result = (String)param.get(key);
        if (result==null)
            throw new IllegalArgumentException( key+" has null argument" );
        return result;
    }
}

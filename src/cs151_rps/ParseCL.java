package cs151_rps;

import java.util.HashMap;
import java.lang.Integer;
import java.lang.IllegalArgumentException;

/**
 * Parse a command line for arguments 
 * 
 * @author: CS151 Team Lunar
 */
public class ParseCL
{
    
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
        throws IllegalArgumentException
    {
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

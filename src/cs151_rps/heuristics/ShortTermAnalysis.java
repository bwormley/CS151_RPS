/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151_rps.heuristics;

import java.util.HashMap; 

/**
 *
 * @author Sohi_x2
 */
public class ShortTermAnalysis extends Analysis {
    public HashMap<String, Integer> shortTerm = new HashMap<String, Integer>();  
    
    public ShortTermAnalysis(String string)
    {
        super(string);
    }
    
    /* add the key in the map if it doesn't exist. 
     * if it key does exist, increment the value */
    protected void add(String str)
    {
        str = str.toLowerCase(); 
        if(str != null) {
            if (!shortTerm.containsKey(str)) 
                shortTerm.put(str, new Integer(1)); 
            else {
                int value = shortTerm.get(str);
                value++; 
                shortTerm.put(str, value); 
            }
        }
    } //end add 
    
    /* call the history method to get the last N moves starting from the max
     * N level to the min N leve */
    @Override
    public void update() 
    {
        if (history.isModified() == true)
            return; 
        
        int i;  
        for (i = MAX_DEPTH; i >= MIN_DEPTH; i--) {
            this.add(history.getLastMoves(i)); 
        }
    } //end update 
    
    /* return the number of time the given pattern ocurred 
     @param - Example of patters: RPS, SPP, RRPP, SSPPR, etc. . . */
    @Override 
    public int frequencyOf(String pattern)
    {
        int value; 
        pattern = pattern.toLowerCase(); 
        
        if (shortTerm.containsKey(pattern))
            value = shortTerm.get(pattern); 
        else 
            value = 0; 
        
        return value; 
    }
    
}

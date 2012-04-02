package cs151_rps.heuristics;

import java.util.HashMap; 
import java.util.Iterator; 

/**
 *
 * @author Team Lunar
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
        if(str != null) {
            if (!shortTerm.containsKey(str)) 
                shortTerm.put(str, 1); 
            else {
                int value = shortTerm.get(str);
                value++; 
                shortTerm.put(str, value); 
            }
        }
    } //end add 
    
    /* call the history method to get the last N moves starting from the max
     * N level to the min N level */
    @Override
    public void update() 
    {
        if (history.isModified()) {
            int i; 
            for(i = MAX_DEPTH; i >= MIN_DEPTH; i--) {
                //if(history.getLastMoves(i) != null)
                this.add(history.getLastMoves(i)); //store the past N moves
            }
        }
        history.upToDate();
    } //end update 
    
    /* return the number of time the given pattern ocurred 
     @param - Example of patters: RPS, SPP, RRPP, SSPPR, etc. . . */
    @Override 
    public int frequencyOf(String pattern)
    {
        int value; 
        if (shortTerm.containsKey(pattern)) {
            value = shortTerm.get(pattern); 
        }
        else 
            value = 0; 
        
        return value; 
    } //end method frequencyOf
    
    public void printMap(HashMap<String, Integer> map){
        System.out.println("printing map"); 
        Iterator it = map.keySet().iterator(); 
        if (map.isEmpty()) System.out.println("Map is empty"); 
        while(it.hasNext()) {
            String key = (it.next()).toString(); 
            System.out.println(key+": "+map.get(key)); 
        }
    }
    
} //end class ShortTermAnalysis 



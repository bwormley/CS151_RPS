
package cs151_rps.heuristics;  

/* The analysis will cretae a hashmap of strings. 
 * In hasmap, the keys will be strings and the value will be the number
 * of times those moves took place.*/

/* Analysis class doesn't know what the N level is. The History class will know 
 * the N level. And based on that N level, the History class will pass N length 
 * of string. */

public interface Analysis {
    
    //This history class will pass the the N moves to add in hashmap
    public String getMoves(String moves); 
    
    //If the String moves already exist in the map, the value will be incremented
    //by one. Else the moves will be added and the value will be one. 
    public void addMoves(String moves); 
    
    //This method will give the Smart Throw Generator class what the predicsted 
    //next move is. 
    public String predictedMove(int N); 
    
    //This method will will fetch the recent N moves from the History class to 
    //predict the next move. 
    public String pastNMoves(int N); 
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151_rps.heuristics;

import cs151_rps.GameObject;
import java.util.Iterator; 
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Sohi_x2
 */
public class ShortTermAnalysisTest {
    
    private ShortTermAnalysis st; 
    public ShortTermAnalysisTest() {
        st = new ShortTermAnalysis(""); 
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class ShortTermAnalysis.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        st.add("RPS");
        st.add("rps"); 
        st.add("pps"); 
        st.add("ssrrr"); 
        st.add("ssrrr"); 
        st.add("ssrrr"); 
        //print the contents in the hashmap
        System.out.println("Printing the contents of the hashmap:"); 
        Iterator it = st.shortTerm.keySet().iterator(); 
        while(it.hasNext()) {
            String key = (it.next()).toString(); 
            System.out.println(key+": "+st.shortTerm.get(key)); 
        }
        System.out.println("End of printing hashmap\n"); 
        int expFrequency = 2; 
        int frequency = st.frequencyOf("rps"); 
        assertEquals(expFrequency, frequency); 
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ShortTermAnalysis.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        ShortTermHistory history = new ShortTermHistory(); 
        history.addRound(GameObject.PAPER, GameObject.PAPER);
        history.addRound(GameObject.ROCK, GameObject.SCISSORS); 
        history.addRound(GameObject.PAPER, GameObject.SCISSORS); 
        int i; 
        //add the last moves in the hashmap using the body for the update method
        for (i = st.MAX_DEPTH; i >= st.MIN_DEPTH; i--) {
            st.add(history.getLastMoves(i)); 
        }
        
        history.addRound(GameObject.PAPER, GameObject.SCISSORS);
        
        //add the last moves in the hashmap using the body for the update method
        for (i = st.MAX_DEPTH; i >= st.MIN_DEPTH; i--) {
            st.add(history.getLastMoves(i)); 
        }
        int frequency = st.frequencyOf("sps"); 
        int expFrequency = 2; 
        //assertEquals(expFrequency, frequency);
        assertEquals(frequency, expFrequency); 
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of frequencyOf method, of class ShortTermAnalysis.
     */
    @Test
    public void testFrequencyOf() {
        System.out.println("frequencyOf");
        int expResult = 1;
        st.add("rrr"); 
        int result = st.frequencyOf("rrr");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}

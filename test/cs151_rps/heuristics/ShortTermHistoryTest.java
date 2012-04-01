/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151_rps.heuristics;

import static cs151_rps.GameObject.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author bwormley
 */
public class ShortTermHistoryTest {
    
    public ShortTermHistoryTest() {
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
     * Test of addRound method, of class ShortTermHistory.
     */
    @Test
    public void testAddRound() {
        System.out.println("addRound");
        ShortTermHistory instance = new ShortTermHistory();
        for (int ix=0; ix<=instance.getMaxArchiveSize()/2; ix++) {
            assertEquals( instance.getArchiveSize(),ix*2);
            instance.addRound(ROCK,PAPER);
        }
         // note: should peg at max
        assertEquals( instance.getArchiveSize(),instance.getMaxArchiveSize());
    }

    /**
     * Test of getLastMoves method, of class ShortTermHistory.
     */
    @Test
    public void testGetLastMoves() {
        System.out.println("getLastMoves");
        int numberOfMoves = 0;
        ShortTermHistory instance = new ShortTermHistory();
        
        String result = instance.getLastMoves(0);
        assertEquals(result, "");
        result = instance.getLastMoves(1);
        assertEquals(result, "");
        
        instance.addRound(ROCK,PAPER);
        result = instance.getLastMoves(1);
        assertEquals(result,"R");
        result = instance.getLastMoves(2);
        assertEquals(result,"pR");
        result = instance.getLastMoves(3);
        assertEquals(result,"");
        
        instance.addRound(SCISSORS,ROCK);
        result = instance.getLastMoves(1);
        assertEquals(result,"S");
        result = instance.getLastMoves(2);
        assertEquals(result,"rS");
        result = instance.getLastMoves(3);
        assertEquals(result,"RrS");
        result = instance.getLastMoves(4);
        assertEquals(result,"pRrS");
        result = instance.getLastMoves(5);
        assertEquals(result,"");
        
        for ( int ix=0; ix<instance.getMaxArchiveSize()/2; ix++ )
            instance.addRound(PAPER,SCISSORS);
        instance.addRound(ROCK,SCISSORS);
        result = instance.getLastMoves(4);
        assertEquals(result,"sPsR");        
    }

    /**
     * Test of getLastMovesSwapped method, of class ShortTermHistory.
     */
    @Test
    public void testGetLastMovesSwapped() {
        System.out.println("getLastMovesSwapped");
        int numberOfMoves = 0;
        ShortTermHistory instance = new ShortTermHistory();
        
        String result = instance.getLastMovesSwapped(0);
        assertEquals(result, "");
        result = instance.getLastMovesSwapped(1);
        assertEquals(result, "");
        
        instance.addRound(ROCK,PAPER);
        result = instance.getLastMovesSwapped(1);
        assertEquals(result,"R");
        result = instance.getLastMovesSwapped(2);
        assertEquals(result,"pR");
        result = instance.getLastMovesSwapped(3);
        assertEquals(result,"");
        
        instance.addRound(SCISSORS,ROCK);
        result = instance.getLastMovesSwapped(1);
        assertEquals(result,"S");
        result = instance.getLastMovesSwapped(2);
        assertEquals(result,"rS");
        result = instance.getLastMovesSwapped(3);
        assertEquals(result,"RrS");
        result = instance.getLastMovesSwapped(4);
        assertEquals(result,"pRrS");
        result = instance.getLastMovesSwapped(5);
        assertEquals(result,"");
        
        for ( int ix=0; ix<instance.getMaxArchiveSize()/2; ix++ )
            instance.addRound(PAPER,SCISSORS);
        instance.addRound(ROCK,SCISSORS);
        result = instance.getLastMovesSwapped(4);
        assertEquals(result,"sPsR");        
    }

    /**
     * Test of getArchiveSize method, of class ShortTermHistory.
     */
    @Test
    public void testGetArchiveSize() {
        System.out.println("getArchiveSize");
        ShortTermHistory instance = new ShortTermHistory();
        
        for ( int ix=0; ix<=50; ix++ )
        {
            if (ix>instance.getMaxArchiveSize()/2)
                assertEquals(instance.getArchiveSize(),instance.getMaxArchiveSize());
            else
                assertEquals(instance.getArchiveSize(),ix*2);
            instance.addRound(ROCK,PAPER);
        }
    }

}

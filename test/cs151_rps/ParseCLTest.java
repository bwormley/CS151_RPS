/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151_rps;

import cs151_rps.ParseCL.ParamType;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author bwormley
 */
public class ParseCLTest {
    
    public ParseCLTest() {
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
     * Test of parse method, of class ParseCL.
     */
    @Test
    public void testParse() {
        
        String[] args;
        ParseCL instance;
        boolean testPassedCorrectly;
        boolean testFailedCorrectly;
        
        System.out.println("parse - function test");
        args = new String[] { "-a","--bigArg","-n","666","--String","foraminifera"};
        instance = new ParseCL();
        instance.setOption("-a", ParamType.NONE);
        instance.setOption("--bigArg", ParamType.NONE);
        instance.setOption("-n", ParamType.INTEGER);
        instance.setOption("--String",ParamType.STRING);
        testPassedCorrectly = true;
        try {
            instance.parse(args);
        }
        catch (Exception e) {
            System.out.println( e );
            testPassedCorrectly = false;
        }
        assert (testPassedCorrectly);

        System.out.println("parse - failure test: superfluous parameter");
        args = new String[]{"--intVal --superfluousFlag"};
        instance = new ParseCL();
        instance.setOption("--intVal", ParamType.INTEGER);
        testFailedCorrectly = false;
        try {
            instance.parse(args);
        }
        catch (IllegalArgumentException e) {
            System.out.println( e );
            testFailedCorrectly = true;
        }
        assert(testFailedCorrectly);

        System.out.println("parse - failure test: missing aux parameter");
        args = new String[]{"--intVal"};
        instance = new ParseCL();
        instance.setOption("--intVal", ParamType.INTEGER);
        testFailedCorrectly = false;
        try {
            instance.parse(args);
        }
        catch (IllegalArgumentException e) {
            System.out.println( e );
            testFailedCorrectly = true;
        }
        assert(testFailedCorrectly);

    }

    /**
     * Test of getParam method, of class ParseCL.
     */
    @Test
    public void testGetParam() {
        System.out.println("getParam -- function test");
        String key = "--myKey";
        String[] args = new String[] {"--myKey"};
        ParseCL instance = new ParseCL();
        instance.setOption(key,ParamType.NONE);
        boolean testPassedCorrectly = true;
        try {
            instance.parse(args);
        }
        catch (Exception e)
        {
            System.out.println(e);
            testPassedCorrectly = false;
        }
        boolean myKeyPresent = instance.getParam(key);
        boolean myOtherKeyNotPresent = !instance.getParam("--otherKey");
        assert(myKeyPresent && myOtherKeyNotPresent && testPassedCorrectly);
    }

    /**
     * Test fo getStringParam method, of class ParseCL.
     */
    @Test
    public void testGetStringParam() {
        System.out.println("getStringParam -- function test");
        String key = "--myArg";
        String option = "foraminifera";
        String[] args = new String[] {"--myArg","foraminifera"};
        String result = "";
        ParseCL instance = new ParseCL();
        instance.setOption(key,ParamType.STRING);
        boolean testPassedCorrectly = true;
        try {
            instance.parse(args);
            result = instance.getStringParam(key);
        }
        catch (Exception e) {
            System.out.println(e);
            testPassedCorrectly = false;
        }
        assertEquals(result,option);
    }
    
    
    /**
     * Test of getIntParam method, of class ParseCL.
     */
    @Test
    public void testGetIntParam() {
        
        // common values
        String key = "--intVal";
        int expResult;
        String[] args;
        int result;
        ParseCL instance;
        boolean testPassedCorrectly;
        boolean testFailedCorrectly;
        
        System.out.println("getIntParam - function test");
        args = new String[]{"--stringVal","hello","--intVal","42","--anotherStringVal","world"};
        instance = new ParseCL();
        expResult = 42;
        instance.setOption(key, ParamType.INTEGER);
        instance.setOption("--stringVal",ParamType.STRING);
        instance.setOption("--anotherStringVal",ParamType.STRING);
        instance.parse(args);
        result = instance.getIntParam(key);
        assertEquals(expResult, result);
        
        System.out.println("getIntParam - failure test: non integer");
        args = new String[]{"--intVal","fish"};
        instance = new ParseCL();
        expResult = 0;
        instance.setOption(key, ParamType.INTEGER);
        instance.parse(args);
        testFailedCorrectly = false;
        try {
            result = instance.getIntParam(key);
        }
        catch (IllegalArgumentException e) {
            System.out.println( e );
            testFailedCorrectly = true;
        }
        assert(testFailedCorrectly);
        
    }
}

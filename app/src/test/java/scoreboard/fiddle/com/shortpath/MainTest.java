package scoreboard.fiddle.com.shortpath;

import scoreboard.fiddle.com.shortpath.Matrix.Main;

import static org.junit.Assert.*;

/**
 * Created by jojomampilly on 3/30/17.
 */
public class MainTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void executeTest1() throws Exception {

        System.out.println("--- Executing test 1");

        Integer inputArray[][] = {{3,4,1,2,8,6},{6,1,8,2,7,4},{5,9,3,9,9,5},{8,4,1,3,2,6},{3,7,2,8,6,4}};

        Main main = new Main();
        Main.Result result = main.executeTest(inputArray);

        assertEquals(true,result.isSuccesFull);
        assertEquals(16,result.shortestPathValue);
        assertArrayEquals(new int[]{1,2,3,4,4,5},result.resultArray);
    }

    @org.junit.Test
    public void executeTest2() throws Exception {
        System.out.println("--- Executing test 2");


        Integer inputArray[][] = {{19,10,19,10,19},{21,23,20,19,12},{20,12,20,11,10}};
        Main main = new Main();
        Main.Result result = main.executeTest(inputArray);

        assertEquals(false,result.isSuccesFull);
        assertEquals(68,result.shortestPathValue);
        assertArrayEquals(new int[]{1,1,1,1,3},result.resultArray);

    }

    @org.junit.Test
    public void executeTest3() throws Exception {
        System.out.println("--- Executing test 3");


        Integer inputArray[][] = {{3,4,1,2,8,6},{6,1,8,2,7,4},{5,9,3,9,9,5},{8,4,1,3,2,6},{3,7,2,1,2,3}};
        Main main = new Main();
        Main.Result result = main.executeTest(inputArray);

        assertEquals(true,result.isSuccesFull);
        assertEquals(11,result.shortestPathValue);
        assertArrayEquals(new int[]{1,2,1,5,5,5},result.resultArray);

    }

    @org.junit.Test
    public void executeTest4() throws Exception {

        System.out.println("--- Executing test 4");


        Integer inputArray[][] = {{5,8,5,3,5}};
        Main main = new Main();
        Main.Result result = main.executeTest(inputArray);

        assertEquals(true,result.isSuccesFull);
        assertEquals(26,result.shortestPathValue);
        assertArrayEquals(new int[]{1,1,1,1,1},result.resultArray);

    }

    @org.junit.Test
    public void executeTest5() throws Exception {

        System.out.println("--- Executing test 5");


        Integer inputArray[][] = {{5},{8},{5},{3},{5}};
        Main main = new Main();
        Main.Result result = main.executeTest(inputArray);

        assertEquals(true,result.isSuccesFull);
        assertEquals(3,result.shortestPathValue);
        assertArrayEquals(new int[]{4},result.resultArray);

    }

    @org.junit.Test
    public void executeTest6() throws Exception {

        System.out.println("--- Executing test 6");


        Integer inputArray[][] = {{60,3,3,6},{6,3,7,9},{5,6,8,3}};
        Main main = new Main();
        Main.Result result = main.executeTest(inputArray);

        assertEquals(true,result.isSuccesFull);
        assertEquals(14,result.shortestPathValue);
        assertArrayEquals(new int[]{3,2,1,3},result.resultArray);

    }


    @org.junit.Test
    public void executeTest7() throws Exception {

        System.out.println("--- Executing test 7");


        Integer inputArray[][] = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};
        Main main = new Main();
        Main.Result result = main.executeTest(inputArray);

        assertEquals(true,result.isSuccesFull);
        assertEquals(20,result.shortestPathValue);
        assertArrayEquals(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},result.resultArray);

    }

    @org.junit.Test
    public void executeTest8() throws Exception {

        System.out.println("--- Executing test 8");


        Integer inputArray[][] = {{51,51},{0,51},{51,51},{55}};
        Main main = new Main();
        Main.Result result = main.executeTest(inputArray);

        assertEquals(false,result.isSuccesFull);
        assertEquals(51,result.shortestPathValue);
        assertArrayEquals(new int[]{2,1},result.resultArray);

    }

    @org.junit.Test
    public void executeTest9() throws Exception {

        System.out.println("--- Executing test 9");


        Object inputArray[][] = {{5,4,'H'},{8,'M',7},{5,7,5}};
        Main main = new Main();
        Main.Result result = main.executeTest(inputArray);

        assertEquals(true,result.arrayInvalid);
        assertEquals(false,result.isSuccesFull);

    }


    @org.junit.Test
    public void executeTest10() throws Exception {

        System.out.println("--- Executing test 8");


        Integer inputArray[][] = {{51,51,51},{0,51,51},{51,51,51},{55,51}};
        Main main = new Main();
        Main.Result result = main.executeTest(inputArray);

        assertEquals(false,result.isSuccesFull);
        assertEquals(51,result.shortestPathValue);
        assertArrayEquals(new int[]{2,1,4},result.resultArray);

    }

}
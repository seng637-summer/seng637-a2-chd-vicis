package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(-1, 1);
    }


    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    
    //My test code
    
    
    @Test
    public void getLowerBoundWithNormalValues() {
    	Range r = new Range(2.0, 10);
        assertEquals("The lower range between 2.0 and 10.0 should be 2.0",
        2.0, r.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundWithLowerNanValue() {
    	Range r = new Range(Double.NaN, 10);
        assertEquals("The lower range between a Nan and 10.0 should be Nan",
        Double.NaN, r.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundWithUpperNanValue() {
    	Range r = new Range(2.0, Double.NaN);
        assertEquals("The lower range between a Nan and 10.0 should be Nan",
        2.0, r.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundWithSameValue() {
    	Range r = new Range(2.0, 2.0);
        assertEquals("The lower range between a Nan and 10.0 should be Nan",
        2.0, r.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundWithMinimumValue() {
    	Range r = new Range(Double.MIN_NORMAL, 2.0);
        assertEquals("The lower range between a Nan and 10.0 should be Nan",
        Double.MIN_NORMAL, r.getLowerBound(), .000000001d);
    }

    
    
    @Test
    public void getUpperBoundWithNormalValues() {
    	Range r = new Range(2.0, 10.0);
        assertEquals("The upper range between 2.0 and 10.0 should be Nan",
        10.0, r.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundWithLowerNanValue() {
    	Range r = new Range(Double.NaN, 10.0);
        assertEquals("The upper range between a Nan and 10.0 should be 10.0",
        10.0, r.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundWithUpperNanValue() {
    	Range r = new Range(2.0, Double.NaN);
        assertEquals("The upper range between a 2.0 and a Nan values should be a Nan value",
        Double.NaN, r.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundWithSameValue() {
    	Range r = new Range(2.0, 2.0);
        assertEquals("The upper range between the same numbers should be the same",
        2.0, r.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundWithMaximumValue() {
    	Range r = new Range(2.0, Double.MAX_VALUE);
        assertEquals("The lower range between a Nan and 10.0 should be Nan",
        Double.MAX_VALUE, r.getUpperBound(), .000000001d);
    }
    

    
    
    
    
    

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
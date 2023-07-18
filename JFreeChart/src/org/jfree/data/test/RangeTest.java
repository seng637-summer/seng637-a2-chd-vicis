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
    
    
    // getLowerBound tests
    @Test
    public void getLowerBoundWithNormalValues() {
        assertEquals("The lower range between 2.0 and 10.0 should be 2.0",
        -1.0, exampleRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundWithLowerNanValue() {
    	Range r = new Range(Double.NaN, 1);
        assertEquals("The lower range between a Nan and 10.0 should be Nan",
        Double.NaN, r.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundWithUpperNanValue() {
    	Range r = new Range(-1.0, Double.NaN);
        assertEquals("The lower range between a Nan and 10.0 should be Nan",
        -1.0, r.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundWithSameValue() {
    	Range r = new Range(1.0, 1.0);
        assertEquals("The lower range between a Nan and 10.0 should be Nan",
        1.0, r.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundWithMinimumValue() {
    	Range r = new Range(Double.MIN_NORMAL, 2.0);
        assertEquals("The lower range between a Nan and 10.0 should be Nan",
        Double.MIN_NORMAL, r.getLowerBound(), .000000001d);
    }

    //getUpperBound tests
    
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

    //getLength test
    @Test
    public void testGetLengthValidRange() {
        Range range = new Range(-1.0, 1.0);
        double result = range.getLength();
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void testGetLengthSingletonRange() {
        Range range = new Range(0.0, 0.0);
        double result = range.getLength();
        assertEquals(0.0, result, 0.0001);
    }
    
    @Test
    public void testGetLengthBoundaryLowerRange() {
        Range range = new Range(-1.0, -0.9);
        double result = range.getLength();
        assertEquals(0.1, result, 0.0001);
    }

    @Test
    public void testGetLengthBoundaryUpperRange() {
        Range range = new Range(0.9, 1.0);
        double result = range.getLength();
        assertEquals(0.1, result, 0.0001);
    }

    @Test
    public void testGetLengthBoundarySingletonRange() {
        Range range = new Range(-1.0, -1.0);
        double result = range.getLength();
        assertEquals(0.0, result, 0.0001);
    }

    //toString tests
     @Test
    public void testToStringValidRange() {
        Range range = new Range(-1.0, 1.0);
        String result = range.toString();
        assertEquals("Range[-1.0,1.0]", result);
    }

    @Test
    public void testToStringSingletonRange() {
        Range range = new Range(0.0, 0.0);
        String result = range.toString();
        assertEquals("Range[0.0,0.0]", result);
    }
    
    @Test
    public void testToStringBoundaryLowerRange() {
        Range range = new Range(-1.0, -0.9);
        String result = range.toString();
        assertEquals("Range[-1.0,-0.9]", result);
    }

    @Test
    public void testToStringBoundaryUpperRange() {
        Range range = new Range(0.9, 1.0);
        String result = range.toString();
        assertEquals("Range[0.9,1.0]", result);
    }

    @Test
    public void testToStringBoundarySingletonRange() {
        Range range = new Range(-1.0, -1.0);
        String result = range.toString();
        assertEquals("Range[-1.0,-1.0]", result);
    }

    //combine tests
    public void combineWithBLB() {
    	Range r = new Range(-1.1, 0);
    	Range expected = new Range(-1.1, 1.0);

    	assertSame("The range should be between -1.1 and 1.0", 
        		expected, Range.combine(exampleRange, r));
    }
    
    @Test
    public void combineWithALB() {
    	Range r = new Range(-0.9, 0.0);
    	Range expected = new Range(-1.0, 1.0);

    	assertSame("The range should be between -1.0 and 1.0", 
        		expected, Range.combine(r, exampleRange));
    }
    
    @Test
    public void combineWithBUB() {
    	Range r = new Range(0.0, 0.9);
    	Range expected = new Range(-1.0, 1.0);

    	assertSame("The range should be between -1.0 and 1.0", 
        		expected, Range.combine(r, exampleRange));
    }
    
    @Test
    public void combineWithAUB() {
    	Range r = new Range(0.0, 1.1);
    	Range expected = new Range(-1.0, 1.1);

    	assertSame("The range should be between -1.0 and 1.1", 
        		expected, Range.combine(r, exampleRange));
    }
    
    @Test
    public void combineWithLB() {
    	Range r = new Range(-1.0, 0.5);
    	Range expected = new Range(-1.0, 1.0);

    	assertSame("The range should be between -1.0 and 1.0", 
        		expected, Range.combine( exampleRange, r));
    }
    
    @Test
    public void combineWithUB() {
    	Range r = new Range(0.0, 1.0);
    	Range expected = new Range(-1.0, 1.0);

    	assertSame("The range should be between -1.0 and 1.0", 
        		expected, Range.combine(r, exampleRange));
    }
    
    @Test
    public void combineWithNOM() {
    	Range r = new Range(-0.5, 0.5);
    	Range expected = new Range(-1.0, 1.0);

    	assertSame("The range should be between -1.0 and 1.0", 
        		expected, Range.combine(r, exampleRange));
    }
    
    @Test
    public void combineWithBothNull() {
    	Range r1 = null;
    	Range r2 = null;

    	assertSame("The range should just be null", 
        		null, Range.combine(r1, r2));
    }
    
    @Test
    public void combineWithFirstNull() {
    	Range r = null;
    	Range expected = new Range(-1.0, 1.0);

    	assertSame("The range should be between -1.0 and 1.0", 
        		expected, Range.combine(r, exampleRange));
    }
    
    @Test
    public void combineWithSecondNull() {
    	Range r = null;
    	Range expected = new Range(-1.0, 1.0);

    	assertSame("The range should be between -1.0 and 1.0", 
        		expected, Range.combine(exampleRange, r));
    }
    
    @Test
    public void combineWithSameRanges() {
    	Range expected = new Range(-1.0, 1.0);

    	assertSame("The range should be between -1.0 and 1.0", 
        		expected, Range.combine(exampleRange, exampleRange));
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}

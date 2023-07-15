package org.jfree.data;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {

    private Mockery mockingContext;
    private Values2D values;
    private DefaultKeyedValues kv;

    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {
        this.mockingContext = new Mockery();
        this.values = this.mockingContext.mock(Values2D.class);
        this.kv = new DefaultKeyedValues();
    }
    
    
    // Tests for calculateColumnTotal(Values2D, int)
    @Test
    public void testCalculateColumnTotal_AllPositiveValues_FirstColumn() {
        mockingContext.checking(new Expectations() {{
            one(values).getRowCount(); will(returnValue(3));
            one(values).getValue(0, 0); will(returnValue(10.0));
            one(values).getValue(1, 0); will(returnValue(20.0));
            one(values).getValue(2, 0); will(returnValue(30.0));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(60.0, result, .000000001d);
    }

    @Test
    public void testCalculateColumnTotal_AllPositiveValues_MiddleColumn() {
        mockingContext.checking(new Expectations() {{
            one(values).getRowCount(); will(returnValue(3));
            one(values).getValue(0, 1); will(returnValue(15.0));
            one(values).getValue(1, 1); will(returnValue(25.0));
            one(values).getValue(2, 1); will(returnValue(35.0));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 1);
        assertEquals(75.0, result, .000000001d);
    }

    @Test
    public void testCalculateColumnTotal_AllPositiveValues_LastColumn() {
        mockingContext.checking(new Expectations() {{
            one(values).getRowCount(); will(returnValue(3));
            one(values).getValue(0, 2); will(returnValue(20.0));
            one(values).getValue(1, 2); will(returnValue(30.0));
            one(values).getValue(2, 2); will(returnValue(40.0));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 2);
        assertEquals(90.0, result, .000000001d);
    }

    @Test
    public void testCalculateColumnTotal_MaxDoubleValue_FirstColumn() {
        mockingContext.checking(new Expectations() {{
            one(values).getRowCount(); will(returnValue(3));
            one(values).getValue(0, 0); will(returnValue(Double.MAX_VALUE));
            one(values).getValue(1, 0); will(returnValue(50.0));
            one(values).getValue(2, 0); will(returnValue(-50.0));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(Double.MAX_VALUE, result, .000000001d);
    }

    @Test
    public void testCalculateColumnTotal_MinDoubleValue_FirstColumn() {
        mockingContext.checking(new Expectations() {{
            one(values).getRowCount(); will(returnValue(3));
            one(values).getValue(0, 0); will(returnValue(Double.MIN_VALUE));
            one(values).getValue(1, 0); will(returnValue(50.0));
            one(values).getValue(2, 0); will(returnValue(-50.0));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(Double.MIN_VALUE, result, .000000001d);
    }

    @Test
    public void testCalculateColumnTotal_MaxIntegerValue_ColumnIndex() {
        mockingContext.checking(new Expectations() {{
            one(values).getRowCount(); will(returnValue(3));
            one(values).getValue(0, Integer.MAX_VALUE); will(returnValue(10.0));
            one(values).getValue(1, Integer.MAX_VALUE); will(returnValue(20.0));
            one(values).getValue(2, Integer.MAX_VALUE); will(returnValue(30.0));
        }});

        double result = DataUtilities.calculateColumnTotal(values, Integer.MAX_VALUE);
        assertEquals(60.0, result, .000000001d);
    }

    @Test
    public void testCalculateColumnTotal_MinIntegerValue_ColumnIndex() {
        mockingContext.checking(new Expectations() {{
            one(values).getRowCount(); will(returnValue(3));
            one(values).getValue(0, Integer.MIN_VALUE); will(returnValue(10.0));
            one(values).getValue(1, Integer.MIN_VALUE); will(returnValue(20.0));
            one(values).getValue(2, Integer.MIN_VALUE); will(returnValue(30.0));
        }});

        double result = DataUtilities.calculateColumnTotal(values, Integer.MIN_VALUE);
        assertEquals(60.0, result, .000000001d);
    }

    @Test
    public void testCalculateColumnTotal_SumZero_FirstColumn() {
        mockingContext.checking(new Expectations() {{
            one(values).getRowCount(); will(returnValue(3));
            one(values).getValue(0, 0); will(returnValue(10.0));
            one(values).getValue(1, 0); will(returnValue(20.0));
            one(values).getValue(2, 0); will(returnValue(-30.0));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(0, result, .000000001d);
    }

    @Test
    public void testCalculateColumnTotal_NullValues2D() {
    	try {
	        double result = DataUtilities.calculateColumnTotal(null, 0);
	        assertEquals(0, result, .000000001d);
    	} catch (NullPointerException e) {
    		// If we get an error then this test case has failed
    		fail("NullPointerException was thrown!");
    	}
    }

    @Test
    public void testCalculateColumnTotal_NegativeColumnIndex() {
        mockingContext.checking(new Expectations() {{
            one(values).getRowCount(); will(returnValue(3));
            one(values).getValue(0, -1); will(returnValue(10.0));
            one(values).getValue(1, -1); will(returnValue(20.0));
            one(values).getValue(2, -1); will(returnValue(30.0));
        }});

        double result = DataUtilities.calculateColumnTotal(values, -1);
        assertEquals(60.0, result, .000000001d);
    }

    @Test
    public void testCalculateColumnTotal_EmptyValues2D() {
        mockingContext.checking(new Expectations() {{
            one(values).getRowCount(); will(returnValue(0));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(0, result, .000000001d);
    }

    @Test
    public void testCalculateColumnTotal_Values2DWithNaN() {
        mockingContext.checking(new Expectations() {{
            one(values).getRowCount(); will(returnValue(3));
            one(values).getValue(0, 0); will(returnValue(Double.NaN));
            one(values).getValue(1, 0); will(returnValue(50.0));
            one(values).getValue(2, 0); will(returnValue(100.0));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(Double.NaN, result, .000000001d);
    }
    
    
    // Tests for calculateColumnTotal(Values2D, int)
    @Test
    public void testGetCumulativePercentages_EmptyKeyedValues() {
        KeyedValues result = DataUtilities.getCumulativePercentages(kv);
        assertEquals(0, result.getItemCount());
    }

    @Test
    public void testGetCumulativePercentages_SingleRowKeyedValue() {
        kv.addValue((Comparable<?>) 0, 5.0);
        KeyedValues result = DataUtilities.getCumulativePercentages(kv);
        assertEquals(1.0, result.getValue(0).doubleValue(), 0.000000001d);
    }

    @Test
    public void testGetCumulativePercentages_SingleRowKeyedValueZeroValue() {
        kv.addValue((Comparable<?>) 0, 0.0);
        KeyedValues result = DataUtilities.getCumulativePercentages(kv);
        assertEquals(0.0, result.getValue(0).doubleValue(), 0.000000001d);
    }

    @Test
    public void testGetCumulativePercentages_SingleRowKeyedValueNullValue() {
        kv.addValue((Comparable<?>) 0, null);
        KeyedValues result = DataUtilities.getCumulativePercentages(kv);
        assertNull(result.getValue(0));
    }

    @Test
    public void testGetCumulativePercentages_MixedValuesIncludingNull() {
        kv.addValue((Comparable<?>) 0, -3.5);
        kv.addValue((Comparable<?>) 1, 4.0);
        kv.addValue((Comparable<?>) 2, null);
        kv.addValue((Comparable<?>) 3, 10.5);
        kv.addValue((Comparable<?>) 4, 0.0);
        KeyedValues result = DataUtilities.getCumulativePercentages(kv);
        assertEquals(0.25, result.getValue(0).doubleValue(), 0.000000001d);
        assertEquals(0.6875, result.getValue(1).doubleValue(), 0.000000001d);
        assertNull(result.getValue(2));
        assertEquals(1.0, result.getValue(3).doubleValue(), 0.000000001d);
        assertEquals(1.0, result.getValue(4).doubleValue(), 0.000000001d);
    }

    @Test
    public void testGetCumulativePercentages_AllPositiveValues() {
        kv.addValue((Comparable<?>) 0, 5);
        kv.addValue((Comparable<?>) 1, 9);
        kv.addValue((Comparable<?>) 2, 2);
        KeyedValues result = DataUtilities.getCumulativePercentages(kv);
        assertEquals(0.3125, result.getValue(0).doubleValue(), 0.000000001d);
        assertEquals(0.875, result.getValue(1).doubleValue(), 0.000000001d);
        assertEquals(1.0, result.getValue(2).doubleValue(), 0.000000001d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCumulativePercentages_NullKeyedValues() {
        kv = null;
        KeyedValues result = DataUtilities.getCumulativePercentages(kv);
    }

    @Test
    public void testGetCumulativePercentages_ZeroValues() {
        kv.addValue((Comparable<?>) 0, 0.0);
        kv.addValue((Comparable<?>) 1, 0.0);
        kv.addValue((Comparable<?>) 2, 0.0);
        KeyedValues result = DataUtilities.getCumulativePercentages(kv);
        assertNull(result.getValue(0));
        assertNull(result.getValue(1));
        assertNull(result.getValue(2));
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}

**SENG 637 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group: SENG637- 2   |
|-----------------|
| Jash Dubal                |   
| Steven Duong              |   
| Nikhil Naikar               |   
| Jason Xu                |
| Christopher DiMattia                |

# 1 Introduction

The primary objective of this assignment was to conduct testing on 10 methods, with 5 methods from each of the Range class and DataUtilities class.

The Range class is responsible for representing an unchangeable range of values, while the DataUtilities class contains utility methods designed for use with specific data classes. It should be noted that certain methods in the DataUtilities class utilize the Values2D and KeyedValues interfaces as input parameters. As a result, Mocking techniques might be employed to test these DataUtilities methods effectively.

To perform the testing, black-Box test-case design techniques such as equivalence classes and boundary value analysis will be applied specifically for these 10 methods.

# 2 Detailed description of unit test strategy

// including the input partitions you have designed<br>
The assignment was successfully completed by following these steps:

1. Select 5 methods out of the 15 provided in the Range class for testing purposes.
2. Allocate 2 methods to each member of the group.
3. Each member thoroughly reviewed the Javadocs associated with their assigned methods to gain a clear understanding of their intended functionality.
4. Develop test cases using black-box test-case design techniques, including equivalence classes and boundary value analysis, to ensure comprehensive coverage.
5. Implement the test cases by writing code, execute JUnit tests, and carefully document the results obtained during the testing process.

## **DataUtilities**

jMock is used to mock the interfaces `Values2D` and `KeyedValues`. `Values2D` object is mocked as a 3*3 matrix holding double values. `KeyedValues` object is mocked holding Integer as key-value pairs. 

In the testing of the methods within this class, we will assess a range of scenarios when possible to test all equivalence classes and all boundary value cases. These include using various column indices such as negative values, zero, and values greater than the total number of columns in the data. Additionally, we will examine different data values, including positive numbers, zero, negative numbers, and NaN. Furthermore, we will test with data that contains duplicate keys and data that has keys in a non-ascending order.

The following 5 methods were chosen to be tested in the DataUtilities class:
1. calculateColumnTotal(Values2D data, int column)
2. calculateRowTotal(Values2D data, int row)
3. createNumberArray(double[] data)
4. createNumberArray2D(double[][] data)
5. getCumulativePercentages(KeyedValues data)


## **Range**

Mocking was unnecessary during the Range class testing. The testing process involved using an instance of the range from -1 to 1 to evaluate all 5 methods whenever feasible. Additionally, different ranges were employed for certain methods to examine specific conditions for Equivalence Class Testing, covering all potential input cases, and Boundary Value Testing, encompassing BLB, LB, ALB, BUB, UB, and AUB.

The following 5 methods were chosen to be tested in the Range class:
1. combine(Range range1, Range range2)
2. getLowerBound()
3. getUpperBound()
4. toString()
5. getLength()


# 3 Test cases developed

Text…

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

### `DataUtilities.calculateColumnTotal(Values2D, int)`

Test case | Input partitions | Status
--- | --- | ---
testCalculateColumnTotal_AllPositiveValues_FirstColumn | [10.0, 20.0, 30.0], 0 | Pass
testCalculateColumnTotal_AllPositiveValues_MiddleColumn | [10.0, 20.0, 30.0], 1 | Pass
testCalculateColumnTotal_AllPositiveValues_LastColumn | [10.0, 20.0, 30.0], 2 | Pass
testCalculateColumnTotal_MaxDoubleValue_FirstColumn | [Double.MAX_VALUE, 50.0, -50.0], 0 | Pass
testCalculateColumnTotal_MinDoubleValue_FirstColumn | [Double.MIN_VALUE, 50.0, -50.0], 0 | Pass
testCalculateColumnTotal_MaxIntegerValue_ColumnIndex | [10.0, 20.0, 30.0], Integer.MAX_VALUE | Pass
testCalculateColumnTotal_MinIntegerValue_ColumnIndex | [10.0, 20.0, 30.0], Integer.MIN_VALUE | Pass
testCalculateColumnTotal_SumZero_FirstColumn | [100.0, 50.0, -150.0], 0 | Pass
testCalculateColumnTotal_NullValues2D | null, 0 | FAIL
testCalculateColumnTotal_NegativeColumnIndex | [10.0, 20.0, 30.0], -1 | Pass
testCalculateColumnTotal_EmptyValues2D | [], 0 | Pass
testCalculateColumnTotal_Values2DWithNaN | [NaN, 50.0, 100.0], 0 | Pass

### `DataUtilities.getCumulativePercentages(KeyedValues)`

| Test case                                              | Input partitions                            | Status |
| ------------------------------------------------------ | ------------------------------------------- | ------ |
| testGetCumulativePercentages_EmptyKeyedValues          | <>                                          | Pass   |
| testGetCumulativePercentages_SingleRowKeyedValue       | <0, 5.0>                                    | FAIL   |
| testGetCumulativePercentages_SingleRowKeyedValueZeroValue | <0, 0.0>                                   | FAIL   |
| testGetCumulativePercentages_SingleRowKeyedValueNullValue | <0, null>                                  | FAIL   |
| testGetCumulativePercentages_MixedValuesIncludingNull  | <0, -3.5>, <1, 4.0>, <2, null>, <3, 10.5>, <4, 0.0> | FAIL   |
| testGetCumulativePercentages_AllPositiveValues         | <0, 5>, <1, 9>, <2, 2>                     | FAIL   |
| testGetCumulativePercentages_NullKeyedValues           | null                                        | Pass   |
| testGetCumulativePercentages_ZeroValues                | <0, 0.0>, <1, 0.0>, <2, 0.0>               | FAIL   |

### `Range.toString()`

Test case | Input partitions | Status
--- | --- | ---
testToStringValidRange | null | FAIL
testToStringSingletonRange | null | Pass
testToStringBoundaryLowerRange | null | FAIL
testToStringBoundaryUpperRange | null | FAIL
testToStringBoundarySingletonRange| null | Pass

### `Range.getLength()`

Test case | Input partitions | Status
--- | --- | ---
testGetLengthValidRange | null | Pass
testGetLengthSingletonRange | null | Pass
testGetLengthBoundaryLowerRange | null | Pass
testGetLengthBoundaryUpperRange | null | Pass
testGetLengthBoundarySingletonRange| null | Pass

### `Range.getLowerBound()`

Test case | Input partitions | Status
--- | --- | ---
getLowerBoundWithNormalValues | null | TODO
getLowerBoundWithLowerNanValue | null | TODO
getLowerBoundWithUpperNanValue | null | TODO
getLowerBoundWithSameValue | null | TODO
getLowerBoundWithMinimumValue| null | TODO

### `Range.getUpperBound()`

Test case | Input partitions | Status
--- | --- | ---
getUpperBoundWithNormalValues | null | TODO
getUpperBoundWithLowerNanValue | null | TODO
getUpperBoundWithUpperNanValue | null | TODO
getUpperBoundWithSameValue | null | TODO
getUpperBoundWithMaximumValue| null | TODO

# 4 How the team work/effort was divided and managed

Given a total of 10 methods to be tested, every member of the group was assigned the responsibility of testing 2 methods.

### `How the tested methods were divided:`

Class | Method | Tester
--- | --- | ---
Range | getLowerBound() | Christopher DiMattia 
Range | getUpperBound() | Christopher DiMattia 
Range | toString() | Steven Duong
Range | getLength() | Steven Duong
Range| combine(Range range1, Range range2) | Nikhil Naikar
DataUtilities | createNumberArray2D(double[][] data) | Nikhil Naikar
DataUtilities | calculateRowTotal(Values2D data, int row)  | Jason Xu
DataUtilities | createNumberArray(double[] data) | Jason Xu
DataUtilities | calculateColumnTotal(Values2D data, int column) | Jash Dubal
DataUtilities| getCumulativePercentages(KeyedValues data) | Jash Dubal

# 5 Difficulties encountered, challenges overcome, and lessons learned

## Discussion of Mocking

**Benefits:**
1. Isolation of dependencies: Mocking helps test a unit without relying on its actual dependencies.
2. Controlled testing environment: Mock objects provide control over the behavior of dependencies, allowing specific scenarios to be tested.
3. Reduced test execution time: Using lightweight mock objects speeds up testing by bypassing time-consuming or slow dependencies.
4. Facilitates Test-Driven Development (TDD): Mocking supports writing tests before implementing functionality.

**Drawbacks:**
1. Increased test complexity: Mocking adds complexity, as correct behavior must be defined for mock objects.
2. Risk of test fragility: Changes to the real implementation can break tests if mock objects don't accurately represent dependencies.
3. Potential false sense of security: Inaccurate mock objects can pass tests while not reflecting actual system behavior.
4. Limited integration validation: Mocking focuses on unit behavior and may not catch integration issues.

In summary, mocking is useful for isolating units and controlling testing, but it requires careful implementation. Consider the trade-offs and use additional techniques, like integration testing, for comprehensive coverage.

## Challenges Encountered

1. One of our challenges was determining the testing scope. We leveraged equivalence class partitioning and boundary value testing to formulate key test cases. This approach not only ensured broad coverage, but also prevented redundancy and inefficiency in the testing process, thereby optimizing the utilization of resources and time.
2. During the black box testing process, the group encountered unclear and ambiguous descriptions for certain methods, such as the "combine" method in the Range class. As black box testing restricts access to the code implementation, the group members had to heavily rely on their best guesses and assumptions to comprehend the functionality of these methods and anticipate the expected results they would produce.<br>
Note: During the testing of the combine() method in the Range class, it was observed that when the order of the parameters was changed, an error warning was triggered indicating that the lower bound was greater than the upper bound. This behavior occurred instead of a simple test failure. However, when the order of the parameters was switched, the error disappeared.

# 6 Comments/feedback on the lab itself

1. This assignment has significantly enhanced our proficiency in creating effective unit tests and successfully mocking interfaces even in the absence of certain implemented classes, underscoring the essential skills required in software engineering.

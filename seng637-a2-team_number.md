**SENG 637 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group: SENG637- 2   |
|-----------------|
| Jash Dubal                |   
| Steven Duong              |   
| Nikhil Naikar               |   
| Jason Xu                |
| Christopher DiMattia                |

# 1 - Introduction

The primary objective of this assignment was to conduct testing on 10 methods, with 5 methods from each of the Range class and DataUtilities class.

The Range class is responsible for representing an unchangeable range of values, while the DataUtilities class contains utility methods designed for use with specific data classes. It should be noted that certain methods in the DataUtilities class utilize the Values2D and KeyedValues interfaces as input parameters. As a result, Mocking techniques might be employed to test these DataUtilities methods effectively.

To perform the testing, black-Box test-case design techniques such as equivalence classes and boundary value analysis were applied and designed specifically for each of the 10 methods.  The team successfully tested each method without errors, made note of why errors occurred and learned valuable lessons about automated unit testing, blackbox testing and JUnit which is discussed in detail below.

# 2 - Detailed description of unit test strategy

The general approach of the test strategy was to understand the requirements of each method by reading the provided JDoc, design different test cases for each individual method including normal inputs, boundary conditions and error cases (should throw exceptions), write and execute the test code and finally review the test cases and results with the entire team. 

Procedurally the assignment was successfully completed by following these steps:

1. Select 5 methods out of the 15 provided in the Range class for testing purposes.
2. Allocate 2 methods to each member of the group.
3. Each member thoroughly reviewed the Javadocs associated with their assigned methods to gain a clear understanding of their intended functionality.
4. Develop test cases using black-box test-case design techniques, including equivalence classes and boundary value analysis, to ensure comprehensive coverage.
5. Implement the test cases by writing code, execute JUnit tests, and carefully document the results obtained during the testing process.
6. Review the results and test cases as a team to ensure consistency and no errors.

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


# 3 - Test cases developed

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

### `DataUtilities.createNumberArray2D(double[][] data)`

| Test case                                              | Input partitions                            | Status |
| ------------------------------------------------------ | ------------------------------------------- | ------ |
| testCreateNumberArray2DAllNegativeValues()         | 2X2 matrix filled with -0.5                                          |  Pass  |
| testCreateNumberArray2DAllPositiveValues()       | 2X2 matrix filled with 0.5                                     | Pass   |
| testCreateNumberArray2DLargeArray() | 4X4 matrix filled with -0.5 and 0.5                                   | FAIL   |
| testCreateNumberArray2DSmallArray() | 2X2 matrix filled with -0.5 and 0.5                                  |  FAIL  |
| testCreateNumberArray2DEmpty()  | empty matrix |  FAIL  |
| testCreateNumberArray2DBLB()         | 2X2 matrix filled with -1.1                     | FAIL   |
| testCreateNumberArray2DALB()           | 2X2 matrix filled with -0.9                                        | FAIL   |
| testCreateNumberArray2DBUB()                | 2X2 matrix filled with 0.9                | FAIL   |
| testCreateNumberArray2DAUB()        | 2X2 matrix filled with 1.1                     | FAIL   |
| testCreateNumberArray2DUB()           | 2X2 matrix filled with 1.0                                         |   FAIL |
| testCreateNumberArray2DLB()                | 2X2 matrix filled with -1.0               | FAIL   |

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
getLowerBoundWithNormalValues | <-1.0, 1.0> | Pass
getLowerBoundWithLowerNanValue | <Nan, 1.0> | Pass
getLowerBoundWithUpperNanValue | <-1.0, Nan> | Pass
getLowerBoundWithSameValue | <0.5, 0.5> | Pass
getLowerBoundWithMinimumValue| <Double.MIN_NORMAL, 1.0> | Pass

### `Range.getUpperBound()`

Test case | Input partitions | Status
--- | --- | ---
getUpperBoundWithNormalValues | <-1.0, 1.0> | FAIL
getUpperBoundWithLowerNanValue | <Nan, 1.0> | FAIL
getUpperBoundWithUpperNanValue | <-1.0, Nan> | FAIL
getUpperBoundWithSameValue | <0.5, 0.5> | Pass
getUpperBoundWithMaximumValue| <-1.0, Double.Max_VALUE> | FAIL

### `Range.combine()`

Test case | Input partitions | Status
--- | --- | ---
combineWithBLB | <-1.1, 0>, <-1.0, 1.0> | FAIL
combineWithALB | <-0.9, 0>, <-1.0, 1.0> | FAIL
combineWithBUB | <0, 0.9>, <-1.0, 1.0> | FAIL
combineWithAUB | <0, 1.1>, <-1.0, 1.0> | FAIL
combineWithLB| <-1.0, 0.5>, <-1.0, 1.0> | Pass
combineWithUB| <0, 1.0>, <-1.0, 1.0> | FAIL
combineWithNOM| <-0.5, 0.5>, <-1.0, 1.0> | FAIL
combineWithBothNull| null, null | Pass
combineWithFirstNull| null, <-1.0, 1.0> | Pass
combineWithSecondNull| <-1.0, 1.0>, null | Pass
combineWithSameRanges| <-1.0, 1.0>, <-1.0, 1.0> | Pass


# 4 - How the team work/effort was divided and managed

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

## Discussion of Mocking
Below is a summary of the benefits and drawbacks of mocking.

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

# 5 - Difficulties encountered, challenges overcome, and lessons learned

## Difficulties Encounted and Challenges Overcome

1. One of our challenges was determining the testing scope. We leveraged equivalence class partitioning and boundary value testing to formulate key test cases. This approach not only ensured broad coverage, but also prevented redundancy and inefficiency in the testing process, thereby optimizing the utilization of resources and time.
2. During the black box testing process, the group encountered unclear and ambiguous descriptions for certain methods, such as the "combine" method in the Range class. As black box testing restricts access to the code implementation, the group members had to heavily rely on their best guesses and assumptions to comprehend the functionality of these methods and anticipate the expected results they would produce.<br>
3. The team encountered errors that were not totally understood.  For example, during the testing of the combine() method in the Range class, it was observed that when the order of the parameters was changed, an error warning was triggered indicating that the lower bound was greater than the upper bound. This behavior occurred instead of a simple test failure. However, when the order of the parameters was switched, the error disappeared.  Intuitively this does not make sense as the function should be associative so the order of arguments should not affect the result.  This was a challenge that indicates a problem with the fuction, but why it JUnit simply did not fail the test and instead produced an error is unknown.
4. Mocks provided many challenges when testing, specifically it added complexity, fragility, a false sense of security and it limited integration validation.  The mocks added complexity as correct behavior must be defined for the mock objects.  Mocks increased test fragility because changes to the real implemenation can break tests if them ock objects don't accurately represent dependencies.  Mocks also have the potential to cause false posities by passing tests because they might not reflect the actual system behavior, so there is another failure point during testing in that the tester can inaccruatetly create mocks.  Finally mocks focus on the behavior and may not catch integration issues, so they limit the range of testing to just that specific boundary between the method and object.  Most of the above challenges were overcome by spending time discussing how to have the mocks best recreate the object they are emulating and having other testers verify that the mocks make sense.  It should also be noted that some of those challenges are not the responsilbiity of these tests, such as ensuring dependencies are reflecte in the mocks behaviour.

## Lessons Learned
1. It is important to set up input parameters beforehand so every team member is using consistent inputs with respect to upper and lower bounds.  The team had to rerun tests that had drastically different input values to ensure consistency between.
2. Blackbox testing requires a deep understanding of what to expect and ideally there should be communication between the testers and the developer who wrote the function to ensure the tests actually test the method properly and do not rely on interpretation.
3. Mocking is a very strong tool that has many strengths in terms of speed, simplicity and the ability to isolate methods, but there are some drawbacks in that it adds complexity to a test which can causes tests to generate incorrect results, may not reflect system behavior and may not display dependency issues.

# 6 - Comments/feedback on the lab itself

1. This assignment has significantly enhanced our proficiency in creating effective unit tests and successfully mocking interfaces even in the absence of certain implemented classes, underscoring the essential skills required in software engineering.
2. The lab was interesting in that it highlighted how limited black box testing is, especially with respect to functions that are not well defined or understood and the testing may be even counter productive because a tester may pass a test when in reality the test was not set up properly because the expecte outcome was not aligned with the project scope or what the original developer intended.
3. The lab highlighted how straight forward and simple using JUnit was, especially when the bounds of an inputs are well defined beforehand.  In comparision to lab 1 it took far less time, was easier to accomplish and didn't require as much critical thinking.  This indicates to the team that using these testing methods are powerful because they do not require many resources and could be easily automated which would be a power tool for future testing.

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

The main goal of this assignment was to conduct automated unit testing on a total of 10 methods. Specifically, 5 methods from both the Range class and the DataUtilities class were included in the testing.

The Range class is responsible for representing a range of values that cannot be changed, while the DataUtilities class contains utility methods that are intended to be used with specific data classes. It's important to mention that certain methods in the DataUtilities class require the Values2D and KeyedValues interfaces as input parameters. As a result, Mocking techniques were employed to test these DataUtilities methods effectively.

To carry out the testing, black-box test case design techniques such as equivalence classes and boundary value analysis were employed. These techniques were tailored for each of the 10 methods. The team successfully tested each method without any errors. Additionally, they took note of the reasons behind any errors encounted and fixed them with a final error free test suite.  The team gained valuable insights into automated unit testing, black-box testing, and JUnit. These insights are discussed in more detail below.

# 2 - Detailed description of unit test strategy

The overall test strategy involved several steps to ensure thorough testing of each method. Firstly, the requirements of each method were carefully examined by referring to the provided javadocs. Based on this understanding, a variety of test cases were designed for each method, including normal inputs, boundary conditions, and error cases where exceptions should be thrown.  Next, the test code was written and executed to carry out the actual testing process. Once the tests were completed, the entire team participated in a review session to assess the test cases and analyze the results. This collaborative discussion allowed for valuable insights and ensured a comprehensive evaluation of the test strategy which is captured in the difficulties encountered, challenges overcome, and lessons learned section.

Procedurally the assignment was successfully completed by following these steps:
1. Select 5 methods out of the 15 provided in the Range class for testing purposes.
2. Allocate 2 methods to each member of the group.
3. Each member thoroughly reviewed the Javadocs associated with their assigned methods to gain a clear understanding of their intended functionality.
4. Develop test cases using black-box test-case design techniques, including equivalence classes and boundary value analysis, to ensure comprehensive coverage.
5. Implement the test cases by writing code, execute JUnit tests, and carefully document the results obtained during the testing process.
6. Review the results and test cases as a team to ensure consistency and no errors.

## **DataUtilities**

jMock is employed to mock the interfaces Values2D and KeyedValues. The Values2D object is mocked as a 3*3 matrix, holding double values. Similarly, the KeyedValues object is mocked, containing Integer key-value pairs.

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

### `DataUtilities.calculateRowTotal(Values2D, int)`
Test case | Input partitions | Status
--- | --- | ---
calculateRowTotalPositiveFirstRow | 0,[10.0, 20.0, 30.0] | FAIL
calculateRowTotalPositiveSecondRow | 1,[10.0, 20.0, 30.0] | FAIL
calculateRowTotalPositiveThirdRow | 2,[10.0, 20.0, 30.0]| FAIL
calculateRowTotalNegativeThirdRow | 0,[-10.0, -20.0, -30.0]| FAIL
calculateRowTotalMaxValueFirstRow |0, [Double.MAX_VALUE, 50.0, -50.0] | Pass
calculateRowTotalMinValueFirstRow |0, [Double.MIN_VALUE, 50.0, -50.0] | FAIL
calculateRowTotalMaxIndexFirstRow | Integer.MAX_VALUE,[10.0, 20.0, 30.0],  | FAIL
calculateRowTotalMinIndexFirstRow | Integer.MIN_VALUE[10.0, 20.0, 30.0] | FAIL
calculateRowTotal_NullValues2D | 0,null | FAIL
calculateRowTotalEmpty| [], 0 | Pass
calculateRowTotalNanFirstRow | 0,[NaN, 50.0, -50.0] | Pass

### `DataUtilities.createNumberArray2D(double[][] data)`

| Test case                                              | Input partitions                            | Status |
| ------------------------------------------------------ | ------------------------------------------- | ------ |
| testCreateNumberArray2DAllNegativeValues()         | 2X2 matrix filled with -0.5                                          |  FAIL  |
| testCreateNumberArray2DAllPositiveValues()       | 2X2 matrix filled with 0.5                                     | FAIL   |
| testCreateNumberArray2DLargeArray() | 4X4 matrix filled with -0.5 and 0.5                                   | FAIL   |
| testCreateNumberArray2DSmallArray() | 2X2 matrix filled with -0.5 and 0.5                                  |  FAIL  |
| testCreateNumberArray2DEmpty()  | empty matrix |  Pass  |
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
combineWithBLB | <-1.1, 0>, <-1.0, 1.0> | Pass
combineWithALB | <-0.9, 0>, <-1.0, 1.0> | Pass
combineWithBUB | <0, 0.9>, <-1.0, 1.0> | Pass
combineWithAUB | <0, 1.1>, <-1.0, 1.0> | Pass
combineWithLB| <-1.0, 0.5>, <-1.0, 1.0> | Pass
combineWithUB| <0, 1.0>, <-1.0, 1.0> | Pass
combineWithNOM| <-0.5, 0.5>, <-1.0, 1.0> | Pass
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

1. One of the challenges we faced was determining the scope of testing. To address this, we utilized techniques such as equivalence class partitioning and boundary value testing to formulate key test cases. This approach ensured comprehensive coverage while avoiding redundancy and inefficiency in the testing process. By optimizing the use of our resources and time, we were able to achieve efficient testing.
2. During the black box testing process, our group encountered challenges due to unclear and ambiguous descriptions for certain methods, like the "combine" method in the Range class. It was not clear when the JDoc stated that "either range can be null, in which case the other range is returned" the null referred  to one specific value in a range or if the entire range object itself was null .Since black box testing restricts access to the code implementation, we had to heavily rely on our best guesses and assumptions to understand the functionality of these methods and anticipate the expected results they would produce.
3. While testing the combine() method in the Range class, our team encountered errors that were not fully understood. We observed that changing the order of the parameters triggered an error warning indicating that the lower bound was greater than the upper bound. This behavior occurred instead of a simple test failure. However, when the order of the parameters was switched, the error disappeared. Intuitively, this behavior does not make sense, as the function should be associative, and the order of arguments should not affect the result. This challenge highlights a problem with the function, but the reason why JUnit produced an error instead of a test failure remains unknown.
4. Mocks presented several challenges during testing. They added complexity, increased test fragility, limited integration validation and could give a false sense of security as mentioned above. Testing with mocks required careful consideration to ensure that they accurately mimicked the behavior of the actual objects they were mocking. Defining the correct behavior for the mock objects added complexity to the testing process. Additionally, changes to the real implementation could break tests if the mock objects did not accurately represent the dependencies. Identifying whether an error was caused by the mock or the actual code added additional time to the testing process. While mocks provided isolation and control over the behavior of dependencies in this assignment, they were not completely error-free or without costs, and their implementation required careful attention.

## Lessons Learned
1. It is crucial to establish consistent input parameters in advance so that every team member uses the same values for upper and lower bounds. The team had to re-run tests that had significantly different input values to ensure consistency.
2. Black-box testing requires a thorough understanding of expected outcomes. Ideally, there should be open communication between the testers and the developer who wrote the function to ensure the tests accurately assess the method and avoid relying on interpretation.
3. Mocking is a powerful tool with various strengths, such as speed, simplicity, and the ability to isolate methods. However, there are drawbacks to consider. Mocking adds complexity to tests, which can lead to incorrect results. It may not accurately reflect the system's behavior and may fail to reveal dependency issues.

# 6 - Comments/feedback on the lab itself

1. This assignment significantly improved our proficiency in creating effective unit tests and successfully mocking interfaces, even when certain classes were not implemented. It highlighted the essential skills required in software engineering
2. The lab was interesting as it emphasized the limitations of black box testing, especially for functions that are poorly defined or not well understood. Testing in such cases can be counterproductive, as testers may pass tests that were not properly set up due to a misalignment between expected outcomes and the project scope or the developer's intentions.  It truly highlights the importance of having testers properly integrated in the development and requirements building process.
3. The lab underscored the straightforward and simple nature of using JUnit, particularly when input bounds are well defined in advance. In comparison to assignment 1, it required less time, was easier to accomplish, and involved less critical thinking. This indicated to the team that utilizing these testing methods is powerful, as they do not require significant resources and can be easily automated, making them a valuable tool for future testing.

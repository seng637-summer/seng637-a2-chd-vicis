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

Text…

# 2 Detailed description of unit test strategy

// including the input partitions you have designed

## **DataUtilities**

jMock is used to mock the interfaces `Values2D` and `KeyedValues`. `Values2D` object is mocked as a 3*3 matrix holding double values. `KeyedValues` object is mocked holding Integer as key-value pairs. 

For the `calculateColumnTotal` method, we will test with various column indices, including negative values, zero, and values greater than the number of columns in the data. We will also test with various data values, including positive numbers, zero, negative numbers, and NaN.

For the `getCumulativePercentages` method, we will test with various data values, including positive numbers, zero, negative numbers, and NaN. We will also test with data that has duplicate keys and data that has keys in a non-ascending order.

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

# 4 How the team work/effort was divided and managed

Given a total of 10 methods to be tested, every member of the group was assigned the responsibility of testing 2 methods.

### `How the tested methods were divided:`

Class | Method | Tester
--- | --- | ---
testToStringValidRange | null | FAIL
testToStringSingletonRange | null | Pass
testToStringBoundaryLowerRange | null | FAIL
testToStringBoundaryUpperRange | null | FAIL
testToStringBoundarySingletonRange| null | Pass

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

# 6 Comments/feedback on the lab itself

1. This assignment has significantly enhanced our proficiency in creating effective unit tests and successfully mocking interfaces even in the absence of certain implemented classes, underscoring the essential skills required in software engineering.

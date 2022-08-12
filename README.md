# ESC Software Testing Campaign

* Name: Aw Yong Jia Min Kellie
* Student ID: 1005466

## Objectives

### Problem Statement
* Data Reconciliation

### Description

Consider a CSV file that stores a list of records (e.g., records of bank accounts).
You are required to write a software program that reads two such CSV files, compares records
stored in these CSV files row by row against a unique combination and records all mismatches
as exceptions. Finally, the software program generates another csv file listing the exceptions.

### Deadlines

* [**Week 8**](#Week-8-Submission) [Document and Code]: Use case diagram should be complete. All Java (or
similar) files should be complete in terms of implementing the functionality and (in the
bare minimum) the sample test files should pass. **Deadline 11th July, 11.59pm**.
* [**Week 9**](#Week-9-Submission) [Document]: A report on your boundary value analysis and equivalence class
partitioning should be complete. **Deadline 18th July, 11.59pm**.
* [**Week 10**](#Week-10-Submission) [Code]: All (Junit) test files conducting unit and system level testing should be
complete. **Deadline 25th July, 11.59pm**.
* **Week 12** [Code]: A refactored/bug fixed version of the code. The fuzzer code is
complete and properly documented for running by a third-party. The implementations of
others are also distributed this week for independent testing by group members.
**Deadline 8th Aug, 11.59pm**.
* **Week 13** [Document and Code]: All new tests written for the third party implementation
should be complete. A report to briefly explain the bugs found in other’s implementation
should be complete. Each new bug found in another implementation will have a bounty
(in terms of bonus marks: 5 marks / unique bug). **Deadline 15th Aug, 11.59pm**.

## Implementation

### Week 8 Submission
* Implementation of the reading of the sample csv files and comparing them can be found in: `ESC-SoftwareMiniTest/src/compareCSV`, named as **`Compare.java`**.
## Getting Started
Firstly, before running the program (in Eclipse), change the path of the sample files used to what corresponds to your own directory. 
You can change them in line 163 for the `compareCols` method, line 165 for the `getHeaders` method and, lines 175 and 176 for the `getContentCsv` method.
## Running the code
After making the necessary changes in the step above, you can proceed to run the code directly. At this point, you will be prompted to give an input based on the headers of the sample csv files. The headers will also be printed for you to help you with what to input.  Notice that you only give one input at a time which means that if you want to give two headers, you will have to type the first header, press 'Enter', type the second header and press 'Enter'. To stop giving inputs, you can simply just press 'Enter' another time.
## Expected output
Depending on the type of input you gave, or the files used in the program, different outputs are expected.
1. Giving an empty input: Both files will just compare for all headers and produce a new CSV file with differences listed if there are differences in both CSV files or produce a new CSV file that is empty if both CSV files used do not contain any differences.
2. Giving an input that does not belong in the list of available headers: An error message saying that the user has entered an invalid input will be printed and the session will be terminated.
3. Comparing CSV files with different number of columns/different order of headers: An error message reminding the user to check that both files have the same number of columns and are in the same order will be printed, and the session will be terminated.

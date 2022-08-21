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
* Implementation of the reading of the sample csv files and comparing them can be found in: `ESC-SoftwareMiniTest/src/compareCSV`, named as **`CompareCSV.java`**.
* Use case diagram can be found in `Week8-Use Case Diagram`.
#### Getting Started
Firstly, before running the program (done in Eclipse), change the path of the sample files used to what corresponds to your own directory. 
You can change them in line 163 for the `compareCols` method, line 165 for the `getHeaders` method and, lines 175 and 176 for the `getContentCsv` method.

![Screenshot 2022-08-13 at 3 44 28 AM](https://user-images.githubusercontent.com/98271835/184431873-2fa393fb-ab09-4eb3-9aaf-f91409652542.png)

#### Running the code
After making the necessary changes in the step above, you can proceed to run the code directly. At this point, you will be prompted to give an input based on the headers of the sample csv files. The headers will also be printed for you to help you with what to input.  Notice that you only give one input at a time which means that if you want to give two headers, you will have to type the first header, press 'Enter', type the second header and press 'Enter'. To stop giving inputs, you can simply just press 'Enter' another time.

![Screenshot 2022-08-13 at 3 45 19 AM](https://user-images.githubusercontent.com/98271835/184431984-5195c1de-0815-4d49-bee1-9015a130db7b.png)

#### Expected output
Depending on the type of input you gave, or the files used in the program, different outputs are expected.
1. Giving an empty input: Both files will just compare for all headers and produce a new CSV file with differences listed if there are differences in both CSV files or produce a new CSV file that is empty if both CSV files used do not contain any differences.
2. Giving an input that does not belong in the list of available headers: An error message saying that the user has entered an invalid input will be printed and the session will be terminated.
3. Comparing CSV files with different number of columns/different order of headers: An error message reminding the user to check that both files have the same number of columns and are in the same order will be printed, and the session will be terminated.

### Week 9 Submission
* Report on the boundary value analysis and equivalence class can be found in `Week9-Report`.

### Week 10 Submission
* Unit tests and system test can be found in `ESC-SoftwareMiniTest/src/compareCSV`, named as **`CompareCSVTest.java`**.

### Week 12 Submission
#### Fuzzing: Getting started
* All relevant fuzzing files can be found in `fuzzing`.
Python was used to help generate random strings and strings with mutated bits.

An example of what the random strings and strings with mutated bits look like are below.

**random_string.txt**:
<img width="1290" alt="Screenshot 2022-08-21 at 4 20 32 PM" src="https://user-images.githubusercontent.com/98271835/185782391-c9c70a88-7214-45b3-9905-a9c8d38e174b.png">

**mutate.txt**:
<img width="1293" alt="Screenshot 2022-08-21 at 4 20 01 PM" src="https://user-images.githubusercontent.com/98271835/185782403-a09a80b3-937c-4661-94b4-612943169b51.png">

#### Running it
1. Change the Scanner to accept the text file with random strings/mutated bits that was generated from running the python code, **random_gen.py**.

<img width="1229" alt="Screenshot 2022-08-21 at 4 08 07 PM" src="https://user-images.githubusercontent.com/98271835/185782317-408ff840-f51f-49c4-8b68-f3364ce8a720.png">
2. Click on the run button to run it directly.

#### Expected output
An error message should pop out for both types of text file.
1. Random strings: **random_string.txt**
<img width="1440" alt="Screenshot 2022-08-21 at 3 50 14 PM" src="https://user-images.githubusercontent.com/98271835/185782308-08e693d3-98da-4827-9678-0cbc81534b0d.png">

2. Strings with mutated bits: **mutate.txt**
<img width="1440" alt="Screenshot 2022-08-21 at 3 49 43 PM" src="https://user-images.githubusercontent.com/98271835/185782293-f94a33b7-efbf-470d-a68b-b8c039bf05d5.png">

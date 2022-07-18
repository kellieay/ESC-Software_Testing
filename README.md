# ESC Software Testing Campaign

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
bare minimum) the sample test files should pass. **Deadline 10th July, 11.59pm**.
* [**Week 9**](#Week-9-Submission) [Document]: A report on your boundary value analysis and equivalence class
partitioning should be complete. **Deadline 17th July, 11.59pm**.
* **Week 10** [Code]: All (Junit) test files conducting unit and system level testing should be
complete. **Deadline 24th July, 11.59pm**.
* **Week 12** [Code]: A refactored/bug fixed version of the code. The fuzzer code is
complete and properly documented for running by a third-party. The implementations of
others are also distributed this week for independent testing by group members.
**Deadline 7th Aug, 11.59pm**.
* **Week 13** [Document and Code]: All new tests written for the third party implementation
should be complete. A report to briefly explain the bugs found in other’s implementation
should be complete. Each new bug found in another implementation will have a bounty
(in terms of bonus marks: 5 marks / unique bug). **Deadline 14th Aug, 11.59pm**.

## Implementation

### Week 8 Submission
* Implementation of the reading of the sample csv files and comparing them are in the `src file`, named as **`Compare.java`**.
Results of the comparison between `sample_file_1.csv` and `sample_file_2.csv` is stored in **`test.csv`**.
Results of the comparison between `sample_file_1.csv` and `sample_file_3.csv` is stored in **`test2.csv`**.

* Use case diagram:
![escw8](https://user-images.githubusercontent.com/98271835/178138229-08e7f983-a688-4c08-85d0-afaa1f6bcc83.jpg)

### Week 9 Submission
* Report on boundary value analysis and equivalence class



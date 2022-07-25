package comparecsv;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertFalse;

public class CompareTest {
	private Compare compare;
	private static BufferedReader br;
	private static BufferedReader br2;
	private static BufferedReader br3;

	@Before
	public void setUpBeforeEachTest() throws Exception {
		compare = new Compare();
		br = new BufferedReader(new FileReader("/Users/kellieayy/eclipse-workspace/comparecsv/src/comparecsv/sample_file_1.csv"));
		br2 = new BufferedReader(new FileReader("/Users/kellieayy/eclipse-workspace/comparecsv/src/comparecsv/sample_file_2.csv"));
		br3 = new BufferedReader(new FileReader("/Users/kellieayy/eclipse-workspace/comparecsv/src/comparecsv/sample_file_3.csv"));
	}

	@After
	public void tearDownAfterEachTest() throws Exception {
	}
	
//	Unit Testing
	
	@Test
	public void testAddToList() {
		List<String> list = new ArrayList<String>();
		String line = "";
		list = Compare.addToList(line, br);
		
//		check that the list contains each line of the csv file
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void testComputeDifferenceList() {
		List<String> list1 = new ArrayList<String>();
		String line1 = "";
		list1 = Compare.addToList(line1, br);
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		String line2 = "";
		String line3 = "";
		list2 = Compare.addToList(line2, br2);
		list3 = Compare.addToList(line3, br3);
		
//		 check that difference list is empty when comparing between two of the same files
		assertEquals(list1, list1);
		assertTrue(Compare.computeDifferenceList(list1, list1).isEmpty());
		
//		check that difference list is not empty when comparing between two different files
		assertFalse(list1.equals(list2));
		assertFalse(Compare.computeDifferenceList(list1, list2).isEmpty());
		
		assertFalse(list1.equals(list3));
		assertFalse(Compare.computeDifferenceList(list1, list3).isEmpty());
	}
	
//	System Testing
	
//	Parse through empty CSV file: Should return an empty list
	@Test
	public void parseEmpty() {
		List<String> outputls = new ArrayList<String>();
		String line = "";
		try {
			br = Compare.readCSVFile("/Users/kellieayy/eclipse-workspace/comparecsv/src/comparecsv/emptycsv.csv");
			outputls = Compare.addToList(line, br);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		the size of the output list is set to 1 to account for the empty string required for the method, addToList to work
		if (outputls.size() == 1) {
			System.out.println("Empty list test passed.");
		} else {
			System.out.println("Error. The output list should be empty.");
		}
	}
	
//	Parse through a filled CSV file: Should return a non-empty list
	@Test
	public void parseFilled() {
		List<String> outputls = new ArrayList<String>();
		String line = "";
		try {
			br = Compare.readCSVFile("/Users/kellieayy/eclipse-workspace/comparecsv/src/comparecsv/sample_file_1.csv");
			outputls = Compare.addToList(line, br);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (outputls.size() > 1) {
			System.out.println("Non-empty list test passed.");
		} else {
			System.out.println("Error. The output list should not be empty.");
		}
	}
	
//	Comparing for differences between two equal lists
//	1. Two empty lists: Should return an empty difference list
	@Test
	public void compareTwoEmpty() {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> differencels = new ArrayList<String>();
		differencels = Compare.computeDifferenceList(list1, list2);
		if (differencels.isEmpty()) {
			System.out.println("Compare between 2 empty lists test passed.");
		} else {
			System.out.println("Error. The difference list should be empty.");
		}
	}
	
//	2. Two lists with equal values: Should return an empty different list
	@Test
	public void compareTwoEqual() {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> differencels = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			list1.add(String.valueOf(i));
			list2.add(String.valueOf(i));
		}
		differencels = Compare.computeDifferenceList(list1, list2);
		if (differencels.isEmpty()) {
			System.out.println("Compare between 2 equal lists test passed.");
		} else {
			System.out.println("Error. The difference list should be empty.");
		}
	}
	
//	Comparing for differences between two lists with different values
//	1. One of the lists having an additional intended blank entry at the bottom of the list: Should return a non-empty list
	@Test
	public void compareWithBlank() {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> differencels = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			list1.add(String.valueOf(i));
			list2.add(String.valueOf(i));
		}
		list1.add("");
		differencels = Compare.computeDifferenceList(list1, list2);
		if (differencels.isEmpty()) {
			System.out.println("Error. The difference list should not be empty.");
		} else {
			System.out.println("Compare between 2 equal lists with one of the lists having an additional blank entry test passed.");
		}
	}
	
//	2. Two lists with different values: Should return a non-empty list
	@Test
	public void compareDifferent() {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> differencels = new ArrayList<String>();
		List<String> newdifferencels = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			list1.add("test");
			list2.add("test2");
		}
		differencels = Compare.computeDifferenceList(list1, list2);
		if (differencels.isEmpty()) {
			System.out.println("Error. The difference list should not be empty.");
		} else {
			System.out.println("Compare between two different lists with equal length test passed.");
		}
		
		list1.add("test");
		newdifferencels = Compare.computeDifferenceList(list1, list2);
		if (differencels.isEmpty()) {
			System.out.println("Error. The difference list should not be empty.");
		} else {
			System.out.println("Compare between two different lists with different length test passed.");
		}
	}
	
//	3. Two lists with one list being empty: Should return a non-empty list
	@Test
	public void compareWithEmpty() {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> differencels = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			list1.add(String.valueOf(i));
		}
		differencels = Compare.computeDifferenceList(list1, list2);
		if (differencels.isEmpty()) {
			System.out.println("Error. The difference list should not be empty.");
		} else {
			System.out.println("Compare between one filled and one empty list test passed.");
		}
	}
	
//	Storing the differences found in another CSV file
//	1. An empty difference list: Should return an empty CSV file
	@Test
	public void emptyList() {
		ArrayList<String> differencels = new ArrayList<String>();
		Compare.writeToCSVFile(differencels, "emptyDifference_test.csv");
	}
	
//	2. A difference list with some blank entries: Should return a CSV file with the blank entries reflected
	@Test
	public void someBlankList() {
		ArrayList<String> differencels = new ArrayList<String>();
		differencels.add("hi");
		differencels.add("hi");
		differencels.add("");
		differencels.add("");
		differencels.add("hi");
		Compare.writeToCSVFile(differencels, "someBlankDifference_test.csv");
	}
	
//	3. A difference list that is filled: Should return a CSV file that is also filled
	@Test 
	public void filledList() {
		ArrayList<String> differencels = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			differencels.add("hi");
		}
		Compare.writeToCSVFile(differencels, "filledDifference_test.csv");
	}

}

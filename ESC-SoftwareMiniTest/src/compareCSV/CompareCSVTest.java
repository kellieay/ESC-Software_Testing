package compareCSV;



import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CompareCSVTest {
	private CompareCSV compareCSV;
//	public static final String TEXT_RESET = "\u001B[0m";
//	public static final String TEXT_RED = "\u001B[31m";
//	public static final String TEXT_GREEN = "\u001B[32m";

	@Before
	public void setUp() throws Exception {
		compareCSV = new CompareCSV();
	}

	@After
	public void tearDown() throws Exception {
	}

//	Unit Testing
	
//	@Test [WORK ON THIS!!!]
//	public void testCompareCols() {
//		String file1 = "/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/testSampleCSV/UnitTest_1col.csv";
//		String file2 = "/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/testSampleCSV/UnitTest_3cols.csv";
//		String file3 = "/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/testSampleCSV/UnitTest_diff3cols.csv";
//		
////		try {
//////			check that both files have the same number of columns with the same column headers in the same order
//////			assertTrue(compareCSV.compareCols(file2, file3));
//////			check that both files do not have the same number of columns: 1 has 1 column, the other has 3 columns
//////			assertFalse(compareCSV.compareCols(file1, file2));
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//	}
	
	@Test
	public void testGetHeaders() {
		String file1 = "/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/testSampleCSV/UnitTest_1col.csv";
		String file2 = "/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/testSampleCSV/UnitTest_3cols.csv";
		String file4 = "/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/testSampleCSV/UnitTest_0col.csv";
				
		List<String> lsFile1 = new ArrayList<String>();
		lsFile1.add("col1");
		try {
			List<String> ls1 = compareCSV.getHeaders(file1);
			assertEquals(lsFile1.size(), ls1.size());
//			assertTrue(lsFile1.containsAll(ls1));
//			assertTrue(ls1.containsAll(lsFile1));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetIndex() {
		List<String> userInp = Arrays.asList("col1", "col3");
		List<String> headerLs = Arrays.asList("col1", "col2", "col3", "col4", "col5");
		List<Integer> indexLs = Arrays.asList(0, 2);
		assertEquals(indexLs, compareCSV.getIndex(userInp, headerLs));
	}
	
	@Test
	public void testGetContentCsv() {
		String file = "/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/testSampleCSV/UnitTest_3cols.csv";
		List<String> result = Arrays.asList("val1,val2,val3");
		try {
			assertEquals(result, compareCSV.getContentCsv(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCompareCsv() {
		List<String> file1 = Arrays.asList("val1,val2,val3");
		List<String> file2 = Arrays.asList("newval1,newval3,newval2");
		List<Integer> indexLs = Arrays.asList(0);
		List<String> result = Arrays.asList("newval1,newval3,newval2","val1,val2,val3");
		assertEquals(result, compareCSV.compareCsv(file1, file2, indexLs));
	}
//	
//	System Testing
//	1. Checks number of columns in both CSV files
//		a. both empty CSV files
	@Test
	public void compareEmpty() {
		String emptyFile = "/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/testSampleCSV/SystemTest_emptyCol.csv";
		try {
			if (compareCSV.compareCols(emptyFile, emptyFile) == true) {
				System.out.println("PASSED! comparison test between two empty CSV files passed.");
			} else {System.out.println("FAILED! comparison test between two empty CSV files failed.");}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//		b. one empty CSV file and one CSV file with only one header
	@Test
	public void compareOneHeader() {
		String emptyFile = "/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/testSampleCSV/SystemTest_emptyCol.csv";
		String oneHeadFile = "/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/testSampleCSV/UnitTest_1col.csv";
		try {
			if (compareCSV.compareCols(emptyFile, oneHeadFile) == false) {
				System.out.println("PASSED! comparison test between one empty and one header CSV files passed.");
			} else {System.out.println("FAILED! comparison test between one empty and one header CSV files failed.");}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//		c. both CSV files are filled
	@Test
	public void compareFilled() {
		String file1 = "/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/testSampleCSV/UnitTest_3cols.csv";
		String file2 = "/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/testSampleCSV/UnitTest_3cols.csv";
		String file3 = "/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/testSampleCSV/UnitTest_1col.csv";
		try {
			if (compareCSV.compareCols(file1, file2) == true) {
				System.out.println("PASSED! comparison between two filled CSV files with equal number of columns passed.");
				if (compareCSV.compareCols(file1, file3) == false) {
					System.out.println("PASSED! comparison between two filled CSV files with different number of columns passed.");
				} else {System.out.println("FAILED! comparison between two filled CSV files with different number of columns failed.");}
			} else {
				System.out.println("FAILED! comparison between two filled CSV files with equal number of columns failed.");
				if (compareCSV.compareCols(file1, file3) == false) {
					System.out.println("PASSED! comparison between two filled CSV files with different number of columns passed.");
				} else {System.out.println("FAILED! comparison between two filled CSV files with different number of columns failed.");}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	2. Getting the headers from a CSV file [NEED TO WORK ON THIS ESP THE DEFAULT FUNC]
//		a. an empty CSV file
	@Test
	public void emptyHead() {
		String emptyFile = "/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/testSampleCSV/SystemTest_emptyCol.csv";
		List<Integer> emptyLs = Collections.<Integer>emptyList();
		try {
			if (compareCSV.getHeaders(emptyFile).equals(emptyLs)) {
				System.out.println("PASSED! getting headers from an empty CSV file passed.");
			} else {System.out.println("FAILED! getting headers from an empty CSV file failed.");}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//		b. a CSV file with one header
	@Test
	public void oneHead() {
		String file = "/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/testSampleCSV/UnitTest_1col.csv";
		List<String> headerLs = Arrays.asList("col1");
		try {
			if (compareCSV.getHeaders(file).equals(headerLs)) {
				System.out.println("PASSED! getting the headers from a CSV file with one header passed.");
			} else {
				System.out.println("FAILED! getting the headers from a CSV file with one header failed.");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//		c. a CSV file with multiple headers
	
//	3. Getting the index of columns to be compared from a CSV file
//		a. empty CSV file
//	@Test
//	public void emptyIndex() {
//		List<String> userInp = new ArrayList<String>();
//		List<String> headerLs = Arrays.asList("col1", "col2");
//		List<Integer> emptyLs = Collections.<Integer>emptyList();
//		if (compareCSV.getIndexHeaders(userInp, headerLs).equals(emptyLs)) {
//			System.out.println("PASSED! getting the indexes from an empty file passed.");
//		} else {System.out.println("FAILED! getting the indexes from an empty file failed.");}
//	}
	
//	Fuzzing Test
	@Test
	public void randUserInp() {
		List<String> userLs = new ArrayList<String>();
		String str1 = "fjaljfoeifowlmnflaklfj";
		String str2 = "hi,this, is , rubbish lol";
		String str3 = "oiajofieika, foiafoijoaf, ofhoaiwjfoiaw, fhoaifjoafo";
		String str4 = "column1,column2, column3, column4";
		String empStr = "";
		List<String> headerLs = Arrays.asList("col1, col2, col3");
		assertEquals(compareCSV.userInpLs(userLs, str1, headerLs), null);
	}

}

package compareCSV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CompareCSV {
	
//	this method helps to check if the number of columns in both CSV files are equal
	public static boolean compareCols(String file1, String file2) throws IOException {
		BufferedReader br1 = new BufferedReader(new FileReader(file1));
		BufferedReader br2 = new BufferedReader(new FileReader(file2));
		String header1 = br1.readLine();
		String header2 = br2.readLine();
		if (header1.equals(header2)) {
			return true;
		} else {
			return false;
		}
	}
	
//	this method helps to get the user input for the unique combination of keys
	public static List<String> getUserInput () {
		List<String> headerList = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter some unique combination of header(s). \nIf there's more than one, please separate them with a comma (,): ");
		String str = sc.nextLine();
		if (str.contains(",")) {
			headerList = Arrays.asList(str.split(","));
		} else {
			headerList.add(str);
		}
		return headerList;
	}
	
//	this method gives us a list of all the headers in a CSV file
	public static List<String> getHeaders(String file) throws FileNotFoundException {
		String headers;
		List<String> headersLs = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		try {
			headers = br.readLine();
			headersLs = Arrays.asList(headers.split(","));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return headersLs;
	}
	
//	this method gives us the headers of the rest of the columns to be compared between the 2 CSV files
	public static List<String> getCorrectHeader(List<String> userInp, List<String> headers) {
		List<String> correctHeaderLs = new ArrayList<String>();
		for (int i = 0; i < userInp.size(); i++) {
			String str = userInp.get(i);
			for (int j = 0; j < headers.size(); j++) {
				String str2 = headers.get(j).replaceAll("^\"|\"$", "");
				if (str2.equals(str)) {
					continue;
				} else {
					correctHeaderLs.add(headers.get(j));
				}
			}
		}
		return correctHeaderLs;
	}
	
//	this method helps to give the list of each line in the CSV file
	public static List<String> addToLs(String file) throws IOException {
		List<String> value = new ArrayList<String>();
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				value.add(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
//	this method helps to get the index of the columns to be compared
	public static List<Integer> getIndexHeaders(String file, List<String> userHeaderLs) {
		String headers;
		List<String> headersLs;
		List<Integer> indexLs = new ArrayList<Integer>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			headers = br.readLine();
			headersLs = Arrays.asList(headers.split(","));
			for (int i = 0; i < headersLs.size(); i++) {
				for (int j = 0; j < userHeaderLs.size(); j++) {
					if (headersLs.get(i).equals(userHeaderLs.get(j))) {
						indexLs.add(i);
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return indexLs;
	}
	
//	this method compares line by line between the tow CSV files
	public static List<String> compareLines(List<String> file1, List<String> file2, List<Integer> indexLs) {
		List<String> differenceLs = new ArrayList<String>();
		if (file1.size() > file2.size()) {
			for (int i = 0; i < file2.size(); i++) {
				List<String> ele1 = Arrays.asList(file1.get(i).split(","));
				List<String> ele2 = Arrays.asList(file2.get(i).split(","));
				for (int j = 0; j < indexLs.size(); j++) {
					int index = indexLs.get(j);
					if (ele1.get(index).equals(ele2.get(index))) {
						continue;
					} else {
						differenceLs.add(file2.get(i));
						differenceLs.add(file1.get(i));
					}
				}
			}
		} else {
			for (int i = 0; i < file1.size(); i++) {
				List<String> ele1 = Arrays.asList(file1.get(i).split(","));
				List<String> ele2 = Arrays.asList(file2.get(i).split(","));
				for (int j = 0; j < indexLs.size(); j++) {
					int index = indexLs.get(j);
					if (ele1.get(index).equals(ele2.get(index))) {
						continue;
					} else {
						differenceLs.add(file2.get(i));
						differenceLs.add(file1.get(i));
					}
				}
			}
		}
		return differenceLs;
	}
	
//	this method writes the difference found between the two CSV files into a new CSV file
	public static File writeToCSVFile(List<String> differenceLs, String newFileName) {
		File file = new File(newFileName);
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < differenceLs.size(); i++) {
				bw.write(differenceLs.get(i));
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<String> headerLs1 = new ArrayList<String>();
		List<String> headerLs2 = new ArrayList<String>();
		List<String> userInp = new ArrayList<String>();
		boolean res = compareCols("/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/compareCSV/sample_file_1.csv", "/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/compareCSV/sample_file_3.csv");
		if (res == true) {
			userInp = getUserInput();
			headerLs1 = getCorrectHeader(userInp, getHeaders("/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/compareCSV/sample_file_1.csv"));
			
			List<String> file1Ls = addToLs("/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/compareCSV/sample_file_1.csv"); 
			List<String> file2Ls = addToLs("/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/compareCSV/sample_file_3.csv");
			List<Integer> indexLs = getIndexHeaders("/Users/kellieayy/ESC-MiniTesting/ESC-SoftwareMiniTest/src/compareCSV/sample_file_1.csv", headerLs1);
			writeToCSVFile(compareLines(file1Ls, file2Ls, indexLs), "test1_4.csv");
			
		} else {
			System.out.println("Error! The number of columns in both files are different.");
		}
	}

}

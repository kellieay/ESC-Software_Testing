package comparecsv;

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

public class Compare {

	public static BufferedReader readCSVFile (String string) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(string));
		return br;
	}
	
	public static List<String> addToList(String line, BufferedReader file) {
		List<String> file1 = new ArrayList<>();
		try {
			while ((line = file.readLine()) != null) {
				file1.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file1;
	}
	
	public static ArrayList<String> computeDifferenceList(List<String> list1, List<String> list2) {
		ArrayList<String> difference = new ArrayList<String>();
		if (list1.size() > list2.size()) {
			for (int i = 0; i < list2.size(); i++) {
				if ((list1.get(i)).equals(list2.get(i))) {
					continue;
				}
				else {
					difference.add(list2.get(i));
					difference.add(list1.get(i));
				}
			}
			for (int j = list2.size(); j < list1.size(); j++) {
				difference.add(list1.get(j));
			}
		} else if (list2.size() > list1.size()) {
			for (int i = 0; i < list1.size(); i++) {
				if ((list1.get(i)).equals(list2.get(i))) {
					continue;
				}
				else {
					difference.add(list2.get(i));
					difference.add(list1.get(i));
				}
			}
			for (int j = list1.size(); j < list2.size(); j++) {
				difference.add(list2.get(j));
			}
		} else if (list1.size() == list2.size()) {
			for (int i = 0; i < list2.size(); i++) {
				if ((list1.get(i)).equals(list2.get(i))) {
					continue;
				}
				else {
					difference.add(list2.get(i));
					difference.add(list1.get(i));
				}
			}
		}
		return difference;
	}
	
	public static File writeToCSVFile(ArrayList<String> differenceList, String newFileName) {
		File file = new File(newFileName);
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Customer ID#, Account No,, Currency, Type, Balance");
			bw.newLine();
			for (int i = 0; i < differenceList.size(); i++) {
				bw.write(differenceList.get(i));
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	public static void main(String[] args) throws FileNotFoundException {
		String line = "";
		String line2 = "";
		List<String> lines = new ArrayList<>();
		List<String> lines2 = new ArrayList<>();
		ArrayList<String> difference = new ArrayList<String>();
		BufferedReader br;
		BufferedReader br2;
//		try {
//			BufferedReader br = new BufferedReader(new FileReader("/Users/kellieayy/eclipse-workspace/comparecsv/src/comparecsv/sample_file_1.csv"));
//			BufferedReader br2 = new BufferedReader(new FileReader("/Users/kellieayy/eclipse-workspace/comparecsv/src/comparecsv/sample_file_3.csv"));
//			
//			lines = addToList(line, br);
//			lines2 = addToList(line2, br2);
//		}
//		catch(FileNotFoundException e) {
//			e.printStackTrace();
//		}
		br = readCSVFile("/Users/kellieayy/eclipse-workspace/comparecsv/src/comparecsv/sample_file_1.csv");
		br2 = readCSVFile("/Users/kellieayy/eclipse-workspace/comparecsv/src/comparecsv/sample_file_3.csv");
		lines = addToList(line, br);
		lines2 = addToList(line2, br2);
		difference = computeDifferenceList(lines, lines2);
		writeToCSVFile(difference, "difference1_3.csv");
		
	}

}

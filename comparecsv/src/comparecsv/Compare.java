package comparecsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Compare {

	public static void main(String[] args) {
		String line = "";
		String line2 = "";
		List<String> lines = new ArrayList<>();
		List<String> lines2 = new ArrayList<>();
		ArrayList<String> difference = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/kellieayy/eclipse-workspace/comparecsv/src/comparecsv/sample_file_1.csv"));
			BufferedReader br2 = new BufferedReader(new FileReader("/Users/kellieayy/eclipse-workspace/comparecsv/src/comparecsv/sample_file_2.csv"));
			try {
				while((line = br.readLine()) != null) {
//					String[] values = line.split(",");
//					System.out.println(values[0]);
					lines.add(line);
				}
				while((line2 = br2.readLine()) != null) {
					lines2.add(line2);
				}
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int i=0; i<lines.size(); i++) {
			if ((lines.get(i)).equals(lines2.get(i))) {
				continue;
			}
			else {
				difference.add(lines2.get(i));
				difference.add(lines.get(i));
			}
		}
		File file = new File("test.csv");
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("Customer ID#, Account No., Currency, Type, Balance");
			bw.newLine();
			for (int j=0; j<difference.size(); j++) {
				bw.write(difference.get(j));
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

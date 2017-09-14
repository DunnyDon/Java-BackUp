package Machine_Learning.CSV_Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void main(String[] args) {
    	int linecount = 0;
        String csvFile = "C:/Users/Conor/Documents/owls15.csv";
        String line;
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                for(int i = 0; i<country.length;i++){
                	System.out.print(country[i]+"\t");
                }
                System.out.println(" ");
                linecount+=1;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(linecount);
    }

}
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;

public class WhichCountriesExport {

    public static void listExporters(CSVParser parser, String exportOfInterest1, String exportOfInterest2){

        int count = 0;
        for (CSVRecord record: parser){
            String exports = record.get("Exports");
            if (exports.contains(exportOfInterest1)&&exports.contains(exportOfInterest2)){
                System.out.println(record.get("Country"));
                count++;
            }
        }
        System.out.println(count + " exporters.");
    }
    public static void listExporters(CSVParser parser, String exportOfInterest1){

        int count = 0;
        for (CSVRecord record: parser){
            String exports = record.get("Exports");
            if (exports.contains(exportOfInterest1)){
                System.out.println(record.get("Country"));
                count++;
            }
        }
        System.out.println(count + " exporters.");
    }

    public static void countryDetails(CSVParser parser){

            for(CSVRecord record: parser){
                    String country = record.get("Country");
                    String value = record.get("Value (dollars)");
                    String valueNumber = value.replaceAll("\\D+","");
                long valueLong = Long.parseLong(valueNumber);
                if(valueLong> 999999999999L){
                    System.out.println(country + " : " + valueNumber);
                }
                }

        }


    public static void main(String[] arg) throws IOException {

        FileResource file = new FileResource("exportdata.csv");
        CSVParser parser = file.getCSVParser();

       listExporters(parser, "cotton", "flowers");
       listExporters(parser, "cocoa");
        System.out.println("");

        countryDetails(parser);
    }
}

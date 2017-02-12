import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class WhichCountriesExport {

    public static void listExporters(CSVParser parser, String exportOfInterest){

        int count = 0;
        for (CSVRecord record: parser){
            String exports = record.get("Exports");
            if (exports.contains(exportOfInterest)){
                System.out.println(record.get("Country"));
                count++;
            }
        }
        System.out.println(count + " exporters.");
    }

    public static void countryDetails(CSVParser parser, String country){

            for(CSVRecord record: parser){
                String c = record.get("Country");
                //if (c.equals(country)) {
                    String exports = record.get("Exports");
                    String value = record.get("Value (dollars)");
                    System.out.println(country + ": " + exports + " : " + value);
                }
        }

    public static void main(String[] arg){

        FileResource file = new FileResource("exports_small.csv");
        CSVParser parser = file.getCSVParser();

        listExporters(parser, "coffe");

         countryDetails(parser, "Germany");
    }
}

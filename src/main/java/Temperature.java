import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class Temperature {

    public static CSVRecord hottestInOneDay(CSVParser parser) {

        CSVRecord largestSoFar = null;

        for (CSVRecord currentRow : parser) {
            if (largestSoFar == null) {
                largestSoFar = currentRow;
            } else {
                Double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                Double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                if (currentTemp > largestTemp) {
                    largestSoFar = currentRow;
                }
            }
        }
        return largestSoFar;
    }
    public static CSVRecord hottestInManyDays() {

        DirectoryResource dr = new DirectoryResource();

        CSVRecord largestSoFar = null;
        for (File f : dr.selectedFiles()) {

            FileResource file = new FileResource(f);
            if (largestSoFar == null) {
                largestSoFar = hottestInOneDay(file.getCSVParser());
            } else {
                CSVRecord current = hottestInOneDay(file.getCSVParser());
                Double currentTemp = Double.parseDouble(current.get("TemperatureF"));
                Double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                if (currentTemp > largestTemp) {
                    largestSoFar = current;
                }
            }
        }return largestSoFar;
    }


    public static void main(String[] arg){
        FileResource file = new FileResource("data/2015/weather-2015-01-01.csv");
        CSVRecord largest = hottestInOneDay(file.getCSVParser());
        System.out.println("The hottest time was "+ largest.get("TimeEST")+" with temperature "+largest.get("TemperatureF"));
        CSVRecord largestInManyDays = hottestInManyDays();
        System.out.println("The hottest time was "+ largestInManyDays.get("TimeEST")+" with temperature "+largestInManyDays.get("TemperatureF"));

    }
}

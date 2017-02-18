import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class Humidity {

    public static CSVRecord lowestInOneDay(CSVParser parser) {

        CSVRecord lowestSoFar = null;
        String time = "";
        Double lowestHum = 0.0;

        for (CSVRecord currentRow : parser) {
            lowestSoFar = getLowestOfTwo(lowestSoFar, currentRow);
        }
        return lowestSoFar;
    }


    public static CSVRecord lowestInManyDays() {

        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestSoFar = null;

        for (File f : dr.selectedFiles()) {
            FileResource file = new FileResource(f);
            CSVRecord currentRow = lowestInOneDay(file.getCSVParser());
            lowestSoFar=getLowestOfTwo(lowestSoFar, currentRow);
        }System.out.println(lowestSoFar.get("Humidity")+" : "+lowestSoFar.get("DateUTC"));

        return lowestSoFar;
    }

    public static CSVRecord getLowestOfTwo(CSVRecord lowestSoFar, CSVRecord currentRow) {
        if (lowestSoFar == null) {
            lowestSoFar = currentRow;
        } else {
            Double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
            Double largestTemp = Double.parseDouble(lowestSoFar.get("Humidity"));
            if (currentTemp < largestTemp) {
                lowestSoFar = currentRow;
            }
        }
        return lowestSoFar;
    }

    public static void main(String[] arg){
//        FileResource file = new FileResource("weather-2014-07-22.csv");
//        CSVParser parser = file.getCSVParser();
//        CSVRecord largest = hottestInOneDay(file.getCSVParser());
//        System.out.println("The hottest time in one day was "+ largest.get("TimeEST")+" with temperature "+largest.get("TemperatureF"));
//        CSVRecord largestInManyDays = hottestInManyDays();
//        System.out.println("The hottest time in many days was "+ largestInManyDays.get("TimeEST")+" with temperature "+largestInManyDays.get("TemperatureF"));

        //    lowestHumidity(parser);
        lowestInManyDays();
    }
}

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class Temperature {

    public static CSVRecord hottestInOneDay(CSVParser parser) {

        CSVRecord largestSoFar = null;

        for (CSVRecord currentRow : parser) {
             largestSoFar = getHottestOfTwo(largestSoFar, currentRow);
        }
        return largestSoFar;
    }

        public static CSVRecord coldestInOneDay(CSVParser parser) {

            CSVRecord coldestSoFar = null;

            for (CSVRecord currentRow : parser) {
                coldestSoFar = getColdestOfTwo(coldestSoFar, currentRow);
            }
            return coldestSoFar;
        }

    public static CSVRecord hottestInManyDays() {

        DirectoryResource dr = new DirectoryResource();
        CSVRecord largestSoFar = null;

        for (File f : dr.selectedFiles()) {
            FileResource file = new FileResource(f);
            CSVRecord currentRow = hottestInOneDay(file.getCSVParser());
            largestSoFar=getHottestOfTwo(largestSoFar, currentRow);
        }return largestSoFar;
    }

    public static String coldestDayInManyDays() {

        DirectoryResource dr = new DirectoryResource();
        CSVRecord coldestSoFar = null;
        String date=null;
        String temp=null;

        for (File f : dr.selectedFiles()) {
            FileResource file = new FileResource(f);
            CSVRecord currentRow = coldestInOneDay(file.getCSVParser());
            coldestSoFar=getColdestOfTwo(coldestSoFar, currentRow);
            date = coldestSoFar.get("DateUTC");
            temp = coldestSoFar.get("TemperatureF");
        }

        return temp;
    }

    public static CSVRecord getHottestOfTwo(CSVRecord largestSoFar, CSVRecord currentRow) {
        if (largestSoFar == null) {
            largestSoFar = currentRow;
        } else {
            Double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            Double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
            if (currentTemp > largestTemp) {
                largestSoFar = currentRow;
            }
        }
        return largestSoFar;
    }

    public static CSVRecord getColdestOfTwo(CSVRecord coldestSoFar, CSVRecord currentRow) {
        if (coldestSoFar == null) {
            coldestSoFar = currentRow;
        } else {
            Double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            Double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
            if (currentTemp < coldestTemp) {
                coldestSoFar = currentRow;
            }
        }
        return coldestSoFar;
    }
    public static double getAverageTemp(CSVParser parser){

        double sum = 0;
        int counter=0;

        for (CSVRecord record: parser){
            double currentTemp = Double.parseDouble(record.get("TemperatureF"));
            sum+=currentTemp;
            counter++;
        }
        return sum/counter;
    }


    public static float getAverageTempWhenHumidity(CSVParser parser){

        int counter=0;
        float sum=0;

        for (CSVRecord record: parser){
            float humidity = Float.parseFloat(record.get("Humidity"));
            float curentTemp=Float.parseFloat(record.get("TemperatureF"));
            if (humidity >= 80){
                sum +=curentTemp;
                counter++;}
        }
        System.out.println("Counter: "+ counter);
        float average=sum/counter;
        return average;
    }

    public static void main(String[] arg){
        FileResource file = new FileResource("weather-2013-09-02.csv");
        CSVParser parser = file.getCSVParser();
//        CSVRecord largest = hottestInOneDay(file.getCSVParser());
//        System.out.println("The hottest time in one day was "+ largest.get("TimeEST")+" with temperature "+largest.get("TemperatureF"));
//        CSVRecord largestInManyDays = hottestInManyDays();
//        System.out.println("The hottest time in many days was "+ largestInManyDays.get("TimeEST")+" with temperature "+largestInManyDays.get("TemperatureF"));

        //System.out.println("The average temp was " + getAverageTemp(parser));
        System.out.println("The average temp when humidity was 80 or more was " + getAverageTempWhenHumidity(parser));
        System.out.print("The coldest day was "+ coldestDayInManyDays());
    }
}

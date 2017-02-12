import edu.duke.URLResource;

public class ReadUrl {

    public static void readFromPage() {

        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");

        for (String word : ur.words()) {
            if(word.contains("youtube.com")){
                int ytIndex = word.indexOf("youtube");
                int urlStart = word.lastIndexOf("\"", ytIndex-1);
                int urlEnd = word.indexOf("\"", ytIndex+3);
                String sub1 = word.substring(urlStart, urlEnd);
                System.out.println(sub1);

            }
        }
    }

    public static void main(String[] args){

    readFromPage();
    }

}
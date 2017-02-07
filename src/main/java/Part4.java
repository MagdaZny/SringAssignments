import edu.duke.URLResource;

public class Part4 {

    public static void readFromPage() {

        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");

        for (String word : ur.words()) {
            if(word.contains("youtube.com")){
                int ytIndex = word.indexOf("youtube");
                int indexStart = word.lastIndexOf("\"");
                int indexEnd = word.indexOf("\"");
                String sub1 = word.substring(0, indexStart);
                String sub2 = word.substring(indexEnd);
                System.out.println("http:"+sub1+"youtube.com"+sub2);
            }
        }
    }

    public static void main(String[] args){

    readFromPage();
    }

}
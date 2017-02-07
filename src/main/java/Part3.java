public class Part3{

    public static boolean twoOccurrences(String a, String b){

        int aStartIndex = b.indexOf(a);
        if(aStartIndex == -1) return false;

        String bShorter = b.substring(aStartIndex + a.length());

        if(bShorter.contains(a)) return true;
            else return false;
    }

}
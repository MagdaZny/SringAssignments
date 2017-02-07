public class Part3{

    public static boolean twoOccurrences(String a, String b){

        int aStartIndex = b.indexOf(a);
        if(aStartIndex == -1) return false;

        String bShorter = b.substring(aStartIndex + a.length());

        if(bShorter.contains(a)) return true;
            else return false;
    }


    public static String lastPart(String a, String b){

        String result;
        int aStartIndex = b.indexOf(a);

        if(aStartIndex == -1) result=b;
        else {
            String bShorter = b.substring(aStartIndex + a.length());
            result=bShorter;
        }
        return result;
    }

}
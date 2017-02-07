public class FindGeneSimpleAndTest{

    public static String findSimpleGene(String dna){

        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1) return "";

        int endIndex = dna.indexOf("TAA", startIndex+3);
        if(endIndex == -1) return "";

        String gene = dna.substring(startIndex, endIndex+3);

        if(gene.length()%3==0)return gene;
        else return "";
    }
}
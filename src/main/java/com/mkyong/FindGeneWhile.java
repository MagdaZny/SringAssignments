package com.mkyong;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FindGeneWhile{

    static FindGeneWhile obj = new FindGeneWhile();

    static String dna = obj.getFile("dna.txt");
    StringBuilder contents = new StringBuilder();

    public String getFile(String fileName) {

        StringBuilder result = new StringBuilder("");

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();

    }

    public static String findGene(String dna, int where) {

        int startIndex = dna.indexOf("ATG", where);
        if(startIndex == -1) return "";

        int taaIndex = findStopCodonIndex("TAA", startIndex);
        int tgaIndex = findStopCodonIndex("TGA", startIndex);
        int tagIndex = findStopCodonIndex("TAG", startIndex);


        int minIndex= Math.min(Math.min(taaIndex, tgaIndex),tagIndex);
        if(minIndex==dna.length())return"";

        String gene = dna.substring(startIndex, minIndex+3);
        return gene;
    }

        public static int findStopCodonIndex(String stopCodon, int startIndex) {

            int currIndex = dna.indexOf(stopCodon, startIndex+3);
            if (currIndex == -1) return 100000;

            while (currIndex != -1) {
                int diff = currIndex - startIndex;
                if (diff % 3 == 0) return currIndex;
                else currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
            return 100000;
        }

    public static int printAllGenes(String dna){
            int startIndex=0;
            int count = 0;
            int length = 0;
            String longestGene = "";

            while(true){
               String currentGene = findGene(dna, startIndex);
            if(currentGene.isEmpty()){
                break;
            }
            //out.println(currentGene);
            //if(gcRatio(currentGene)>0.35)count +=1;
            startIndex = dna.indexOf(currentGene, startIndex)+currentGene.length();
            if(currentGene.length()>length)
                length = currentGene.length();
                longestGene = currentGene;
            }

            System.out.println(longestGene);
            System.out.println(longestGene.length());
            return count;

    }

    public static float gcRatio(String dna){

        int counter = 0;
        for( int i=0; i< dna.length(); i++ ) {
            if( dna.charAt(i) == 'G'|| dna.charAt(i) =='C' ){
                counter++;
            }
        }

        float len = dna.length();
        return counter/len;
    }

    public static void main(String[] arg){
          // out.print(dna);
           //printAllGenes(dna);
           //System.out.print(printAllGenes(dna));

        int counter = 0;
        String sub = "";
        for( int i=0; i < dna.length()-3; i++ ) {
          sub=dna.substring(i, i+3);
          if(sub.equals("CTG"))counter += 1;
        }
        System.out.println(counter);


    }
    }
 public class Part2{

        public static String findSimpleGene(String dna, String startCodon, String stopCodon) {

            int startIndex = dna.indexOf(startCodon);
            if (startIndex == -1) return "";

            int endIndex = dna.indexOf(stopCodon, startIndex + 3);
            if (endIndex == -1) return "";

            String gene = dna.substring(startIndex, endIndex + 3);

            if (gene.length() % 3 == 0) {
                if (gene.toLowerCase() == gene) return gene.toLowerCase();
                else return gene;
            } else return "";
        }

    }

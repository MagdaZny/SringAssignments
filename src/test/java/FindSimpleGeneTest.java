import org.junit.Assert;
import org.junit.Test;

public class FindSimpleGeneTest {

    @Test
    public void testFindSimpleGeneValidDna() {

        String dna = "AATGCGTGAAGAGSAGTAAGCTTAAAG";
        System.out.println("DNA strand is " + dna);
        String gene = FindGeneSimpleAndTest.findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        Assert.assertEquals("ATGCGTGAAGAGSAGTAA" ,gene);

    }

    @Test
    public void testFindSimpleGeneNoATG() {

        String dna = "TGCGTAAGAGSATAAGCTAG";
        System.out.println("DNA strand is " + dna);
        String gene = FindGeneSimpleAndTest.findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        Assert.assertEquals("", gene);

    }

    @Test
    public void testFindSimpleGeneNoTAA() {

        String dna = "AATGCGTATGAGSATAGCAAAG";
        System.out.println("DNA strand is " + dna);
        String gene = FindGeneSimpleAndTest.findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        Assert.assertEquals("", gene);

    }

    @Test
    public void testFindSimpleGeneInvalidDnaLength() {

        String dna = "AATGCGTGAAGAGSATAAGCTTAAAG";
        System.out.println("DNA strand is " + dna);
        String gene = FindGeneSimpleAndTest.findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        Assert.assertEquals("", gene);

    }
}

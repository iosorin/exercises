import java.util.List;
import java.util.ArrayList;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        String[] codons = rnaSequence.replaceAll("(.{3})", "$1\n").split("\n");

        List<String> list = new ArrayList<String>();

        search:

        for (String codon : codons) {
            for (Protein protein : Protein.values()) {
                if (protein.codons.contains(codon)) {
                    if (protein.equals(Protein.STOP)) break search;

                    list.add(protein.name());
                }
            }
        }

        return list;
    }

    enum Protein {
        Methionine("AUG"),
        Phenylalanine("UUU, UUC, UUC"),
        Leucine("UUA, UUG, UUG"),
        Serine("UCU, UCC, UCA, UCG"),
        Tyrosine("UAU, UAC"),
        Cysteine("UGU, UGC"),
        Tryptophan("UGG"),
        STOP("UAA, UAG, UGA");

        String codons;

        Protein(String codons) {
            this.codons = codons;
        }
    }
}

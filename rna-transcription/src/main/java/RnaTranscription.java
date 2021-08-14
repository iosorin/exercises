class RnaTranscription {

    String transcribe(String DNAStrand) {
        StringBuilder result = new StringBuilder();

        DNAStrand.chars().forEach(c -> result.append(RNAStrand.fromString((char)c)));

        return result.toString();
    }

    private enum RNAStrand {
        U('A'),
        G('C'),
        C('G'),
        A('T');

        private char DNAStrand;

        RNAStrand(char DNAStrand) {
            this.DNAStrand = DNAStrand;
        }

        public static String fromString(char DNAStrand) {
            for (RNAStrand strand : RNAStrand.values()) {
                if (strand.DNAStrand == DNAStrand) {
                    return strand.toString();
                }
            }

            return "";
        }
    }
}

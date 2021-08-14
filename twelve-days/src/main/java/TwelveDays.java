class TwelveDays {
    private final static String VERSE_FORMAT = "On the %s day of Christmas my true love gave to me: %s.\n";

    String verse(int verseNumber) {
        String day = "";
        String gifts = "";

        for (int i = 0; i < verseNumber; i++) {
            Gifts gift = Gifts.values()[verseNumber - i - 1];
            String divider = "";

            if (i == 0) day = gift.day;
            else divider = i == verseNumber - 1 ? ", and " : ", ";

            gifts += divider + gift.gift;
        }

        return String.format(VERSE_FORMAT, day, gifts);
    }

    String verses(int startVerse, int endVerse) {
        String verses = "";

        for (int i = startVerse; i <= endVerse; i++) verses += verse(i) + (i == endVerse ? "" : "\n");

        return verses;
    }
    
    String sing() {
        return verses(1, 12);
    }

    enum Gifts {
        first("a Partridge in a Pear Tree"),
        second("two Turtle Doves"),
        third("three French Hens"),
        fourth("four Calling Birds"),
        fifth("five Gold Rings"),
        sixth("six Geese-a-Laying"),
        seventh("seven Swans-a-Swimming"),
        eighth("eight Maids-a-Milking"),
        ninth("nine Ladies Dancing"),
        tenth("ten Lords-a-Leaping"),
        eleventh("eleven Pipers Piping"),
        twelfth("twelve Drummers Drumming");

        String day;
        String gift;

        Gifts(String gift) {
            this.gift = gift;
            this.day = this.name();
        }
    }
}

class Yacht {
    int[] dice;
    YachtCategory yachtCategory;

    void correctDiceNumber(int[] dice) {
        if(dice.length != 5) throw new IllegalArgumentException("Illegal dice number");
    }

    void categoryProvided(YachtCategory yachtCategory) {
        if (yachtCategory == null) throw new IllegalArgumentException("Yacht category is a required");
    }

    Yacht(int[] dice, YachtCategory yachtCategory) {
        correctDiceNumber(dice);
        categoryProvided(yachtCategory);

        this.dice = dice;
        this.yachtCategory = yachtCategory;
    }

    int score() {
        return YachtScorer.score(this.dice, this.yachtCategory);
    }

}

class YachtScorer {
    static int score(int[] dice, YachtCategory yachtCategory) {
        switch (yachtCategory) {
            case ONES: return number(dice, 1);
            case TWOS: return number(dice, 2);
            case THREES: return number(dice, 3);
            case FOURS: return number(dice, 4);
            case FIVES: return number(dice, 5);
            case SIXES: return number(dice, 6);
            case FULL_HOUSE: return fullHouse(dice);
            case FOUR_OF_A_KIND: return fourOfKind(dice);
            case LITTLE_STRAIGHT: return straight(dice, 1);
            case BIG_STRAIGHT: return straight(dice, 2);
            case CHOICE: return choice(dice);
            default: return yacht(dice);
        }
    }

    static int number(int[] dice, int number) {
        int score = 0;

        for (int n : dice) if (n == number) score += n;

        return score;
    }

    static int fullHouse(int[] dice) {
        int n1 = dice[0];
        int n2 = 0, s1 = 0, s2 = 0;

        for (int n : dice) {
            if (n == n1) {
                s1 += n1;

                continue;
            }

            if (n2 != 0 && n != n2) return 0;

            n2 = n;
            s2 += n2;
        }

        if (s1 == n1 || n2 == 0) return 0;

        return s1 + s2;
    }

    static int fourOfKind(int[] dice) {
        if (dice[0] == dice[1] || dice[0] == dice[2]) {
            return number(dice, dice[0]) >= dice[0] * 4 ? dice[0] * 4 : 0;
        }

        return number(dice, dice[1]) >= dice[1] * 4 ? dice[1] * 4 : 0;
    }

    static int straight(int[] dice, int start) {
        if(start < 1 || start > 2) throw new IllegalArgumentException("start must be equal 1 or 2");

        int sum = choice(dice);

        if (start == 1) return sum == 15 ? 30 : 0;

        return sum == 20 ? 30 : 0;
    }

    static int choice(int[] dice) {
        int score = 0;

        for (int n : dice) score += n;

        return score;
    }

    static int yacht(int[] dice) {
        for (int n : dice) if (n != dice[0]) return 0;

        return 50;
    }
}

class Darts {
    double x, y, h;

    Darts(double x, double y) {
        this.x = x;
        this.y = y;

        this.h = Math.sqrt(x*x + y*y);
    }

    int score() {
        int score = Target.outside.score;

        for (Target target : Target.values()) {
            if (this.h <= target.radius) {
                score = target.score;

                break;
            }
        }

        return score;
    }

    private enum Target {
        inner(10, 1),
        middle(5, 5),
        outer(1, 10),
        outside(0, Target.outer.radius + 1);

        private int score;
        private int radius;

        Target(final int score, int radius) {
            this.score = score;
            this.radius = radius;
        }
    }
}

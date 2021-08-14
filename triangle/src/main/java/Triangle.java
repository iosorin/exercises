import java.util.Arrays;

class Triangle {
    Type type;

    double[] sides;

    void isCorrectSides(double[] sides) throws TriangleException {
        for (int i = 0; i < sides.length; i++) {
            if (sides[i] == 0) throw new TriangleException("All sides have to be of length > 0");

            double sum = 0;
            for (int j = 0; j < sides.length; j++) sum += i == j ? 0 : sides[j];

            if (sides[i] > sum) throw new TriangleException(
                    "Sum of the lengths of any two sides must be greater than or equal to the length of the third side"
            );
        }
    }

    Triangle(double side1, double side2, double side3) throws TriangleException {
        sides = new double[] {side1, side2, side3};

        isCorrectSides(sides);

        determineType();
    }

    private void determineType() {
        int distinctCount = (int) Arrays.stream(sides).distinct().count();

        switch (distinctCount) {
            case 1: type = Type.Equilateral; break;
            case 2: type = Type.Isosceles; break;
            case 3: type = Type.Scalene; break;
        }
    }

    boolean isEquilateral() {
        return type == Type.Equilateral;
    }

    boolean isIsosceles() {
        return type == Type.Isosceles || isEquilateral();
    }

    boolean isScalene() {
        return type == Type.Scalene;
    }

    enum Type {
        Equilateral,
        Isosceles,
        Scalene
    }

}

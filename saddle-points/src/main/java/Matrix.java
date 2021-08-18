import java.util.*;

class Matrix {
    private final List<List<Integer>> values;

    private final Map<MatrixCoordinate, Integer> matrix = new HashMap<>();

    private final Set<MatrixCoordinate> saddlePoints = new HashSet<>();

    Matrix(List<List<Integer>> values) {
        this.values = values;

        if (values.size() > 0) {
            this.generateMatrix();
            this.computeSaddlePoint();
        }
    }

    void generateMatrix() {
        for (int row = 0; row < values.size(); row++) {
            List<Integer> rowValues = values.get(row);

            for (int col = 0; col < rowValues.size(); col++) {
                int number = rowValues.get(col);
                MatrixCoordinate coordinate = new MatrixCoordinate(row + 1, col + 1);

                matrix.put(coordinate, number);
            }
        }
    }

    void computeSaddlePoint() {
        for (Map.Entry<MatrixCoordinate, Integer> entry : matrix.entrySet()) {
            MatrixCoordinate coordinate = entry.getKey();
            Integer value = entry.getValue();

            boolean isGreaterOrEqualInRow = true;
            boolean isLessOrEqualInCol = true;

            for (Map.Entry<MatrixCoordinate, Integer> subEntry : matrix.entrySet()) {
                MatrixCoordinate subCoordinate = subEntry.getKey();
                Integer subValue = subEntry.getValue();

                if (coordinate.equals(subCoordinate)) continue;

                if (coordinate.col == subCoordinate.col) {
                    if (value > subValue) {
                        isLessOrEqualInCol = false;
                        break;
                    }
                }

                if (coordinate.row == subCoordinate.row) {
                    if (value < subValue) {
                        isGreaterOrEqualInRow = false;
                        break;
                    }
                }
            }

            if (isGreaterOrEqualInRow && isLessOrEqualInCol) saddlePoints.add(coordinate);
        }
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        return saddlePoints;
    }
}

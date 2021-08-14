class Matrix {
    int rows[][];
    int cols[][];

    Matrix(String matrixAsString) {
        this.compute(matrixAsString);
    }

    private void compute(String input) {
        String[] stringRows = input.split("\n");

        int rowsLength = stringRows.length;
        int colsLength = stringRows[0].split(" ").length;

        rows = new int[rowsLength][colsLength];
        cols = new int[colsLength][rowsLength];

        for (int i = 0; i < stringRows.length; i++) {
            String[] stringRow = stringRows[i].split(" ");

            for (int j = 0; j < stringRow.length; j++) {
                rows[i][j] = cols[j][i] = Integer.parseInt(stringRow[j]);
            }
        }
    }

    int[] getRow(int rowNumber) {
        return rows[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        return cols[columnNumber - 1];
    }
}

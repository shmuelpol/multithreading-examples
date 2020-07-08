// project maman15, package matrixMultiplication, Matrix class. by shmuel polonsky
// a Matrix class. enables initialization to random values, and extracting of a row/column.
// displays random matrix on terminal when activated.

package matrixMultiplication;

import java.util.Random;

public class Matrix {
    private static final int MAX_CELL_VALUE = 11;
    private final int numOfRows;
    private final int numOfColumns;
    private int[][] data;

    public Matrix(int columns, int rows) {
        numOfColumns = columns;
        numOfRows = rows;
        data = new int[rows][columns];
    }

    public void initializeRandomMatrix() {
        Random random = new Random();
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                int num = random.nextInt(MAX_CELL_VALUE);
                System.out.print(num + " ");
                data[i][j] = num;
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public int getNumOfColumns() {
        return numOfColumns;
    }

    public int[] getRowVector(int row) {
        if (row > -1 && row < numOfRows) return data[row].clone();
        return null;
    }

    public int[] getColumnVector(int column) {
        if (column < 0 || column > numOfColumns) return null;
        int[] res = new int[numOfRows];
        for (int i = 0; i < numOfRows; i++) {
            res[i] = data[i][column];
        }
        return res;
    }
}

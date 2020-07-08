// project maman15, package matrixMultiplication, Matrix class. by shmuel polonsky
// receives two matrices, and multiplies them using multiplierThreads and printMonitor.

package matrixMultiplication;

public class MatrixMultiplier {
    public void multiplyAndDisplay(Matrix matrix1, Matrix matrix2) {
        int n = matrix1.getNumOfRows(); // size for final matrix
        int p = matrix2.getNumOfColumns();
        MatrixPrintMonitor printMonitor = new MatrixPrintMonitor(n, p);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                MultiplierThread thread = new MultiplierThread(matrix1, matrix2, i, j, printMonitor);
                thread.setPrintPriority((i * p) + (j + 1)); // set printPriority to actual coordinates on final matrix
                printMonitor.addToQueue(thread);
            }
        }
        printMonitor.go(); // start all threads
    }
}

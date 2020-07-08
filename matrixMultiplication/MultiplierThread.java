// project maman15, package matrixMultiplication, MultiplierThread class. by shmuel polonsky
// receives two matrices, and a specific cell in final matrix, and calculates the multiplication
// of the necessary row and column. displays result on terminal when permission is received from
// assigned printMonitor.


package matrixMultiplication;


public class MultiplierThread extends Thread {
    private final Matrix matrix1;
    private final Matrix matrix2;
    private final int i;
    private final int j;
    private MatrixPrintMonitor printMonitor;
    private int printPriority;

    public MultiplierThread(Matrix matrix1, Matrix matrix2, int i, int j, MatrixPrintMonitor printMonitor) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.i = i;
        this.j = j;
        this.printMonitor = printMonitor;
    }

    public void run() {
        try {
            multiply();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void multiply() throws InterruptedException {
        int res = 0;
        int[] rowVector = matrix1.getRowVector(i);
        int[] columnVector = matrix2.getColumnVector(j);
        for (int i = 0; i < rowVector.length; i++) {
            res = res + rowVector[i] * columnVector[i];
        }

        printMonitor.requestPermission();
        System.out.print(res + " ");
    }

    public int getPrintPriority() {
        return printPriority;
    }

    public void setPrintPriority(int printPriority) {
        this.printPriority = printPriority;
    }
}


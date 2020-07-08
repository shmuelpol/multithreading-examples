// project maman15, package matrixMultiplication, main class. by shmuel polonsky
// initializes two random matrices, and runs matrixMultiplier on them.

package matrixMultiplication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int n = 0;
        int m = 0;
        int p = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("please submit n");
            n = scanner.nextInt();
            System.out.println("please submit m");
            m = scanner.nextInt();
            System.out.println("please submit p");
            p = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("invalid arguments, goodbye.");
        }
        Matrix matrix1 = new Matrix(m, n);
        matrix1.initializeRandomMatrix();
        Matrix matrix2 = new Matrix(p, m);
        matrix2.initializeRandomMatrix();
        new MatrixMultiplier().multiplyAndDisplay(matrix1, matrix2);
    }
}


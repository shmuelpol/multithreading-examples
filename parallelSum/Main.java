// project maman15, question1.
// main class. crates a stock and threads and runs them.

package parallelSum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("please state the number of stock size desired");
            int stockSize = Integer.parseInt(scanner.next());
            Stock stock = new Stock(stockSize);
            System.out.println("please state the number of threads desired");
            int numOfThreads = Integer.parseInt(scanner.next());
            for (int i = 0; i < numOfThreads; i++) {
                new MyThread(stock).start();
            }
        } catch (Exception notANumber) {
            System.out.println("converting your string to number failed. goodbye.");
        }
    }
}

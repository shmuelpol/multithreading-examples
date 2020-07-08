// project maman15, question1.
// this class represents the main stock of elements. enables threads to retrieve
// two elements from the stock. also enables threads to add their sum to the stock.
// tells the last thread to show the total sum.

package parallelSum;


import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Stock {
    private static final int MAX_NUMBER = 100;
    private final int SUM_TIMEOUT = 200;
    private int retrievesLeft;
    private LinkedList<Integer> array = new LinkedList<>();

    public Stock(int size) {
        retrievesLeft = size - 1;
        Random random = new Random();
        System.out.println("the number in the array that were picked randomly are:");
        for (int i = 0; i < size; i++) {
            array.add(random.nextInt(MAX_NUMBER));
            System.out.println(array.getLast());
        }
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum = sum + array.get(i);
        }
    }

    public synchronized int[] retrieve() {
        if (retrievesLeft > 0) {
            retrievesLeft--;
            return new int[]{array.poll(), array.poll()};
        } else return null;
    }

    public synchronized int add(int num) throws InterruptedException {
        // allows threads to add sums to the array.
        // returns total sum to last thread in case of last addition, -1 otherwise
        array.add(num);

        if (retrievesLeft == 0) { // last addition
            TimeUnit.MILLISECONDS.sleep(SUM_TIMEOUT);
            return array.poll();
        }
        return -1; // not last addition
    }

    public synchronized boolean isActive() {
        if (retrievesLeft > 0) return true;
        return false;
    }
}

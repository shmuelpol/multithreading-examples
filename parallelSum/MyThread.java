// project maman15, question1.
// a thread for stock addition. sums elements from the array while array is active,
// displays the total sum of the array in case it's the last thread to make changes.

package parallelSum;

public class MyThread extends Thread {
    private Stock myStock;

    public MyThread(Stock stock) {
        super();
        myStock = stock;
    }

    public void run() {
        // sums two elements from stock. displays final sum if happens to be the last.
        while (myStock.isActive()) {
            int[] toSum = myStock.retrieve();
            int res = toSum[0] + toSum[1];
            int totalSum = -1;
            try {
                totalSum = myStock.add(res);
            } catch (Exception interrupted) {
            }

            System.out.println(this + " retrieved " + toSum[0] + " and " + toSum[1] + ", and submitted " + res);
            if (totalSum != -1) System.out.println("Total sum is " + totalSum + ". proudly given to you by " + this);
        }
    }
}

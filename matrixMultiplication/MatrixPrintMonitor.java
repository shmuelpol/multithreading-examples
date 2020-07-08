// project maman15, package matrixMultiplication, MatrixPrintMonitor class. by shmuel polonsky
// the print monitor builds a queue of threads, according to their print priority, and starts them.
// when a thread asks for permission to print, it is joined be the printMonitor to its
// preceding thread.
// the printMonitor also prints \n at the end of the final matrix line.


package matrixMultiplication;


public class MatrixPrintMonitor {
    private MultiplierThread[] queue;
    private int p;

    public MatrixPrintMonitor(int n, int p) {
        this.p = p;
        queue = new MultiplierThread[1 + n * p]; // sorted by actual order on final table
    }

    public void addToQueue(MultiplierThread thread) {
        queue[thread.getPrintPriority()] = thread;
    }

    public void requestPermission() throws InterruptedException {
        if (((MultiplierThread) Thread.currentThread()).getPrintPriority() != 1) {
            queue[((MultiplierThread) Thread.currentThread()).getPrintPriority() - 1].join();
            if ((((MultiplierThread) Thread.currentThread()).getPrintPriority() - 1) % p == 0) // start of a new row
                System.out.println("\n");
        }
    }

    public void go() {
        // fires all threads
        for (int i = 1; i < queue.length; i++) {
            queue[i].start();
        }
    }
}

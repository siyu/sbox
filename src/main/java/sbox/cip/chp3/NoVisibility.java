package sbox.cip.chp3;

/**
 * Created with IntelliJ IDEA.
 * User: siyu798
 * Date: 8/20/13
 * Time: 12:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}

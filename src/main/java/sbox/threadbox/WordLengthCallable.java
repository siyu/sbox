package sbox.threadbox;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: siyu798
 * Date: 5/21/13
 * Time: 12:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class WordLengthCallable implements Callable {

    private String word;
    public WordLengthCallable(String word) {
        this.word = word;
    }
    public Integer call() {
        return Integer.valueOf(word.length());
    }
}

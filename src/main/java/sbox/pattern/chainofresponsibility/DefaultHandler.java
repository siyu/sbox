package sbox.pattern.chainofresponsibility;

/**
 * Created with IntelliJ IDEA.
 * User: siyu798
 * Date: 8/6/13
 * Time: 11:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultHandler implements IHandler<String, String> {

    @Override
    public String handle(String s) {
        return s;
    }
}

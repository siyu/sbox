package sbox.pattern.chainofresponsibility;

/**
 * Created with IntelliJ IDEA.
 * User: siyu798
 * Date: 8/6/13
 * Time: 11:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class StrAppendYHandler implements IHandler<String, String> {

    IHandler<String,String> next;

    public StrAppendYHandler(IHandler<String, String> next) {
        assert next != null;
        this.next = next;
    }

    @Override
    public String handle(String s) {
        String res = next.handle(s);
        if (res != null)
            res = res + "Y";
        return res;
    }
}

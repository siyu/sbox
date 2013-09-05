package sbox.pattern.chainofresponsibility;

/**
 * Created with IntelliJ IDEA.
 * User: siyu798
 * Date: 8/6/13
 * Time: 9:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class StrRevHandler implements IHandler<String, String> {

    IHandler<String,String> next;

    public StrRevHandler(IHandler<String, String> next) {
        assert next != null;
        this.next = next;
    }

    @Override
    public String handle(String s) {
        String res = next.handle(s);
        if (res != null)
            res = new StringBuffer(res).reverse().toString();
        return res;
    }
}

package sbox.pattern.chainofresponsibility;

/**
 * Created with IntelliJ IDEA.
 * User: siyu798
 * Date: 8/6/13
 * Time: 11:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class App {
    public static void main(String[] args) {
        IHandler<String, String> h1 =
                new StrAppendXHandler(
                        new StrAppendYHandler(new StrUpperHandler(new DefaultHandler())));

        System.out.println("h1:" + h1.handle("alan"));

        IHandler<String, String> h2 =
                new StrAppendXHandler(
                        new StrAppendYHandler(
                                new StrUpperHandler(
                                        new StrRevHandler(new DefaultHandler()))));
        System.out.println("h2:" + h2.handle("alan2"));
    }
}

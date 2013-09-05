package sbox.pattern.chainofresponsibility;

/**
 * Created with IntelliJ IDEA.
 * User: siyu798
 * Date: 8/6/13
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IHandler<T,R> {
    public T handle(R r);
}

package sbox.zmq.weather;

/**
 * Created with IntelliJ IDEA.
 * User: siyu798
 * Date: 8/28/13
 * Time: 11:21 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DataListener {
    void onUpdate(String s);
}

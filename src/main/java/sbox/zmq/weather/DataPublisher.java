package sbox.zmq.weather;

/**
 * Created with IntelliJ IDEA.
 * User: siyu798
 * Date: 8/29/13
 * Time: 12:19 AM
 * To change this template use File | Settings | File Templates.
 */
public interface DataPublisher {
    void addListener(DataListener dataListener);
}

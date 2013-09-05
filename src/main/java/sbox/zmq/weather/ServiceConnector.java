package sbox.zmq.weather;

import org.jeromq.ZMQ;

/**
 * Created with IntelliJ IDEA.
 * User: siyu798
 * Date: 8/26/13
 * Time: 9:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class ServiceConnector implements DataPublisher {

    private DataListener dataListener;

    public void start() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                ZMQ.Context ctx = ZMQ.context(1);
                ZMQ.Socket socket = ctx.socket(ZMQ.SUB);
                socket.connect("tcp://*:5555");
                socket.subscribe("");
                while (true) {
                    String currTemperature = socket.recvStr();
                    dataListener.onUpdate(currTemperature);
                }
            }
        });
        t.run();
    }

    @Override
    public void addListener(DataListener dataListener) {
        this.dataListener = dataListener;
    }
}

package sbox.zmq.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: siyu798
 * Date: 8/26/13
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClientConnector implements DataListener {

    private static final Logger LOG = LoggerFactory.getLogger(ClientConnector.class);

    @Override
    public void onUpdate(String s) {
        LOG.info("got update from service {}", s);
    }

    public void start() {

    }
}

package sbox.zmq.weather;

/**
 * Created with IntelliJ IDEA.
 * User: siyu798
 * Date: 8/26/13
 * Time: 9:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bridge {

    private ServiceConnector serviceConnector;
    private ClientConnector clientConnector;

    public Bridge(ServiceConnector serviceConnector, ClientConnector clientConnector) {
        this.serviceConnector = serviceConnector;
        this.clientConnector = clientConnector;
    }

    public void start() {
        serviceConnector.start();
        clientConnector.start();
    }

    public static void main(String[] args) {

        WeatherService ws = new WeatherService();
        ws.start();

        ClientConnector clientConnector = new ClientConnector();
        ServiceConnector serviceConnector = new ServiceConnector();
        serviceConnector.addListener(clientConnector);

        Bridge bridge = new Bridge(serviceConnector, clientConnector);
        bridge.start();


    }
}

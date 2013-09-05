package sbox.zmq.weather;

import org.jeromq.ZMQ;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with IntelliJ IDEA.
 * User: siyu798
 * Date: 8/26/13
 * Time: 9:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class WeatherService {

    private final AtomicLong currentTemperature = new AtomicLong();
    private final Random rand = new Random(System.currentTimeMillis());

    public WeatherService() {
        measureTemperature();
    }

    public void start() {
        Runnable publisher = new Runnable() {
            @Override
            public void run() {
                ZMQ.Context ctx = ZMQ.context(1);
                ZMQ.Socket socket = ctx.socket(ZMQ.PUB);
                socket.bind("tcp://*:5555");

                while (!Thread.currentThread().isInterrupted()) {
                    measureTemperature();
                    System.out.println("server - current temperature = " + currentTemperature);
                    socket.send(currentTemperature.toString());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                socket.close();
                ctx.term();
            }
        };
        new Thread(publisher).start();

        Runnable responder = new Runnable() {
            @Override
            public void run() {
                ZMQ.Context ctx = ZMQ.context(1);
                ZMQ.Socket socket = ctx.socket(ZMQ.ROUTER);
                socket.bind("tcp://*:5556");

                while (!Thread.currentThread().isInterrupted()) {
                    socket.recvStr();
                }
            }
        };
    }

    private void measureTemperature() {
        currentTemperature.set(rand.nextInt(100));
    }

    public static void main(String[] args) {
        WeatherService ws = new WeatherService();
        ws.start();

//        ZMQ.Context ctx = ZMQ.context(1);
//        ZMQ.Socket socket = ctx.socket(ZMQ.SUB);
//        socket.connect("tcp://*:5555");
//        socket.subscribe("");
//
//        while (true) {
//            String currTemperature = socket.recvStr();
//            System.out.println("latest temperature: " + currTemperature);
//        }
        //socket.close();
        //ctx.term();
    }

}

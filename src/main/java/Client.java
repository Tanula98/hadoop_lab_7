import org.zeromq.SocketType;
import org.zeromq.ZMQ;

import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket requester = context.socket(SocketType.REQ);
        requester.connect(Constants.CLIENT_ROUTER_ADDRESS);
    }
}

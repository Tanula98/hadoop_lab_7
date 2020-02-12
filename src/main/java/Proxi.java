import org.zeromq.SocketType;
import org.zeromq.ZMQ;

import java.util.ArrayList;

public class Proxi {

    private static final ArrayList<CacheLine> cacheServers = new ArrayList<>();


    public static void main (String[] args) {

        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket frontend = context.socket(SocketType.ROUTER);
        ZMQ.Socket backend = context.socket(SocketType.ROUTER);
        frontend.bind(Constants.CLIENT_ROUTER_ADDRESS);
        backend.bind(Constants.CACHE_ROUTER_ADDRESS);
    }
}

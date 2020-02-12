import org.zeromq.SocketType;
import org.zeromq.ZFrame;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;

import java.util.ArrayList;

public class Proxi {

    private static final ArrayList<CacheLine> cacheServers = new ArrayList<>();


    public static void main (String[] args) {

        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket frontend = context.socket(SocketType.ROUTER);
        ZMQ.Socket backend = context.socket(SocketType.ROUTER);
        frontend.bind(Constants.CLIENT_ROUTER_ADDRESS);
        backend.bind(Constants.CACHE_ROUTER_ADDRESS);

        System.out.println("proxi started");

        ZMQ.Poller items = context.poller(2);
        items.register(frontend, ZMQ.Poller.POLLIN);
        items.register(backend, ZMQ.Poller.POLLIN);

        while (!Thread.currentThread().isInterrupted()) {
            items.poll(Constants.HEARTBEAT_TIMEOUT);

            if (items.pollin(0)) {
                ZMsg msg = ZMsg.recvMsg(frontend);
                String command = new String(msg.getLast().getData(), ZMQ.CHARSET);
                ParseUtils.CommandType commandType = ParseUtils.getCommandType(command);
                boolean isIdValid;

                if (commandType == ParseUtils.CommandType.GET) {
                    System.out.println("got GET command!");
                    Integer id = ParseUtils.getKey(command);
                    Integer[] pair = ParseUtils.getKeyValue(command);

                    isIdValid = sendGetRequest(backend, id, msg);

                    if (!isIdValid) {
                        msg.getLast().reset("id is out of cached range");
                        msg.send(frontend);
                    }

                }


                if (commandType == ParseUtils.CommandType.PUT) {
                    System.out.println("got PUT command!");
                    isIdValid = sendPutRequest(backend, pair[0], msg);
                    
                }
            }

            if (items.pollin(1)) {

            }
        }

        frontend.close();
        backend.close();
        context.close();
    }


    private static boolean sendGetRequest (ZMQ.Socket backend, Integer id, ZMsg msg) {
        for (int i = 0; i < cacheServers.size(); i++) {
            CacheLine cacheServer = cacheServers.get(i);

            if (cacheServer.isDead()) {

                cacheServers.remove(i);
                continue;
            }

            if (id >= cacheServer.getMinKey() && id <= cacheServer.getMaxKey()) {

                cacheServer.getAddress().send(backend, ZFrame.REUSE + ZFrame.MORE);
                msg.send(backend, false);
                return true;
            }

        }
        return false;
    }


    private static boolean sendPutRequest (ZMQ.Socket backend, Integer id, ZMsg msg) {

        for (int i = 0; i < cacheServers.size(); i++) {
            CacheLine cacheServer = cacheServers.get(i);
            if (cacheServer.isDead()) {

                cacheServers.remove(i);
                continue;
            }

            if (id >= cacheServer.getMinKey() && id <= cacheServer.getMaxKey()) {
                cacheServer.getAddress().send(backend, ZFrame.REUSE + ZFrame.MORE);
                msg.send(backend, false);
                return true;
            }
        }
        return false;
    }

}

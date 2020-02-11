import org.zeromq.SocketType;
import org.zeromq.ZMQ;

import java.util.HashMap;

public class Cache {

    public static void main(String[] args) {
        if (args.length != 2 || ParseUtils.getCommandType(args[0] + " " + args[1]) != ParseUtils.CommandType.RUN_CACHE) {
            System.out.println("incorrect command-line arguments");
            System.exit(-1);
        }

        HashMap<Integer, Integer> cache = new HashMap<>();

        Integer minKey = Integer.parseInt(args[0]);
        Integer maxKey = Integer.parseInt(args[1]);

        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket dealer = context.socket(SocketType.DEALER);
        dealer.connect(Constants.CACHE_ROUTER_ADDRESS);


    }

    private static void sendConnectRequest (ZMQ.Socket socket, Integer minKey, Integer maxKey) {
        
    }
}

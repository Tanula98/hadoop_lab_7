import org.zeromq.SocketType;
import org.zeromq.ZMQ;

public class Client {
    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket requester = context.socket(SocketType.REQ);
        
    }
}

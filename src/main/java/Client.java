import org.zeromq.SocketType;
import org.zeromq.ZMQ;

import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket requester = context.socket(SocketType.REQ);
        requester.connect(Constants.CLIENT_ROUTER_ADDRESS);

        Scanner sc = new java.util.Scanner(System.in);

        while (!Thread.currentThread().isInterrupted()) {

        }

        requester.close();
        context.close();
    }

    private static void ExecuteCommand(ZMQ.Socket requester, String commandLine) {
        if (ParseUtils.getCommandType(commandLine) == ParseUtils.getCommandType(GET)){

        }
    }
}

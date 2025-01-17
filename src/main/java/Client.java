import org.zeromq.SocketType;
import org.zeromq.ZMQ;

import java.util.Scanner;
public class Client {
    public static void main(String[] args) {

        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket requester = context.socket(SocketType.REQ);
        requester.connect(Constants.CLIENT_ROUTER_ADDRESS);

        System.out.println("client started");

        Scanner sc = new java.util.Scanner(System.in);

        while (!Thread.currentThread().isInterrupted()) {
            ExecuteCommand(requester, sc.nextLine());
        }

        requester.close();
        context.close();
    }
//Подключается к центральному прокси. Читает команды из консоли и отправляет их в прокси.

    private static void ExecuteCommand(ZMQ.Socket requester, String commandLine) {
        if (ParseUtils.getCommandType(commandLine) == ParseUtils.CommandType.GET ||
                ParseUtils.getCommandType(commandLine) == ParseUtils.CommandType.PUT)
        {
            System.out.println("valid command!");
            requester.send(commandLine);
            //получить сообщение в виде строки
            String response = requester.recvStr();
            System.out.println(response);
        }else {
            System.out.println("invalid command");
        }
    }
}

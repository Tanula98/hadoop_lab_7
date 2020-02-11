import java.util.HashMap;

public class Cache {

    public static void main(String[] args) {
        if (args.length != 2 || ParseUtils.getCommandType(args[0] + " " + args[1]) != ParseUtils.CommandType.RUN_CACHE) {
            System.out.println("incorrect command-line arguments");
            System.exit(-1);
        }

        HashMap<Integer, Integer> cache = new HashMap<>();

        
    }
}

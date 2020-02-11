public class Constants {
    static final String CLIENT_ROUTER_ADDRESS = "tcp://localhost:8080";
    static final String CACHE_ROUTER_ADDRESS = "tcp://localhost:8081";
    static final int HEARTBEAT_TIMEOUT = 1500;


    ///utiles
    public static final Pattern GET_COMMAND_PATTERN = Pattern.compile("^GET \\d+$", Pattern.CASE_INSENSITIVE);
    public static final Pattern PUT_COMMAND_PATTERN = Pattern.compile("^PUT \\d+ \\d+$", Pattern.CASE_INSENSITIVE);
    public static final Pattern RETURN_VALUE_COMMAND_PATTERN = Pattern.compile("^RETURN_VALUE (\\d+|null)$", Pattern.CASE_INSENSITIVE);
    public static final Pattern CONNECT_COMMAND_PATTERN = Pattern.compile("^CONNECT \\d+ \\d+$", Pattern.CASE_INSENSITIVE);
    public static final Pattern NOTIFY_COMMAND_PATTERN = Pattern.compile("^NOTIFY$", Pattern.CASE_INSENSITIVE);
    public static final Pattern OK_COMMAND_PATTERN = Pattern.compile("^OK$", Pattern.CASE_INSENSITIVE);
    public static final Pattern RUN_CACHE_PATTERN = Pattern.compile("^\\d+ \\d+$");
    public static final String DELIMITER = " ";
}

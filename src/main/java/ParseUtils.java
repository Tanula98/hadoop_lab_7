public class ParseUtils {

    public enum CommandType {
        GET,
        PUT,
        RUN_CACHE,
        RETURN_VALUE,
        CONNECT,
        NOTIFY,
        INVALID,
        OK
    }

    public static CommandType getCommandType(String command){
        if (Constants.GET_COMMAND_PATTERN.matcher(command).find()) {
            return CommandType.GET;
        }
    }
}

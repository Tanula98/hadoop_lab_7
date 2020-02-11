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
        if (Constants.PUT_COMMAND_PATTERN.matcher(command).find()) {
            return CommandType.PUT;
        }
        if (Constants.RUN_CACHE_PATTERN.matcher(command).find()) {
            return CommandType.RUN_CACHE;
        }
        if (Constants.RETURN_VALUE_COMMAND_PATTERN.matcher(command).find()) {
            return CommandType.RETURN_VALUE;
        }
        
        return CommandType.INVALID;
    }
}

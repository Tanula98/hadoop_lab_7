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
        if (Constants.CONNECT_COMMAND_PATTERN.matcher(command).find()) {
            return CommandType.CONNECT;
        }
        if (Constants.NOTIFY_COMMAND_PATTERN.matcher(command).find()) {
            return CommandType.NOTIFY;
        }
        if (Constants.OK_COMMAND_PATTERN.matcher(command).find()) {
            return CommandType.OK;
        }
        return CommandType.INVALID;
    }

    public static String buildConnectRequest (Integer minKey, Integer maxKey) {
        return "CONNECT " + minKey + " " + maxKey;
    }

    public static String buildNotifyRequest () {
        return "NOTIFY";
    }

    public static String buildOkResponse () {
        return "OK";
    }


    public static Integer[] getKeyValue(String putCommand) {
        String[] words = putCommand.split(Constants.DELIMITER);
        return new Integer[] {Integer.parseInt(words[1]), Integer.parseInt(words[2])};
    }
    
}

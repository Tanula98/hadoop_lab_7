import org.zeromq.ZFrame;

class CacheLine {

    private String id;
    private ZFrame address;
    private int minKey;
    private int maxKey;
    private long hertbeatTime;

    CacheLine(String id, ZFrame address, int minKey, int maxKey, long hertbeatTime) {
        this.id = id;
        this.address = address;
        this.maxKey = maxKey;
        this.minKey = minKey;
        this.hertbeatTime = hertbeatTime;
    }

    String getId() {
        return id;
    }

    ZFrame getAddress() {
        return address;
    }

    int getMinKey() {
        return minKey;
    }

    int getMaxKey() {
        return maxKey;
    }

    void setHertbeatTime(long hertbeatTime) {
        this.hertbeatTime = hertbeatTime;
    }

    boolean isDead() {
        return System.currentTimeMillis() > hertbeatTime + 2 * Constants.HEARTBEAT_TIMEOUT;
    }
}

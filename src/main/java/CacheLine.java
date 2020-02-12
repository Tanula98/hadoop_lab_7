import org.zeromq.ZFrame;

public class CacheLine {

    private String id;
    private ZFrame address;
    private int minKey;
    private int maxKey;
    private long hertbeatTime;

    public CacheLine(String id, ZFrame address, int minKey, int maxKey, long hertbeatTime) {
        this.id = id;
        this.address = address;
        this.maxKey = maxKey;
        this.minKey = minKey;
        this.hertbeatTime = hertbeatTime;
    }

    
}

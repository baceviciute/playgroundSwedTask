import java.util.List;
import java.util.Queue;

public class PlaySite {

    private PlaySiteType type;
    private Integer maxAmountOfKids;
    private List<Kid> kids;
    private Queue<Kid> queue;
    private Integer capacity;
    private String utilization;

    public PlaySite() {
    }

    public PlaySite(PlaySiteType type, Integer maxAmountOfKids) {
        this.type = type;
        this.maxAmountOfKids = maxAmountOfKids;
    }

    public PlaySiteType getType() {
        return type;
    }

    public void setType(PlaySiteType type) {
        this.type = type;
    }

    public Integer getMaxAmountOfKids() {
        return maxAmountOfKids;
    }

    public void setMaxAmountOfKids(Integer maxAmountOfKids) {
        this.maxAmountOfKids = maxAmountOfKids;
    }

    public List<Kid> getKids() {
        return kids;
    }

    public void setKids(List<Kid> kids) {
        this.kids = kids;
    }

    public Queue<Kid> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Kid> queue) {
        this.queue = queue;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getUtilization() {
        return utilization;
    }

    public void setUtilization(String utilization) {
        this.utilization = utilization;
    }

    @Override
    public String toString() {
        return "PlaySite{" +
                "type=" + type +
                ", maxAmountOfKids=" + maxAmountOfKids +
                ", kids=" + kids +
                ", queue=" + queue +
                ", capacity=" + capacity +
                ", utilization='" + utilization + '\'' +
                '}';
    }
}

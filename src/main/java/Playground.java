import java.util.List;

public class Playground {

    private List<PlaySite> playSites;
    private String utilization;
    private Integer totalKids;
    private Long workStart;
    private Long workEnd;

    public Playground() {
    }

    public List<PlaySite> getPlaySites() {
        return playSites;
    }

    public void setPlaySites(List<PlaySite> playSites) {
        this.playSites = playSites;
    }

    public String getUtilization() {
        return utilization;
    }

    public void setUtilization(String utilization) {
        this.utilization = utilization;
    }

    public Integer getTotalKids() {
        return totalKids;
    }

    public void setTotalKids(Integer totalKids) {
        this.totalKids = totalKids;
    }

    public Long getWorkStart() {
        return workStart;
    }

    public void setWorkStart(Long workStart) {
        this.workStart = workStart;
    }

    public Long getWorkEnd() {
        return workEnd;
    }

    public void setWorkEnd(Long workEnd) {
        this.workEnd = workEnd;
    }

    @Override
    public String toString() {
        return "Playground{" +
                "playSites=" + playSites +
                ", utilization='" + utilization + '\'' +
                ", totalKids=" + totalKids +
                ", workStart=" + workStart +
                ", workEnd=" + workEnd +
                '}';
    }
}

import java.util.ArrayList;
import java.util.List;

public class Kid {

    private String name;
    private Integer age;
    private String ticketNumber;
    private boolean vip;
    private Long timeEntered;
    private Long timeRemoved;
    private Long timeSpent;
    private List<PlaySite> playSitesBeenPlayedOn;

    public Kid() {
    }

    public Kid(String name, Integer age, String ticketNumber, boolean vip) {
        this.name = name;
        this.age = age;
        this.ticketNumber = ticketNumber;
        this.vip = vip;
        this.playSitesBeenPlayedOn = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public Long getTimeEntered() {
        return timeEntered;
    }

    public void setTimeEntered(Long timeEntered) {
        this.timeEntered = timeEntered;
    }

    public Long getTimeRemoved() {
        return timeRemoved;
    }

    public void setTimeRemoved(Long timeRemoved) {
        this.timeRemoved = timeRemoved;
    }

    public Long getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Long timeSpent) {
        this.timeSpent = timeSpent;
    }

    public List<PlaySite> getPlaySitesBeenPlayedOn() {
        return playSitesBeenPlayedOn;
    }

    public void setPlaySitesBeenPlayedOn(List<PlaySite> playSitesBeenPlayedOn) {
        this.playSitesBeenPlayedOn = playSitesBeenPlayedOn;
    }

    public void addPlaySitesBeenPlayedOn(PlaySite playSitesBeenPlayedOn) {
        this.playSitesBeenPlayedOn.add(playSitesBeenPlayedOn);
    }

    @Override
    public String toString() {
        return "Kid{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ticketNumber='" + ticketNumber + '\'' +
                ", vip=" + vip +
                ", timeEntered=" + timeEntered +
                ", timeRemoved=" + timeRemoved +
                ", timeSpent=" + timeSpent +
                '}';
    }
}

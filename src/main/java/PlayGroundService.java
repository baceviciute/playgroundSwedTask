import java.util.List;

public interface PlayGroundService {

    Integer totalKidsPerWorkingHours(List<PlaySite> playSites);

    void countUtilization(Playground playground);

    String getUtilizationAtTime (Playground playground);
}

import java.util.List;

public interface PlaySiteService {

    void addKidToPlaySite(Kid kid,PlaySite playSite);

    List<Kid> removeKidFromPlaySite(Kid kid, PlaySite playSite);

    void removeKidFromQueue(Kid kid, PlaySite playSite);

    Long calculateTimeOnPlaySite(Kid kid, PlaySite playSite);

    void calculateUtilization(PlaySite playSite);

}

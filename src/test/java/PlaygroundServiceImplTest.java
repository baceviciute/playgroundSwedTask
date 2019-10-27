import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlaygroundServiceImplTest {

    private PlayGroundService service = new PlayGroundServiceImpl();

    private Playground playground = new Playground();

    private PlaySite playSite1;
    private PlaySite playSite2;

    private List<PlaySite> playSites;
    private List<Kid> kids;

    private Kid Jonas = new Kid("Jonas", 8, "Nr12", false);
    private Kid Petras = new Kid("Petras", 9, "Nr32", true);
    private Kid Jolanta = new Kid("Jolanta", 7, "Nr54", false);
    private Kid Ona = new Kid("Ona", 9, "Nr83", true);

    @Before
    public void init() {
        playSite1 = new PlaySite(PlaySiteType.CAROUSEL, 4);
        playSite2 = new PlaySite(PlaySiteType.SLIDE, 8);
        kids = new ArrayList<>(Arrays.asList(Jonas, Petras, Jolanta, Ona));
        playSite1.setKids(kids);
        playSite2.setKids(kids);
        playSites = new ArrayList<>(Arrays.asList(playSite1, playSite2));
        playground.setPlaySites(playSites);
    }

    @Test
    public void totalKidsPerWorkingHoursTest() {
        int totalKids = service.totalKidsPerWorkingHours(playSites);
        assertEquals(8, totalKids);
    }
}

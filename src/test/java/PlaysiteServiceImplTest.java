import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlaysiteServiceImplTest {

    private PlaySiteService service = new PlaysiteServiceImpl();

    private PlaySite playSite;

    private List<Kid> kids;

    private Kid Jonas = new Kid("Jonas", 8, "Nr12", false);
    private Kid Petras = new Kid("Petras", 9, "Nr32", true);
    private Kid Jolanta = new Kid("Jolanta", 7, "Nr54", false);
    private Kid Ona = new Kid("Ona", 9, "Nr83", true);
    private Kid Tadas = new Kid("Tadas", 8, "Nr99", false);
    private Kid Julija = new Kid("Julija", 7, "Nr45", false);

    @Before
    public void init() {
        playSite = new PlaySite(PlaySiteType.DOUBLE_SWINGS, 4);
        kids = new ArrayList<>(Arrays.asList(Jonas, Petras));
        playSite.setKids(kids);
    }

    @Test
    public void addKidToPlaySiteTest() {
        service.addKidToPlaySite(Jolanta, playSite);
        assertEquals(3, kids.size());
    }

    @Test
    public void addKidToPlaySiteWherePlaysiteIsFullTest() {
        List<Kid> kids = setBiggerList();
        playSite.setKids(kids);
        service.addKidToPlaySite(Jolanta, playSite);
        assertEquals(4, playSite.getKids().size());
        assertEquals(1, playSite.getQueue().size());
        assertEquals("Jolanta", playSite.getQueue().element().getName());
    }

    @Test
    public void removeKidFromPlaySiteTest() {
        service.removeKidFromPlaySite(Jonas, playSite);
        assertEquals(1, playSite.getKids().size());
        assertEquals("Petras", playSite.getKids().get(0).getName());
    }

    @Test
    public void removeKidFromPlaysiteWhenAQueueExists() {
        List<Kid> kids = setBiggerList();
        playSite.setKids(kids);
        service.addKidToPlaySite(Jolanta, playSite);
        service.addKidToPlaySite(Julija, playSite);
        service.removeKidFromPlaySite(Jonas, playSite);
        assertEquals(4, playSite.getKids().size());
        assertEquals("Julija", playSite.getQueue().element().getName());
        assertEquals("Jolanta", playSite.getKids().get(kids.size() - 1).getName());
    }

    @Test
    public void removeKidFromQueueTest() {
        List<Kid> kids = setBiggerList();
        playSite.setKids(kids);
        service.addKidToPlaySite(Jolanta, playSite);
        service.addKidToPlaySite(Julija, playSite);
        assertEquals(4, playSite.getKids().size());
        assertEquals(2, playSite.getQueue().size());
        service.removeKidFromQueue(Julija, playSite);
        assertEquals("Jolanta", playSite.getQueue().element().getName());
    }

    @Test
    public void claculateUtilizationTest() {
        service.calculateUtilization(playSite);
        assertEquals("50%", playSite.getUtilization());
    }

    private List<Kid> setBiggerList() {
        List<Kid> kidsList = new ArrayList<>();
        kidsList.add(Jonas);
        kidsList.add(Petras);
        kidsList.add(Ona);
        kidsList.add(Tadas);
        return kidsList;
    }

}

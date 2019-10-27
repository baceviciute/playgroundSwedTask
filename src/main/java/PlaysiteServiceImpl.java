
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PlaysiteServiceImpl implements PlaySiteService {

    @Override
    public void addKidToPlaySite(Kid kid, PlaySite playSite) {
        if (playSite.getKids() == null) {
            addKidToPlaySite(new ArrayList<>(), kid, playSite);
        } else {
            if (playSite.getKids().size() < playSite.getMaxAmountOfKids()) {
                addKidToPlaySite(playSite.getKids(), kid, playSite);
            } else if (playSite.getKids().size() == playSite.getMaxAmountOfKids()) {
                if (playSite.getQueue() == null) {
                    addKidToQueue(new LinkedList<>(), kid, playSite);
                } else {
                    addKidToQueue(playSite.getQueue(), kid, playSite);
                }
            }
        }
    }

    @Override
    public List<Kid> removeKidFromPlaySite(Kid kidToRemove, PlaySite playSite) {
        List<Kid> kids = playSite.getKids();
        kids.removeIf(kid -> kid.getTicketNumber().equals(kidToRemove.getTicketNumber()));
        playSite.setKids(kids);
        kidToRemove.setTimeRemoved(System.currentTimeMillis());

        if (playSite.getQueue() != null) {
            addKidToPlaySite(playSite.getQueue().remove(), playSite);
        }
        return kids;
    }

    @Override
    public void removeKidFromQueue(Kid kidToRemove, PlaySite playSite) {
        Queue<Kid> queue = playSite.getQueue();
        queue.removeIf(kid -> kid.getTicketNumber().equals(kidToRemove.getTicketNumber()));
        playSite.setQueue(queue);
    }

    @Override
    public Long calculateTimeOnPlaySite(Kid kid, PlaySite playSite) {
        Long time = kid.getTimeRemoved() - kid.getTimeEntered();
        //time in minutes
        return time / (60 * 1000);
    }

    @Override
    public void calculateUtilization(PlaySite playSite) {
        BigDecimal allowedKidsOnSite = new BigDecimal(playSite.getMaxAmountOfKids());
        BigDecimal kidOnSite = new BigDecimal(playSite.getKids().size());
        BigDecimal result = kidOnSite.divide(allowedKidsOnSite).multiply(new BigDecimal(100));
        playSite.setUtilization(result.stripTrailingZeros().toPlainString() + "%");
    }

    private void addKidToPlaySite(List<Kid> kids, Kid kid, PlaySite playSite) {
        kids.add(kid);
        kid.setTimeEntered(System.currentTimeMillis());
        kid.addPlaySitesBeenPlayedOn(playSite);
        playSite.setKids(kids);
    }

    private void addKidToQueue(Queue<Kid> queue, Kid kid, PlaySite playSite) {
        queue.add(kid);
        playSite.setQueue(queue);
    }

}

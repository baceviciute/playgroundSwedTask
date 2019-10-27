import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PlayGroundServiceImpl implements PlayGroundService {

    @Override
    public Integer totalKidsPerWorkingHours(List<PlaySite> playSites) {
        return countAllKidsOnPlaySites(playSites);
    }

    @Override
    public void countUtilization(Playground playground) {
        BigDecimal kidsOnSite = new BigDecimal(countAllKidsOnPlaySites(playground.getPlaySites()));
        BigDecimal allowedKids = new BigDecimal(countAllAllowedKidsOnPlaySites(playground.getPlaySites()));
        BigDecimal result = kidsOnSite.divide(allowedKids, 2, RoundingMode.DOWN).multiply(new BigDecimal(100));
        playground.setUtilization(result.stripTrailingZeros().toPlainString() + "%");
    }

    @Override
    public String getUtilizationAtTime(Playground playground) {
        String utilization = playground.getUtilization();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String currentTime = formatter.format(date);

        return currentTime + "utilization is " + utilization;
    }


    private Integer countAllKidsOnPlaySites(List<PlaySite> playSites) {
        Integer kidsTotal = 0;

        for (PlaySite playSite : playSites) {
            kidsTotal += playSite.getKids().size();
        }
        return kidsTotal;
    }

    private Integer countAllAllowedKidsOnPlaySites(List<PlaySite> playSites) {
        Integer totalKidsAllowed = 0;

        for (PlaySite playSite : playSites) {
            totalKidsAllowed += playSite.getMaxAmountOfKids();
        }
        return totalKidsAllowed;
    }
}
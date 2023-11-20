import com.test.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteSponsorHandler {

    @Autowired
    private SponsorService sponsorService;

    public void handleRequest(String sponsorId) {
        sponsorService.deleteSponsorById(sponsorId);
    }
}
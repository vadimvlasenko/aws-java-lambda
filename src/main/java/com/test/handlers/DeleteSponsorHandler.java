package com.test.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.test.service.SponsorService;
import com.test.model.SponsorModel;

public class DeleteSponsorHandler implements RequestHandler<SponsorModel, String> {
    private SponsorService sponsorService = new SponsorService();

    @Override
    public String handleRequest(SponsorModel input, Context context) {
        sponsorService.deleteSponsor(input);
        return "Sponsor deleted successfully!";
    }
}
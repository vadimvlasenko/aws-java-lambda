package com.test.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.test.model.SponsorModel;
import com.test.service.SponsorService;
import com.test.utils.HandlerUtils;

public class DeleteSponsorHandler implements RequestHandler<SponsorModel, String> {

    private final SponsorService sponsorService = new SponsorService();

    @Override
    public String handleRequest(SponsorModel input, Context context) {
        try {
            sponsorService.deleteSponsorById(input.getId());
            return HandlerUtils.createSuccessResponse();
        } catch (Exception e) {
            return HandlerUtils.createErrorResponse(e);
        }
    }
}
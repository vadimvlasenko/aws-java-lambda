package com.test.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.test.model.SponsorModel;
import com.test.service.SponsorService;
import com.test.utils.HandlerUtils;

public class DeleteSponsorByIdHandler implements RequestHandler<SponsorModel, String> {

    private SponsorService sponsorService = new SponsorService();

    @Override
    public String handleRequest(SponsorModel input, Context context) {
        try {
            sponsorService.deleteSponsorById(input.getId());
            return HandlerUtils.generateSuccessResponse();
        } catch (SponsorNotFoundException e) {
            return HandlerUtils.generateErrorResponse(ErrorCodes.SPONSOR_NOT_FOUND);
        }
    }
}
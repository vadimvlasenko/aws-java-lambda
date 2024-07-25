package com.test.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.test.config.CoreComponent;
import com.test.config.DaggerCoreComponent;
import com.test.service.SponsorService;
import com.test.utils.HandlerUtils;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;

@Slf4j
public class DeleteSponsorHandler extends ApiHandler {
    @Inject
    SponsorService sponsorService;
    protected final CoreComponent coreComponent;

    public DeleteSponsorHandler() {
        coreComponent = DaggerCoreComponent.builder().build();
        coreComponent.inject(this);
    }

    @Override
    public APIGatewayProxyResponseEvent handle(APIGatewayProxyRequestEvent input, Context context) {
        try {
            String sponsorId = input.getPathParameters().get("id");
            if (sponsorId == null || sponsorId.trim().isEmpty()) {
                return HandlerUtils.buildBadRequestError("Sponsor ID is required");
            }

            sponsorService.deleteSponsorById(sponsorId);

            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(204);
        } catch (Exception e) {
            log.error("Error deleting sponsor: {}", e.getMessage(), e);
            return HandlerUtils.buildServerError("Error deleting sponsor");
        }
    }
}
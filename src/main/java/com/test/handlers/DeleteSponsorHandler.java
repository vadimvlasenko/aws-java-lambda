package com.test.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.test.config.CoreComponent;
import com.test.config.DaggerCoreComponent;
import com.test.service.SponsorService;
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
        String id = input.getPathParameters().get("id");
        sponsorService.deleteSponsorById(id);
        return new APIGatewayProxyResponseEvent()
                .withStatusCode(204);
    }
}
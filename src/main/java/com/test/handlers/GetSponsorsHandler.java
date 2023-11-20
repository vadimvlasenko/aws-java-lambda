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
public class GetSponsorsHandler extends ApiHandler {

    @Inject
    SponsorService sponsorService;
    protected final CoreComponent coreComponent;

    public GetSponsorsHandler() {
        coreComponent = DaggerCoreComponent.builder().build();
        coreComponent.inject(this);
    }

    @Override
    public APIGatewayProxyResponseEvent handle(APIGatewayProxyRequestEvent input, Context context) {
        return new APIGatewayProxyResponseEvent()
                .withBody(jsonService.toJson(sponsorService.getSponsors()))
                .withStatusCode(200);
    }

public void configureRoutes() {
    router.delete("/sponsors/{id}", DeleteSponsorHandler.class, "handle");
}

}

package com.test.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.test.config.CoreComponent;
import com.test.config.DaggerCoreComponent;
import com.test.service.SponsorService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.stream.Collectors;
import java.util.List;

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

    // Update the getSponsors method to exclude deleted sponsors
    public List<SponsorModel> getSponsors() {
        return sponsorService.getSponsors().stream()
            .filter(sponsor -> !sponsor.isDeleted())
            .collect(Collectors.toList());
    }
}

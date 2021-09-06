package com.test.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.test.config.CoreComponent;
import com.test.config.DaggerCoreComponent;
import com.test.errors.ErrorCodes;
import com.test.model.PayloadError;
import com.test.service.SponsorService;
import com.test.utils.HandlerUtils;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.Map;

@Slf4j
public class FindSponsorHandler extends ApiHandler {

    @Inject
    SponsorService sponsorService;
    protected final CoreComponent coreComponent;

    public FindSponsorHandler() {
        coreComponent = DaggerCoreComponent.builder().build();
        coreComponent.inject(this);
    }

    @Override
    public APIGatewayProxyResponseEvent handle(APIGatewayProxyRequestEvent input, Context context) {
        Map<String, String> pathParameters = input.getPathParameters();
        if (!pathParameters.containsKey("id")) {
            PayloadError error = new PayloadError(ErrorCodes.VALIDATION_ERROR.getValue(), "'id' is required path parameter");
            return HandlerUtils.buildBadRequestError(jsonService.toJson(error));
        }
        String id = pathParameters.getOrDefault("id", "test");
        return new APIGatewayProxyResponseEvent()
                .withBody(jsonService.toJson(sponsorService.getSponsorById(id)))
                .withStatusCode(200);
    }

}

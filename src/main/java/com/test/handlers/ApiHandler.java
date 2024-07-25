package com.test.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.test.errors.ErrorCodes;
import com.test.errors.SponsorNotFoundException;
import com.test.model.PayloadError;
import com.test.service.JsonService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;

import static com.test.utils.HandlerUtils.buildNotFoundError;
import static com.test.utils.HandlerUtils.buildServerError;

@Slf4j
public abstract class ApiHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Inject
    JsonService jsonService;

    public abstract APIGatewayProxyResponseEvent handle(APIGatewayProxyRequestEvent input, Context context);

    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        try {
            return handle(input, context);
        } catch(SponsorNotFoundException ex) {
            log.error("Error during handling request: {}", ex.getMessage());
            PayloadError error = new PayloadError(ErrorCodes.SPONSOR_NOT_FOUND.getValue(), "Cannot find sponsor with provided ID");
            return buildNotFoundError(jsonService.toJson(error));
        } catch (Exception ex) {
            log.error("Error during handling request: {}", ex.getMessage());
            ex.printStackTrace();
            PayloadError error = new PayloadError(ErrorCodes.SERVER_ERROR.getValue(), ex.getMessage());
            return buildServerError(jsonService.toJson(error));
        }
    }

    @Override
    public APIGatewayProxyResponseEvent handle(APIGatewayProxyRequestEvent input, Context context) {
        // Implementation goes here
        return new APIGatewayProxyResponseEvent()
                .withStatusCode(200)
                .withBody("{\"message\":\"Sponsor request processed successfully\"}");
    }

}
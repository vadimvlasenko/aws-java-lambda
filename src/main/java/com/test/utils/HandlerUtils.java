package com.test.utils;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class HandlerUtils {
    public static APIGatewayProxyResponseEvent buildBadRequestError(String body) {
        return new APIGatewayProxyResponseEvent()
            .withBody(body)
            .withStatusCode(400);
    }

    public static APIGatewayProxyResponseEvent buildNotFoundError(String body) {
        return new APIGatewayProxyResponseEvent()
                .withBody(body)
                .withStatusCode(404);
    }

    public static APIGatewayProxyResponseEvent buildServerError(String body) {
        return new APIGatewayProxyResponseEvent()
                .withBody(body)
                .withStatusCode(500);
    }
}

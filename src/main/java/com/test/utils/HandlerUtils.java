package com.test.utils;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

/**
* HandlerUtils class contains helper methods for AWS Lambda handlers.
* API Endpoints:
* 1. /sponsors - This endpoint returns a list of sponsors.
* 2. /sponsors/{id} - This endpoint returns details of a specific sponsor identified by {id}.
*/
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

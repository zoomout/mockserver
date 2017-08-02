package com.bogdan.test.utils;

import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import static com.bogdan.test.configuration.Configuration.PORT;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;

public class MockServer {

    private MockServer() {
    }

    private static ClientAndServer mockServer;

    public static void start() {
        if (mockServer == null) {
            mockServer = startClientAndServer(PORT);
        }
    }

    public static void stop() {
        mockServer.stop();
    }

    public static void reset() {
        mockServer.reset();
    }

    public static void confMock(final HttpRequest httpRequest, final HttpResponse httpResponse) {
        mockServer.when(httpRequest).respond(httpResponse);
    }
}

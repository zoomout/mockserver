package com.bogdan.test.utils;

import com.bogdan.test.configuration.Configuration;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import static com.bogdan.test.configuration.Configuration.getConfiguration;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;

public class MockServer {

    private MockServer() {
    }

    private static MockServerClient mock;

    public static void start() {
        final Configuration configuration = getConfiguration();
        if (configuration.isStandaloneMock()) {
            mock = new MockServerClient(configuration.getMockHost(), configuration.getStandaloneMockPort());
        } else {
            mock = startClientAndServer(configuration.getMockPort());
        }
    }

    public static void stop() {
        if (!getConfiguration().isStandaloneMock()) {
            mock.stop();
        }
    }

    public static void reset() {
        mock.reset();
    }

    public static void confMock(final HttpRequest httpRequest, final HttpResponse httpResponse) {
        mock.when(httpRequest).respond(httpResponse);
    }
}

package com.bogdan.test.configuration;

public class Configuration {

    private static Configuration configuration;

    // To run standalone server: docker run -d -p 1080:1080 jamesdbloom/mockserver
    private static final boolean IS_STANDALONE_MOCK = true;

    private static final int MOCK_PORT_IN_MEMORY = 1081;
    private static final int MOCK_PORT_STANDALONE = 1080;
    private static final String MOCK_HOST = "localhost";
    private static final String MOCK_URL_BASE = "http://" + MOCK_HOST + ":";

    public static Configuration getConfiguration() {
        if (configuration == null) {
            configuration = new Configuration();
        }
        return configuration;
    }

    public String getMockHost() {
        return MOCK_HOST;
    }

    public int getStandaloneMockPort() {
        return MOCK_PORT_STANDALONE;
    }

    public Integer getMockPort() {
        return MOCK_PORT_IN_MEMORY;
    }

    public boolean isStandaloneMock() {
        return IS_STANDALONE_MOCK;
    }

    public String getBaseUrl() {
        if (IS_STANDALONE_MOCK) {
            return MOCK_URL_BASE + MOCK_PORT_STANDALONE;
        } else {
            return MOCK_URL_BASE + MOCK_PORT_IN_MEMORY;
        }
    }
}

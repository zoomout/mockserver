package com.bogdan.test.testdata;

import org.mockserver.model.HttpRequest;

import static org.mockserver.model.HttpRequest.request;

public class TestData {
    public static final String BODY = "{\"foo\":\"bar\"}";

    public static final HttpRequest DEFAULT_REQUEST = request().withMethod("GET").withPath("/path");
}

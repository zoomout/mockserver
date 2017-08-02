package com.bogdan.test.tests;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static com.bogdan.test.testdata.TestData.BODY;
import static com.bogdan.test.utils.MockServer.confMock;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class MockServerTest extends BaseTest {

    @Test
    public void mockServerPositiveTest() {

        confMock(
                request()
                        .withMethod("GET")
                        .withPath("/path"),
                response()
                        .withStatusCode(HttpStatus.SC_OK)
                        .withBody(BODY)
        );

        when()
                .get("/path")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(is(BODY));
    }

    @Test
    public void mockServerNegativeTest() {

        confMock(
                request()
                        .withMethod("GET")
                        .withPath("/path"),
                response()
                        .withStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
        );

        when()
                .get("/path")
                .then()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

}

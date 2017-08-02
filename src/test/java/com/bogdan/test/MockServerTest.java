package com.bogdan.test;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static com.bogdan.test.MockServer.confMock;
import static com.bogdan.test.TestData.BODY;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class MockServerTest extends BaseTest {

    @Test
    public void mockServerTest() {


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

}

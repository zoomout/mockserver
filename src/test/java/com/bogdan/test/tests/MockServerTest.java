package com.bogdan.test.tests;

import org.apache.http.HttpStatus;
import org.mockserver.model.HttpRequest;
import org.testng.annotations.Test;

import static com.bogdan.test.testdata.TestData.BODY;
import static com.bogdan.test.testdata.TestData.DEFAULT_REQUEST;
import static com.bogdan.test.utils.MockServer.confMock;
import static com.bogdan.test.utils.MockServer.getRecordedRequest;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockserver.model.HttpResponse.response;

public class MockServerTest extends BaseTest {

    @Test
    public void mockServerPositiveTest() {


        confMock(
                DEFAULT_REQUEST,
                response()
                        .withStatusCode(HttpStatus.SC_OK)
                        .withBody(BODY)
        );

        when()
                .get("/path")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(is(BODY));

        HttpRequest recordedRequest = getRecordedRequest(DEFAULT_REQUEST);

        assertThat(DEFAULT_REQUEST.getBody(), is(recordedRequest.getBody()));
        assertThat(DEFAULT_REQUEST.getPath(), is(recordedRequest.getPath()));

        assertThat(DEFAULT_REQUEST.getHeaders().size(), is(0));
        assertThat(recordedRequest.getHeaders().size(), is(5));

    }

    @Test
    public void mockServerNegativeTest() {

        confMock(
                DEFAULT_REQUEST,
                response()
                        .withStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
        );

        when()
                .get("/path")
                .then()
                .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

}

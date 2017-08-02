package com.bogdan.test;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.bogdan.test.Configuration.BASE_URL;

public class BaseTest {

    @BeforeSuite
    public void configureRestAssured() {
        RestAssured.baseURI = BASE_URL;
    }

    @BeforeSuite
    public void startMock() {
        MockServer.start();
    }

    @BeforeMethod
    public void resetMock() {
        MockServer.reset();
    }

    @AfterSuite
    public void stopMock() {
        MockServer.stop();
    }
}

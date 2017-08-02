package com.bogdan.test.tests;

import com.bogdan.test.utils.MockServer;
import com.jayway.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.bogdan.test.configuration.Configuration.getConfiguration;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        MockServer.start();
        RestAssured.baseURI = getConfiguration().getBaseUrl();
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

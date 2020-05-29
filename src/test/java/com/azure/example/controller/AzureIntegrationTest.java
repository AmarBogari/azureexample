package com.azure.example.controller;

import com.azure.example.controller.AzureWebController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(properties = {"CONNECTIONSTRING=Endpoint=https://azurespringconfig.azconfig.io\\;Id=XKvw-lh-s0:SVsLG6ZNdx+VyKOSBSjw\\;Secret=xLoC2oj1vNL57bJjLHrv1ht/g7FDD8RwTHEUxoBGIOM="})
@ActiveProfiles("test")
public class AzureIntegrationTest {

    @Autowired
    private AzureWebController azureWebController;

    @Test
    void getAllResourcesTest() {
        Map<String, String> resources = azureWebController.getAllResources();
        Assert.assertEquals(12,resources.size());
    }

}
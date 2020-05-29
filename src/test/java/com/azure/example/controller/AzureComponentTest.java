package com.azure.example.controller;

import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.data.appconfiguration.ConfigurationClient;
import com.azure.data.appconfiguration.models.ConfigurationSetting;
import com.azure.data.appconfiguration.models.SettingSelector;
import com.azure.example.controller.config.TestConfig;
import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@TestPropertySource(properties = {"CONNECTIONSTRING=Endpoint=https://azurespringconfig.azconfig.io\\;Id=XKvw-lh-s0:SVsLG6ZNdx+VyKOSBSjw\\;Secret=xLoC2oj1vNL57bJjLHrv1ht/g7FDD8RwTHEUxoBGIOM="})
@ActiveProfiles("test")
public class AzureComponentTest {

    @Autowired
    private AzureWebController azureWebController;

    @Autowired
    ConfigurationClient configurationClient;

    @Test
    void getAllResourcesTest() throws NoSuchFieldException {
        PagedIterable pagedIterable = getPagedIterable();
        Mockito.when(configurationClient.listConfigurationSettings(Mockito.any(SettingSelector.class))).
                thenReturn(pagedIterable);

        Map<String, String> resources = azureWebController.getAllResources();
        Assert.assertEquals(1,resources.size());
        Assert.assertEquals("value",resources.get("key"));

    }

    private PagedIterable getPagedIterable() {
        PagedFlux<ConfigurationSetting> response = new PagedFlux<ConfigurationSetting>(() ->
                Mono.just(new PagedResponseBase<HttpHeaders,
                ConfigurationSetting>(null, 200, null,
                getConfigurationSettings(), null,
                null)));
        return new PagedIterable(response);
    }

    private List<ConfigurationSetting> getConfigurationSettings() {
        ConfigurationSetting configurationSetting = new ConfigurationSetting();
        configurationSetting.setKey("key");
        configurationSetting.setValue("value");
        return Arrays.asList(configurationSetting);
    }

}
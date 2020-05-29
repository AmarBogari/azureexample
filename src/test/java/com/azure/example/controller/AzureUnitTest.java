package com.azure.example.controller;

import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.data.appconfiguration.ConfigurationClient;
import com.azure.data.appconfiguration.models.ConfigurationSetting;
import com.azure.data.appconfiguration.models.SettingSelector;
import com.azure.example.service.AzureService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class AzureUnitTest {

    @InjectMocks
    private AzureService azureService;

    @Mock
    ConfigurationClient configurationClient;

    @BeforeEach
    public void before(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllResourcesTest() {
        PagedIterable pagedIterable = getPagedIterable();
        Mockito.when(configurationClient.listConfigurationSettings(Mockito.any(SettingSelector.class))).
                thenReturn(pagedIterable);
        Map<String, String> resources = azureService.getAllResources();
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
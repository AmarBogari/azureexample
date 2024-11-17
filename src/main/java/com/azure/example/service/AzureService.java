package com.azure.example.service;

import com.azure.core.http.rest.PagedIterable;
import com.azure.data.appconfiguration.ConfigurationClient;
import com.azure.data.appconfiguration.models.ConfigurationSetting;
import com.azure.data.appconfiguration.models.SettingSelector;
import com.azure.example.config.AzureConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AzureService {

    @Autowired
    private ConfigurationClient configurationClient;

    public Map<String, String> getAllResources() {
        return configurationClient.listConfigurationSettings(new SettingSelector()).stream().
                collect(Collectors.toMap(ConfigurationSetting::getKey,ConfigurationSetting::getValue));
    }

    public Map<String, String> getAllResources1() {
        return configurationClient.listConfigurationSettings(new SettingSelector()).stream().
                collect(Collectors.toMap(ConfigurationSetting::getKey,ConfigurationSetting::getValue));
    }

}

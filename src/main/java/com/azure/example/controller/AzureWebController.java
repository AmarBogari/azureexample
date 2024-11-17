package com.azure.example.controller;

import com.azure.example.service.AzureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AzureWebController {

    @Autowired
    AzureService azureService;

    @GetMapping("/allazureproperties")
    public Map<String,String> getAllResources(){
        return azureService.getAllResources();
    }

       @GetMapping("/allazureproperties1")
    public Map<String,String> getAllResources1(){
        return azureService.getAllResources();
    }
}

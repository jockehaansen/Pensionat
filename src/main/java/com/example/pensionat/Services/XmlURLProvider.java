package com.example.pensionat.Services;

import com.example.pensionat.configuration.IntegrationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class XmlURLProvider {


    @Qualifier("integrationProperties")
    @Autowired
    IntegrationProperties properties;

    public URL GetCompanyCustomersURL() throws MalformedURLException {
        URL url = new URL(properties.getContractcustomer().getUrl());
        return url;
    }
    public URL GetShippersURL() throws MalformedURLException {
        URL url =  new URL(properties.getShipper().getUrl());
        return url;
    }
   }

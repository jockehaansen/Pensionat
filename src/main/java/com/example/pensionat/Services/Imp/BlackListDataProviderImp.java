package com.example.pensionat.Services.Imp;

import com.example.pensionat.Models.BlackListPerson;
import com.example.pensionat.Services.BlackListDataProvider;
import com.example.pensionat.configuration.IntegrationProperties;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlackListDataProviderImp implements BlackListDataProvider {

    @Qualifier("integrationProperties")
    @Autowired
    IntegrationProperties properties;
    @Override
    public List<BlackListPerson> getAllBLKunder() throws IOException {
        JsonMapper jSonMapper = new JsonMapper();
        BlackListPerson[] blps = jSonMapper.readValue(GetBlackListPersonURL(), BlackListPerson[].class);
        return List.of(blps);
    }

    public URL GetBlackListPersonURL() throws MalformedURLException {
        return new URL(properties.getBlacklist().getUrl());
    }
}

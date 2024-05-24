package com.example.pensionat.Services;

import com.example.pensionat.Models.allcustomers;
import com.example.pensionat.Models.customers;
import com.example.pensionat.configuration.IntegrationProperties;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
@Service
public class XMLCompanyCustomerProvider  {
    private final CompanyCustomerService companyCustomerService;

    public void GetCompanyCustomersAsXMLAndSaveToDatabase() throws Exception {
        XmlURLProvider xmlURLProvider = new XmlURLProvider();
        //final CompanyCustomerService companyCustomerService;

        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        XmlMapper xmlMapper = new XmlMapper(module);
        allcustomers customerList = xmlMapper.readValue(xmlURLProvider.GetCompanyCustomersURL(), allcustomers.class);

        for( customers c : customerList.customers ){
            companyCustomerService.addCustomerToDB(c);
//            System.out.println(c.contactName);
//            System.out.println(c.country);
        }
        System.out.println("kör CustomersConsoleApplication");
    }

}

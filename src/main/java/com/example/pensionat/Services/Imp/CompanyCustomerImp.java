package com.example.pensionat.Services.Imp;

import com.example.pensionat.Dtos.CustomerDto;
import com.example.pensionat.Models.Bokning;
import com.example.pensionat.Models.Shippers;
import com.example.pensionat.Models.customers;
import com.example.pensionat.Repositories.CustomerRepo;
import com.example.pensionat.Services.CompanyCustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyCustomerImp implements CompanyCustomerService {
    private final CustomerRepo cr;

    @Override
    public CustomerDto customersToCustomerDto(customers c) {
        return CustomerDto.builder().companyName(c.getCompanyName()).contactName(c.getContactName()).country(c.getCountry()).city(c.getCity()).build();
    }

    @Override
    public customers getCustomerDetailsById(Long id) {
        Optional<customers> optionalCustomers = cr.findById(id);
        if (optionalCustomers.isPresent()) {
            customers customer = optionalCustomers.get();
            return customer;
        } else {
            return null;
        }
    }

    @Override
    public void addCustomerToDB(customers customer) {
        customers foundCustomer;
        foundCustomer = cr.findAll().stream().filter(c -> Objects.equals(c.getPhone(), customer.getPhone())).findFirst().orElse(null);

        if (foundCustomer==null) {
            cr.save(customer);
            System.out.println(" --- En ny företagskund har lagts till: \"" + customer.getContactName() + ", " + customer.getContactTitle() + "\" --- ");
        }
        else {
            System.out.println( "Företagskunden " + customer.getCompanyName() + " fanns redan.");
        }
    }

    @Override
    public List<CustomerDto> getAllContractCustomers() {
        return cr.findAll().stream().map(this::customersToCustomerDto).toList();
    }

    @Override
    public List<CustomerDto> sortContractCustomersByCompanyAscending() {
        Sort sort = Sort.by(Sort.Direction.ASC, "companyName");
        return cr.findAll(sort).stream().map(this::customersToCustomerDto).toList();
    }

    @Override
    public List<CustomerDto> sortContractCustomersByCompanyDescending() {
        Sort sort = Sort.by(Sort.Direction.DESC, "companyName");
        return cr.findAll(sort).stream().map(this::customersToCustomerDto).toList();
    }

    @Override
    public List<CustomerDto> sortContractCustomersByContactAscending() {
        Sort sort = Sort.by(Sort.Direction.ASC, "contactName");
        return cr.findAll(sort).stream().map(this::customersToCustomerDto).toList();
    }

    @Override
    public List<CustomerDto> sortContractCustomersByContactDescending() {
        Sort sort = Sort.by(Sort.Direction.DESC, "contactName");
        return cr.findAll(sort).stream().map(this::customersToCustomerDto).toList();
    }

    @Override
    public List<CustomerDto> sortContractCustomersByCityAscending() {
        Sort sort = Sort.by(Sort.Direction.ASC, "city");
        return cr.findAll(sort).stream().map(this::customersToCustomerDto).toList();
    }

    @Override
    public List<CustomerDto> sortContractCustomersByCityDescending() {
        Sort sort = Sort.by(Sort.Direction.DESC, "city");
        return cr.findAll(sort).stream().map(this::customersToCustomerDto).toList();
    }

    @Override
    public List<CustomerDto> sortContractCustomersByCountryAscending() {
        Sort sort = Sort.by(Sort.Direction.ASC, "country");
        return cr.findAll(sort).stream().map(this::customersToCustomerDto).toList();
    }

    @Override
    public List<CustomerDto> sortContractCustomersByCountryDescending() {
        Sort sort = Sort.by(Sort.Direction.DESC, "country");
        return cr.findAll(sort).stream().map(this::customersToCustomerDto).toList();
    }
}

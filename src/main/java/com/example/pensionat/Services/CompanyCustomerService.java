package com.example.pensionat.Services;

import com.example.pensionat.Dtos.BokningDto;
import com.example.pensionat.Dtos.CustomerDto;
import com.example.pensionat.Models.Bokning;
import com.example.pensionat.Models.customers;

import java.util.List;

public interface CompanyCustomerService {
    public CustomerDto customersToCustomerDto(customers customer);
    public customers getCustomerDetailsById(Long id);
    public void addCustomerToDB(customers customer);

    public List<CustomerDto> getAllContractCustomers();
    public List<CustomerDto> sortContractCustomersByCompanyAscending();
    public List<CustomerDto> sortContractCustomersByCompanyDescending();
    public List<CustomerDto> sortContractCustomersByContactAscending();
    public List<CustomerDto> sortContractCustomersByContactDescending();
    public List<CustomerDto> sortContractCustomersByCityAscending();
    public List<CustomerDto> sortContractCustomersByCityDescending();
    public List<CustomerDto> sortContractCustomersByCountryAscending();
    public List<CustomerDto> sortContractCustomersByCountryDescending();
}

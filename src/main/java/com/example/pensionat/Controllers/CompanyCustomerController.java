package com.example.pensionat.Controllers;

import com.example.pensionat.Dtos.CustomerDto;
import com.example.pensionat.Models.Bokning;
import com.example.pensionat.Models.customers;
import com.example.pensionat.Services.CompanyCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "company")
@RequiredArgsConstructor
public class CompanyCustomerController {

    private final CompanyCustomerService ccs;

    @GetMapping("/customers/{id}")
    public String showIndividualCustomer(@PathVariable Long id, Model model) {
        customers customer = ccs.getCustomerDetailsById(id);
        model.addAttribute("customer", customer);
        return "visaCompanyCustomerIndividual.html";
    }

    @GetMapping("allCustomers")
    public String getCustomerList(Model model){
        List<CustomerDto> contractCustomers = ccs.getAllContractCustomers();
        model.addAttribute("allContractCustomers", contractCustomers);
        return "visaAvtalsKunder";
    }

    @GetMapping("allCustomers/sortedByCompanyAsc")
    public String getContractCustomersByCompanyAscending(Model model){
        List<CustomerDto> contractCustomers = ccs.sortContractCustomersByCompanyAscending();
        model.addAttribute("allContractCustomers", contractCustomers);
        return "visaAvtalsKunder";
    }
    @GetMapping("allCustomers/sortedByCompanyDesc")
    public String getContractCustomersByCompanyDescending(Model model){
        List<CustomerDto> contractCustomers = ccs.sortContractCustomersByCompanyDescending();
        model.addAttribute("allContractCustomers", contractCustomers);
        return "visaAvtalsKunder";
    }
    @GetMapping("allCustomers/sortedByContactAsc")
    public String getContractCustomersByContactAscending(Model model){
        List<CustomerDto> contractCustomers = ccs.sortContractCustomersByContactAscending();
        model.addAttribute("allContractCustomers", contractCustomers);
        return "visaAvtalsKunder";
    }
    @GetMapping("allCustomers/sortedByContactDesc")
    public String getContractCustomersByContactDescending(Model model){
        List<CustomerDto> contractCustomers = ccs.sortContractCustomersByContactDescending();
        model.addAttribute("allContractCustomers", contractCustomers);
        return "visaAvtalsKunder";
    }
    @GetMapping("allCustomers/sortedByCityAsc")
    public String getContractCustomersByCityAscending(Model model){
        List<CustomerDto> contractCustomers = ccs.sortContractCustomersByCityAscending();
        model.addAttribute("allContractCustomers", contractCustomers);
        return "visaAvtalsKunder";
    }
    @GetMapping("allCustomers/sortedByCityDesc")
    public String getContractCustomersByCityDescending(Model model){
        List<CustomerDto> contractCustomers = ccs.sortContractCustomersByCityDescending();
        model.addAttribute("allContractCustomers", contractCustomers);
        return "visaAvtalsKunder";
    }
    @GetMapping("allCustomers/sortedByCountryAsc")
    public String getContractCustomersByCountryAscending(Model model){
        List<CustomerDto> contractCustomers = ccs.sortContractCustomersByCountryAscending();
        model.addAttribute("allContractCustomers", contractCustomers);
        return "visaAvtalsKunder";
    }
    @GetMapping("allCustomers/sortedByCountryDesc")
    public String getContractCustomersByCountryDescending(Model model){
        List<CustomerDto> contractCustomers = ccs.sortContractCustomersByCountryDescending();
        model.addAttribute("allContractCustomers", contractCustomers);
        return "visaAvtalsKunder";
    }


}

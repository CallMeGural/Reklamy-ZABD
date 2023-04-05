package pl.gg.reklamy_zabd_be.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gg.reklamy_zabd_be.pojo.City;
import pl.gg.reklamy_zabd_be.pojo.Company;
import pl.gg.reklamy_zabd_be.pojo.dto.CompanyDto;
import pl.gg.reklamy_zabd_be.repository.CompanyRepository;
import pl.gg.reklamy_zabd_be.service.CompanyService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/list")
    public String getAllCompanies(Model model) {
        model.addAttribute("companies", companyService.getAllCompanies());
        return "companies_list";
    }

    @GetMapping("/{id}")
    public String getCompanyById(Model model, @PathVariable int id) {
        Company company = companyService.getCompanyById(id);
        model.addAttribute("company", company);
        return "company_edit";
    }

    @GetMapping("/form")
    public String companyForm(Model model) {
        model.addAttribute("company",new Company());
        return "company_form";
    }

    @PutMapping
    public String updateCompany(@Valid @ModelAttribute("company") CompanyDto company,
                             Model model) {
        companyService.updateCompany(company);
        model.addAttribute("company", company);
        return "company_edit";
    }

    @PostMapping
    public String addCompany(@Valid Company company) {
        companyService.saveCompany(company);
        return "redirect:/companies/list";
    }

    @DeleteMapping("/{id}")
    public String deleteCompanyById(@PathVariable int id) {
        companyService.deleteCompanyById(id);
        return "redirect:/companies/list";
    }

    @DeleteMapping
    public String deleteAllCompanies() {
        companyService.deleteAllCompanies();
        return "companies_list";
    }
}

package pl.gg.reklamy_zabd_be.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.gg.reklamy_zabd_be.pojo.Company;
import pl.gg.reklamy_zabd_be.service.CompanyService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("companies")
public class CompanyController {

    CompanyService companyService;

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable int id) {
        return companyService.getCompanyById(id);
    }

    @PutMapping
    public int updateCompany(Company company) {
        return companyService.updateCompany(company);
    }

    @PostMapping
    public int addCompany(Company company) {
        return companyService.saveCompany(company);
    }

    @DeleteMapping("/{id}")
    public int deleteCompanyById(@PathVariable int id) {
        return companyService.deleteCompanyById(id);
    }

    @DeleteMapping
    public int deleteAllCompanies() {
        return companyService.deleteAllCompanies();
    }
}

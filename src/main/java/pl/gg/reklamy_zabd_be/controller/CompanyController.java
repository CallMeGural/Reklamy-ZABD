package pl.gg.reklamy_zabd_be.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.gg.reklamy_zabd_be.pojo.Company;
import pl.gg.reklamy_zabd_be.pojo.dto.CompanyDto;
import pl.gg.reklamy_zabd_be.repository.CompanyRepository;
import pl.gg.reklamy_zabd_be.repository.JdbcCompanyRepository;
import pl.gg.reklamy_zabd_be.service.CompanyService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = new ArrayList<>(companyService.getAllCompanies());
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable int id) {
        return companyService.getCompanyById(id);
    }

    @PutMapping
    public int updateCompany(CompanyDto company) {
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

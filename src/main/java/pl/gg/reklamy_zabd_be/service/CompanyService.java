package pl.gg.reklamy_zabd_be.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gg.reklamy_zabd_be.pojo.Company;
import pl.gg.reklamy_zabd_be.repository.JdbcCompanyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    JdbcCompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(int id) {
        return companyRepository.findById(id);
    }

    public int saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public int updateCompany(Company company) {
        return companyRepository.update(company);
    }

    public int deleteCompanyById(int id) {
        return companyRepository.deleteById(id);
    }

    public int deleteAllCompanies() {
        return companyRepository.deleteAll();
    }
}

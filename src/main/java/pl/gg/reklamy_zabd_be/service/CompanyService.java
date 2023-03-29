package pl.gg.reklamy_zabd_be.service;

import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gg.reklamy_zabd_be.pojo.BankAccount;
import pl.gg.reklamy_zabd_be.pojo.Company;
import pl.gg.reklamy_zabd_be.pojo.dto.CompanyDto;
import pl.gg.reklamy_zabd_be.repository.CompanyRepository;;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final BankAccountService bankAccountService;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(int id) {
        return companyRepository.findById(id).orElseThrow();
    }

    public Company saveCompany(Company company) {
        Iban iban = Iban.random(CountryCode.PL);
        bankAccountService.saveBankAccount(new BankAccount(iban.getAccountNumber(),iban.getCheckDigit(),0,company));
        return companyRepository.save(company);
    }

    @Transactional
    public Company updateCompany(CompanyDto dto) {
        Company update = companyRepository.findById(dto.getId()).orElseThrow();
        if(!dto.getName().equals("")) update.setName(dto.getName());
        return companyRepository.save(update);
    }

    public void deleteCompanyById(int id) {
         companyRepository.deleteById(id);
    }

    public void deleteAllCompanies() {
         companyRepository.deleteAll();
    }
}

package pl.gg.reklamy_zabd_be.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gg.reklamy_zabd_be.pojo.Company;
import pl.gg.reklamy_zabd_be.pojo.dto.CompanyDto;
import pl.gg.reklamy_zabd_be.repository.JdbcCompanyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    @Autowired
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

    @Transactional
    public int updateCompany(CompanyDto dto) {
        Company update = companyRepository.findById(dto.getId());
        if(dto.getBankAccId()!=0) update.setBankAccId(dto.getBankAccId());
        if(!dto.getName().equals("")) update.setName(dto.getName());
        return companyRepository.update(dto);
    }

    public int deleteCompanyById(int id) {
        return companyRepository.deleteById(id);
    }

    public int deleteAllCompanies() {
        return companyRepository.deleteAll();
    }
}

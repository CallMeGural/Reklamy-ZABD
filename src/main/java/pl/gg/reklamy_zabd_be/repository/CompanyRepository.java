package pl.gg.reklamy_zabd_be.repository;

import pl.gg.reklamy_zabd_be.pojo.Company;
import pl.gg.reklamy_zabd_be.pojo.dto.CompanyDto;

import java.util.List;

public interface CompanyRepository {
    int save(Company company);
    int update(CompanyDto company);
    Company findById(int id);
    int deleteById(int id);
    List<Company> findAll();
    int deleteAll();
}

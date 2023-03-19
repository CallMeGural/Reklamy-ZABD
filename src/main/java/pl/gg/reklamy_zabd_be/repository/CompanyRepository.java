package pl.gg.reklamy_zabd_be.repository;

import pl.gg.reklamy_zabd_be.pojo.Company;

import java.util.List;

public interface CompanyRepository {
    int save(Company company);
    int update(Company company);
    Company findById(int id);
    int deleteById(int id);
    List<Company> findAll();
    int deleteAll();
}

package pl.gg.reklamy_zabd_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gg.reklamy_zabd_be.pojo.Company;
import pl.gg.reklamy_zabd_be.pojo.dto.CompanyDto;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
//    int save(Company company);
//    int update(CompanyDto company);
//    Company findById(int id);
//    int deleteById(int id);
//    List<Company> findAll();
//    int deleteAll();
}

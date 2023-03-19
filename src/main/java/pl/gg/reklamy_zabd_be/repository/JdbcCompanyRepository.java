package pl.gg.reklamy_zabd_be.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.gg.reklamy_zabd_be.pojo.Company;

import java.util.List;

@Repository
public class JdbcCompanyRepository implements CompanyRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String sql;

    @Override
    public int save(Company company) {
        sql = "INSERT INTO company(name,bank_account_id) VALUES(?,?)";
        return jdbcTemplate.update(sql, company.getName(),company.getBankAccId());
    }

    @Override
    public int update(Company company) {
        sql = "UPDATE company SET name=?, bank_account_id=? WHERE id=?";
        return jdbcTemplate.update(sql, company.getName(),company.getBankAccId(),company.getId());
    }

    @Override
    public Company findById(int id) {
        sql = "SELECT * FROM company WHERE id=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Company.class));
    }

    @Override
    public int deleteById(int id) {
         sql = "DELETE FROM company WHERE id=?";
         return jdbcTemplate.update(sql,id);
    }

    @Override
    public List<Company> findAll() {
        sql = "SELECT * FROM company";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Company.class));
    }

    @Override
    public int deleteAll() {
         sql = "DELETE FROM company";
         return jdbcTemplate.update(sql);
    }
}

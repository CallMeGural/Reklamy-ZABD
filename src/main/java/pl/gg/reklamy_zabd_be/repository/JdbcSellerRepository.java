package pl.gg.reklamy_zabd_be.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.gg.reklamy_zabd_be.pojo.Seller;

import java.util.List;

public class JdbcSellerRepository implements SellerRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String sql;

    @Override
    public int save(Seller seller) {
        sql = "INSERT INTO seller(name,bank_account_id,company_id) VALUES(?,?,?)";
        return jdbcTemplate.update(sql, seller.getName(),seller.getBankAccId(),seller.getCompanyId());
    }

    @Override
    public int update(Seller seller) {
        sql = "UPDATE seller SET name=?, bank_account_id=?, company_id=? WHERE id=?";
        return jdbcTemplate.update(sql, seller.getName(),seller.getBankAccId(),seller.getCompanyId(),seller.getId());
    }

    @Override
    public Seller findById(int id) {
        sql = "SELECT * FROM seller WHERE id=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Seller.class));
    }

    @Override
    public int deleteById(int id) {
        sql = "DELETE FROM seller WHERE id=?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public List<Seller> findAll() {
        sql = "SELECT * FROM seller";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Seller.class));
    }

    @Override
    public int deleteAll() {
        sql = "DELETE FROM seller";
        return jdbcTemplate.update(sql);
    }
}

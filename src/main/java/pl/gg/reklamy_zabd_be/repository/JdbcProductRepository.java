package pl.gg.reklamy_zabd_be.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.gg.reklamy_zabd_be.pojo.Product;

import java.util.List;

@Repository
public class JdbcProductRepository implements ProductRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String sql;

    @Override
    public int save(Product product) {
        sql = "INSERT INTO product(name,seller_id) VALUES(?,?)";
        return jdbcTemplate.update(sql, product.getName(), product.getSellerId());
    }

    @Override
    public int update(Product product) {
        sql = "UPDATE product set name=?, seller_id=? WHERE id=?";
        return jdbcTemplate.update(sql,product.getName(),product.getSellerId(),product.getId());

    }

    @Override
    public Product findById(int id) {
        sql = "SELECT * FROM product WHERE id=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Product.class));

    }

    @Override
    public int deleteById(int id) {
        sql = "DELETE FROM product WHERE id=?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public List<Product> findAll() {
        sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Product.class));

    }

    @Override
    public int deleteAll() {
        sql = "DELETE FROM product";
        return jdbcTemplate.update(sql);
    }
}

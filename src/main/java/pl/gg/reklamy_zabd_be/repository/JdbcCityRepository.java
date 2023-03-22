package pl.gg.reklamy_zabd_be.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.gg.reklamy_zabd_be.pojo.BankAccount;
import pl.gg.reklamy_zabd_be.pojo.City;

import java.util.List;

@Repository
public class JdbcCityRepository implements CityRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String sql;

    @Override
    public int save(City city) {
        sql = "INSERT INTO city(name,population,area) VALUES(?,?,?)";
        return jdbcTemplate.update(sql,city.getName(),city.getPopulation(),city.getArea());
    }

    @Override
    public int update(City city) {
        sql = "UPDATE city set population=? WHERE id=?";
        return jdbcTemplate.update(sql, city.getPopulation());

    }

    @Override
    public City findById(int id) {
        sql = "SELECT * FROM city WHERE id=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(City.class));

    }

    @Override
    public int deleteById(int id) {
        sql = "DELETE FROM city WHERE id=?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public List<City> findAll() {
        sql = "SELECT * FROM city";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(City.class));

    }

    @Override
    public int deleteAll() {
        sql = "DELETE FROM city";
        return jdbcTemplate.update(sql);
    }
}

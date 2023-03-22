package pl.gg.reklamy_zabd_be.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.gg.reklamy_zabd_be.pojo.BankAccount;
import pl.gg.reklamy_zabd_be.pojo.Company;
import pl.gg.reklamy_zabd_be.pojo.dto.BankAccountDto;

import java.util.List;

@Repository
public class JdbcBankAccountRepository implements BankAccountRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String sql;

    @Override
    public int save(BankAccount acc) {
        sql = "INSERT INTO bank_account(credit_card_number,cvc,balance) VALUES(?,?,?)";
        return jdbcTemplate.update(sql,acc.getCreditCardNumber(),acc.getCvc(),acc.getBalance());
    }

    @Override
    public int update(BankAccountDto acc) {
        sql = "UPDATE bank_account set credit_card_number=?, cvc=?, balance=? WHERE id=?";
        return jdbcTemplate.update(sql,acc.getCreditCardNumber(),acc.getCvc(),acc.getBalance(),acc.getId());

    }

    @Override
    public BankAccount findById(int id) {
        sql = "SELECT * FROM bank_account WHERE id=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(BankAccount.class));

    }

    @Override
    public int deleteById(int id) {
        sql = "DELETE FROM bank_account WHERE id=?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public List<BankAccount> findAll() {
        sql = "SELECT * FROM bank_account";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(BankAccount.class));

    }

    @Override
    public int deleteAll() {
        sql = "DELETE FROM bank_account";
        return jdbcTemplate.update(sql);
    }
}

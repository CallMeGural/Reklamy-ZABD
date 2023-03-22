package pl.gg.reklamy_zabd_be.repository;

import pl.gg.reklamy_zabd_be.pojo.BankAccount;

import java.util.List;

public interface BankAccountRepository {
    int save(BankAccount acc);
    int update(BankAccount acc);
    BankAccount findById(int id);
    int deleteById(int id);
    List<BankAccount> findAll();
    int deleteAll();
}

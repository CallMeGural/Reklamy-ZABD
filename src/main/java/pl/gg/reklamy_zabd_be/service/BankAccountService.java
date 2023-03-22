package pl.gg.reklamy_zabd_be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gg.reklamy_zabd_be.pojo.BankAccount;
import pl.gg.reklamy_zabd_be.repository.JdbcBankAccountRepository;

import java.util.List;

@Service
public class BankAccountService {
    @Autowired
    JdbcBankAccountRepository bankAccountRepository;

    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    public BankAccount getBankAccountById(int id) {
        return bankAccountRepository.findById(id);
    }

    public int saveBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    public int updateBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.update(bankAccount);
    }

    public int deleteBankAccountById(int id) {
        return bankAccountRepository.deleteById(id);
    }

    public int deleteAllBankAccounts() {
        return bankAccountRepository.deleteAll();
    }
}

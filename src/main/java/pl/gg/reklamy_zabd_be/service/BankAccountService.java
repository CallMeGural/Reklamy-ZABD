package pl.gg.reklamy_zabd_be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gg.reklamy_zabd_be.pojo.BankAccount;
import pl.gg.reklamy_zabd_be.pojo.dto.BankAccountDto;
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

    @Transactional
    public int updateBankAccount(BankAccountDto dto) {
        BankAccount update = getBankAccountById(dto.getId());
        if(dto.getBalance()!=0.)
            update.setBalance(dto.getBalance());
        if(!dto.getCvc().equals(""))
            update.setCvc(dto.getCvc());
        if(!dto.getCreditCardNumber().equals(""))
            update.setCreditCardNumber(dto.getCreditCardNumber());
        return bankAccountRepository.update(dto);
    }

    public int deleteBankAccountById(int id) {
        return bankAccountRepository.deleteById(id);
    }

    public int deleteAllBankAccounts() {
        return bankAccountRepository.deleteAll();
    }

    @Transactional
    public int sendMoneyToOtherBankAccount(int sendId, int receiveId, double balance) {
        BankAccount sendBankAcc = bankAccountRepository.findById(sendId);
        BankAccount receiveBankAcc = bankAccountRepository.findById(receiveId);
        sendBankAcc.setBalance(sendBankAcc.getBalance()-balance);
        bankAccountRepository.update(new BankAccountDto(sendBankAcc.getId(),
                                                        sendBankAcc.getCreditCardNumber(),
                                                        sendBankAcc.getCvc(),
                                                        sendBankAcc.getBalance()));
        receiveBankAcc.setBalance(receiveBankAcc.getBalance()+balance);
        return bankAccountRepository.update(new BankAccountDto(receiveBankAcc.getId(),
                                                                receiveBankAcc.getCreditCardNumber(),
                                                                receiveBankAcc.getCvc(),
                                                                receiveBankAcc.getBalance()));
    }
}

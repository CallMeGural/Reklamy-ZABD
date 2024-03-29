package pl.gg.reklamy_zabd_be.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.gg.reklamy_zabd_be.pojo.BankAccount;
import pl.gg.reklamy_zabd_be.pojo.Company;
import pl.gg.reklamy_zabd_be.pojo.Seller;
import pl.gg.reklamy_zabd_be.pojo.dto.BankAccountDto;
import pl.gg.reklamy_zabd_be.pojo.dto.ProcessPaymentDto;
import pl.gg.reklamy_zabd_be.repository.BankAccountRepository;
import pl.gg.reklamy_zabd_be.repository.SellerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;
    private final SellerRepository sellerRepository;

    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    public BankAccount getBankAccountById(int id) {
        return bankAccountRepository.findById(id).orElseThrow();
    }

    public BankAccount saveBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    @Transactional
    public BankAccount updateBankAccount(BankAccount dto) {
        BankAccount update = getBankAccountById(dto.getId());
//        if(dto.getBalance()!=0.)
            update.setBalance(dto.getBalance());
//        if(!dto.getCvc().equals(""))
            update.setCvc(dto.getCvc());
//        if(!dto.getCreditCardNumber().equals(""))
            update.setCreditCardNumber(dto.getCreditCardNumber());
            update.setCompany(dto.getCompany());
            update.setStatus(dto.isStatus());

        update.setCompany(dto.getCompany());
        return bankAccountRepository.save(update);
    }

    public void deleteBankAccountById(int id) {
         bankAccountRepository.deleteById(id);
    }


    @Transactional
    public void processPayment(ProcessPaymentDto payment) {
        log.info(payment.toString());
        BankAccount bankAccount = getBankAccountById(payment.getBankAccount().getId());
        Seller seller = sellerRepository.findById(payment.getSeller().getId()).orElseThrow();
        bankAccount.setBalance(bankAccount.getBalance()-payment.getPayment());
        seller.setBalance(seller.getBalance()+payment.getPayment());
        bankAccountRepository.save(bankAccount);
        sellerRepository.save(seller);
    }

    public BankAccount saveCampaign(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }
}

package pl.gg.reklamy_zabd_be.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.gg.reklamy_zabd_be.pojo.BankAccount;
import pl.gg.reklamy_zabd_be.pojo.Company;
import pl.gg.reklamy_zabd_be.pojo.dto.BankAccountDto;
import pl.gg.reklamy_zabd_be.service.BankAccountService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bank-accounts")
public class BankAccountController {

    @Autowired
    BankAccountService bankAccountService;

    @GetMapping
    public ResponseEntity<List<BankAccount>> getAllCompanies() {
        List<BankAccount> bankAccounts = new ArrayList<>(bankAccountService.getAllBankAccounts());
        return ResponseEntity.ok(bankAccounts);
    }

    @GetMapping("/{id}")
    public BankAccount getCompanyById(@PathVariable int id) {
        return bankAccountService.getBankAccountById(id);
    }

    @PutMapping
    public int updateCompany(BankAccountDto bankAccount) {
        return bankAccountService.updateBankAccount(bankAccount);
    }

    @PostMapping
    public int addCompany(BankAccount bankAccount) {
        return bankAccountService.saveBankAccount(bankAccount);
    }

    @DeleteMapping("/{id}")
    public int deleteCompanyById(@PathVariable int id) {
        return bankAccountService.deleteBankAccountById(id);
    }

    @DeleteMapping
    public int deleteAllCompanies() {
        return bankAccountService.deleteAllBankAccounts();
    }

    @PutMapping("/transfer")
    public int sendMoneyToOtherBankAccount(int sendId, int receiveId, double balance) {
        return bankAccountService.sendMoneyToOtherBankAccount(sendId,receiveId,balance);
    }

}

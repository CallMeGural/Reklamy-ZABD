package pl.gg.reklamy_zabd_be.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.gg.reklamy_zabd_be.pojo.BankAccount;
import pl.gg.reklamy_zabd_be.pojo.Company;
import pl.gg.reklamy_zabd_be.pojo.dto.BankAccountDto;
import pl.gg.reklamy_zabd_be.service.BankAccountService;
import org.springframework.ui.Model;
import pl.gg.reklamy_zabd_be.service.CompanyService;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bank-accounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;
    private final CompanyService companyService;

    @GetMapping("/list")
    public String getAllBankAccounts(Model model) {
        model.addAttribute("bankAccounts", bankAccountService.getAllBankAccounts());
        return "bank_account_list";
    }

    @GetMapping
    public String bankAccountForm(Model model) {
        model.addAttribute("bankAccount",new BankAccount());
        model.addAttribute("companies",companyService.getAllCompanies());
        return "bank_form";
    }

    @GetMapping("/{id}")
    public String getBankAccountById(Model model, @PathVariable int id) {
        BankAccount bank = bankAccountService.getBankAccountById(id);
        model.addAttribute("bankAccount", bank);
        model.addAttribute("companies",companyService.getAllCompanies());
        return "bank_edit";
    }

    @PutMapping
    public String updateBankAccount(
            @Valid @ModelAttribute("bank") BankAccountDto bankAccount,
            Errors errors) {
        if(errors.hasErrors()) return "bank_edit";
        bankAccountService.updateBankAccount(bankAccount);
        return "redirect:/bank_accounts/list";
    }


    @DeleteMapping("/{id}")
    public String deleteBankAccountById(@PathVariable int id) {
        bankAccountService.deleteBankAccountById(id);
        return "redirect:/bank_accounts/list";
    }

    @DeleteMapping
    public String deleteAllBankAccounts() {
        bankAccountService.deleteAllBankAccounts();
        return "redirect:/";
    }

    @PutMapping("/transfer")
    public String sendMoneyToOtherBankAccount(int sendId, int receiveId, double balance) {
        bankAccountService.sendMoneyToOtherBankAccount(sendId, receiveId, balance);
        return "banks_list";
    }
}

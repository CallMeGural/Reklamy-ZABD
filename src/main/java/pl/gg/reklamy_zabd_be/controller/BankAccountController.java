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


import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bank-accounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @GetMapping("/list")
    public String getAllCompanies(Model model) {
        List<BankAccount> bankAccounts = new ArrayList<>();
        model.addAttribute("bankAccounts", bankAccountService.getAllBankAccounts());
        return "banks_list";
    }

    @GetMapping("/{id}")
    public String getCompanyById(Model model, @PathVariable int id) {
        BankAccount bank = bankAccountService.getBankAccountById(id);
        model.addAttribute("bankAccount", bank);
        return "bank_edit";
    }

    @PutMapping
    public String updateCompany(@Valid @ModelAttribute("bank") BankAccountDto bankAccount, Model model) {
        bankAccountService.updateBankAccount(bankAccount);
        model.addAttribute("bank", bankAccount);
        return "bank_edit";
    }

    @PostMapping
    public String addCompany(@Valid BankAccount bankAccount) {
        bankAccountService.saveBankAccount(bankAccount);
        return "redirect:/bank_accounts/list";
    }

    @DeleteMapping("/{id}")
    public String deleteCompanyById(@PathVariable int id) {
        bankAccountService.deleteBankAccountById(id);
        return "redirect:/bank_accounts/list";
    }

    @DeleteMapping
    public String deleteAllCompanies() {
        bankAccountService.deleteAllBankAccounts();
        return "redirect:index";
    }


    @PutMapping("/transfer")
    public String sendMoneyToOtherBankAccount(int sendId, int receiveId, double balance) {
        bankAccountService.sendMoneyToOtherBankAccount(sendId,receiveId,balance);
        return "banks_list";
    }

}

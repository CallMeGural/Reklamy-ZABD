package pl.gg.reklamy_zabd_be.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.gg.reklamy_zabd_be.pojo.BankAccount;
import pl.gg.reklamy_zabd_be.pojo.Campaign;
import pl.gg.reklamy_zabd_be.pojo.Company;
import pl.gg.reklamy_zabd_be.pojo.Seller;
import pl.gg.reklamy_zabd_be.pojo.dto.BankAccountDto;
import pl.gg.reklamy_zabd_be.pojo.dto.ProcessPaymentDto;
import pl.gg.reklamy_zabd_be.service.BankAccountService;
import org.springframework.ui.Model;
import pl.gg.reklamy_zabd_be.service.CompanyService;
import pl.gg.reklamy_zabd_be.service.SellerService;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bank-accounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;
    private final CompanyService companyService;
    private final SellerService sellerService;

    //list of bank accounts
    @GetMapping("/list")
    public String getAllBankAccounts(Model model) {
        model.addAttribute("bankAccounts", bankAccountService.getAllBankAccounts());
        return "bank_account_list";
    }

    //adding new bank account form
    @GetMapping("/form")
    public String bankAccountForm(Model model) {
        model.addAttribute("bankAccount",new BankAccount());
        model.addAttribute("companies",companyService.getAllCompanies());
        return "bank_form";
    }
    @PostMapping
    public String addCampaign(@Valid BankAccount bankAccount,
                              Errors errors) {
        if(errors.hasErrors()) return "bank_form";
        bankAccountService.saveCampaign(bankAccount);
        return "redirect:/bank-accounts/list";
    }

    @GetMapping("/{id}")
    public String getBankAccountById(Model model, @PathVariable int id) {
        BankAccount bankAccount = bankAccountService.getBankAccountById(id);
        model.addAttribute("bankAccount", bankAccount);
        model.addAttribute("companies",companyService.getAllCompanies());
        return "bank_edit";
    }

    @GetMapping("/send/{id}")
    public String sendMoneyForm(Model model,@PathVariable int id) {
        BankAccount bankAccount = bankAccountService.getBankAccountById(id);
        List<Seller> sellers = sellerService.getSellersFromCompany(bankAccount.getCompany());
        model.addAttribute("bankAccount",bankAccount);
        model.addAttribute("sellers",sellers);
        model.addAttribute("dto",new ProcessPaymentDto(bankAccount));
        return "bank_send_money";
    }

    @PutMapping("/send")
    public String processPayment(@ModelAttribute("dto") ProcessPaymentDto payment) {
        bankAccountService.processPayment(payment);
        return "redirect:/bank-accounts/list";
    }

    @PutMapping("/{id}")
    public String updateBankAccount(
            @Valid BankAccount bankAccount,
            Errors errors) {
        if(errors.hasErrors()) return "bank_edit";
        bankAccountService.updateBankAccount(bankAccount);
        return "redirect:/bank-accounts/list";
    }


    @DeleteMapping("/{id}")
    public String deleteBankAccountById(@PathVariable int id) {
        bankAccountService.deleteBankAccountById(id);
        return "redirect:/bank-accounts/list";
    }

}

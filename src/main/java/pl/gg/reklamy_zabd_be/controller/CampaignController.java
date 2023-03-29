package pl.gg.reklamy_zabd_be.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.gg.reklamy_zabd_be.pojo.BankAccount;
import pl.gg.reklamy_zabd_be.pojo.Campaign;
import pl.gg.reklamy_zabd_be.service.BankAccountService;
import pl.gg.reklamy_zabd_be.service.CampaignService;
import org.springframework.ui.Model;
import pl.gg.reklamy_zabd_be.service.CityService;
import pl.gg.reklamy_zabd_be.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/campaigns")
public class CampaignController {

    private final CampaignService campaignService;
    private final ProductService productService;
    private final CityService cityService;

    @GetMapping("/list")
    public String getAllCampaigns(Model model) {
        model.addAttribute("campaigns",campaignService.getAllCampaigns());
        return "campaigns_list";
    }

    @GetMapping
    public String campaignForm(Model model) {
        model.addAttribute("campaign",new Campaign());
        model.addAttribute("cities",cityService.getAllCities());
        model.addAttribute("products",productService.getAllProducts());
        return "campaign_form";
    }

    @GetMapping("/{id}")
    public String getCampaignById(Model model, @PathVariable int id) {
        Campaign campaign = campaignService.getCampaignById(id);
        model.addAttribute("campaign", campaign);
        System.out.println(cityService.getAllCities());
        model.addAttribute("cities",cityService.getAllCities());
        model.addAttribute("products",productService.getAllProducts());
        return "campaign_edit";
    }

    @PutMapping("/{id}")
    public String updateCampaign(@Valid Campaign campaign, Errors errors) {
        if(errors.hasErrors()) return "campaign_edit";
        campaignService.updateCampaign(campaign);
        return "redirect:/campaigns/list";
    }

    @PostMapping
    public String addCampaign(@Valid Campaign campaign,
                             Errors errors) {
        if(errors.hasErrors()) return "campaign_form";
        campaignService.saveCampaign(campaign);
        return "redirect:/campaigns/list";
    }

    @DeleteMapping("/{id}")
    public String deleteCampaignyById(@PathVariable int id) {
        campaignService.deleteCampaignById(id);
        return "redirect:/campaigns/list";
    }

    @DeleteMapping
    public String deleteAllCampaigns() {
        campaignService.deleteAllCampaigns();
        return "redirect:/campaigns/list";
    }

    @PutMapping("/charge/{id}")
    public String chargeCampaignWhenSiteOpened(@PathVariable int id) {
        campaignService.chargeCampaignWhenSiteOpened(id);
        return "campaigns_list";
    }
}

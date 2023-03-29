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
import pl.gg.reklamy_zabd_be.pojo.City;
import pl.gg.reklamy_zabd_be.pojo.dto.CampaignDto;
import pl.gg.reklamy_zabd_be.repository.CampaignRepository;
import pl.gg.reklamy_zabd_be.service.BankAccountService;
import pl.gg.reklamy_zabd_be.service.CampaignService;
import org.springframework.ui.Model;
import pl.gg.reklamy_zabd_be.service.CityService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/campaigns")
public class CampaignController {
    @Autowired
    CampaignService campaignService;

    @Autowired
    private final CityService cityService;

    @GetMapping("/list")
    public String getAllCompanies(Model model) {
        model.addAttribute("campaigns",campaignService.getAllCampaigns());
        return "campaigns_list";
    }

    @GetMapping("/{id}")
    public String getCompanyById(Model model, @PathVariable int id) {
        Campaign campaign = campaignService.getCampaignById(id);
        model.addAttribute("campaign", campaign);
        model.addAttribute("cities", cityService.getAllCities());
        return "campaign_edit";
    }

    @PutMapping("/{id}")
    public String updateCompany(@Valid @ModelAttribute("campaign") CampaignDto campaign,
                                Model model) {
        campaignService.updateCampaign(campaign);
        model.addAttribute("campaign", campaign);
        return "campaign_edit";
    }

    @PostMapping
    public String addCompany(@Valid Campaign campaign,
                             Errors errors) {
        if(errors.hasErrors()) return "campaign_form";
        campaignService.saveCampaign(campaign);
        return "redirect:/campaigns/list";
    }

    @DeleteMapping("/{id}")
    public String deleteCompanyById(@PathVariable int id) {
        campaignService.deleteCampaignById(id);
        return "redirect:/campaigns/list";
    }

    @DeleteMapping
    public String deleteAllCompanies() {
        campaignService.deleteAllCampaigns();
        return "redirect:/campaigns/list";
    }

    @PutMapping("/{id}")
    public String chargeCampaignWhenSiteOpened(@PathVariable int id) {
        campaignService.chargeCampaignWhenSiteOpened(id);
        return "campaigns_list";
    }
}

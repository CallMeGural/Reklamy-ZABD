package pl.gg.reklamy_zabd_be.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.gg.reklamy_zabd_be.pojo.Campaign;
import pl.gg.reklamy_zabd_be.pojo.City;
import pl.gg.reklamy_zabd_be.pojo.dto.CampaignDto;
import pl.gg.reklamy_zabd_be.service.CampaignService;
import org.springframework.ui.Model;
import pl.gg.reklamy_zabd_be.service.CityService;
import pl.gg.reklamy_zabd_be.service.ProductService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/campaigns")
public class CampaignController {

    private final CampaignService campaignService;
    private final ProductService productService;
    private final CityService cityService;

    @GetMapping("/list")
    public String getAllCompanies(Model model) {
        model.addAttribute("campaigns",campaignService.getAllCampaigns());
        System.out.println(campaignService.getAllCampaigns());
        return "campaigns_list";
    }

    @GetMapping("/{id}")
    public String getCompanyById(Model model, @PathVariable int id) {
        Campaign campaign = campaignService.getCampaignById(id);
        model.addAttribute("campaign", campaign);
        System.out.println(cityService.getAllCities());
        model.addAttribute("cities",cityService.getAllCities());
        model.addAttribute("products",productService.getAllProducts());
        return "campaign_edit";
    }

    @PutMapping("/{id}")
    public String updateCompany(@Valid Campaign campaign, Errors errors) {
        if(errors.hasErrors()) return "campaign_edit";
        campaignService.updateCampaign(campaign);
        return "redirect:/campaigns/list";
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

    @PutMapping("/charge/{id}")
    public String chargeCampaignWhenSiteOpened(@PathVariable int id) {
        campaignService.chargeCampaignWhenSiteOpened(id);
        return "campaigns_list";
    }
}

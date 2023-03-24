package pl.gg.reklamy_zabd_be.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.gg.reklamy_zabd_be.pojo.BankAccount;
import pl.gg.reklamy_zabd_be.pojo.Campaign;
import pl.gg.reklamy_zabd_be.pojo.dto.CampaignDto;
import pl.gg.reklamy_zabd_be.service.BankAccountService;
import pl.gg.reklamy_zabd_be.service.CampaignService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/campaigns")
public class CampaignController {
    @Autowired
    CampaignService campaignService;

    @GetMapping
    public ResponseEntity<List<Campaign>> getAllCompanies() {
        List<Campaign> campaigns = new ArrayList<>(campaignService.getAllCampaigns());
        return ResponseEntity.ok(campaigns);
    }

    @GetMapping("/{id}")
    public Campaign getCompanyById(@PathVariable int id) {
        return campaignService.getCampaignById(id);
    }

    @PutMapping
    public int updateCompany(CampaignDto campaign) {
        return campaignService.updateCampaign(campaign);
    }

    @PostMapping
    public int addCompany(Campaign campaign) {
        return campaignService.saveCampaign(campaign);
    }

    @DeleteMapping("/{id}")
    public int deleteCompanyById(@PathVariable int id) {
        return campaignService.deleteCampaignById(id);
    }

    @DeleteMapping
    public int deleteAllCompanies() {
        return campaignService.deleteAllCampaigns();
    }

    @PutMapping("/{id}")
    public int chargeCampaignWhenSiteOpened(@PathVariable int id) {
        return campaignService.chargeCampaignWhenSiteOpened(id);
    }
}

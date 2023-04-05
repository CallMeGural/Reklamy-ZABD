package pl.gg.reklamy_zabd_be.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gg.reklamy_zabd_be.pojo.Campaign;
import pl.gg.reklamy_zabd_be.pojo.dto.CampaignDto;
import pl.gg.reklamy_zabd_be.repository.CampaignRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignService {

    private final CampaignRepository campaignRepository;

    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    public Campaign getCampaignById(int id) {
        return campaignRepository.findById(id).orElseThrow();
    }

    public Campaign saveCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    @Transactional
    public Campaign updateCampaign(Campaign dto) {
        Campaign update = campaignRepository.findById(dto.getId()).orElseThrow();
//        if(!dto.getName().equals(""))
            update.setName(dto.getName());
//        if(!dto.getKeywords().equals(""))
            update.setKeywords(dto.getKeywords());
//        if(dto.getFund()!=0)
            update.setFund(dto.getFund());

            update.setKeywords(dto.getKeywords());
            update.setStatus(dto.isStatus());
            update.setCity(dto.getCity());
            //update.setProduct(dto.getProduct());
            update.setRadius(dto.getRadius());
        return campaignRepository.save(update);
    }

    public void deleteCampaignById(int id) {
         campaignRepository.deleteById(id);
    }

    public void deleteAllCampaigns() {
         campaignRepository.deleteAll();
    }

    @Transactional
    public void chargeCampaignWhenSiteOpened(int id) {
        Campaign campaignToCharge = campaignRepository.findById(id).orElseThrow();
        campaignToCharge.setFund(campaignToCharge.getFund()-campaignToCharge.getBid());
        campaignRepository.save(campaignToCharge);
    }
}

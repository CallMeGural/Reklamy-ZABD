package pl.gg.reklamy_zabd_be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gg.reklamy_zabd_be.pojo.BankAccount;
import pl.gg.reklamy_zabd_be.pojo.Campaign;
import pl.gg.reklamy_zabd_be.pojo.dto.CampaignDto;
import pl.gg.reklamy_zabd_be.repository.JdbcBankAccountRepository;
import pl.gg.reklamy_zabd_be.repository.JdbcCampaignRepository;

import java.util.List;

@Service
public class CampaignService {
    @Autowired
    JdbcCampaignRepository campaignRepository;

    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    public Campaign getCampaignById(int id) {
        return campaignRepository.findById(id);
    }

    public int saveCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    public int updateCampaign(CampaignDto dto) {
        Campaign update = campaignRepository.findById(dto.getId());
        if(!dto.getKeywords().equals(""))
            update.setKeywords(dto.getKeywords());
        if(dto.getCampaignFund()!=0)
            update.setCampaignFund(dto.getCampaignFund());
        return campaignRepository.update(dto);
    }

    public int deleteCampaignById(int id) {
        return campaignRepository.deleteById(id);
    }

    public int deleteAllCampaigns() {
        return campaignRepository.deleteAll();
    }
}

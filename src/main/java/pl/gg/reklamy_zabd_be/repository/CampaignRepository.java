package pl.gg.reklamy_zabd_be.repository;

import pl.gg.reklamy_zabd_be.pojo.Campaign;
import pl.gg.reklamy_zabd_be.pojo.dto.CampaignDto;

import java.util.List;

public interface CampaignRepository {
    int save(Campaign campaign);
    int update(CampaignDto campaign);
    Campaign findById(int id);
    int deleteById(int id);
    List<Campaign> findAll();
    int deleteAll();

    int chargeCampaignById(int id);
}

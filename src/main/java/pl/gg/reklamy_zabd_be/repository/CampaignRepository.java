package pl.gg.reklamy_zabd_be.repository;

import pl.gg.reklamy_zabd_be.pojo.Campaign;
import pl.gg.reklamy_zabd_be.pojo.Company;

import java.util.List;

public interface CampaignRepository {
    int save(Campaign campaign);
    int update(Campaign campaign);
    Campaign findById(int id);
    int deleteById(int id);
    List<Campaign> findAll();
    int deleteAll();
}

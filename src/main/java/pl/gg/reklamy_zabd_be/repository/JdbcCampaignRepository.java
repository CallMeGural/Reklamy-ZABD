package pl.gg.reklamy_zabd_be.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.gg.reklamy_zabd_be.pojo.Campaign;
import pl.gg.reklamy_zabd_be.pojo.dto.CampaignDto;

import java.util.List;

@Repository
public class JdbcCampaignRepository implements CampaignRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String sql;

    @Override
    public int save(Campaign campaign) {
        sql = "INSERT INTO campaign(keywords,bid,fund,city_id,radius,product_id) VALUES(?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, campaign.getKeywords(), campaign.getBidAmount(),campaign.getCampaignFund(),campaign.getCityId(),campaign.getRadius(),campaign.getProductId());

    }

    @Override
    public int update(CampaignDto campaign) {
        sql = "UPDATE campaign SET keywords=?, fund=? WHERE id=?";
        return jdbcTemplate.update(sql, campaign.getKeywords(),campaign.getCampaignFund(),campaign.getId());

    }

    @Override
    public Campaign findById(int id) {
        sql = "SELECT * FROM campaign WHERE id=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Campaign.class));

    }

    @Override
    public int deleteById(int id) {
        sql = "DELETE FROM campaign WHERE id=?";
        return jdbcTemplate.update(sql,id);

    }

    @Override
    public List<Campaign> findAll() {
        sql = "SELECT * FROM campaign";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Campaign.class));

    }

    @Override
    public int deleteAll() {
        sql = "DELETE FROM campaign";
        return jdbcTemplate.update(sql);

    }

    @Override
    public int chargeCampaignById(int id) {
        sql = "UPDATE campaign SET fund = fund - bid WHERE id=?";
        return jdbcTemplate.update(sql,id);
    }
}

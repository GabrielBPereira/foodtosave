package br.com.foodtosave.dao;

import br.com.foodtosave.entities.Affiliate;
import br.com.foodtosave.entities.mappers.AffiliateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@CacheConfig(cacheNames = "affiliateCache")
public class AffiliateDAOImpl implements AffiliateDAO {

    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_AFFILIATE_BY_ID = "SELECT * FROM affiliate WHERE id = ?";
    private final String SQL_FIND_AFFILIATE_BY_NAME = "SELECT * FROM affiliate WHERE name = ?";

    @Autowired
    public AffiliateDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //@Cacheable(cacheNames = "affiliate", key = "#affiliate_id", unless = "#result == null")
    public Affiliate getAffiliateById(Long id) {
        waitSomeTime();
        return jdbcTemplate.queryForObject(SQL_FIND_AFFILIATE_BY_ID, new Object[] { id }, new AffiliateMapper());
    }

    public Affiliate getAffiliateByName(String name) {
        return jdbcTemplate.queryForObject(SQL_FIND_AFFILIATE_BY_NAME, new Object[] { name }, new AffiliateMapper());
    }

    private void waitSomeTime() {
        System.out.println("Long Wait Begin");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Long Wait End");
    }
}

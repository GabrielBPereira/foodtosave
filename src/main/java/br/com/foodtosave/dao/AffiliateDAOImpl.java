package br.com.foodtosave.dao;

import br.com.foodtosave.entities.Affiliate;
import br.com.foodtosave.entities.mappers.AffiliateMapper;
import org.postgresql.core.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
@CacheConfig(cacheNames = "affiliateCache")
public class AffiliateDAOImpl implements AffiliateDAO {

    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_AFFILIATE_BY_ID = "SELECT * FROM affiliate WHERE id = ?";
    private final String SQL_FIND_AFFILIATE_BY_NAME = "SELECT * FROM affiliate WHERE name = ?";
    private final String SQL_FIND_AFFILIATES = "SELECT * FROM affiliate";

    @Autowired
    public AffiliateDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Cacheable(cacheNames = "affiliateById", key = "#id", unless = "#result == null")
    public Affiliate getAffiliateById(Long id) throws NoSuchElementException{

        try {
            Optional<Affiliate> affiliate = jdbcTemplate.query(SQL_FIND_AFFILIATE_BY_ID, new Object[] {id}, new AffiliateMapper()).stream().findFirst();
            return affiliate.orElseThrow();
        } catch (NoSuchElementException e) {
            e.fillInStackTrace();
            return null;
        }
    }
    @Cacheable(cacheNames = "affiliateByName", key = "#name", unless = "#result == null")
    public Affiliate getAffiliateByName(String name) throws NoSuchElementException{

        try {
            Optional<Affiliate> affiliate = jdbcTemplate.query(SQL_FIND_AFFILIATE_BY_NAME, new Object[] {name}, new AffiliateMapper()).stream().findFirst();
            return affiliate.orElseThrow();
        } catch (NoSuchElementException e) {
            e.fillInStackTrace();
            return null;
        }
    }
    @Cacheable(cacheNames = "affiliates", key = "\"all\"", unless = "#result == null")
    public List<Affiliate> getAffiliates() {
            List<Affiliate> affiliates = jdbcTemplate.query(SQL_FIND_AFFILIATES, new AffiliateMapper());
            return !affiliates.isEmpty() ? affiliates : null;
    }
}

package br.com.foodtosave.dao;

import br.com.foodtosave.entities.Affiliate;
import br.com.foodtosave.entities.mappers.AffiliateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class AffiliateDAOImpl implements AffiliateDAO {

    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_AFFILIATE_BY_ID = "select * from affiliate where affiliate_id = ?";
    private final String SQL_FIND_AFFILIATE_BY_NAME = "select * from affiliate where name = ?";

    @Autowired
    public AffiliateDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Affiliate getAffiliateById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_AFFILIATE_BY_ID, new Object[] { id }, new AffiliateMapper());
    }

    public Affiliate getAffiliateByName(String name) {
        return jdbcTemplate.queryForObject(SQL_FIND_AFFILIATE_BY_NAME, new Object[] { name }, new AffiliateMapper());
    }
}

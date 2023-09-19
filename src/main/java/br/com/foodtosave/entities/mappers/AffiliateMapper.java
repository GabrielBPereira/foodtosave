package br.com.foodtosave.entities.mappers;

import br.com.foodtosave.entities.Affiliate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AffiliateMapper implements RowMapper<Affiliate> {

    public Affiliate mapRow(ResultSet resultSet, int i) throws SQLException {

        Affiliate affiliate = new Affiliate();
        affiliate.setId(resultSet.getInt("affiliate_id"));
        affiliate.setCity(resultSet.getString("city"));
        affiliate.setName(resultSet.getString("name"));
        affiliate.setTypeCompany(resultSet.getString("type_company"));
        affiliate.setContractValue(resultSet.getDouble("contract_value"));
        return affiliate;
    }
}
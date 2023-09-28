package br.com.foodtosave.dao;

import br.com.foodtosave.entities.Affiliate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AffiliateDAO {
    Affiliate getAffiliateById(Long id);

    Affiliate getAffiliateByName(String name);

    List<Affiliate> getAffiliates();
}

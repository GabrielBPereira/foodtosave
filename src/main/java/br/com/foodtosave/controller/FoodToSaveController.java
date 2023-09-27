package br.com.foodtosave.controller;

import br.com.foodtosave.dao.AffiliateDAO;
import br.com.foodtosave.entities.Affiliate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/affiliate")
public class FoodToSaveController {

    @Autowired
    AffiliateDAO affiliateDAO;

    @GetMapping("/id")
    public String getAffiliateById(@RequestParam(value = "id") Long id) {
        System.out.println("\nGet affiliate with ID " + id);

        Affiliate affiliate = this.affiliateDAO.getAffiliateById(id);
        return String.format("%s", affiliate.toString());
    }

    @GetMapping("/name")
    public String getAffiliateByName(@RequestParam(value = "name") String name) {
        System.out.println("\nGet affiliate with Name " + name);

        Affiliate affiliate = this.affiliateDAO.getAffiliateByName(name);
        return String.format("%s", affiliate.toString());
    }
}
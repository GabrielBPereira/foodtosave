package br.com.foodtosave.controller;

import br.com.foodtosave.dao.AffiliateDAO;
import br.com.foodtosave.entities.Affiliate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/affiliate")
public class FoodToSaveController {

    @Autowired
    AffiliateDAO affiliateDAO;

    @GetMapping("/id/{id}")
    public ResponseEntity<Affiliate> getAffiliateById(@PathVariable Long id) {
        System.out.println("\nGet affiliate with ID " + id);

        Affiliate affiliate = this.affiliateDAO.getAffiliateById(id);
        if(affiliate == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(affiliate);
    }

    @GetMapping("/name/{name}")
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Affiliate> getAffiliateByName(@PathVariable String name) {
        System.out.println("\nGet affiliate with Name " + name);

        Affiliate affiliate = this.affiliateDAO.getAffiliateByName(name);
        if(affiliate == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(affiliate);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Affiliate>> getAffiliates() {
        System.out.println("\nGet all affiliates");

        List<Affiliate> affiliates = this.affiliateDAO.getAffiliates();
        if (affiliates.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(affiliates);
    }
}
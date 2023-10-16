package br.com.foodtosave.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Affiliate {

    public Affiliate() {

    }

    private Integer id;
    private String name;
    private String city;
    private String typeCompany;
    private Double contractValue;

    @Override
    public String toString() {
        return String.format("Affiliate: \n\nID:%d\nName: %s\nCity: %s\nType Company: %s\nContract Value: %2f",
                id, name, city, typeCompany, contractValue);
    }
}

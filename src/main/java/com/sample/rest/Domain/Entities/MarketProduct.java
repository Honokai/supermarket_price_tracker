package com.sample.rest.Domain.Entities;

import java.math.BigDecimal;
import java.sql.Date;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    private Market market;

    @ManyToOne
    private Product product;

    private BigDecimal price;

    private BigDecimal promo_price = new BigDecimal(0);

    @UpdateTimestamp
    private Date price_updated;

    @UpdateTimestamp
    private Date updated_on;
}

package com.sample.rest.Domain.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

import com.sample.rest.Domain.Entities.Product;
import com.sample.rest.WebApi.DTO.ProductsGet;

public interface IProductRepository extends JpaRepository<Product, UUID> {
    @Query("Select new com.sample.rest.WebApi.DTO.ProductsGet(p.name, b.name, c.name) from Product p join p.brand b join p.category c")
    public List<ProductsGet> findAllProductsGetDto();
}

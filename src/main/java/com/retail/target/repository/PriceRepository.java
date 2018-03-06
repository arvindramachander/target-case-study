package com.retail.target.repository;

import com.retail.target.entity.Price;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "price", path = "price")
public interface PriceRepository extends MongoRepository<Price, String> {
    /**
     * @param productId
     * @return
     */
    Price getPriceByProductId(String productId);
}

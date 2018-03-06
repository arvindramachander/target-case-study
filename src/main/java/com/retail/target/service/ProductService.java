package com.retail.target.service;

import com.retail.target.repository.PriceRepository;
import com.retail.target.entity.Price;
import com.retail.target.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    PriceRepository priceRepository;

    @Autowired
    ProductTitleService titleService;

    public Optional<Product> getProduct(String productId) {
        Price price = priceRepository.getPriceByProductId(productId);
        if (price == null) return Optional.empty();

        Optional<String> title = titleService.getTitle(productId);
        if (!title.isPresent()) return Optional.empty();

        Product product = new Product(productId, title.get(), price);
        return Optional.of(product);
    }
    
	/**
	 * @param price
	 */
	public void updateProductById(Price price) {
		priceRepository.save(price);
	}
}

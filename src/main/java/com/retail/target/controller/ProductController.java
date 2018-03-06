package com.retail.target.controller;

import com.retail.target.entity.Product;
import com.retail.target.exception.ProductNotFoundException;
import com.retail.target.service.ProductService;
import com.retail.target.exception.CustomResponse;
import com.retail.target.exception.ProductMisMatchException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping(value = "/products")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * @return This method can be used to fetch all the products.
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "No security on me. I can show all the products when implemented.";
    }

    /**
     * @param productId
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProductInfo(@PathVariable("id") String productId) {
        Optional<Product> optional = productService.getProduct(productId);
        if (!optional.isPresent()) {
            throw new ProductNotFoundException();
        }

        Product product = optional.get();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    
	/**
	 * @param productId
	 * @return
	 * 
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomResponse> updatePrice(@RequestBody Product product,
			@PathVariable("id") String productId) {
		if (!product.getId().equalsIgnoreCase(productId)) {
			throw new ProductMisMatchException();
		}
		Optional<Product> optional = productService.getProduct(productId);
        if (!optional.isPresent()) {
            throw new ProductNotFoundException();
        }
        
        productService.updateProductById(product.getPrice());

		return new ResponseEntity<CustomResponse>(
				new CustomResponse(HttpStatus.OK.value(), "Product price has been updated"), HttpStatus.OK);
	}
    
}

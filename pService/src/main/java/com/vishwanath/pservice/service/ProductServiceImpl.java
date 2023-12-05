package com.vishwanath.pservice.service;

import com.vishwanath.pservice.entity.Product;
import com.vishwanath.pservice.exception.ProductServiceCustomException;
import com.vishwanath.pservice.model.ProductRequest;
import com.vishwanath.pservice.model.ProductResponse;
import com.vishwanath.pservice.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.*;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Addding Product..");

        Product product = Product.builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();

        productRepository.save(product);
        log.info("Product added successfully");
    return product.getProductId();
    }

    @Override
    public ProductResponse getProduct(long id) {
        log.info("Fetching product for ProductUD: {}", id);

        Product product = productRepository.findById(id).orElseThrow(() -> new ProductServiceCustomException(("Product not found"),"Product_not_found"));

        ProductResponse  productResponse = new ProductResponse();

        copyProperties((product), productResponse);

        return productResponse;

    }
}

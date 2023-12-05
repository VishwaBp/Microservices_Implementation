package com.vishwanath.pservice.service;

import com.vishwanath.pservice.model.ProductRequest;
import com.vishwanath.pservice.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProduct(long id);
}

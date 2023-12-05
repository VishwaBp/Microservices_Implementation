package com.vishwanath.pservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String name;
    private long price;
    private long quantity;

}

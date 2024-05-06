package com.ashaipi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    private Long id;
    private String productName;
    private double price;
    private String size;
    private String color;
    private int stockQuantity;
    private double discount;
    private String img;
    private String barcode;
    private String description;
    private String note;

}

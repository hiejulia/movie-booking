package com.project.moviebooking.dto.order;


import lombok.Data;

@Data
public class ShoppingCartDTO {

    private String movieId;

    private Integer quantity;

    private String status;
}

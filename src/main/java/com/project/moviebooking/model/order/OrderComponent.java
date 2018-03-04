package com.project.moviebooking.model.order;
import java.util.List;

public class OrderComponent {

    private String customerId;

    private List<String> movieIds;

    public OrderComponent(String customerId, List<String> movieIds) {
        super();
        this.customerId = customerId;
        this.movieIds = movieIds;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<String> getProductIds() {
        return movieIds;
    }

    public void setMovieIds(List<String> movieIds) {
        this.movieIds = movieIds;
    }

}

package com.epam.bookingsystem.dto.response;

public class RateResponseDTO extends ResponseDTO {

    private Double rating;
    private Double totalRate;
    private Integer ratesCount;

    public RateResponseDTO() {
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(Double totalRate) {
        this.totalRate = totalRate;
    }

    public Integer getRatesCount() {
        return ratesCount;
    }

    public void setRatesCount(Integer ratesCount) {
        this.ratesCount = ratesCount;
    }
}

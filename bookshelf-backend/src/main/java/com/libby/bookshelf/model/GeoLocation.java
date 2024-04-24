package com.libby.bookshelf.model;


import jakarta.persistence.Embeddable;

@Embeddable
public class GeoLocation {

    private Double latitude;
    private Double longitude;

    // Default no-argument constructor
    public GeoLocation() {
        latitude = 0.0;
        longitude = 0.0;
    }

    public GeoLocation(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}

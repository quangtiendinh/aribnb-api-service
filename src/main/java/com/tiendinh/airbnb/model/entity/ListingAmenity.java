package com.tiendinh.airbnb.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "listing_amenities", schema = "public")
public class ListingAmenity extends BaseEntity {
    @EmbeddedId
    private ListingAmenityId id;

    @Embeddable
    @Getter
    @Setter
    public static class ListingAmenityId implements Serializable {
        private Long listingId;
        private Long amenityId;
    }
}

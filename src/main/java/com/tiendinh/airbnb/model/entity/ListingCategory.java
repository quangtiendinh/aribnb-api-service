package com.tiendinh.airbnb.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "listings_categories", schema = "public")
public class ListingCategory extends BaseEntity {
    @EmbeddedId
    private ListingCategoryId id;

    @ManyToOne
    @MapsId("listingId")
    @JoinColumn(name = "listing_id")
    private Listing listing;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    private Category category;

    @Embeddable
    @Getter
    @Setter
    public static class ListingCategoryId implements Serializable {
        private Long listingId;
        private Long categoryId;
    }
}
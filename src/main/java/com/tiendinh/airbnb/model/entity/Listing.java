package com.tiendinh.airbnb.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "listings", schema = "public")
public class Listing extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "host_id", nullable = false)
    private User host;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "property_type_id")
    private PropertyType propertyType;

    private int guests;
    private int bedrooms;
    private int bathrooms;
    private int beds;

    @Column(name = "price_per_night", precision = 10, scale = 2)
    private BigDecimal pricePerNight;

    @Column(name = "cleaning_fee", precision = 10, scale = 2)
    private BigDecimal cleaningFee;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "is_active")
    private boolean isActive = true;

    @OneToMany(mappedBy = "listing", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ListingCategory> listingCategories = new HashSet<>();
}

